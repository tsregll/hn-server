package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.enums.UserStatus;
import com.ruoyi.common.exception.BaseException;
import com.ruoyi.common.utils.MessageUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.sign.Base64;
import com.ruoyi.framework.manager.AsyncManager;
import com.ruoyi.framework.manager.factory.AsyncFactory;
import com.ruoyi.system.domain.vo.NewRouterVo;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.framework.web.service.SysPermissionService;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.service.ISysMenuService;

/**
 * 登录验证
 *
 * @author ruoyi
 */
@RestController
public class SysLoginController {
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ISysUserService userService;
    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
        String passwordCode = loginBody.getPassword();
        byte[] decode = Base64.decode(passwordCode);
        String password = new String(decode);
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), password, loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }
    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/loginByKey")
    public AjaxResult loginByKey(LoginBody loginBody) {
        String userName = loginBody.getUsername();
        if("".equals(userName) || userName == null){
            return  AjaxResult.error("未获取用户登录信息！");
        }
        SysUser sysUser = userService.selectUserByUserName(userName);
        if (StringUtils.isNull(sysUser)) {
            throw new UsernameNotFoundException("登录用户：" + userName + " 不存在");
        } else if (UserStatus.DELETED.getCode().equals(sysUser.getDelFlag())) {
            throw new BaseException("对不起，您的账号：" + userName + " 已被删除");
        } else if (UserStatus.DISABLE.getCode().equals(sysUser.getStatus())) {
            throw new BaseException("对不起，您的账号：" + userName + " 已停用");
        }
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(userName, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        Set<String> permissions = permissionService.getMenuPermission(sysUser);
//        Set<String> strings = menuService.selectMenuPermsByUserId(sysUser.getUserId());
//         生成令牌
        LoginUser loginUser = new LoginUser();
        loginUser.setUser(sysUser);
        loginUser.setPermissions(permissions);
        String token = tokenService.createToken(loginUser);
        AjaxResult ajax = AjaxResult.success();
        ajax.put(Constants.TOKEN, token);
        ajax.put("nickName", sysUser.getNickName());
        return ajax;
    }
//    @PostMapping("/loginByKey")
//    public AjaxResult loginByKey(LoginBody loginBody) {
//        String userName = loginBody.getUsername();
//        if("".equals(userName) || userName == null){
//            return  AjaxResult.error("未获取用户登录信息！");
//        }
//        SysUser sysUser = userService.selectUserByUserName(userName);
//        Set<String> strings = menuService.selectMenuPermsByUserId(sysUser.getUserId());
////         生成令牌
//        LoginUser loginUser = new LoginUser();
//        loginUser.setUser(sysUser);
//        loginUser.setPermissions(strings);
//        String token = tokenService.createToken(loginUser);
//        AjaxResult ajax = AjaxResult.success();
//        ajax.put(Constants.TOKEN, token);
//        ajax.put("nickName", sysUser.getNickName());
//        return ajax;
//    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        // 用户信息
        SysUser user = loginUser.getUser();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(user.getUserId());
        return AjaxResult.success(menuService.buildMenus(menus));
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getNewRouters")
    public AjaxResult getNewRouters() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        // 用户信息
        SysUser user = loginUser.getUser();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(user.getUserId());
        List<SysRole> list= user.getRoles();
        String roleName=list.size()>0?list.get(0).getRoleName():"";
        boolean isasb="安生部".equals(roleName);
//        boolean isasb = list.contains();
        List<String> menusName =new ArrayList<>();
        for (SysMenu menu: menus) {
            menusName.add(menu.getMenuName());
        }
//        List<SysMenu> menus = menuService.selectMenuTreeByUserId(1L);
        return AjaxResult.success(menuService.newBuildMenus(menusName,isasb));
    }
}

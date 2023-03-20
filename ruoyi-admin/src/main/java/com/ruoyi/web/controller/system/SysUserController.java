package com.ruoyi.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.exception.user.UserPasswordNotOldpasswordException;
import com.ruoyi.common.utils.sign.Base64;
import com.ruoyi.system.domain.vo.LivePhoneUserVo;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.web.controller.view.ChangeUserPasswordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.system.service.ISysPostService;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;

import javax.annotation.Resource;

/**
 * 用户信息/人资信息
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/user")
public class SysUserController extends BaseController {
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysPostService postService;

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private TokenService tokenService;
    @Resource
    private AuthenticationManager authenticationManager;

    /**
     * 获取用户列表
     */
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysUser user) {
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:user:export')")
    @GetMapping("/export")
    public AjaxResult export(SysUser user) {
        List<SysUser> list = userService.selectUserList(user);
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.exportExcel(list, "用户数据");
    }

    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:user:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        List<SysUser> userList = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = userService.importUser(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate() {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.importTemplateExcel("用户数据");
    }

    /**
     * 根据用户编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping(value = {"/", "/{userId}"})
    public AjaxResult getInfo(@PathVariable(value = "userId", required = false) Long userId) {
        AjaxResult ajax = AjaxResult.success();
        List<SysRole> roles = roleService.selectRoleAll();
        ajax.put("roles", SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        ajax.put("posts", postService.selectPostAll());
        if (StringUtils.isNotNull(userId)) {
            ajax.put(AjaxResult.DATA_TAG, userService.selectUserById(userId));
            ajax.put("postIds", postService.selectPostListByUserId(userId));
            ajax.put("roleIds", roleService.selectRoleListByUserId(userId));
        }
        return ajax;
    }

    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysUser user) {
        if (user.getRoleIds() == null || user.getRoleIds().length == 0) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，角色不能为空");
        }
        if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(user.getUserName()))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }
        user.setCreateBy(SecurityUtils.getUsername());
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        return toAjax(userService.insertUser(user));
    }

    /**
     * 修改用户
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysUser user) {
        userService.checkUserAllowed(user);
        if (UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
            return AjaxResult.error("修改用户'" + user.getUserName() + "'失败，手机号码已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
            return AjaxResult.error("修改用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }
        user.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(userService.updateUser(user));
    }

    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('system:user:remove')")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds) {
        return toAjax(userService.deleteUserByIds(userIds));
    }

    /**
     * 重置密码
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping("/resetPwd")
    public AjaxResult resetPwd(@RequestBody SysUser user) {
        userService.checkUserAllowed(user);
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        user.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(userService.resetPwd(user));
    }

    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysUser user) {
        userService.checkUserAllowed(user);
        user.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(userService.updateUserStatus(user));
    }

    /**
     * 根据登录用户获取用户所在部门的三级领导审批名单
     */
    @GetMapping("/leaders")
    public AjaxResult leaders() {
        Map<String, SysUser> result = new HashMap<>();
        LoginUser loginUser = SecurityUtils.getLoginUser();
        Long deptId = loginUser.getUser().getDeptId();
        if (deptId == null) {
            return AjaxResult.error("用户部门为空,请先绑定用户所在部门!");
        }
        SysDept sysDept = deptService.selectDeptById(deptId);
        String parentIds = sysDept.getAncestors() + "," + sysDept.getDeptId();
        String[] ids = parentIds.split(",");
        for (int i = ids.length - 1; i >= 0; i--) {
            List<SysUser> deptLeaders = userService.selectUserByDeptIdAndRoleKey(ids[i], "deptLeader");
            if (deptLeaders != null && deptLeaders.size() > 0) {
                result.put("deptLeader", deptLeaders.get(0));
                break;
            }
        }
        for (int i = ids.length - 1; i >= 0; i--) {
            List<SysUser> chargeLeaders = userService.selectUserByDeptIdAndRoleKey(ids[i], "chargeLeader");
            if (chargeLeaders != null && chargeLeaders.size() > 0) {
                result.put("chargeLeader", chargeLeaders.get(0));
                break;
            }
        }
        for (int i = ids.length - 1; i >= 0; i--) {
            List<SysUser> keyLeaders = userService.selectUserByDeptIdAndRoleKey(ids[i], "keyLeader");
            if (keyLeaders != null && keyLeaders.size() > 0) {
                result.put("keyLeader", keyLeaders.get(0));
                break;
            }
        }
        return AjaxResult.success("获取数据成功", result);
    }
    /**
     * 指挥调度——视频通话
     */
    @Log(title = "视频通话", businessType = BusinessType.UPDATE)
    @GetMapping("/videoCall")
    public AjaxResult videoCall() {
        Map<String,List<LivePhoneUserVo>> returnMap = userService.selectVideoCallUser();
        return AjaxResult.success(returnMap);
    }

    /**
     * 重置密码
     */
//    @PreAuthorize("@ss.hasPermi('system:user:changepassword')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changePassword")
    public AjaxResult changePassword(ChangeUserPasswordVo userVo) {
        //通过前台传入的用户名去查询用户
        SysUser user = userService.selectUserByUserName(userVo.getUserName());
        //判断用户是否能够修改密码
        userService.checkUserAllowed(user);
        //定义Base64解码
        byte[] decode = Base64.decode(userVo.getOldPasswordCode());
        String oldPassword = new String(decode);
        try {
            //匹配密码
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), oldPassword));
            //旧密码匹配之后进行修改密码
            decode = Base64.decode(userVo.getNewPasswordCode());
            String newPasswordCode = new String(decode);
            user.setPassword(SecurityUtils.encryptPassword(newPasswordCode));
            user.setUpdateBy(SecurityUtils.getUsername());
            //修改并且返回结果
            return toAjax(userService.changePassword(user));
        }catch (Exception e){
            throw new UserPasswordNotOldpasswordException();
        }
    }
}

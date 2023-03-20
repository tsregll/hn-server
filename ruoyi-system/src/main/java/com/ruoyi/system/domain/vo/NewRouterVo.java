package com.ruoyi.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 路由配置信息
 *
 * @author ruoyi
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NewRouterVo {
    /**
     * 路由名字
     */
    private String name;

    /**
     * 路由地址
     */
    private String path;


    /**
     * 重定向地址，当设置 noRedirect 的时候该路由在面包屑导航中不可被点击
     */
    private String redirect;

    /**
     * 组件地址
     */
    private String component;

    /**
     * 当你一个路由下面的 children 声明的路由大于1个时，自动会变成嵌套的模式--如组件页面
     */
    private Boolean alwaysShow;

    /**
     * 其他元素
     */
    private MetaVo meta;
    /**
     * 其他元素
     */
    private String icons;
    /**
     * 其他元素
     */
    private String names;
    /**
     * 其他元素
     */
    private String paths;
    /**
     * 其他元素
     */
    private boolean permission;

    /**
     * 子路由
     */
    private List<RouterVo> children;
    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }
    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getPaths() {
        return paths;
    }
    public void setPaths(String paths) {
        this.paths = paths;
    }

    public Boolean getPermission() {
        return permission;
    }

    public void setPermission(Boolean permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Boolean getAlwaysShow() {
        return alwaysShow;
    }

    public void setAlwaysShow(Boolean alwaysShow) {
        this.alwaysShow = alwaysShow;
    }

    public MetaVo getMeta() {
        return meta;
    }

    public void setMeta(MetaVo meta) {
        this.meta = meta;
    }

    public List<RouterVo> getChildren() {
        return children;
    }

    public void setChildren(List<RouterVo> children) {
        this.children = children;
    }
}

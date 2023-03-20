package com.ruoyi.common.core.domain.entity;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.annotation.Excel.Type;
import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 sys_user
 *
 * @author ruoyi
 */
@ApiModel("人资实体描述")
public class SysUser extends BaseEntity {
    private static final long serialVersionUID = 1L;


    /* 导入用的字段 */
    @ApiModelProperty(value = "角色名称", name = "roleName", dataType = "String")
    @Excel(name = "角色名称", type = Type.IMPORT)
    private String roleName;

    @ApiModelProperty(value = "部门名称", name = "deptName", dataType = "String")
    @Excel(name = "部门名称", type = Type.IMPORT)
    private String deptName;

    @Excel(name = "年份", type = Type.EXPORT)
    private String year;
    /* ------------------------------------------------------- */
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "职工序号", name = "userId", dataType = "Long")
    @Excel(name = "用户序号", cellType = ColumnType.NUMERIC, prompt = "用户编号", type = Type.EXPORT)
    private Long userId;

    /**
     * 部门ID
     */
    @ApiModelProperty(value = "部门编号", name = "userId", dataType = "Long")
//    @Excel(name = "部门编号", type = Type.IMPORT)
    private Long deptId;

    /**
     * 用户账号
     */
    @ApiModelProperty(value = "职工编号", name = "userId", dataType = "String")
    @Excel(name = "登录名称")
    private String userName;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "职工名称", name = "nickName", dataType = "String")
    @Excel(name = "用户名称")
    private String nickName;

    /**
     * 用户邮箱
     */
    @ApiModelProperty(value = "职工邮箱", name = "email", dataType = "String")
    @Excel(name = "用户邮箱", type = Type.EXPORT)
    private String email;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "职工手机号码", name = "phonenumber", dataType = "String")
    @Excel(name = "手机号码", type = Type.EXPORT)
    private String phonenumber;

    /**
     * 用户性别
     */
    @ApiModelProperty(value = "职工性别0=男,1=女,2=未知", name = "sex", dataType = "String")
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知", type = Type.EXPORT)
    private String sex;

    @ApiModelProperty(value = "职工学历0=研究生及以上,1=本科学历,2=专科学历,3=中专及以下学历", name = "educationBackground", dataType = "String")
    @Excel(name = "职工学历", readConverterExp = "0=研究生及以上,1=本科学历,2=专科学历,3=中专及以下学历", type = Type.EXPORT)
    private String educationBackground;

    @ApiModelProperty(value = "职工职称0=高级职称,1=中级职称,2=初级职称", name = "workerType", dataType = "String")
    @Excel(name = "职工职称", readConverterExp = "0=高级职称,1=中级职称,2=初级职称", type = Type.EXPORT)
    private String workerType;

    @ApiModelProperty(value = "职工技能0=高级技师资格,1=技师资格,2=高级工资格,3=中级工资格,4=初级工资格", name = "workerSkills", dataType = "String")
    @Excel(name = "职工技能", readConverterExp = "0=高级技师资格,1=技师资格,2=高级工资格,3=中级工资格,4=初级工资格", type = Type.EXPORT)
    private String workerSkills;


    /**
     * 入职时间
     */
    @ApiModelProperty(value = "入职时间", name = "entryTime", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入职时间", width = 30, dateFormat = "yyyy-MM-dd", type = Type.EXPORT)
    private Date entryTime;
    /**
     * 生日
     */
    @ApiModelProperty(value = "职工出生年月", name = "birthday", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "职工出生年月", width = 30, dateFormat = "yyyy-MM-dd", type = Type.EXPORT)
    private Date birthday;
//    worker_type
    /**
     * 用户头像
     */
    @ApiModelProperty(value = "职工头像", name = "avatar", dataType = "String")
    private String avatar;

    /**
     * 密码
     */
    @ApiModelProperty(value = "职工密码", name = "password", dataType = "String")
    private String password;

    /**
     * 盐加密
     */
    @ApiModelProperty(value = "盐加密", name = "salt", dataType = "String")
    private String salt;

    /**
     * 帐号状态（0正常 1停用）
     */
    @ApiModelProperty(value = "帐号状态0正常 1停用", name = "status", dataType = "String")
    @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用", type = Type.EXPORT)
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）", name = "delFlag", dataType = "String")
    private String delFlag;

    /**
     * 最后登录IP
     */
    @ApiModelProperty(value = "最后登录IP", name = "loginIp", dataType = "String")
    @Excel(name = "最后登录IP", type = Type.EXPORT)
    private String loginIp;

    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间", name = "loginDate", dataType = "Date")
    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
    private Date loginDate;
    /**
     * 最后登录IP
     */
    @ApiModelProperty(value = "直拨号码", name = "livePhoneCode", dataType = "String")
    private String livePhoneCode;
    /**
     * 最后登录IP
     */
    @ApiModelProperty(value = "Ip地址", name = "ipAddress", dataType = "String")
    private String ipAddress;

    /**
     * 部门对象
     */
    @ApiModelProperty(value = "部门对象", name = "dept", dataType = "SysDept")
    @Excels({
            @Excel(name = "部门名称", targetAttr = "deptName", type = Type.EXPORT),
            @Excel(name = "部门负责人", targetAttr = "leader", type = Type.EXPORT)
    })
    private SysDept dept;

    /**
     * 角色对象
     */
    @ApiModelProperty(value = "角色对象", name = "roles", dataType = "List<SysRole>")
    private List<SysRole> roles;

    /**
     * 角色组
     */
    @ApiModelProperty(value = "角色组", name = "roleIds", dataType = "Long[]")
    private Long[] roleIds;

    /**
     * 岗位组
     */
    @ApiModelProperty(value = "岗位组", name = "postIds", dataType = "Long[]")
    private Long[] postIds;
    /**
     * 上次修改密码时间
     */
    @ApiModelProperty(value = "上次修改密码时间", name = "updPasswordTime", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updPasswordTime;
    /**
     * 上次修改密码时间
     */
    @ApiModelProperty(value = "是否需要修改密码", name = "boolUpdatePassword", dataType = "String")
    private String boolUpdatePassword;

    public void setBoolUpdatePassword(String boolUpdatePassword) {
        this.boolUpdatePassword = boolUpdatePassword;
    }

    public String getBoolUpdatePassword() {
        return boolUpdatePassword;
    }

    public Date getUpdPasswordTime() {
        return updPasswordTime;
    }

    public void setUpdPasswordTime(Date updPasswordTime) {
        this.updPasswordTime = updPasswordTime;
    }

    public SysUser() {

    }

    public SysUser(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isAdmin() {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Size(min = 0, max = 30, message = "用户昵称长度不能超过30个字符")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @NotBlank(message = "用户账号不能为空")
    @Size(min = 0, max = 30, message = "用户账号长度不能超过30个字符")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @JsonIgnore
    @JsonProperty
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    public Long[] getPostIds() {
        return postIds;
    }

    public void setPostIds(Long[] postIds) {
        this.postIds = postIds;
    }


    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("deptId", getDeptId())
                .append("workerType", getWorkerType())
                .append("workerSkills", getWorkerSkills())
                .append("educationBackground", getEducationBackground())
                .append("userName", getUserName())
                .append("nickName", getNickName())
                .append("email", getEmail())
                .append("phonenumber", getPhonenumber())
                .append("sex", getSex())
                .append("avatar", getAvatar())
                .append("password", getPassword())
                .append("salt", getSalt())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("loginIp", getLoginIp())
                .append("loginDate", getLoginDate())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("dept", getDept())
                .append("livePhoneCode", getLivePhoneCode())
                .append("ipAddress", getIpAddress())
                .toString();
    }

    public String getWorkerType() {
        return workerType;
    }

    public void setWorkerType(String workerType) {
        this.workerType = workerType;
    }

    public String getWorkerSkills() {
        return workerSkills;
    }

    public void setWorkerSkills(String workerSkills) {
        this.workerSkills = workerSkills;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public String getLivePhoneCode() {
        return livePhoneCode;
    }

    public void setLivePhoneCode(String livePhoneCode) {
        this.livePhoneCode = livePhoneCode;
    }
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}

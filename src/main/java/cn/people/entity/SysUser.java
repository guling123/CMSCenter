package cn.people.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.people.entity.BaseEntity;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 管理用户表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@TableName("tb_sys_user")
@ApiModel(value="SysUser对象", description="管理用户表")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "登录用户名")
    @TableField("username")
    private String username;
    
    @ApiModelProperty(value = "用户ID")
    @TableField("userid")
    private Integer userid;

    @ApiModelProperty(value = "真实姓名")
    @TableField("realname")
    private String realname;

    @ApiModelProperty(value = "密码")
    @TableField("pwd")
    private String pwd;

    @ApiModelProperty(value = "密码盐值")
    @TableField("pwdsalt")
    private String pwdsalt;

    @ApiModelProperty(value = "创建时间")
    @TableField("createtime")
    private Date createtime;

    @ApiModelProperty(value = "最后登录时间")
    @TableField("lastlogintime")
    private Date lastlogintime;

    @ApiModelProperty(value = "创建人id")
    @TableField("createrid")
    private String createrid;

    @ApiModelProperty(value = "角色id")
    @TableField("roleid")
    private String roleid;

    @ApiModelProperty(value = "租户id")
    @TableField("orgid")
    private String orgid;

    @ApiModelProperty(value = "用户状态,0禁用 , 1启用")
    @TableField("dstatus")
    private Integer dstatus;

    public String getUsername() {
        return username;
    }

    public SysUser setUsername(String username) {
        this.username = username;
        return this;
    }
    public String getRealname() {
        return realname;
    }

    public Integer getUserid()
    {
        return userid;
    }

    public void setUserid(Integer userid)
    {
        this.userid = userid;
    }

    public SysUser setRealname(String realname) {
        this.realname = realname;
        return this;
    }
    public String getPwd() {
        return pwd;
    }

    public SysUser setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }
    public String getPwdsalt() {
        return pwdsalt;
    }

    public SysUser setPwdsalt(String pwdsalt) {
        this.pwdsalt = pwdsalt;
        return this;
    }
    public Date getCreatetime() {
        return createtime;
    }

    public SysUser setCreatetime(Date createtime) {
        this.createtime = createtime;
        return this;
    }
    public Date getLastlogintime() {
        return lastlogintime;
    }

    public SysUser setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
        return this;
    }
    public String getCreaterid() {
        return createrid;
    }

    public SysUser setCreaterid(String createrid) {
        this.createrid = createrid;
        return this;
    }
    public String getRoleid() {
        return roleid;
    }

    public SysUser setRoleid(String roleid) {
        this.roleid = roleid;
        return this;
    }
    public String getOrgid() {
        return orgid;
    }

    public SysUser setOrgid(String orgid) {
        this.orgid = orgid;
        return this;
    }
    public Integer getDstatus() {
        return dstatus;
    }

    public SysUser setDstatus(Integer dstatus) {
        this.dstatus = dstatus;
        return this;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        "username=" + username +
        ", realname=" + realname +
        ", pwd=" + pwd +
        ", pwdsalt=" + pwdsalt +
        ", createtime=" + createtime +
        ", lastlogintime=" + lastlogintime +
        ", createrid=" + createrid +
        ", roleid=" + roleid +
        ", orgid=" + orgid +
        ", dstatus=" + dstatus +
        "}";
    }
}

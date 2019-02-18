package cn.people.entity;

import cn.people.entity.BaseEntity;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 管理角色表
 * </p>
 *
 * @author fuqiang
 * @since 2018-12-17
 */
@ApiModel(value="SysRole对象", description="管理角色表")
@TableName("tb_sys_role")
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色标识")
    @TableField("ident")
    private String ident;

    @ApiModelProperty(value = "角色名称")
    @TableField("rolename")
    private String rolename;
    
    @ApiModelProperty(value = "角色描述")
    @TableField("role_desc")
    private String roleDesc;

    @ApiModelProperty(value = "创建时间")
    @TableField("createtime")
    private Date createtime;

    @ApiModelProperty(value = "创建人id")
    @TableField("createrid")
    private String createrid;

    @ApiModelProperty(value = "租户id")
    @TableField("orgid")
    private String orgid;

    public String getIdent() {
        return ident;
    }

    public SysRole setIdent(String ident) {
        this.ident = ident;
        return this;
    }
    public String getRolename() {
        return rolename;
    }

    public SysRole setRolename(String rolename) {
        this.rolename = rolename;
        return this;
    }
    public String getRoleDesc() {
        return roleDesc;
    }

    public SysRole setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
        return this;
    }
    public Date getCreatetime() {
        return createtime;
    }

    public SysRole setCreatetime(Date createtime) {
        this.createtime = createtime;
        return this;
    }
    public String getCreaterid() {
        return createrid;
    }

    public SysRole setCreaterid(String createrid) {
        this.createrid = createrid;
        return this;
    }
    public String getOrgid() {
        return orgid;
    }

    public SysRole setOrgid(String orgid) {
        this.orgid = orgid;
        return this;
    }

    @Override
    public String toString() {
        return "SysRole{" +
        "ident=" + ident +
        ", rolename=" + rolename +
        ", roleDesc=" + roleDesc +
        ", createtime=" + createtime +
        ", createrid=" + createrid +
        ", orgid=" + orgid +
        "}";
    }
}

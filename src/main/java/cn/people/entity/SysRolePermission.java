package cn.people.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.people.entity.BaseEntity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 角色权限关系表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@TableName("tb_sys_role_permission")
@ApiModel(value="SysRolePermission对象", description="角色权限关系表")
public class SysRolePermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    @TableField("roleid")
    private String roleid;

    @ApiModelProperty(value = "权限id")
    @TableField("permissionid")
    private String permissionid;

    @ApiModelProperty(value = "创建时间")
    @TableField("createtime")
    private LocalDateTime createtime;

    @ApiModelProperty(value = "创建人id")
    @TableField("createrid")
    private String createrid;

    public String getRoleid() {
        return roleid;
    }

    public SysRolePermission setRoleid(String roleid) {
        this.roleid = roleid;
        return this;
    }
    public String getPermissionid() {
        return permissionid;
    }

    public SysRolePermission setPermissionid(String permissionid) {
        this.permissionid = permissionid;
        return this;
    }
    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public SysRolePermission setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
        return this;
    }
    public String getCreaterid() {
        return createrid;
    }

    public SysRolePermission setCreaterid(String createrid) {
        this.createrid = createrid;
        return this;
    }

    @Override
    public String toString() {
        return "SysRolePermission{" +
        "roleid=" + roleid +
        ", permissionid=" + permissionid +
        ", createtime=" + createtime +
        ", createrid=" + createrid +
        "}";
    }
}

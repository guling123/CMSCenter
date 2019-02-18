package cn.people.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.people.entity.BaseEntity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 权限资源关系表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@TableName("tb_permission_resource")
@ApiModel(value="PermissionResource对象", description="权限资源关系表")
public class PermissionResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "资源d")
    @TableField("resourceid")
    private String resourceid;

    @ApiModelProperty(value = "权限id")
    @TableField("permissionid")
    private String permissionid;

    @ApiModelProperty(value = "创建时间")
    @TableField("createtime")
    private LocalDateTime createtime;

    @ApiModelProperty(value = "创建人id")
    @TableField("createrid")
    private String createrid;

    public String getResourceid() {
        return resourceid;
    }

    public PermissionResource setResourceid(String resourceid) {
        this.resourceid = resourceid;
        return this;
    }
    public String getPermissionid() {
        return permissionid;
    }

    public PermissionResource setPermissionid(String permissionid) {
        this.permissionid = permissionid;
        return this;
    }
    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public PermissionResource setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
        return this;
    }
    public String getCreaterid() {
        return createrid;
    }

    public PermissionResource setCreaterid(String createrid) {
        this.createrid = createrid;
        return this;
    }

    @Override
    public String toString() {
        return "PermissionResource{" +
        "resourceid=" + resourceid +
        ", permissionid=" + permissionid +
        ", createtime=" + createtime +
        ", createrid=" + createrid +
        "}";
    }
}

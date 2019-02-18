package cn.people.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.people.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 管理员账户组表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-17
 */
@TableName("tb_sys_user_channel")
@ApiModel(value="SysUserChannel对象", description="管理员账户组表")
public class SysUserChannel extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "管理员id")
    @TableField("sysuerid")
    private String sysuerid;

    @ApiModelProperty(value = "账户组id")
    @TableField("groupid")
    private String groupid;

    public String getSysuerid() {
        return sysuerid;
    }

    public SysUserChannel setSysuerid(String sysuerid) {
        this.sysuerid = sysuerid;
        return this;
    }
    public String getGroupid() {
        return groupid;
    }

    public SysUserChannel setGroupid(String groupid) {
        this.groupid = groupid;
        return this;
    }

    @Override
    public String toString() {
        return "SysUserChannel{" +
        "sysuerid=" + sysuerid +
        ", groupid=" + groupid +
        "}";
    }
}

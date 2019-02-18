package cn.people.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.people.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 管理组栏目表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-17
 */
@TableName("tb_sys_group_channel")
@ApiModel(value="SysGroupChannel对象", description="管理组栏目表")
public class SysGroupChannel extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "栏目id")
    @TableField("channelid")
    private String channelid;

    @ApiModelProperty(value = "管理组id")
    @TableField("groupid")
    private String groupid;

    public String getChannelid() {
        return channelid;
    }

    public SysGroupChannel setChannelid(String channelid) {
        this.channelid = channelid;
        return this;
    }
    public String getGroupid() {
        return groupid;
    }

    public SysGroupChannel setGroupid(String groupid) {
        this.groupid = groupid;
        return this;
    }

    @Override
    public String toString() {
        return "SysGroupChannel{" +
        "channelid=" + channelid +
        ", groupid=" + groupid +
        "}";
    }
}

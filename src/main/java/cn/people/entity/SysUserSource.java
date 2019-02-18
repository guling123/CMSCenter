package cn.people.entity;

import cn.people.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户常用稿源表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-18
 */
@ApiModel(value="SysUserSource对象", description="用户常用稿源表")
@TableName("tb_sys_user_source")
public class SysUserSource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableField("userid")
    private String userid;

    @ApiModelProperty(value = "稿源id")
    @TableField("sourceid")
    private String sourceid;

    public String getUserid() {
        return userid;
    }

    public SysUserSource setUserid(String userid) {
        this.userid = userid;
        return this;
    }
    public String getSourceid() {
        return sourceid;
    }

    public SysUserSource setSourceid(String sourceid) {
        this.sourceid = sourceid;
        return this;
    }

    @Override
    public String toString() {
        return "SysUserSource{" +
        "userid=" + userid +
        ", sourceid=" + sourceid +
        "}";
    }
}

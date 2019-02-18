package cn.people.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.people.entity.BaseEntity;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 管理账户组表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-13
 */
@TableName("tb_sys_group")
@ApiModel(value="SysGroup对象", description="管理账户组表")
public class SysGroup extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "站点id")
    @TableField("siteid")
    private String siteid;

    @ApiModelProperty(value = "管理组名称")
    @TableField("groupname")
    private String groupname;
    
    @ApiModelProperty(value = "管理组描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "创建时间")
    @TableField("createtime")
    private Date createtime;

    @ApiModelProperty(value = "创建人id")
    @TableField("createrid")
    private String createrid;
    
    @ApiModelProperty(value = "2已删除 , 1未删除")
    @TableField("dstatus")
    private Integer dstatus;

    public String getSiteid() {
        return siteid;
    }

    public Integer getDstatus()
    {
        return dstatus;
    }

    public void setDstatus(Integer dstatus)
    {
        this.dstatus = dstatus;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public SysGroup setSiteid(String siteid) {
        this.siteid = siteid;
        return this;
    }
    public String getGroupname() {
        return groupname;
    }

    public SysGroup setGroupname(String groupname) {
        this.groupname = groupname;
        return this;
    }
    public Date getCreatetime() {
        return createtime;
    }

    public SysGroup setCreatetime(Date createtime) {
        this.createtime = createtime;
        return this;
    }
    public String getCreaterid() {
        return createrid;
    }

    public SysGroup setCreaterid(String createrid) {
        this.createrid = createrid;
        return this;
    }

    @Override
    public String toString() {
        return "SysGroup{" +
        "siteid=" + siteid +
        ", groupname=" + groupname +
        ", createtime=" + createtime +
        ", createrid=" + createrid +
        "}";
    }
}

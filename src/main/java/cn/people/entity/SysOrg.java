package cn.people.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.people.entity.BaseEntity;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 租户表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@TableName("tb_sys_org")
@ApiModel(value="SysOrg对象", description="租户表")
public class SysOrg extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "租户ID")
    @TableField("orgid")
    private Integer orgid;
    
    @ApiModelProperty(value = "租户名称")
    @TableField("orgname")
    private String orgname;

    @ApiModelProperty(value = "租户描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "创建时间")
    @TableField("createtime")
    private Date createtime;

    @ApiModelProperty(value = "创建人id")
    @TableField("createrid")
    private String createrid;

    @ApiModelProperty(value = "超级管理员账号id")
    @TableField("sauserid")
    private String sauserid;

    @ApiModelProperty(value = "状态，0禁用，1可用")
    @TableField("dtatus")
    private Integer dtatus;

    public String getOrgname() {
        return orgname;
    }

    public Integer getOrgid()
    {
        return orgid;
    }
    public void setOrgid(Integer orgid)
    {
        this.orgid = orgid;
    }



    public SysOrg setOrgname(String orgname) {
        this.orgname = orgname;
        return this;
    }
    public String getDescription() {
        return description;
    }

    public SysOrg setDescription(String description) {
        this.description = description;
        return this;
    }
    public Date getCreatetime() {
        return createtime;
    }

    public SysOrg setCreatetime(Date createtime) {
        this.createtime = createtime;
        return this;
    }
    public String getCreaterid() {
        return createrid;
    }

    public SysOrg setCreaterid(String createrid) {
        this.createrid = createrid;
        return this;
    }
    public String getSauserid() {
        return sauserid;
    }

    public SysOrg setSauserid(String sauserid) {
        this.sauserid = sauserid;
        return this;
    }
    public Integer getDtatus() {
        return dtatus;
    }

    public SysOrg setDtatus(Integer dtatus) {
        this.dtatus = dtatus;
        return this;
    }

    @Override
    public String toString() {
        return "SysOrg{" +
        "orgname=" + orgname +
        ", description=" + description +
        ", createtime=" + createtime +
        ", createrid=" + createrid +
        ", sauserid=" + sauserid +
        ", dtatus=" + dtatus +
        "}";
    }
}

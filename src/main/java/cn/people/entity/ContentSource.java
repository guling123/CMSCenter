package cn.people.entity;

import cn.people.entity.BaseEntity;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 稿件来源表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-18
 */
@ApiModel(value="ContentSource对象", description="稿件来源表")
@TableName("tb_content_source")
public class ContentSource extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "逻辑ID 4 位数值，1000起")
    @TableField("logic_id")
    private Integer logicId;
    
    @ApiModelProperty(value = "站点id")
    @TableField("siteid")
    private String siteid;

    @ApiModelProperty(value = "来源名称")
    @TableField("sourcename")
    private String sourcename;

    @ApiModelProperty(value = "来源域名")
    @TableField("domain")
    private String domain;

    @ApiModelProperty(value = "稿源地址")
    @TableField("source_url")
    private String sourceUrl;

    @ApiModelProperty(value = "可信度")
    @TableField("reliability")
    private Integer reliability;

    @ApiModelProperty(value = "有效期")
    @TableField("limit_date")
    private Date limitDate;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "创建人")
    @TableField("createrid")
    private String createrid;

    @ApiModelProperty(value = "创建时间")
    @TableField("createtime")
    private Date createtime;
    

    public Integer getLogicId()
    {
        return logicId;
    }
    public void setLogicId(Integer logicId)
    {
        this.logicId = logicId;
    }
    public String getSiteid()
    {
        return siteid;
    }
    public ContentSource setSiteid(String siteid) {
        this.siteid = siteid;
        return this;
    }
    public String getSourcename() {
        return sourcename;
    }

    public ContentSource setSourcename(String sourcename) {
        this.sourcename = sourcename;
        return this;
    }
    public String getDomain() {
        return domain;
    }

    public ContentSource setDomain(String domain) {
        this.domain = domain;
        return this;
    }
    public String getSourceUrl() {
        return sourceUrl;
    }

    public ContentSource setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
        return this;
    }
    public Integer getReliability() {
        return reliability;
    }

    public ContentSource setReliability(Integer reliability) {
        this.reliability = reliability;
        return this;
    }
    public Date getLimitDate() {
        return limitDate;
    }

    public ContentSource setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
        return this;
    }
    public Integer getStatus() {
        return status;
    }

    public ContentSource setStatus(Integer status) {
        this.status = status;
        return this;
    }
    public String getCreaterid() {
        return createrid;
    }

    public ContentSource setCreaterid(String createrid) {
        this.createrid = createrid;
        return this;
    }
    public Date getCreatetime() {
        return createtime;
    }

    public ContentSource setCreatetime(Date createtime) {
        this.createtime = createtime;
        return this;
    }

    @Override
    public String toString() {
        return "ContentSource{" +
        "siteid=" + siteid +
        ", logicId=" + logicId +
        ", sourcename=" + sourcename +
        ", domain=" + domain +
        ", sourceUrl=" + sourceUrl +
        ", reliability=" + reliability +
        ", limitDate=" + limitDate +
        ", status=" + status +
        ", createrid=" + createrid +
        ", createtime=" + createtime +
        "}";
    }
}

package cn.people.controller.vo;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 模板表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-19
 */
@ApiModel(value="Model对象", description="模板表")
public class Model implements Serializable {


    private static final long serialVersionUID = 2334626427942136979L;
    
    @ApiModelProperty(value = "id")
    private String id;
    
    @ApiModelProperty(value = "逻辑id")
    private String logicId;
    
    @ApiModelProperty(value = "站点id")
    private String siteId;

    @ApiModelProperty(value = "模板名称")
    private String modelName;

    @ApiModelProperty(value = "内容的地址")
    private String url;

    @ApiModelProperty(value = "创建人id")
    private String createId;
    
    @ApiModelProperty(value = "创建人姓名")
    private String createName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "类型id")
    private String typeId;
    
    @ApiModelProperty(value = "类型名称")
    private String typeName;

    @ApiModelProperty(value = "状态 ， 1正常,2已删除 ")
    private Integer dstatus;

    @ApiModelProperty(value = "版本id")
    private String versionId;

	public String getLogicId() {
		return logicId;
	}

	public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    public void setLogicId(String logicId) {
		this.logicId = logicId;
	}

	public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public Integer getDstatus() {
		return dstatus;
	}

	public void setDstatus(Integer dstatus) {
		this.dstatus = dstatus;
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    public String getCreateName()
    {
        return createName;
    }

    public void setCreateName(String createName)
    {
        this.createName = createName;
    }

    public String getCreateId()
    {
        return createId;
    }

    public void setCreateId(String createId)
    {
        this.createId = createId;
    }

    @Override
    public String toString() {
        return "Model{" +
        "siteId=" + siteId +
        ", modelName=" + modelName +
        ", url=" + url +
        ", createId=" + createId +
        ", createName=" + createName +
        ", createTime=" + createTime +
        ", typeId=" + typeId +
        ", dstatus=" + dstatus +
        ", versionId=" + versionId +
        "}";
    }
}
    

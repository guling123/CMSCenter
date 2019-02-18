package cn.people.controller.vo;

import cn.people.entity.BaseEntity;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 模板碎片表,对应原TEMPLATE_TAG
 * </p>
 *
 * @author shidandan
 * @since 2019-01-07
 */
@ApiModel(value="ModelSplit对象", description="模板碎片表,对应原TEMPLATE_TAG")
public class ModelSplit extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "逻辑ID 6 位数值，100000起,站点ID内不重复 （暂时不用） 暂以TAG_id_TAG 形式定位")
    private Integer logicId;
    
    @ApiModelProperty(value = "碎片标记，{TAG_211695_TAG}")
    private String splitTag;

    @ApiModelProperty(value = "模板id")
    private String modelId;

    @ApiModelProperty(value = "碎片ID")
    private String splitId;

    @ApiModelProperty(value = "碎片名称")
    private String splitName;
    
    @ApiModelProperty(value = "碎片类型")
    private Integer type;
    
    @ApiModelProperty(value = "碎片类型名称")
    private String typeName;

    @ApiModelProperty(value = "引用时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private String createId;
    
    @ApiModelProperty(value = "创建人姓名")
    private String createName;

    public Integer getLogicId() {
        return logicId;
    }

    public Integer getType()
    {
        return type;
    }

    public String getSplitTag()
    {
        return splitTag;
    }

    public void setSplitTag(String splitTag)
    {
        this.splitTag = splitTag;
    }

    public void setType(Integer type)
    {
        this.type = type;
    }

    public String getCreateName()
    {
        return createName;
    }

    public void setCreateName(String createName)
    {
        this.createName = createName;
    }

    public ModelSplit setLogicId(Integer logicId) {
        this.logicId = logicId;
        return this;
    }
    public String getModelId() {
        return modelId;
    }

    public ModelSplit setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }
    public String getSplitId() {
        return splitId;
    }

    public ModelSplit setSplitId(String splitId) {
        this.splitId = splitId;
        return this;
    }
    public String getSplitName() {
        return splitName;
    }

    public ModelSplit setSplitName(String splitName) {
        this.splitName = splitName;
        return this;
    }
    
    public Date getCreateTime() {
        return createTime;
    }

    public ModelSplit setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
    public String getCreateId() {
        return createId;
    }

    public ModelSplit setCreateId(String createId) {
        this.createId = createId;
        return this;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "ModelSplit{" +
        ", logicId=" + logicId +
        ", modelId=" + modelId +
        ", splitId=" + splitId +
        ", splitName=" + splitName +
        ", createTime=" + createTime +
        ", createId=" + createId +
        "}";
    }
}

package cn.people.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;


/**
 * <p>
 * 原始图片表
 * </p>
 *
 * @author shidandan
 * @since 2018-11-29
 */
@ApiModel(value="TbOriginImage对象", description="原始图片表")
@TableName(value="tb_origin_image")
public class OriginImage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类型。1，静态、2，模板、3，内容")
    @TableField("dtype")
    private Integer dtype;

    @ApiModelProperty(value = "站点id")
    @TableField("siteid")
    private String siteid;

    @ApiModelProperty(value = "栏目id")
    @TableField("channelid")
    private Integer channelid;
    
    @ApiModelProperty(value = "内容id")
    @TableField("contentid")
    private Integer contentid;
    
    @ApiModelProperty(value = "模板id")
    @TableField("modelid")
    private String modelid;

    @ApiModelProperty(value = "图片位置")
    @TableField("filepath")
    private String filepath;

    @ApiModelProperty(value = "宽度")
    @TableField("wight")
    private Integer wight;

    @ApiModelProperty(value = "高度")
    @TableField("height")
    private Integer height;

    @ApiModelProperty(value = "大小，单位kb")
    @TableField("size")
    private Integer size;

    @ApiModelProperty(value = "创建时间")
    @TableField("createtime")
    private LocalDateTime createtime;

    @ApiModelProperty(value = "来源类型,1CMS头图,2,CMS内容,3MAM上传,4外部导入")
    @TableField("sourcetype")
    private Integer sourcetype;

    @ApiModelProperty(value = "标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "来源")
    @TableField("source")
    private String source;

    public Integer getDtype() {
        return dtype;
    }

    public OriginImage setDtype(Integer dtype) {
        this.dtype = dtype;
        return this;
    }
    public String getSiteid() {
        return siteid;
    }

    public OriginImage setSiteid(String siteid) {
        this.siteid = siteid;
        return this;
    }
    public Integer getChannelid() {
        return channelid;
    }

    public Integer getContentid()
    {
        return contentid;
    }

    public void setContentid(Integer contentid)
    {
        this.contentid = contentid;
    }

    public OriginImage setChannelid(Integer channelid) {
        this.channelid = channelid;
        return this;
    }
    public String getModelid() {
        return modelid;
    }

    public OriginImage setModelid(String modelid) {
        this.modelid = modelid;
        return this;
    }
    public String getFilepath() {
        return filepath;
    }

    public OriginImage setFilepath(String filepath) {
        this.filepath = filepath;
        return this;
    }
    public Integer getWight() {
        return wight;
    }

    public OriginImage setWight(Integer wight) {
        this.wight = wight;
        return this;
    }
    public Integer getHeight() {
        return height;
    }

    public OriginImage setHeight(Integer height) {
        this.height = height;
        return this;
    }
    public Integer getSize() {
        return size;
    }

    public OriginImage setSize(Integer size) {
        this.size = size;
        return this;
    }
    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public OriginImage setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
        return this;
    }
    public Integer getSourcetype() {
        return sourcetype;
    }

    public OriginImage setSourcetype(Integer sourcetype) {
        this.sourcetype = sourcetype;
        return this;
    }
    public String getTitle() {
        return title;
    }

    public OriginImage setTitle(String title) {
        this.title = title;
        return this;
    }
    public String getDescription() {
        return description;
    }

    public OriginImage setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getSource() {
        return source;
    }

    public OriginImage setSource(String source) {
        this.source = source;
        return this;
    }

    @Override
    public String toString() {
        return "TbOriginImage{" +
        "dtype=" + dtype +
        ", siteid=" + siteid +
        ", channelid=" + channelid +
        ", modelid=" + modelid +
        ", filepath=" + filepath +
        ", wight=" + wight +
        ", height=" + height +
        ", size=" + size +
        ", createtime=" + createtime +
        ", sourcetype=" + sourcetype +
        ", title=" + title +
        ", description=" + description +
        ", source=" + source +
        "}";
    }
}

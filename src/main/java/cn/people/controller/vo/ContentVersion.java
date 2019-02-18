package cn.people.controller.vo;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 内容版本表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-19
 */
@ApiModel(value="ContentVersion对象", description="内容版本表")
public class ContentVersion implements Serializable{


    private static final long serialVersionUID = -2793485864142976636L;
    @ApiModelProperty(value = "id")
    private String id;
    
    @ApiModelProperty(value = "内容id")
    private String contentid;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "副标题")
    private String subtitle;

    @ApiModelProperty(value = "肩标题")
    private String shouldertitle;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "内容描述")
    private String description;

    @ApiModelProperty(value = "缩略图id")
    private String imageid;

    @ApiModelProperty(value = "缩略图URL")
    private String imageurl;

    @ApiModelProperty(value = "模板id")
    private String modelid;

    @ApiModelProperty(value = "内容主体")
    private String content;

    @ApiModelProperty(value = "操作时间")
    private Date createtime2;

    @ApiModelProperty(value = "操作类型，1创建，2保存，3保存并提审，4提审，5二审通过，6二审不通过，7三审通过，8三审不通过，9上线，10下线，11置顶")
    private Integer dtype;

    @ApiModelProperty(value = "操作人id")
    private String operatorid;

    @ApiModelProperty(value = "内容变化。0 无变化，1有变化")
    private Integer contentchange;

    public String getContentid() {
        return contentid;
    }

    public ContentVersion setContentid(String contentid) {
        this.contentid = contentid;
        return this;
    }
    public String getTitle() {
        return title;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public ContentVersion setTitle(String title) {
        this.title = title;
        return this;
    }
    public String getSubtitle() {
        return subtitle;
    }

    public ContentVersion setSubtitle(String subtitle) {
        this.subtitle = subtitle;
        return this;
    }
    public String getShouldertitle() {
        return shouldertitle;
    }

    public ContentVersion setShouldertitle(String shouldertitle) {
        this.shouldertitle = shouldertitle;
        return this;
    }
    public String getAuthor() {
        return author;
    }

    public ContentVersion setAuthor(String author) {
        this.author = author;
        return this;
    }
    public String getDescription() {
        return description;
    }

    public ContentVersion setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getImageid() {
        return imageid;
    }

    public ContentVersion setImageid(String imageid) {
        this.imageid = imageid;
        return this;
    }
    public String getImageurl() {
        return imageurl;
    }

    public ContentVersion setImageurl(String imageurl) {
        this.imageurl = imageurl;
        return this;
    }
    public String getModelid() {
        return modelid;
    }

    public ContentVersion setModelid(String modelid) {
        this.modelid = modelid;
        return this;
    }
    public String getContent() {
        return content;
    }

    public ContentVersion setContent(String content) {
        this.content = content;
        return this;
    }
    public Date getCreatetime2() {
        return createtime2;
    }

    public ContentVersion setCreatetime2(Date createtime2) {
        this.createtime2 = createtime2;
        return this;
    }
    public Integer getDtype() {
        return dtype;
    }

    public ContentVersion setDtype(Integer dtype) {
        this.dtype = dtype;
        return this;
    }
    public String getOperatorid() {
        return operatorid;
    }

    public ContentVersion setOperatorid(String operatorid) {
        this.operatorid = operatorid;
        return this;
    }
    public Integer getContentchange() {
        return contentchange;
    }

    public ContentVersion setContentchange(Integer contentchange) {
        this.contentchange = contentchange;
        return this;
    }

    @Override
    public String toString() {
        return "ContentVersion{" +
        "contentid=" + contentid +
        ", title=" + title +
        ", subtitle=" + subtitle +
        ", shouldertitle=" + shouldertitle +
        ", author=" + author +
        ", description=" + description +
        ", imageid=" + imageid +
        ", imageurl=" + imageurl +
        ", modelid=" + modelid +
        ", content=" + content +
        ", createtime2=" + createtime2 +
        ", dtype=" + dtype +
        ", operatorid=" + operatorid +
        ", contentchange=" + contentchange +
        "}";
    }
}

package cn.people.controller.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * @author guling
 * @ClassName: ImageUploadVO
 * @Description: 缩略图上传入参
 * @date 2019/1/11 11:16
 */
@ApiModel(value = "缩略图上传请求参数", description = "缩略图上传请求参数")
public class ImageCreateVO implements Serializable
{
    private static final long serialVersionUID = -4527112488023175219L;

    @ApiModelProperty(value = "类型。1，静态、2，模板、3，内容、4，栏目")
    private Integer dtype;

    @ApiModelProperty(value = "站点id")
    private String siteid;

    @ApiModelProperty(value = "栏目id")
    private String channelid;

    @ApiModelProperty(value = "内容id")
    private String contentid;

    @ApiModelProperty(value = "模板id")
    private String modelid;

    @ApiModelProperty(value = "图片位置")
    private String filepath;

    @ApiModelProperty(value = "来源类型,1CMS头图,2,CMS内容,3MAM上传,4外部导入")
    private Integer sourcetype;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "来源")
    private String source;

    public Integer getDtype()
    {
        return dtype;
    }

    public void setDtype(Integer dtype)
    {
        this.dtype = dtype;
    }

    public String getSiteid()
    {
        return siteid;
    }

    public void setSiteid(String siteid)
    {
        this.siteid = siteid;
    }

    public String getChannelid()
    {
        return channelid;
    }

    public void setChannelid(String channelid)
    {
        this.channelid = channelid;
    }

    

    public String getContentid()
    {
        return contentid;
    }

    public void setContentid(String contentid)
    {
        this.contentid = contentid;
    }

    public String getModelid()
    {
        return modelid;
    }

    public void setModelid(String modelid)
    {
        this.modelid = modelid;
    }

    public String getFilepath()
    {
        return filepath;
    }

    public void setFilepath(String filepath)
    {
        this.filepath = filepath;
    }

    public Integer getSourcetype()
    {
        return sourcetype;
    }

    public void setSourcetype(Integer sourcetype)
    {
        this.sourcetype = sourcetype;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    @Override
    public String toString()
    {
        return "ImageCreateVO{" + "dtype=" + dtype + ", siteid='" + siteid + '\'' + ", channelid="
               + channelid + ", contentid=" + contentid + ", modelid='" + modelid + '\''
               + ", filepath='" + filepath + '\'' + ", sourcetype=" + sourcetype + ", title='"
               + title + '\'' + ", description='" + description + '\'' + ", source='" + source
               + '\'' + '}';
    }
}

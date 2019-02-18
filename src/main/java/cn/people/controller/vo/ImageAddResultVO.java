package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * @author guling
 * @ClassName: ImageResultVO
 * @Description: 缩略图返回路劲(这里用一句话描述这个类的作用)
 * @date 2019/1/11 11:16
 */
@ApiModel(value="缩略图返回参数类型", description="缩略图返回参数类型")
public class ImageAddResultVO implements Serializable
{
    private static final long serialVersionUID = 2026342692971512279L;

    @ApiModelProperty(value="图片存储路径",name="url")
    private String  url;

    @ApiModelProperty(value="传输状态",name="state")
    private String state;

    @ApiModelProperty(value="标题",name="title")
    private String title;

    @ApiModelProperty(value="标题",name="original")
    private String original;

    @ApiModelProperty(value="返回信息",name="original")
    private String message;


    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getOriginal()
    {
        return original;
    }

    public void setOriginal(String original)
    {
        this.original = original;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}

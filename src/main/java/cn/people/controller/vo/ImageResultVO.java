package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * @author guling
 * @ClassName: ImageResultVO
 * @Description: 缩略图返回参数类型(这里用一句话描述这个类的作用)
 * @date 2019/1/11 11:16
 */
@ApiModel(value="缩略图返回参数类型", description="缩略图返回参数类型")
public class ImageResultVO implements Serializable
{
    private static final long serialVersionUID = 2026342692971512279L;

    @ApiModelProperty(value="id",name="id")
    private String  id;

    @ApiModelProperty(value="图片存储路径",name="filepath")
    private String  filepath;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getFilepath()
    {
        return filepath;
    }

    public void setFilepath(String filepath)
    {
        this.filepath = filepath;
    }
}

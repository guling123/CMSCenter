/**   
* @Title: ImageCutVO.java 
* @Package cn.people.controller.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2018年11月29日 下午2:09:56 
* @version V1.0   
*/
package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/** 
* @ClassName: ImageCutVO 
* @Description: 图片裁剪请求参数 
* @author shidandan
* @date 2018年11月29日 下午2:09:56 
*  
*/
@ApiModel(value="图片裁剪请求参数", description="图片裁剪请求参数")
public class ImageCutVO implements Serializable
{
    private static final long serialVersionUID = 617291355952451516L;
    
    @ApiModelProperty("原始图片ID")
    private String originImageId;
    
    @ApiModelProperty("新图片宽度")
    private Integer width;
    
    @ApiModelProperty("新图片高度")
    private Integer height;
    
    @ApiModelProperty("原图左上角")
    private Integer x;
    
    @ApiModelProperty("原图左上角")
    private Integer y;

    public Integer getWidth()
    {
        return width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

    public Integer getHeight()
    {
        return height;
    }

    public String getOriginImageId()
    {
        return originImageId;
    }

    public void setOriginImageId(String originImageId)
    {
        this.originImageId = originImageId;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public Integer getX()
    {
        return x;
    }

    public void setX(Integer x)
    {
        this.x = x;
    }

    public Integer getY()
    {
        return y;
    }

    public void setY(Integer y)
    {
        this.y = y;
    }
    
    
    
    
    
}

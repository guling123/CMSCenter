/**   
* @Title: ImageCompressVO.java 
* @Package cn.people.controller.vo 
* @Description: 图片压缩请求参数 
* @author shidandan
* @date 2018年11月29日 下午2:11:32 
* @version V1.0   
*/
package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/** 
* @ClassName: ImageCompressVO 
* @Description: 图片压缩请求参数 
* @author shidandan
* @date 2018年11月29日 下午2:11:32 
*  
*/
@ApiModel(value="图片压缩", description="图片压缩")
public class ImageCompressVO implements Serializable
{
    private static final long serialVersionUID = 4768294102962421198L;
    
    @ApiModelProperty("原始图片ID")
    private String originImageId;
    
    @ApiModelProperty(value = "压缩后的宽")
    private int width;
    
    @ApiModelProperty(value = "压缩后的高")
    private int height;
    
    @ApiModelProperty(value = "压缩质量（0-100）")
    private Double quality;

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public String getOriginImageId()
    {
        return originImageId;
    }

    public void setOriginImageId(String originImageId)
    {
        this.originImageId = originImageId;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public Double getQuality()
    {
        return quality;
    }

    public void setQuality(Double quality)
    {
        this.quality = quality;
    }
    
}
/**   
* @Title: OriginImageCopyVO.java 
* @Package cn.people.controller.vo 
* @Description: 原始图片复制 
* @author shidandan
* @date 2018年11月29日 下午3:41:15 
* @version V1.0   
*/
package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/** 
* @ClassName: OriginImageCopyVO 
* @Description: 原始图片复制
* @author shidandan
* @date 2018年11月29日 下午3:41:15 
*  
*/
@ApiModel(value="图片复制", description="图片复制")
public class ImageCopyVO implements Serializable
{

    /** 
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
    */ 
    private static final long serialVersionUID = 8632943068996693469L;
    
    @ApiModelProperty("图片ID")
    private String imageId;
    
    @ApiModelProperty("目标内容id")
    private String contentid;
    
    public String getImageId()
    {
        return imageId;
    }

    public void setImageId(String imageId)
    {
        this.imageId = imageId;
    }

    public String getContentid()
    {
        return contentid;
    }

    public void setContentid(String contentid)
    {
        this.contentid = contentid;
    }
    
}

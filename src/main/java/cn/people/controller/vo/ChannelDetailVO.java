/**   
* @Title: ChannelDetailVO.java 
* @Package cn.people.controller.vo 
* @Description: 栏目详情 
* @author shidandan
* @date 2018年12月20日 下午1:28:40 
* @version V1.0   
*/
package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: ChannelDetailVO 
* @Description: 栏目详情
* @author shidandan
* @date 2018年12月20日 下午1:28:40 
*  
*/
@ApiModel(value = "栏目详情", description = "栏目详情")
public class ChannelDetailVO extends ChannelCreateVO
{

    private static final long serialVersionUID = -3105787413734970719L;
    
    @ApiModelProperty(value = "栏目id")
    private String id;
    
    @ApiModelProperty(value = "栏目模板名称")
    private String channelModelName;

    @ApiModelProperty(value = "图文内容模板")
    private String contentModelName;

    @ApiModelProperty(value = "图集内容模板名称")
    private String imagesModelName;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getChannelModelName()
    {
        return channelModelName;
    }

    public void setChannelModelName(String channelModelName)
    {
        this.channelModelName = channelModelName;
    }

    public String getContentModelName()
    {
        return contentModelName;
    }

    public void setContentModelName(String contentModelName)
    {
        this.contentModelName = contentModelName;
    }

    public String getImagesModelName()
    {
        return imagesModelName;
    }

    public void setImagesModelName(String imagesModelName)
    {
        this.imagesModelName = imagesModelName;
    }
    
}

/**   
* @Title: UserChannelVO.java 
* @Package cn.people.controller.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2019年1月28日 下午2:25:47 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: UserChannelVO 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author shidandan
* @date 2019年1月28日 下午2:25:47 
*  
*/
@ApiModel(value = "用户常用栏目", description = "用户常用栏目")
public class UserChannelVO implements Serializable
{
    /** 
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
    */ 
    private static final long serialVersionUID = 2665204304544295638L;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "栏目ID")
    private String channelId;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getChannelId()
    {
        return channelId;
    }

    public void setChannelId(String channelId)
    {
        this.channelId = channelId;
    }

}

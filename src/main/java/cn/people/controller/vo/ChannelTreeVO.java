/**   
* @Title: ChannelTreeVO.java 
* @Package cn.people.controller.vo 
* @Description: 渠道树 
* @author shidandan
* @date 2019年1月3日 上午10:12:07 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: ChannelTreeVO 
* @Description:  渠道树
* @author shidandan
* @date 2019年1月3日 上午10:12:07 
*  
*/
public class ChannelTreeVO implements Serializable
{

    private static final long serialVersionUID = -707847564457723174L;
    @ApiModelProperty(value = "栏目名称")
    private String channelname;

    @ApiModelProperty(value = "栏目id")
    private String channelid;
    
    @ApiModelProperty(value = "父栏目id")
    private String parentid;
    
    @ApiModelProperty(value = "是否选中")
    private boolean checked=false;
    
    @ApiModelProperty(value = "下级节点列表")
    List<ChannelTreeVO> subList=new ArrayList<>();

    public String getChannelname()
    {
        return channelname;
    }

    public void setChannelname(String channelname)
    {
        this.channelname = channelname;
    }

    public String getChannelid()
    {
        return channelid;
    }

    public void setChannelid(String channelid)
    {
        this.channelid = channelid;
    }

    public String getParentid()
    {
        return parentid;
    }

    public void setParentid(String parentid)
    {
        this.parentid = parentid;
    }

    public boolean isChecked()
    {
        return checked;
    }

    public void setChecked(boolean checked)
    {
        this.checked = checked;
    }

    public List<ChannelTreeVO> getSubList()
    {
        return subList;
    }

    public void setSubList(List<ChannelTreeVO> subList)
    {
        this.subList = subList;
    }
}

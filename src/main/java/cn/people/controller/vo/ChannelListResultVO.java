/**   
* @Title: ChannelListResultVO.java 
* @Package cn.people.controller.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2018年12月20日 下午1:43:00 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: ChannelListResultVO 
* @Description: 栏目列表查询结果集 
* @author shidandan
* @date 2018年12月20日 下午1:43:00 
*  
*/
public class ChannelListResultVO extends ChannelVO
{

    private static final long serialVersionUID = 7122822396614444556L;
    @ApiModelProperty(value = "栏目类型 ，1 栏目，2专题")
    private Integer dtype;

    @ApiModelProperty(value = "栏目显示，0隐藏，1显示")
    private Integer display;
    
    @ApiModelProperty(value = "创建人")
    private String createrid;
    
    @ApiModelProperty(value = "创建时间")
    private Date creatertime;

    public Integer getDtype()
    {
        return dtype;
    }

    public void setDtype(Integer dtype)
    {
        this.dtype = dtype;
    }

    public Integer getDisplay()
    {
        return display;
    }

    public void setDisplay(Integer display)
    {
        this.display = display;
    }

    public String getCreaterid()
    {
        return createrid;
    }

    public void setCreaterid(String createrid)
    {
        this.createrid = createrid;
    }

    public Date getCreatertime()
    {
        return creatertime;
    }

    public void setCreatertime(Date creatertime)
    {
        this.creatertime = creatertime;
    }
}

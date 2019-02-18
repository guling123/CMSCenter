/**   
* @Title: ContentRecycledListVO.java 
* @Package cn.people.controller.vo 
* @Description: 回收站内容列表查询参数
* @author shidandan
* @date 2018年12月5日 下午2:05:37 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: ContentRecycledListVO 
* @Description: 回收站内容列表查询参数
* @author shidandan
* @date 2018年12月5日 下午2:05:37 
*  
*/
public class ContentRecycledListVO extends PageVO
{

    private static final long serialVersionUID = -6557993107060227127L;
    
    @ApiModelProperty(value = "站点ID")
    private String siteid;

    @ApiModelProperty(value = "栏目id")
    private String channelid;
    
    @ApiModelProperty(value = "标题")
    private String title;


    @ApiModelProperty(value = "来源id")
    private String sourceid;

    @ApiModelProperty(value = "删除开始时间")
    private Date deleteBeginTime;
    
    @ApiModelProperty(value = "删除结束时间")
    private Date deleteEndTime;

    public String getTitle()
    {
        return title;
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

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getSourceid()
    {
        return sourceid;
    }

    public void setSourceid(String sourceid)
    {
        this.sourceid = sourceid;
    }

    public Date getDeleteBeginTime()
    {
        return deleteBeginTime;
    }

    public void setDeleteBeginTime(Date deleteBeginTime)
    {
        this.deleteBeginTime = deleteBeginTime;
    }

    public Date getDeleteEndTime()
    {
        return deleteEndTime;
    }

    public void setDeleteEndTime(Date deleteEndTime)
    {
        this.deleteEndTime = deleteEndTime;
    }
    
    
}

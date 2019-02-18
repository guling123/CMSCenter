package cn.people.controller.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
* @ClassName: SplitDetailVO 
* @Description: 碎片详情反参对象
* @author zhangchengchun
* @date 2018年12月7日 上午9:42:41 
*  
 */
@ApiModel(value="碎片详情反参对象", description="碎片详情反参对象")
public class SplitDetailVO implements Serializable
{
    private static final long serialVersionUID = -6706748050012067723L;

    @ApiModelProperty(value = "碎片名称")
    private String splitname;

    @ApiModelProperty(value = "创建人")
    private String createrid;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    @ApiModelProperty(value = "碎片内容")
    private String splitcontent;

    @ApiModelProperty(value = "碎片作用域,1私有碎片,2公有碎片")
    private Integer scope;

    @ApiModelProperty(value = "碎片类型。 1 自动碎片，2手动碎片，3静态碎片")
    private Integer dtype;

    @ApiModelProperty(value = "碎片自动抓取栏目")
    private String channelid;

    @ApiModelProperty(value = "忽略条数")
    private Integer ignorenum;

    @ApiModelProperty(value = "抓取条数")
    private Integer fetchnum;
    
    @ApiModelProperty(value = "碎片内容集合")
    private List<SplitContent> splitContents=new ArrayList<SplitContent>();

    public String getSplitname()
    {
        return splitname;
    }

    public void setSplitname(String splitname)
    {
        this.splitname = splitname;
    }

    public String getCreaterid()
    {
        return createrid;
    }

    public void setCreaterid(String createrid)
    {
        this.createrid = createrid;
    }

    public Date getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(Date createtime)
    {
        this.createtime = createtime;
    }

    public String getSplitcontent()
    {
        return splitcontent;
    }

    public void setSplitcontent(String splitcontent)
    {
        this.splitcontent = splitcontent;
    }

    public Integer getScope()
    {
        return scope;
    }

    public void setScope(Integer scope)
    {
        this.scope = scope;
    }

    public Integer getDtype()
    {
        return dtype;
    }

    public void setDtype(Integer dtype)
    {
        this.dtype = dtype;
    }

    public String getChannelid()
    {
        return channelid;
    }

    public void setChannelid(String channelid)
    {
        this.channelid = channelid;
    }

    public Integer getIgnorenum()
    {
        return ignorenum;
    }

    public void setIgnorenum(Integer ignorenum)
    {
        this.ignorenum = ignorenum;
    }

    public Integer getFetchnum()
    {
        return fetchnum;
    }

    public void setFetchnum(Integer fetchnum)
    {
        this.fetchnum = fetchnum;
    }

    public List<SplitContent> getSplitContents()
    {
        return splitContents;
    }

    public void setSplitContents(List<SplitContent> splitContents)
    {
        this.splitContents = splitContents;
    }    
}

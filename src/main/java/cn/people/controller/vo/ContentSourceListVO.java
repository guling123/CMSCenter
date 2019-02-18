/**   
* @Title: ContentSourceListVO.java 
* @Package cn.people.controller.vo 
* @Description: 稿源列表查询 
* @author shidandan
* @date 2018年12月18日 下午3:04:02 
* @version V1.0   
*/
package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: ContentSourceListVO 
* @Description: 稿源列表查询
* @author shidandan
* @date 2018年12月18日 下午3:04:02 
*  
*/
@ApiModel(value = "稿源列表查询", description = "稿源列表查询")
public class ContentSourceListVO extends PageVO
{

    private static final long serialVersionUID = -1454193093809289869L;
    
    
    @ApiModelProperty(value = "来源名称")
    private String sourcenameOrId;

    @ApiModelProperty(value = "可信度")
    private Integer reliability;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "创建人")
    private String createrName;
    
    @ApiModelProperty(value = "站点ID")
    private String siteid;

    public String getSourcenameOrId()
    {
        return sourcenameOrId;
    }

    public String getSiteid()
    {
        return siteid;
    }

    public void setSiteid(String siteid)
    {
        this.siteid = siteid;
    }

    public void setSourcenameOrId(String sourcenameOrId)
    {
        this.sourcenameOrId = sourcenameOrId;
    }

    public Integer getReliability()
    {
        return reliability;
    }

    public void setReliability(Integer reliability)
    {
        this.reliability = reliability;
    }
    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public String getCreaterName()
    {
        return createrName;
    }

    public void setCreaterName(String createrName)
    {
        this.createrName = createrName;
    }
}

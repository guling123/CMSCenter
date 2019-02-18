/**   
* @Title: OriginImageListVO.java 
* @Package cn.people.controller.vo 
* @Description: 原始图片筛选
* @author shidandan
* @date 2018年11月29日 下午3:43:33 
* @version V1.0   
*/
package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/** 
* @ClassName: OriginImageListVO 
* @Description: 原始图片筛选参数
* @author shidandan
* @date 2018年11月29日 下午3:43:33 
*  
*/
@ApiModel(value="原始图片筛选参数", description="原始图片筛选参数")
public class OriginImageListVO implements Serializable
{

  
    private static final long serialVersionUID = 4045166814120952991L;
    @ApiModelProperty(value = "当前页", required = true)
    private int pageNo = 1;
    
    @ApiModelProperty(value = "每页条数", required = true)
    private int pageSize = 10;
    
    @ApiModelProperty(value = "站点id")
    private String siteid;

    @ApiModelProperty(value = "栏目id")
    private Integer channelid;

    @ApiModelProperty(value = "模板id")
    private String modelid;
    
    @ApiModelProperty(value = "内容id")
    private Integer contentid;

    public String getSiteid()
    {
        return siteid;
    }

    public void setSiteid(String siteid)
    {
        this.siteid = siteid;
    }

    public int getPageNo()
    {
        return pageNo;
    }

    public void setPageNo(int pageNo)
    {
        this.pageNo = pageNo;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public Integer getChannelid()
    {
        return channelid;
    }

    public void setChannelid(Integer channelid)
    {
        this.channelid = channelid;
    }

    public String getModelid()
    {
        return modelid;
    }

    public void setModelid(String modelid)
    {
        this.modelid = modelid;
    }

    public Integer getContentid()
    {
        return contentid;
    }

    public void setContentid(Integer contentid)
    {
        this.contentid = contentid;
    } 
    
    
    
}

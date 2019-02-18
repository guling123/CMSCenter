/**   
* @Title: WatermarkListVO.java 
* @Package cn.people.controller.vo 
* @Description: 站点水印列表查询参数 
* @author shidandan
* @date 2018年11月29日 上午10:58:59 
* @version V1.0   
*/
package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/** 
* @ClassName: WatermarkListVO 
* @Description: 站点水印列表查询参数 
* @author shidandan
* @date 2018年11月29日 上午10:58:59 
*  
*/
@ApiModel(value="站点水印列表", description="站点水印列表请求参数")
public class WatermarkListVO implements Serializable
{

    private static final long serialVersionUID = -7811580373592761103L;
    
    @ApiModelProperty(value = "当前页", required = true)
    private int pageNo = 1;
    
    @ApiModelProperty(value = "每页条数", required = true)
    private int pageSize = 10;
    
    @ApiModelProperty(value = "站点名称")
    private String siteName;
    
    @ApiModelProperty(value = "水印类型")
    private String type;
    
    @ApiModelProperty(value = "水印状态")
    private String status;

    public String getSiteName()
    {
        return siteName;
    }

    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
    
    
    
}

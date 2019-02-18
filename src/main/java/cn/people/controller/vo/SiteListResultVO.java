/**   
* @Title: SiteListResultVO.java 
* @Package cn.people.controller.vo 
* @Description: 站点列表查询结果 
* @author shidandan
* @date 2018年12月12日 下午7:35:22 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SiteListResultVO 
* @Description: 站点列表查询结果
* @author shidandan
* @date 2018年12月12日 下午7:35:22 
*  
*/
@ApiModel(value = "站点列表查询结果", description = "站点列表查询结果")
public class SiteListResultVO implements Serializable
{

    private static final long serialVersionUID = 560782763450771482L;
    @ApiModelProperty(value = "站点名称")
    private String id;
    
    @ApiModelProperty(value = "站点名称")
    private String sitename;

    @ApiModelProperty(value = "站点描述")
    private String description;

    @ApiModelProperty(value = "域名")
    private String domain;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    @ApiModelProperty(value = "创建人")
    private String createrid;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSitename()
    {
        return sitename;
    }

    public void setSitename(String sitename)
    {
        this.sitename = sitename;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDomain()
    {
        return domain;
    }

    public void setDomain(String domain)
    {
        this.domain = domain;
    }

    public Date getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(Date createtime)
    {
        this.createtime = createtime;
    }

    public String getCreaterid()
    {
        return createrid;
    }

    public void setCreaterid(String createrid)
    {
        this.createrid = createrid;
    }
    
}

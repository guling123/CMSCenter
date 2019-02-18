/**   
* @Title: SiteVO.java 
* @Package cn.people.controller.vo 
* @Description: 站点详情 
* @author shidandan
* @date 2018年12月28日 下午2:29:23 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;

import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SiteVO 
* @Description: 站点详情 
* @author shidandan
* @date 2018年12月28日 下午2:29:23 
*  
*/
public class SiteVO implements Serializable
{

    private static final long serialVersionUID = -6105998224252510594L;
    
    @ApiModelProperty(value = "站点id")
    private String id;
    
    @ApiModelProperty(value = "站点名称")
    private String sitename;

    @ApiModelProperty(value = "站点名称")
    private String description;

    @ApiModelProperty(value = "域名")
    private String domain;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    @ApiModelProperty(value = "创建人")
    private String createrName;

    @ApiModelProperty(value = "租户id")
    @TableField("orgid")
    private String orgid;

    public String getSitename()
    {
        return sitename;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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

    public String getCreaterName()
    {
        return createrName;
    }

    public void setCreaterName(String createrName)
    {
        this.createrName = createrName;
    }

    public String getOrgid()
    {
        return orgid;
    }

    public void setOrgid(String orgid)
    {
        this.orgid = orgid;
    }
    
}

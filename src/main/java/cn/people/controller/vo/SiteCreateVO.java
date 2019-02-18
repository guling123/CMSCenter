/**   
* @Title: SiteCreateVO.java 
* @Package cn.people.controller.vo 
* @Description: 站点基本信息
* @author shidandan
* @date 2018年12月28日 下午3:45:43 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SiteCreateVO 
* @Description: 站点基本信息
* @author shidandan
* @date 2018年12月28日 下午3:45:43 
*  
*/
@ApiModel(value = "站点基本信息", description = "站点基本信息")
public class SiteCreateVO implements Serializable
{

    private static final long serialVersionUID = 1007274861260155868L;
    @ApiModelProperty(value = "站点名称")
    @TableField("sitename")
    private String sitename;

    @ApiModelProperty(value = "站点名称")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "域名")
    @TableField("domain")
    private String domain;

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
}

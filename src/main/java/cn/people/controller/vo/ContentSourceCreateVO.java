/**   
* @Title: ContentSourceCreateVO.java 
* @Package cn.people.controller.vo 
* @Description: 创建稿源请求参数
* @author shidandan
* @date 2018年12月18日 下午2:34:25 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: ContentSourceCreateVO 
* @Description: 创建稿源请求参数
* @author shidandan
* @date 2018年12月18日 下午2:34:25 
*  
*/
@ApiModel(value = "创建稿源请求参数", description = "创建稿源请求参数")
public class ContentSourceCreateVO implements Serializable
{

    private static final long serialVersionUID = -8195094127892036901L;
    
    @NotBlank(message="站点id不能为空")
    @ApiModelProperty(value = "站点id")
    private String siteid;

    @NotBlank(message="来源名称不能为空")
    @ApiModelProperty(value = "来源名称")
    private String sourcename;

    @ApiModelProperty(value = "来源域名")
    private String domain;

    @ApiModelProperty(value = "状态")
    private String sourceUrl;

    @ApiModelProperty(value = "可信度")
    private Integer reliability;

    @ApiModelProperty(value = "有效期")
    private Date limitDate;

    @ApiModelProperty(value = "状态")
    private Integer status;

    public String getSiteid()
    {
        return siteid;
    }

    public void setSiteid(String siteid)
    {
        this.siteid = siteid;
    }

    public String getSourcename()
    {
        return sourcename;
    }

    public void setSourcename(String sourcename)
    {
        this.sourcename = sourcename;
    }

    public String getDomain()
    {
        return domain;
    }

    public void setDomain(String domain)
    {
        this.domain = domain;
    }

    public Integer getReliability()
    {
        return reliability;
    }

    public void setReliability(Integer reliability)
    {
        this.reliability = reliability;
    }

    public String getSourceUrl()
    {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl)
    {
        this.sourceUrl = sourceUrl;
    }

    public Date getLimitDate()
    {
        return limitDate;
    }

    public void setLimitDate(Date limitDate)
    {
        this.limitDate = limitDate;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }
} 

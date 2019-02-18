/**   
* @Title: SysOrgCreateVO.java 
* @Package cn.people.controller.vo 
* @Description: 添加租户 
* @author shidandan
* @date 2018年12月13日 下午2:25:50 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysOrgCreateVO 
* @Description: 添加租户
* @author shidandan
* @date 2018年12月13日 下午2:25:50 
*  
*/
@ApiModel(value = "添加租户", description = "添加租户")
public class SysOrgCreateVO implements Serializable
{

    private static final long serialVersionUID = -4089680056427385247L;
    
    @NotBlank(message = "租户名称不能为空")
    @ApiModelProperty(value = "租户名称")
    private String orgname;

    @ApiModelProperty(value = "租户描述")
    private String description;
    

    public String getOrgname()
    {
        return orgname;
    }

    public void setOrgname(String orgname)
    {
        this.orgname = orgname;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}

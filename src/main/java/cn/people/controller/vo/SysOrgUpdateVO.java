/**   
* @Title: SysOrgUpdateVO.java 
* @Package cn.people.controller.vo 
* @Description: 租户更新参数 
* @author shidandan
* @date 2018年12月13日 下午2:31:28 
* @version V1.0   
*/
package cn.people.controller.vo;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysOrgUpdateVO 
* @Description: 租户更新参数
* @author shidandan
* @date 2018年12月13日 下午2:31:28 
*  
*/
@ApiModel(value = "更新租户", description = "更新租户")
public class SysOrgUpdateVO extends SysOrgCreateVO
{

    private static final long serialVersionUID = 2035197816517385476L;
    
    @NotBlank(message = "租户主键id")
    @ApiModelProperty(value = "租户主键id")
    private String id;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

}

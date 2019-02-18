/**   
* @Title: SysOrgListVO.java 
* @Package cn.people.controller.vo 
* @Description: 租户分页查询得参数 
* @author shidandan
* @date 2018年12月13日 下午2:34:51 
* @version V1.0   
*/
package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysOrgListVO 
* @Description: 租户分页查询得参数
* @author shidandan
* @date 2018年12月13日 下午2:34:51 
*  
*/
@ApiModel(value = "租户分页查询得参数", description = "租户分页查询得参数")
public class SysOrgListVO extends PageVO 
{
    
    private static final long serialVersionUID = 459908754854479047L;

    @ApiModelProperty(value = "租户id或是姓名")
    private String orgidOrName;
    
    @ApiModelProperty(value = "状态，0禁用，1可用")
    private Integer dtatus;
    
    @ApiModelProperty(value = "创建人")
    private String creater;

    public String getCreater()
    {
        return creater;
    }

    public void setCreater(String creater)
    {
        this.creater = creater;
    }
    public String getOrgidOrName()
    {
        return orgidOrName;
    }

    public void setOrgidOrName(String orgidOrName)
    {
        this.orgidOrName = orgidOrName;
    }

    public Integer getDtatus()
    {
        return dtatus;
    }

    public void setDtatus(Integer dtatus)
    {
        this.dtatus = dtatus;
    }
}

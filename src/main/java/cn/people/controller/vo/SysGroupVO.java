/**   
* @Title: SysGroupVO.java 
* @Package cn.people.controller.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2018年12月13日 下午2:18:19 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysGroupVO 
* @Description: 账户组
* @author shidandan
* @date 2018年12月13日 下午2:18:19 
*  
*/
@ApiModel(value = "账户组", description = "账户组")
public class SysGroupVO implements Serializable
{

    private static final long serialVersionUID = -6923353315717206988L;
    
    @ApiModelProperty(value = "管理组名称")
    private String groupname;
    
    @ApiModelProperty(value = "管理组id")
    private String groupid;
    
    @ApiModelProperty(value = "管理组描述")
    private String description;


    public String getGroupname()
    {
        return groupname;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setGroupname(String groupname)
    {
        this.groupname = groupname;
    }

    public String getGroupid()
    {
        return groupid;
    }

    public void setGroupid(String groupid)
    {
        this.groupid = groupid;
    }
}

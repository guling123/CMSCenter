/**   
* @Title: SysRoleUpdateVO.java 
* @Package cn.people.controller.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2018年12月13日 上午9:20:12 
* @version V1.0   
*/
package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysRoleUpdateVO 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author shidandan
* @date 2018年12月13日 上午9:20:12 
*  
*/
@ApiModel(value = "更新角色", description = "更新角色")
public class SysRoleUpdateVO extends SysRoleCreateVO
{

    private static final long serialVersionUID = 8533564091503802701L;
    
    @ApiModelProperty(value = "ID")
    private String id;
    
    @ApiModelProperty(value = "角色ID")
    private String roleid;

    
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getRoleid()
    {
        return roleid;
    }

    public void setRoleid(String roleid)
    {
        this.roleid = roleid;
    }
    
}

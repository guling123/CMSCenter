/**   
* @Title: SysRoleDetailVO.java 
* @Package cn.people.controller.vo 
* @Description: 角色详情
* @author shidandan
* @date 2018年12月13日 上午9:22:27 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysRoleDetailVO 
* @Description: 角色详情 
* @author shidandan
* @date 2018年12月13日 上午9:22:27 
*  
*/
@ApiModel(value = "角色详情", description = "角色详情")
public class SysRoleDetailVO implements Serializable
{

    private static final long serialVersionUID = 3964247591063153326L;
    
    @ApiModelProperty(value = "角色ID")
    private String roleid;
    
    @ApiModelProperty(value = "角色标识")
    private String ident;

    @ApiModelProperty(value = "角色名称")
    private String rolename;
    
    @ApiModelProperty(value = "角色描述")
    private String roleDesc;

    @ApiModelProperty(value = "角色权限集合")
    private  List<String> permissionList;

    public String getRoleid()
    {
        return roleid;
    }

    public String getRoleDesc()
    {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc)
    {
        this.roleDesc = roleDesc;
    }

    public void setRoleid(String roleid)
    {
        this.roleid = roleid;
    }

    public String getIdent()
    {
        return ident;
    }

    public void setIdent(String ident)
    {
        this.ident = ident;
    }

    public String getRolename()
    {
        return rolename;
    }

    public void setRolename(String rolename)
    {
        this.rolename = rolename;
    }

    public List<String> getPermissionList()
    {
        return permissionList;
    }

    public void setPermissionList(List<String> permissionList)
    {
        this.permissionList = permissionList;
    }
    
}

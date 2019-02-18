/**   
* @Title: SysRoleCreateVO.java 
* @Package cn.people.controller.vo 
* @Description: 创建角色请求参数 
* @author shidandan
* @date 2018年12月12日 下午7:46:33 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysRoleCreateVO 
* @Description: 创建角色请求参数 
* @author shidandan
* @date 2018年12月12日 下午7:46:33 
*  
*/
@ApiModel(value = "创建角色请求参数", description = "创建角色请求参数")
public class SysRoleCreateVO implements Serializable
{

    private static final long serialVersionUID = -2142572693955635982L;
    
    @ApiModelProperty(value = "角色描述")
    @TableField("role_desc")
    private String roleDesc;

    @ApiModelProperty(value = "角色名称")
    private String rolename;

    @ApiModelProperty(value = "角色权限集合")
    private List<String> permissionids;


    public String getRoleDesc()
    {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc)
    {
        this.roleDesc = roleDesc;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    public String getRolename()
    {
        return rolename;
    }

    public void setRolename(String rolename)
    {
        this.rolename = rolename;
    }

    public List<String> getPermissionids()
    {
        return permissionids;
    }

    public void setPermissionids(List<String> permissionids)
    {
        this.permissionids = permissionids;
    }
}

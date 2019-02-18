/**   
* @Title: SysPermissionVO.java 
* @Package cn.people.controller.vo 
* @Description: 角色权限 
* @author shidandan
* @date 2018年12月12日 下午7:49:04 
* @version V1.0   
*/
package cn.people.controller.vo;


import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysPermissionVO 
* @Description: 角色权限
* @author shidandan
* @date 2018年12月12日 下午7:49:04 
*  
*/
public class SysPermissionVO implements Serializable
{
    private static final long serialVersionUID = -8236220182211889088L;
    
    @ApiModelProperty(value = "id")
    private String id;
    
    @ApiModelProperty(value = "权限标识")
    private String ident;

    @ApiModelProperty(value = "权限名称")
    private String permissionname;
    
    @ApiModelProperty(value = "权限名称")
    private String permissionid;
    
    @ApiModelProperty(value = "父权限ID")
    private String parentpermissionid;
    
    @ApiModelProperty(value = "权限是否选中")
    private boolean checked ;

    public String getIdent()
    {
        return ident;
    }

    public void setIdent(String ident)
    {
        this.ident = ident;
    }

    public String getParentpermissionid()
    {
        return parentpermissionid;
    }

    public void setParentpermissionid(String parentpermissionid)
    {
        this.parentpermissionid = parentpermissionid;
    }

    public boolean isChecked()
    {
        return checked;
    }

    public void setChecked(boolean checked)
    {
        this.checked = checked;
    }

    public String getPermissionname()
    {
        return permissionname;
    }

    public void setPermissionname(String permissionname)
    {
        this.permissionname = permissionname;
    }

    public String getPermissionid()
    {
        return permissionid;
    }

    public void setPermissionid(String permissionid)
    {
        this.permissionid = permissionid;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    
}

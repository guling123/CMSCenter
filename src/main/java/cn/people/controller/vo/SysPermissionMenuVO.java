/**   
* @Title: SysPermissionMenuVO.java 
* @Package cn.people.controller.vo 
* @Description: 菜单类权限树  
* @author shidandan
* @date 2018年12月13日 上午9:55:27 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysPermissionMenuVO 
* @Description: 菜单类权限树 
* @author shidandan
* @date 2018年12月13日 上午9:55:27 
*  
*/
@ApiModel(value="菜单类权限树", description="菜单类权限树")
public class SysPermissionMenuVO implements Serializable
{

    private static final long serialVersionUID = -8161987141981368022L;

    @ApiModelProperty(value = "权限集合")
    private List<String> permissions;
    
    @ApiModelProperty(value = "菜单树")
    private SysPermissionTreeVO menuTree;

    public SysPermissionTreeVO getMenuTree()
    {
        return menuTree;
    }

    public void setMenuTree(SysPermissionTreeVO menuTree)
    {
        this.menuTree = menuTree;
    }

    public List<String> getPermissions()
    {
        return permissions;
    }

    public void setPermissions(List<String> permissions)
    {
        this.permissions = permissions;
    }
}

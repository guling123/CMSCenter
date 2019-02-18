/**   
* @Title: SysPermissionTreeVO.java 
* @Package cn.people.controller.vo 
* @Description: 角色权限 
* @author fuqiang
* @date 2018年12月18日 下午7:49:04 
* @version V1.0   
*/
package cn.people.controller.vo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;

import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysPermissionTreeVO 
* @Description: 角色权限树
* @author fuqiang
* @date 2018年12月18日 下午7:49:04 
*  
*/
public class SysPermissionTreeVO implements Serializable
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
    
    @ApiModelProperty(value = "父节点")
    private String parentId;
    
    @ApiModelProperty(value = "菜单的URL，配合前端显示菜单")
    private String preUrl;
    
    @ApiModelProperty(value = "是否显示站点树")
    private Integer siteShow;
    
    @ApiModelProperty(value = "排序")
    @TableField("sort_index")
    private Integer sortIndex;
    
    @ApiModelProperty(value = "权限是否选中")
    private boolean checked ;
    
    @ApiModelProperty(value = "下级节点列表")
    List<SysPermissionTreeVO> subList=new ArrayList<>();

    public Integer getSiteShow()
    {
        return siteShow;
    }

    public void setSiteShow(Integer siteShow)
    {
        this.siteShow = siteShow;
    }

    public String getIdent()
    {
        return ident;
    }

    public void setIdent(String ident)
    {
        this.ident = ident;
    }

    public String getPreUrl()
    {
        return preUrl;
    }

    public void setPreUrl(String preUrl)
    {
        this.preUrl = preUrl;
    }

    public String getParentId()
    {
        return parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
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

    public List<SysPermissionTreeVO> getSubList()
    {
        return subList;
    }

    public void setSubList(List<SysPermissionTreeVO> subList)
    {
        this.subList = subList;
    }

    public Integer getSortIndex()
    {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex)
    {
        this.sortIndex = sortIndex;
    }
    @Override
    public String toString()
    {
        return "[id="+id+",parentid="+parentId+"]";
    }
    
    
}

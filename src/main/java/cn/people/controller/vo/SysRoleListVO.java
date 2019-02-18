/**   
* @Title: SysRoleListVO.java 
* @Package cn.people.controller.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2018年12月13日 上午9:34:39 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;

import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysRoleListVO 
* @Description: 角色列表查询
* @author shidandan
* @date 2018年12月13日 上午9:34:39 
*  
*/
public class SysRoleListVO implements Serializable
{
    
    private static final long serialVersionUID = 5468759846350014801L;

    @ApiModelProperty(value = "角色ID")
    private String roleid;
    
    @ApiModelProperty(value = "角色标识")
    @TableField("ident")
    private String ident;

    @ApiModelProperty(value = "角色名称")
    @TableField("rolename")
    private String rolename;
    
    @ApiModelProperty(value = "角色描述")
    @TableField("role_desc")
    private String roleDesc;

    @ApiModelProperty(value = "创建时间")
    @TableField("createtime")
    private Date createtime;

    @ApiModelProperty(value = "创建人id")
    @TableField("createrid")
    private String createrid;
    
    @ApiModelProperty(value = "创建人名称")
    private String creatername;

    public String getRoleid()
    {
        return roleid;
    }

    public void setRoleid(String roleid)
    {
        this.roleid = roleid;
    }

    public String getCreatername()
    {
        return creatername;
    }

    public void setCreatername(String creatername)
    {
        this.creatername = creatername;
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

    public Date getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(Date createtime)
    {
        this.createtime = createtime;
    }

    public String getCreaterid()
    {
        return createrid;
    }

    public void setCreaterid(String createrid)
    {
        this.createrid = createrid;
    }

    public String getRoleDesc()
    {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc)
    {
        this.roleDesc = roleDesc;
    }
    
}

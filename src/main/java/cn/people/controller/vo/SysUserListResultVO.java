/**   
* @Title: SysUserListResultVO.java 
* @Package cn.people.controller.vo 
* @Description: 用户列表查询结果 
* @author shidandan
* @date 2018年12月13日 上午10:17:33 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysUserListResultVO 
* @Description: 用户列表查询结果
* @author shidandan
* @date 2018年12月13日 上午10:17:33 
*  
*/
public class SysUserListResultVO implements Serializable
{

    private static final long serialVersionUID = -1562384872281700875L;
    
    @ApiModelProperty(value = "登录用户逻辑ID")
    private Integer userid;
    
    @ApiModelProperty(value = "登录用户ID")
    private String id;
    
    @ApiModelProperty(value = "登录用户名")
    private String username;

    @ApiModelProperty(value = "真实姓名")
    private String realname;

    @ApiModelProperty(value = "角色名称")
    private String rolename;

    @ApiModelProperty(value = "账户组")
    private String groupname;

    @ApiModelProperty(value = "用户状态,0禁用 , 1启用")
    private Integer dstatus;

    @ApiModelProperty(value = "创建人id")
    private String createrid;
    
    @ApiModelProperty(value = "创建人姓名")
    private String creatername;
    
    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    public String getCreatername()
    {
        return creatername;
    }

    public Integer getUserid()
    {
        return userid;
    }

    public void setUserid(Integer userid)
    {
        this.userid = userid;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setCreatername(String creatername)
    {
        this.creatername = creatername;
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

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getRealname()
    {
        return realname;
    }

    public void setRealname(String realname)
    {
        this.realname = realname;
    }

    public Integer getDstatus()
    {
        return dstatus;
    }

    public void setDstatus(Integer dstatus)
    {
        this.dstatus = dstatus;
    }

    public String getRolename()
    {
        return rolename;
    }

    public void setRolename(String rolename)
    {
        this.rolename = rolename;
    }

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
    
    
}

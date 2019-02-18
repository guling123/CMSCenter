/**   
* @Title: SysUserUpdateVO.java 
* @Package cn.people.controller.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2018年12月13日 上午10:03:39 
* @version V1.0   
*/
package cn.people.controller.vo;


import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysUserUpdateVO 
* @Description: 更新账户信息 
* @author shidandan
* @date 2018年12月13日 上午10:03:39 
*  
*/
public class SysUserUpdateVO implements Serializable
{

    private static final long serialVersionUID = 6147935140303159252L;
    
    @NotBlank(message = "账户ID不能为空")
    @ApiModelProperty(value = "账户ID")
    private String userid;
    
    //@NotBlank(message = "账户名不能为空")
    @ApiModelProperty(value = "账户名")
    private String username;

    @ApiModelProperty(value = "真实姓名")
    private String realname;

    //@NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String pwd;
    
    //@NotBlank(message = "用户状态不能为空")
    @ApiModelProperty(value = "用户状态,0禁用 , 1启用")
    private Integer dstatus;

    @ApiModelProperty(value = "角色id")
    private String roleid;

    public String getUserid()
    {
        return userid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
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

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    public Integer getDstatus()
    {
        return dstatus;
    }

    public void setDstatus(Integer dstatus)
    {
        this.dstatus = dstatus;
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

/**   
* @Title: SysUserCreateVO.java 
* @Package cn.people.controller.vo 
* @Description: 账户创建参数 
* @author shidandan
* @date 2018年12月13日 上午10:00:57 
* @version V1.0   
*/
package cn.people.controller.vo;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysUserCreateVO 
* @Description: 账户创建参数
* @author shidandan
* @date 2018年12月13日 上午10:00:57 
*  
*/
@ApiModel(value = "添加账户", description = "添加账户")
public class SysUserCreateVO implements Serializable
{

    private static final long serialVersionUID = -1220864712049373205L;

    @NotBlank(message = "账户名不能为空")
    @ApiModelProperty(value = "账户名")
    private String username;

    @ApiModelProperty(value = "真实姓名")
    private String realname;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String pwd;
    
    //@NotBlank(message = "用户状态不能为空")
    @ApiModelProperty(value = "用户状态,0禁用 , 1启用")
    private Integer dstatus;

    @ApiModelProperty(value = "角色id")
    private String roleid;

    @NotBlank(message = "用户角色标识不能为空")
    @ApiModelProperty(value = "用户角色标识，1.租户超管，0.平常用户")
    private String ident;
    
    @ApiModelProperty(value = "租户id")
    private String orgId;

    public String getOrgId()
    {
        return orgId;
    }
    public void setOrgId(String orgId)
    {
        this.orgId = orgId;
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
    public String getIdent()
    {
        return ident;
    }
    public void setIdent(String ident)
    {
        this.ident = ident;
    }
    public void setRoleid(String roleid)
    {
        this.roleid = roleid;
    }

}

/**   
* @Title: SysUserVO.java 
* @Package cn.people.controller.vo 
* @Description: 用户基本信息
* @author shidandan
* @date 2018年12月17日 下午7:07:17 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysUserVO 
* @Description: 用户基本信息
* @author shidandan
* @date 2018年12月17日 下午7:07:17 
*  
*/
@ApiModel(value = "用户基本信息", description = "用户基本信息")
public class SysUserVO implements Serializable
{

    private static final long serialVersionUID = -884271175849467576L;
    @ApiModelProperty(value = "登录用户ID")
    private String userid;
    
    @ApiModelProperty(value = "账户名")
    private String username;

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
    
} 

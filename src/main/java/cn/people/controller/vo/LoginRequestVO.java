/**   
* @Title: LoginRequestVO.java 
* @Package cn.people.controller.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2019年1月18日 上午9:47:17 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: LoginRequestVO 
* @Description: 登录请求 
* @author shidandan
* @date 2019年1月18日 上午9:47:17 
*  
*/
@ApiModel(value = "登陆请求参数", description = "登陆请求参数")
public class LoginRequestVO implements Serializable
{

    private static final long serialVersionUID = 3772169050976768349L;
    @ApiModelProperty(value = "用户名")
    private String username;//用户名
    
    @ApiModelProperty(value = "密码")
    private String password;//密码
    
    @ApiModelProperty(value = "验证码")
    private String vcode;//验证码

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getVcode()
    {
        return vcode;
    }

    public void setVcode(String vcode)
    {
        this.vcode = vcode;
    }
}

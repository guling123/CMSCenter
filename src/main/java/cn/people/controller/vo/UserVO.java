/**   
* @Title: UserVO.java 
* @Package cn.people.controller.vo 
* @Description: 账户创建参数 
* @author shidandan
* @date 2018年12月18日 上午10:00:57 
* @version V1.0   
*/
package cn.people.controller.vo;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: UserVO 
* @Description: 用户对象
* @author shidandan
* @date 2018年12月13日 上午10:00:57 
*  
*/
@ApiModel(value = "用户对象", description = "删除角色关联的账户")
public class UserVO implements Serializable
{
    private static final long serialVersionUID = -5746352108776516822L;

    
    @ApiModelProperty(value = "账户名")
    private String username;

    @ApiModelProperty(value = "真实姓名")
    private String realname;

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

}

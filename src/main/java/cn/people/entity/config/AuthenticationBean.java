/**   
* @Title: AuthenticationBean.java 
* @Package cn.people.entity.config 
* @Description: 登陆数据 
* @author shidandan
* @date 2018年12月28日 下午5:39:58 
* @version V1.0   
*/
package cn.people.entity.config;

/** 
* @ClassName: AuthenticationBean 
* @Description: 登陆数据  
* @author shidandan
* @date 2018年12月28日 下午5:39:58 
*  
*/
public class AuthenticationBean {
    private String username;//用户名
    private String password;//密码
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


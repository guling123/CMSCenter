/**   
* @Title: MyAuthenticationFilter.java 
* @Package cn.people.entity.config 
* @Description: 使登陆支持JSON
* @author shidandan
* @date 2018年12月28日 下午5:26:47 
* @version V1.0   
*/
package cn.people.entity.config;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import cn.people.commons.exceptions.MyAuthenticationException;

/** 
* @ClassName: MyAuthenticationFilter 
* @Description: 使登陆支持JSON
* @author shidandan
* @date 2018年12月28日 下午5:26:47 
*  
*/
public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
    @SuppressWarnings("finally")
    public Authentication attemptAuthentication(HttpServletRequest request,HttpServletResponse response) throws AuthenticationException {
        
        
       //attempt Authentication when Content-Type is json
        if(request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)
                ||request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)){

            ObjectMapper mapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken authRequest = null;
            try (InputStream is = request.getInputStream()){
                AuthenticationBean authenticationBean = mapper.readValue(is,AuthenticationBean.class);
                Object codeObject = request.getSession().getAttribute("vcode");
                System.out.println("===login====vcode:"+codeObject.toString());
                if (codeObject == null || !StringUtils.equalsIgnoreCase(codeObject.toString(), authenticationBean.getVcode())) {
                    throw new MyAuthenticationException("验证码错误请重新输入");
                }
                authRequest = new UsernamePasswordAuthenticationToken(
                        authenticationBean.getUsername(), authenticationBean.getPassword());
            }catch (MyAuthenticationException a) {
                throw a;
            }
            catch (Exception e) {
                authRequest = new UsernamePasswordAuthenticationToken(
                        "", "");
            }
            setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }

        else {
            return super.attemptAuthentication(request, response);
        }  
    }
    
    

}

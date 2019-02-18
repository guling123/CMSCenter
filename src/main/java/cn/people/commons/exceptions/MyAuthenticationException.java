package cn.people.commons.exceptions;

import org.springframework.security.core.AuthenticationException;
/**
 * 
* @ClassName: MyAuthenticationException 
* @Description: 登录异常处理类 
* @author shidandan
* @date 2019年1月18日 上午9:35:37 
*  
 */
public class MyAuthenticationException extends AuthenticationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1140466947463128486L;

	public MyAuthenticationException(String msg) {
		super(msg);
	}

}

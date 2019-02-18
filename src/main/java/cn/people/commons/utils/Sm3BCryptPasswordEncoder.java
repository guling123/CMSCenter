package cn.people.commons.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/** 
* @ClassName: Sm3BCryptPasswordEncoder 
* @Description: Sm3嫁接 BCrypt 用于密码校验
* @author gaoyongjiu
* @date 2018年12月19日 上午9:22:17 
*  
*/
public class Sm3BCryptPasswordEncoder extends BCryptPasswordEncoder {

	private final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		if (encodedPassword == null || encodedPassword.length() == 0) {
			logger.warn("Empty encoded password");
			return false;
		}
		
		// 获取用户盐值
		String sm3Salt = encodedPassword.substring(0,10);
		// 还原security密码
		encodedPassword = encodedPassword.substring(10);
		
		// 对用户输入密码进行sm3加密
		rawPassword = Sm3Utils.encryptWithSalt(rawPassword.toString(), sm3Salt);
		
		return super.matches(rawPassword, encodedPassword);
	}
}

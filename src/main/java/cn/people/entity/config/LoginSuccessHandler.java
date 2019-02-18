package cn.people.entity.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.alibaba.fastjson.JSONObject;

import cn.people.controller.vo.ResultVO;

/**
 * <p>
   *  登录成功处理器，以json方式返回
 * </p>
 *
 * @author gaoyongjiu
 * @since 2018-12-19
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		ResultVO<Authentication> respBean = ResultVO.ok(authentication);
        response.reset(); // 必要地清除response中的缓存信息
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
		response.getOutputStream().write(JSONObject.toJSONString(respBean).getBytes());
		response.flushBuffer();
	}

}

package cn.people.entity.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.alibaba.fastjson.JSONObject;

import cn.people.commons.constants.CodeConstants;
import cn.people.commons.exceptions.MyAuthenticationException;
import cn.people.controller.vo.ResultVO;

/**
 * <p>
   *  登录失败处理器，以json方式返回
 * </p>
 *
 * @author gaoyongjiu
 * @since 2018-12-19
 */
public class LoginFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		ResultVO<Authentication> respBean =null;
        if(exception instanceof DisabledException) {
            respBean = ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM,"账户被禁用，请联系管理员!");
        }else if(exception instanceof MyAuthenticationException) {
            respBean = ResultVO.badRequest(CodeConstants.VCODE_ERR,exception.getMessage());
        }
        else {
            respBean = ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM,"用户名或密码错误！");
        }
        response.reset(); // 必要地清除response中的缓存信息
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
		response.getOutputStream().write(JSONObject.toJSONString(respBean).getBytes());
	}

}

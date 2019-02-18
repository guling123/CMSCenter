package cn.people.entity.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.alibaba.fastjson.JSONObject;

import cn.people.commons.constants.CodeConstants;
import cn.people.controller.vo.ResultVO;

/**
 * <p>
   *  权限不足，以json方式返回
 * </p>
 *
 * @author gaoyongjiu
 * @since 2018-12-19
 */
public class SecurityDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		ResultVO<String> respBean = ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM,"权限不足，请联系管理员!");
        response.reset(); // 必要地清除response中的缓存信息
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
		response.getOutputStream().write(JSONObject.toJSONString(respBean).getBytes());
	}

}

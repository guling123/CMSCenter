package cn.people.commons.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import cn.people.commons.constants.CodeConstants;
import cn.people.commons.exceptions.CMSBussinessException;
import cn.people.controller.vo.SessionUser;
/**
 * <p>
 * Session工具类实现类,从SpringSecurity中获取用户session相关信息
 * </p>
 *
 * @author fuqiang
 * @since 2018-12-18
 */
public class SessionUtil
{
    /**
     * 
    * @Title: getUserName 
    * @author fuqiang
    * @date 2018年12月18日 上午8:55:32 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @return  参数说明 
    * @return String    session中的用户名
     * @throws Exception 
    * @throws 
     */
    public static String getUserName() throws Exception {
        try {
            if(null==SecurityContextHolder.getContext().getAuthentication() 
                || StringUtils.isEmpty(SecurityContextHolder.getContext().getAuthentication().getName())) {
                throw new CMSBussinessException(CodeConstants.LOGIN_TIME_OUT, "登陆过期请重新登录");
            }
            return SecurityContextHolder.getContext().getAuthentication().getName();
        }catch (Exception e) {
            throw new CMSBussinessException(CodeConstants.LOGIN_TIME_OUT, "登陆过期请重新登录");
        }
        
    }
    
    /**
     * 
    * @Title: getUserPrincipal 
    * @author fuqiang
    * @date 2018年12月18日 上午8:55:24 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @return  参数说明 
    * @return Object    session中的user对象
    * @throws 
     */
    public static SessionUser getUserPrincipal() throws Exception{
        if(SecurityContextHolder.getContext().getAuthentication()!=null) {
            try {
                System.out.println( SecurityContextHolder.getContext().getAuthentication().getPrincipal());
                return (SessionUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            }catch (Exception e) {
                throw new CMSBussinessException(CodeConstants.LOGIN_TIME_OUT, "登陆过期请重新登录");
            }
            
        }
        return null;
    }
}

/**
 *   
 *
 * @Title: ModelBussinessExceptionConstants.java 
 * @Package cn.people.commons.constants 
 * @Description: 模板异常错误CODE常量类 
 * @author 高永久
 * @date 2018年12月04日 下午2:58:19 
 * @version V1.0   
 */
package cn.people.commons.constants;

/**
 *  
 *
 * @author gaoyongjiu
 * @ClassName: ModelBussinessExceptionConstants 
 * @Description: 内容异常错误CODE常量类 
 * @date 2018年12月04日 下午2:58:19 
 *   
 */
public class CodeConstants {

    /**
     * success
     */
    public static final String RESULT_OK = "200";

    /**
     * 参数错误
     */
    public static final String RESULT_ERR_PARAM = "001";
    /**
     * 登陆过期请重新登录
     */
    public static final String LOGIN_TIME_OUT = "002";
    /**
     * 验证码错误
     */
    public static final String VCODE_ERR = "003";

    /**
     * 站点名称已经存在
     */
    public static final String SITENAME_EXIST = "501";
    /**
     * 站点不存在
     */
    public static final String SITE_NOT_EXIST = "502";

    /**
     * 内容不存在
     */
    public static final String CONTENT_NOT_EXIST = "503";

    /**
     * 操作错误
     */
    public static final String OPERATE_ERROR = "401";
    
    /**
     * 租户不存在
     */
    public static final String SYSORG_NOT_EXIST = "504";
    
    /**
     * 没权限
     */
    public static final String PERMISSIONS_ERROR = "506";
    
    /**
     * 账户组名称已经存在
     */
    public static final String GROUPNAME_EXIST = "505";
    
    /**
     * 稿源不存在
     */
    public static final String CONTENT_SOURCE_NOT_EXIST = "507";
    /**
     * 栏目不存在
     */
    public static final String CHANNEL_NOT_EXIST = "508";
    
    /**
     * 角色已关联账户
     */
    public static final String SYS_ROLE_INUSE = "509";
    /**
     * 账户组不存在
     */
    public static final String GROUPNAME_NOT_EXIST = "510";
    
    /**
     * 租户已经存在
     */
    public static final String SYSORG_EXIST = "511";
    /**
     * 模板已经被栏目绑定
     */
    public static final String MODEL_CHANNEL_BIND = "512";
    
    /**
     * 账户名称已经存在
     */
    public static final String USER_EXIST = "513";
    
    /**
     * 角色已经存在
     */
    public static final String ROLE_EXIST = "514";
    
    /**
     * 用户稿源已经存在
     */
    public static final String USER_CONTENT_SOURCE_EXIST = "515";
}

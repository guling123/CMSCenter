package cn.people.service;

import cn.people.controller.vo.SysPermissionMenuVO;
import cn.people.controller.vo.SysResourceRuleVo;
import cn.people.entity.PermissionResource;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 权限资源关系表 服务类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
public interface IPermissionResourceService extends IService<PermissionResource> {
	/**
	 * 允许所有人访问
	 */
	public static final String PERMIT_ALL = "*";
    /**
     * 
    * @Title: getUserResource 
    * @author fuqiang
    * @date 2018年12月18日 下午4:38:36 
    * @Description: 获取用户可以访问的资源
    * @param @param userId
    * @param @return  参数说明 
    * @return UserResourceVo    返回类型 
    * @throws 
     */
    public SysResourceRuleVo getSysResourceRule();
    /**
     * 
    * @Title: 获取菜单权限树 
    * @author shidandan
    * @date 2019年1月18日 下午4:38:09 
    * @Description: 获取菜单权限树 
    * @return  参数说明 
    * @return SysPermissionMenuTreeVO    返回类型 
    * @throws 
     */
    public SysPermissionMenuVO getPermissionMenu(String username);
}

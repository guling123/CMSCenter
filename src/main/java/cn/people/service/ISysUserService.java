package cn.people.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import cn.people.controller.vo.SysUserCreateVO;
import cn.people.controller.vo.SysUserListVO;
import cn.people.controller.vo.SysUserUpdateVO;
import cn.people.controller.vo.SysUserVO;
import cn.people.entity.SysUser;

/**
 * <p>
 * 管理用户表 服务类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 
    * @Title: createSysUser 
    * @author shidandan
    * @date 2018年12月14日 下午4:23:30 
    * @Description: 创建用户 
    * @param @param createVO
    * @param @return  参数说明 
    * @return Boolean    返回类型 
    * @throws 
     */
    Boolean createSysUser(SysUserCreateVO createVO,String creater,String orgid);

    /**
     * 
    * @Title: updateSysUser 
    * @author gaoyongjiu
    * @date 2018年12月20日 下午4:23:30 
    * @Description: 更新用户 
    * @param @param SysUserUpdateVO
    * @param @return  参数说明 
    * @return Boolean    返回类型 
    * @throws 
     */
    Boolean updateSysUser(SysUserUpdateVO updateVO);
    
    /**
     * 
    * @Title: getSysUserByOrgid 
    * @author shidandan
    * @date 2018年12月17日 下午7:09:20 
    * @Description: 查询租户下的所有人员信息
    * @param @param orgid
    * @param @return  参数说明 
    * @return List<SysUserVO>    返回类型 
    * @throws 
     */
    List<SysUserVO> getSysUserByOrgid(String orgid);
    

    /**
     * 
    * @Title: queryUserByPage 
    * @author gaoyongjiu
    * @date 2018年12月20日 下午7:09:20 
    * @Description: 分页查询账户列表
    * @param @param orgid
    * @param @return  参数说明 
    * @return IPage<SysUser>    返回类型 
    * @throws 
     */
	IPage<SysUser> queryUserByPage(Page<SysUser> page,SysUserListVO param);
}

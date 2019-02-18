package cn.people.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.people.controller.vo.SysUserListParamVO;
import cn.people.controller.vo.SysUserListVO;
import cn.people.entity.SysUser;

/**
 * <p>
 * 管理用户表 Mapper 接口
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
	
	/**
	 * 分页查询用户列表
	 * @param page
	 * @param param
	 * @return
	 */
	IPage<SysUser> queryUserByPage(Page<SysUser> page,SysUserListParamVO param);
}

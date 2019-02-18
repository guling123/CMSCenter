package cn.people.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.people.commons.constants.CMSConstants;
import cn.people.commons.utils.Sm3Utils;
import cn.people.controller.vo.SysUserCreateVO;
import cn.people.controller.vo.SysUserListParamVO;
import cn.people.controller.vo.SysUserListVO;
import cn.people.controller.vo.SysUserUpdateVO;
import cn.people.controller.vo.SysUserVO;
import cn.people.entity.SysUser;
import cn.people.mapper.SysUserMapper;
import cn.people.service.IIdGeneraterService;
import cn.people.service.ISysUserService;

/**
 * <p>
 * 管理用户表 服务实现类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private IIdGeneraterService iIdGeneraterService;
    /*
    * Title: createSysUser
    * @author shidandan
    * @date 2018年12月14日 下午4:23:49 
    *Description: 创建用户
    * @param createVO
    * @return 
    * @see cn.people.service.ISysUserService#createSysUser(cn.people.controller.vo.SysUserVO) 
    */
    @Override
    public Boolean createSysUser(SysUserCreateVO createVO,String creater,String orgid)
    {
        SysUser user=new SysUser();
        BeanUtils.copyProperties(createVO, user);
        user.setCreaterid(creater);
        String salt=Sm3Utils.getSalt10(); 
        user.setPwdsalt(salt);//密码盐值
        user.setPwd(Sm3Utils.encryptWithSalt(createVO.getPwd(), salt));//设置密码
        user.setDstatus(createVO.getDstatus());
        
        user.setCreatetime(new Date());
        Integer userid=iIdGeneraterService.getNextValue(SysUser.class.getAnnotation(TableName.class).value());
        user.setUserid(userid);
        if(createVO.getIdent().equals("1")) {//创建租户超管
            user.setDstatus(1);
            user.setRoleid(CMSConstants.SUPER_SYSY_USER_ROLE_ID);
            user.setOrgid(createVO.getOrgId());
        }else {
            user.setOrgid(orgid);
        }
        return this.save(user);
    }
	@Override
	public Boolean updateSysUser(SysUserUpdateVO updateVO) {
		SysUser user = this.getById(updateVO.getUserid());
		if(user == null) {
			// 原用户信息不存在
			return false;
		}
		// copy属性
        BeanUtils.copyProperties(updateVO, user);
		// 修改过密码
        if(StringUtils.isEmpty(updateVO.getPwd())) {
        	String salt=Sm3Utils.getSalt10(); 
            user.setPwdsalt(salt);//密码盐值
            user.setPwd(Sm3Utils.encryptWithSalt(updateVO.getPwd(), salt));//设置密码
		}
        
        // 更新处理
        SysUser updKey = new SysUser();
        updKey.setId(user.getId());
		return this.update(user, new QueryWrapper<>(updKey));
	}


    /*
    * Title: getSysUserByOrgid
    * @author shidandan
    * @date 2018年12月17日 下午7:09:44 
    *Description: 
    * @param orgid
    * @return 
    * @see cn.people.service.ISysUserService#getSysUserByOrgid(java.lang.String) 
    */
    @Override
    public List<SysUserVO> getSysUserByOrgid(String orgid)
    {
        if(StringUtils.isEmpty(orgid)) {
            return null;
        }
        SysUser user=new SysUser();
        user.setOrgid(orgid);
        List<SysUser> userList=this.list(new QueryWrapper<SysUser>(user));
        
        if(CollectionUtils.isNotEmpty(userList)) {
            List<SysUserVO> result=new ArrayList<SysUserVO>(); 
            
            userList.forEach(sysUser ->{
                SysUserVO vo=new SysUserVO();
                vo.setUserid(sysUser.getId());
                vo.setUsername(sysUser.getUsername());
                result.add(vo);
            });
            return result;
        }
        return null;
    }

	@Override
	public IPage<SysUser> queryUserByPage(Page<SysUser> page, SysUserListVO param) {
	    SysUserListParamVO vo=new SysUserListParamVO();
	    BeanUtils.copyProperties(param, vo);
	    if(StringUtils.isNotEmpty(param.getCreatername())) {
	        QueryWrapper<SysUser> wrapper=new QueryWrapper<SysUser>();
	        wrapper.like("realname", param.getCreatername());
	        List<SysUser> userList=this.list(wrapper); 
	        
	        if(!CollectionUtils.isEmpty(userList)) {
	            Set<String> userids=userList.stream().map(user->{
	                return user.getId();
	            }).collect(Collectors.toSet());
	            vo.setCreaterids(userids);
	        }
	    }
        return baseMapper.queryUserByPage(page, vo);
	}
}

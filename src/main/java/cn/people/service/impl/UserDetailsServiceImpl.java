package cn.people.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.people.commons.utils.Sm3BCryptPasswordEncoder;
import cn.people.controller.vo.SessionUser;
import cn.people.controller.vo.SiteVO;
import cn.people.controller.vo.SysPermissionMenuVO;
import cn.people.entity.SysPermission;
import cn.people.entity.SysUser;
import cn.people.service.IPermissionResourceService;
import cn.people.service.ISiteService;
import cn.people.service.ISysPermissionService;
import cn.people.service.ISysUserService;

/**
 * <p>
 * 用户登录用
 * </p>
 *
 * @author fuqiang
 * @since 2018-12-12
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	ISysPermissionService sysPermissionService;

	@Autowired
	ISysUserService sysUserService;
	
	@Autowired
	IPermissionResourceService iPermissionResourceService;

	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	private ISiteService iSiteService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
		    SessionUser sessionUser = null;
//		    if(null!=SecurityContextHolder.getContext().getAuthentication()) {
//		        sessionUser=(SessionUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		    }
			
			SysUser u = new SysUser();
			u.setUsername(username);
			QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>(u);
			List<SysUser> users = sysUserService.list(queryWrapper);
			if (CollectionUtils.isEmpty(users)) {
				throw new UsernameNotFoundException("用户名或者密码错误！");
			} else {
				SysUser sysUser = users.get(0);
				boolean enabled = true;
				if (sysUser.getDstatus().intValue() == 0) {// 禁用
					enabled = false;
				}
				List<SysPermission> permissions = sysPermissionService.queryPermissoinByUserName(username);
				List<GrantedAuthority> authorities = new ArrayList<>();
				for (SysPermission s : permissions) {
					authorities.add(new SimpleGrantedAuthority("ROLE_" + s.getIdent()));// Ident不能以ROLE_开头
				}
				if (authorities.isEmpty()) {
					// 系统管理员 可以拥有所有权限
					if ("sa".equals(username) || "admin".equals(username)) {
						authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));// Ident不能以ROLE_开头
					}
				}
				// 数据库保存密码经过security计算后，再加盐值前缀（会根据用户输入做sm3计算）
				sessionUser = new SessionUser(username, sysUser.getPwdsalt() + passwordEncoder.encode(sysUser.getPwd()),
						enabled, true, true, true, authorities);
				sessionUser.setUserId(sysUser.getId());
				sessionUser.setTenantId(sysUser.getOrgid());
				
				//权限信息
				SysPermissionMenuVO permission=iPermissionResourceService.getPermissionMenu(username);
				sessionUser.setPermissions(permission);
				
				//站点信息
				List<SiteVO> sites=iSiteService.getSiteList(sysUser.getOrgid());
				sessionUser.setSites(sites);
				if(!CollectionUtils.isEmpty(sites)) {
				    sessionUser.setDefaultSite(sites.get(0).getId());
				}
				
			}

			return sessionUser;

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	@Bean
	public PasswordEncoder getPassEncoder() {
		// 自定义密码比较方法，先进行sm3计算，再通过BCryptPasswordEncoder加密比较
		PasswordEncoder encoder = new Sm3BCryptPasswordEncoder();
		return encoder;
	}

}

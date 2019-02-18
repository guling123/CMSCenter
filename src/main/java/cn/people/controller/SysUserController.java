package cn.people.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.people.commons.constants.CodeConstants;
import cn.people.commons.utils.SessionUtil;
import cn.people.commons.utils.Sm3Utils;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SessionUser;
import cn.people.controller.vo.SysUserCreateVO;
import cn.people.controller.vo.SysUserListResultVO;
import cn.people.controller.vo.SysUserListVO;
import cn.people.controller.vo.SysUserPwdUpdVO;
import cn.people.controller.vo.SysUserUpdateVO;
import cn.people.controller.vo.SysUserVO;
import cn.people.entity.SysGroup;
import cn.people.entity.SysRole;
import cn.people.entity.SysUser;
import cn.people.mapper.SysUserMapper;
import cn.people.service.ISysGroupService;
import cn.people.service.ISysOrgService;
import cn.people.service.ISysRoleService;
import cn.people.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 管理用户表 前端控制器
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@RestController
@RequestMapping("/account")
@Api(value = "用户管理", description = "用户管理")
public class SysUserController {
    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private ISysRoleService iSysRoleService;
    @Autowired
    private ISysGroupService iSysGroupService;
    @Autowired
    private SysUserMapper sysUserMapper;
    
    
    /**
     * 
    * @Title: createSysUser 
    * @author shidandan
    * @date 2018年12月12日 下午7:54:38 
    * @Description: 新增用户
    * @param @param createVO
    * @param @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
     * @throws Exception 
    * @throws 
     */
	@ApiOperation(value = "新增用户", notes = "新增用户")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultVO<Boolean> createSysUser(@Valid @RequestBody SysUserCreateVO createVO) throws Exception {
		// 增加新的sys_role_permission联系
		SysUser user = new SysUser();
		user.setUsername(createVO.getUsername());
		if (iSysUserService.count(new QueryWrapper<>(user)) > 0) {
			return ResultVO.badRequest(CodeConstants.USER_EXIST, "账户名已存在！");
		}

		// session中获取登录账户名作为createrid
		SessionUser sessionUser=SessionUtil.getUserPrincipal();
		String orgid=sessionUser.getTenantId();
		String createrid = sessionUser.getUserId();
		return ResultVO.ok(iSysUserService.createSysUser(createVO, createrid,orgid));
	}
    
    /**
     * 
    * @Title: passwordupd 
    * @author gaoyonjiu
    * @date 2018年12月20日 上午9:21:25 
    * @Description: 修改密码 
    * @param @param updateVO
    * @param @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
     * @throws Exception 
    * @throws 
     */
    @ApiOperation(value = "更新用户信息 ", notes = "更新用户信息 ")
    @RequestMapping(value = "/passwordupd",method = RequestMethod.POST)
    public ResultVO<Boolean> passwordupd(@Valid @RequestBody SysUserPwdUpdVO updateVO) throws Exception {
    	//check 租户信息
    	// session中用户信息
    	SessionUser su = SessionUtil.getUserPrincipal();
    	if(su==null) {
    		return ResultVO.badRequest(CodeConstants.PERMISSIONS_ERROR, "权限不足，请重新登录！");
    	}
    	
    	// 获取账户信息
		SysUser user = iSysUserService.getById(su.getUserId());
    	String oldPwd = Sm3Utils.encryptWithSalt(updateVO.getNewpwd(), user.getPwdsalt());
    	if(!user.getPwd().equals(oldPwd)) {
    		return ResultVO.badRequest(CodeConstants.PERMISSIONS_ERROR, "原密码错误！");
    	}
    	
    	// 更新密码
    	String salt=Sm3Utils.getSalt10(); 
        user.setPwdsalt(salt);//密码盐值
        user.setPwd(Sm3Utils.encryptWithSalt(updateVO.getNewpwd(), salt));//设置密码
        
        // 更新处理
        SysUser updKey = new SysUser();
        updKey.setId(user.getId());
		return ResultVO.ok(iSysUserService.update(user, new QueryWrapper<>(updKey)));
    }

    /**
     * 
    * @Title: updateSysUser 
    * @author shidandan
    * @date 2018年12月13日 上午9:21:25 
    * @Description: 更新用户信息 
    * @param @param updateVO
    * @param @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "更新用户信息 ", notes = "更新用户信息 ")
    @RequestMapping(value = "/{id}/update",method = RequestMethod.POST)
    public ResultVO<Boolean> updateSysUser(@Valid @RequestBody SysUserUpdateVO updateVO) {
      return ResultVO.ok(iSysUserService.updateSysUser(updateVO));  
    }
    
    /**
     * 
    * @Title: getSysUser 
    * @author gaoyongjiu
    * @date 2018年12月13日 上午9:31:25 
    * @Description: 查询用户详情 
    * @param @param model
    * @param @param request
    * @param @param id
    * @param @return  参数说明 
    * @return ResultVO<SysUserUpdateVO>    返回类型 
     * @throws Exception 
    * @throws 
     */
    @ApiOperation(value = "查询用户详情", notes = "查询用户详情")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/detail",method = RequestMethod.GET)
	public ResultVO<SysUserUpdateVO> getSysUser(HttpServletRequest request, @PathVariable String id) throws Exception {
		// 获得账户信息
		SysUser user = iSysUserService.getById(id);
		// 数据检查
		ResultVO<Boolean> chkResult = checkUser(user);

		if (chkResult != null) {
			// 数据异常
			return ResultVO.badRequest(chkResult.getCode(), chkResult.getMessage());
		} else {
			// 无异常
			SysUserUpdateVO rtn = new SysUserUpdateVO();
			// copy属性
			BeanUtils.copyProperties(user, rtn);
			rtn.setUserid(user.getId()); // userId
			rtn.setPwd(null); // 清空密码

			return ResultVO.ok(rtn);
		}
	}
 
    
    /**
     * 
    * @Title: delSysUser 
    * @author shidandan
    * @date 2018年12月13日 上午9:39:08 
    * @Description: 删除用户
    * @param @param model
    * @param @param request
    * @param @param id
    * @param @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @Deprecated
    @ApiOperation(value = "删除用户", notes = "删除用户")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/del",method = RequestMethod.GET)
    public ResultVO<Boolean> delSysUser(HttpServletRequest request,@PathVariable String id) {
        //TODO
      return ResultVO.ok(true);  
    }
    
    
    /**
     * 
    * @Title: getSysUserPaged 
    * @author shidandan
    * @date 2018年12月13日 上午9:37:52 
    * @Description: 账户列表查询
    * @param @param model
    * @param @param request
    * @param @return  参数说明 
    * @return ResultVO<IPage<SysUserListResultVO>>    返回类型 
     * @throws Exception 
    * @throws 
     */
    @ApiOperation(value = "账户列表查询", notes = "账户列表查询")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ResultVO<IPage<SysUserListResultVO>> getSysUserPaged(HttpServletRequest request,@RequestBody SysUserListVO listVO) throws Exception {
        //获取租户Id从登陆信息种
    	// session中用户信息
    	SessionUser su = SessionUtil.getUserPrincipal();
    	if(su==null) {
    		return ResultVO.badRequest(CodeConstants.PERMISSIONS_ERROR, "权限不足，请重新登录！");
    	}
    	String tenantId = su.getTenantId();
    	listVO.setOrgid(tenantId);
    	
    	// 分页查询用户信息
        IPage<SysUser> users = iSysUserService.queryUserByPage(
                new Page<SysUser>(listVO.getCurrent(), listVO.getPageSize()), listVO);
        
        IPage<SysUserListResultVO> rtn = new Page<SysUserListResultVO>();
        // copy属性
        rtn.setCurrent(users.getCurrent());
        rtn.setPages(users.getPages());
        rtn.setTotal(users.getTotal());
        rtn.setRecords(new ArrayList<SysUserListResultVO>());
        if(CollectionUtils.isEmpty(users.getRecords())) {
            return ResultVO.ok(rtn);
        }
        // 查询出租户下的角色,并组装成map{roleId,roleName}
        SysRole roleQu = new SysRole();
        List<SysRole> roles = iSysRoleService.list(new QueryWrapper<>(roleQu));
		Map<String,String> roleMap = new HashMap<>();
		for (SysRole sysRole : roles) {
			roleMap.put(sysRole.getId(), sysRole.getRolename());
		}

        // 查询出站点下的账户组,并组装成map{groupId,groupName}
		SysGroup roleSG = new SysGroup();
        List<SysGroup> groups = iSysGroupService.list(new QueryWrapper<>(roleSG));
		Map<String,String> groupMap = new HashMap<>();
		for (SysGroup sysGroup : groups) {
			groupMap.put(sysGroup.getId(), sysGroup.getGroupname());
		}
		
		//组装创建人
		Set<String> userids=users.getRecords().stream().map(r ->{
            return r.getCreaterid();
        }).collect(Collectors.toSet());
        List<SysUser> userList=sysUserMapper.selectBatchIds(userids);
        Map<String,String> userMap=new HashMap<String,String>();
        userList.forEach(user->{
            userMap.put(user.getId(), user.getUsername());
        });
        
        
        for (SysUser user : users.getRecords()) {
        	SysUserListResultVO vo = new SysUserListResultVO();
    		// copy属性
    		BeanUtils.copyProperties(user, vo);
    		vo.setUserid(user.getUserid());
    		vo.setRolename(roleMap.get(user.getRoleid()));		// 设置角色名称
    		vo.setGroupname(groupMap.get(user.getPwdsalt()));	// 设置账户组名称
    		
    		if(null!=userMap.get(user.getCreaterid())) {
    		    vo.setCreatername(userMap.get(user.getCreaterid()));
    		}
        	rtn.getRecords().add(vo);
		}
        
        return ResultVO.ok(rtn);  
    }
    
    /**
     * 
    * @Title: enabledSysUser 
    * @author shidandan
    * @date 2018年12月13日 下午2:21:54 
    * @Description: 启用账户
    * @param @param request
    * @param @param id
    * @param @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
     * @throws Exception 
    * @throws 
     */
    @ApiOperation(value = "启用账户", notes = "启用账户")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/enabled",method = RequestMethod.GET)
	public ResultVO<Boolean> enabledSysUser(HttpServletRequest request, @PathVariable String id) throws Exception {
		// 获得账户信息
		SysUser user = iSysUserService.getById(id);
		// 数据检查
		ResultVO<Boolean> chkResult = checkUser(user);

		if (chkResult != null) {
			// 数据异常
			return ResultVO.badRequest(chkResult.getCode(), chkResult.getMessage());
		} else {
			if(user.getDstatus()!=null && user.getDstatus() == 1) {
				// 账户已经是启用状态
				return ResultVO.ok(true);
			} else {
				user.setDstatus(1);
		        SysUser updKey = new SysUser();
		        updKey.setId(user.getId());
		        iSysUserService.update(user, new QueryWrapper<>(updKey));
				return ResultVO.ok(true);
			}
		}
	}
    
    /**
     * 
    * @Title: disableSysUser 
    * @author shidandan
    * @date 2018年12月13日 下午2:22:05 
    * @Description: 禁用账户
    * @param @param request
    * @param @param id
    * @param @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
     * @throws Exception 
    * @throws 
     */
    @ApiOperation(value = "禁用账户", notes = "禁用账户")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/disable",method = RequestMethod.GET)
    public ResultVO<Boolean> disableSysUser(HttpServletRequest request,@PathVariable String id) throws Exception {
		// 获得账户信息
		SysUser user = iSysUserService.getById(id);
		// 数据检查
		ResultVO<Boolean> chkResult = checkUser(user);

		if (chkResult != null) {
			// 数据异常
			return ResultVO.badRequest(chkResult.getCode(), chkResult.getMessage());
		} else {
			if(user.getDstatus()!=null && user.getDstatus() == 0) {
				// 账户已经是启用状态
				return ResultVO.ok(true);
			} else {
				user.setDstatus(0);
		        SysUser updKey = new SysUser();
		        updKey.setId(user.getId());
		        iSysUserService.update(user, new QueryWrapper<>(updKey));
				return ResultVO.ok(true);
			}
		}
    }
    
    /**
     * 
    * @Title: getSysUserByOrgid 
    * @author shidandan
    * @date 2018年12月17日 下午7:19:06 
    * @Description: 查询某租户下的所有用户 
    * @param @param orgid
    * @param @return  参数说明 
    * @return ResultVO<List<SysUserVO>>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "查询租户下的所有用户", notes = "查询租户下的所有用户")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{orgid}/listbyorg",method = RequestMethod.GET)
    public ResultVO<List<SysUserVO>> getSysUserByOrgid(@PathVariable(value="orgid") String orgid) {

        return ResultVO.ok(iSysUserService.getSysUserByOrgid(orgid));  
    }

    /**
          * 用户信息检查
     * @param user
     * @return 返回null 表示无异常
     * @throws Exception 
     */
	private ResultVO<Boolean> checkUser(SysUser user) throws Exception {
		if(user==null) {
    		return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "账户信息不存在！");
    	}
    	
        //check 租户信息
    	// session中用户信息
    	SessionUser su = SessionUtil.getUserPrincipal();
    	if(su==null) {
    		return ResultVO.badRequest(CodeConstants.PERMISSIONS_ERROR, "权限不足，请重新登录！");
    	}
    	if(!ISysOrgService.SYSTEM_ORG.equals(su.getTenantId()) 
    			&& !su.getTenantId().equals(user.getOrgid())) {
    		// 非系统管理员、 非本租户账户，不允许查看账户信息
    		return ResultVO.badRequest(CodeConstants.PERMISSIONS_ERROR, "权限不足，请重新登录！");    		
    	}
    	
    	return null;
	}
}

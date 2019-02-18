package cn.people.controller;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import cn.people.commons.constants.CodeConstants;
import cn.people.commons.exceptions.CMSBussinessException;
import cn.people.commons.utils.SessionUtil;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.RoleResultVO;
import cn.people.controller.vo.SessionUser;
import cn.people.controller.vo.SysRoleCreateVO;
import cn.people.controller.vo.SysRoleDetailVO;
import cn.people.controller.vo.SysRoleListVO;
import cn.people.controller.vo.UserVO;
import cn.people.entity.SysRole;
import cn.people.entity.SysRolePermission;
import cn.people.entity.SysUser;
import cn.people.mapper.SysUserMapper;
import cn.people.service.ISysPermissionService;
import cn.people.service.ISysRolePermissionService;
import cn.people.service.ISysRoleService;
import cn.people.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


/**
 * <p> 管理角色表 前端控制器 </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@RestController
@RequestMapping("/role")
@Api(value = "角色管理", description = "角色管理")
public class SysRoleController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    ISysRoleService sysRoleService;

    @Autowired
    ISysRolePermissionService sysRolePermissionService;
    
    @Autowired
    ISysPermissionService sysPermissionService;
    @Autowired
    ISysUserService sysUserService;
    @Autowired
    SysUserMapper sysUserMapper;

    /**
     * @Title: createRole 
     * @author shidandan
     * @date 2018年12月12日 下午7:54:38 
     * @Description: 新增角色 
     * @param @param
     *            site
     * @param @return 
     *             参数说明 
     * @return ResultVO<Boolean>    返回类型  @throws 
     */
    @ApiOperation(value = "新增角色", notes = "新增角色")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<Boolean> createRole(@RequestBody SysRoleCreateVO createVO)
    {
        LOGGER.info("createRole req=" + JSON.toJSONString(createVO));
        try
        {
            SysRole role=new SysRole();
            role.setRolename(createVO.getRolename());
            List<SysRole> roleList=sysRoleService.list(new QueryWrapper<SysRole>(role));
            if(CollectionUtils.isNotEmpty(roleList)) {
                throw new CMSBussinessException(CodeConstants.ROLE_EXIST, "角色已经存在");
            }
            SessionUser user=SessionUtil.getUserPrincipal();
            String operatorid = user.getUserId();
            String tanentId = user.getTenantId();//从session的User中获取租客id
            SysRole entity = new SysRole();
            BeanUtils.copyProperties(createVO, entity);
            entity.setCreaterid(operatorid);
            entity.setOrgid(tanentId);
            entity.setCreatetime(new Date());
            sysRoleService.save(entity);
            if(entity.getId()==null) {
                throw new RuntimeException("bug");
            }
            // 增加新的sys_role_permission关联
            List<SysRolePermission> rolePermissionList = new ArrayList<>();
            for (String id : createVO.getPermissionids())
            {
                SysRolePermission p = new SysRolePermission();
                p.setRoleid(entity.getId());
                p.setPermissionid(id);
                p.setCreatetime(LocalDateTime.now());
                p.setCreaterid(operatorid);
                rolePermissionList.add(p);
            }
            sysRolePermissionService.saveBatch(rolePermissionList);
            return ResultVO.ok(true);
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage(), e);
        }

        return ResultVO.ok(false);
    }

    /**
     * @Title: updateRole 
     * @author shidandan
     * @date 2018年12月13日 上午9:21:25 
     * @Description: 更新角色信息 
     * @param @param
     *            updateVO
     * @param @return
     *             参数说明 
     * @return ResultVO<Boolean>    返回类型  @throws 
     */
    @ApiOperation(value = "更新角色信息", notes = "更新角色信息")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public ResultVO<Boolean> updateRole(@RequestBody SysRoleCreateVO updateVO,@PathVariable(value="id") String id)
    {
        LOGGER.info("updateRole req=" + JSON.toJSONString(updateVO));
        try
        {
            SysRole roleWrapper=new SysRole();
            roleWrapper.setRolename(updateVO.getRolename());
            List<SysRole> roleList=sysRoleService.list(new QueryWrapper<SysRole>(roleWrapper));
            if(CollectionUtils.isNotEmpty(roleList)) {
                for(SysRole sr:roleList) {
                    if(!sr.getId().equals(id)) {
                        throw new CMSBussinessException(CodeConstants.ROLE_EXIST, "角色已经存在");
                    }
                }
                
            }
            
            SysRole role = new SysRole();
            role.setId(id);
            QueryWrapper<SysRole> wrapper = new QueryWrapper<SysRole>(role);
            SysRole entity = new SysRole();
            BeanUtils.copyProperties(updateVO, entity);
            SessionUser user=SessionUtil.getUserPrincipal();
            String operatorid = user.getUserId();
            sysRoleService.update(entity, wrapper);
            // 删除原有sys_role_permission
            SysRolePermission rolePermission = new SysRolePermission();
            rolePermission.setRoleid(role.getId());
            QueryWrapper<SysRolePermission> wrapperPermission = new QueryWrapper<SysRolePermission>(rolePermission);
            sysRolePermissionService.remove(wrapperPermission);
            // 增加新的sys_role_permission联系
            List<SysRolePermission> rolePermissionList = new ArrayList<>();
            for (String permissionid : updateVO.getPermissionids())
            {
                SysRolePermission p = new SysRolePermission();
                p.setRoleid(role.getId());
                p.setPermissionid(permissionid);
                p.setCreatetime(LocalDateTime.now());
                p.setCreaterid(operatorid);
                rolePermissionList.add(p);
            }
            sysRolePermissionService.saveBatch(rolePermissionList);
            return ResultVO.ok(true);
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage(), e);
        }

        return ResultVO.ok(false);
    }

    /**
     * @Title: getRole 
     * @author shidandan
     * @date 2018年12月13日 上午9:31:25 
     * @Description: 查询角色详情 
     * @param @param
     *            model
     * @param @param
     *            request
     * @param @param
     *            id
     * @param @return
     *             参数说明 
     * @return ResultVO<SysRoleDetailVO>    返回类型  @throws 
     */
    @ApiOperation(value = "查询角色详情", notes = "查询角色详情")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
    public ResultVO<SysRoleDetailVO> getRole(HttpServletRequest request, @PathVariable String id)
    {
        LOGGER.info("getRole id=" + JSON.toJSONString(id));
        SysRoleDetailVO result = new SysRoleDetailVO();
        try
        {
            SysRole entity = new SysRole();
            entity.setId(id);
            QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>(entity);

            SysRole role = sysRoleService.getOne(queryWrapper);
            result.setIdent(role.getIdent());
            result.setRolename(role.getRolename());
            result.setRoleid(role.getId());
            result.setRoleDesc(role.getRoleDesc());
            // 增加新的sys_role_permission联系
            SysRolePermission rolePermission = new SysRolePermission();
            rolePermission.setRoleid(id);
            QueryWrapper<SysRolePermission> queryPerssionWrapper = new QueryWrapper<>(
                rolePermission);

            List<SysRolePermission> list = sysRolePermissionService.list(queryPerssionWrapper);
            List<String> idList=new ArrayList<>();
            for(SysRolePermission rp:list) {
                idList.add(rp.getPermissionid());
            }

            result.setPermissionList(idList);
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage(), e);
        }

        return ResultVO.ok(result);
    }

    /**
     * @Title: getSiteList 
     * @author fuqiang
     * @date 2018年12月17日 上午9:37:52 
     * @Description: 角色列表查询
     * @param @param
     *            model
     * @param @param
     *            request
     * @param @return
     *             参数说明 
     * @return ResultVO<List<SysRoleListVO>>    返回类型  @throws 
     * @throws Exception 
     */
    @ApiOperation(value = "角色列表查询", notes = "角色列表查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultVO<List<SysRoleListVO>> getSysRoleList(HttpServletRequest request) throws Exception
    {
    	// session中用户信息
    	SessionUser su = SessionUtil.getUserPrincipal();
    	if(su==null) {
    		return ResultVO.badRequest(CodeConstants.PERMISSIONS_ERROR, "权限不足，请重新登录！");
    	}
        String tanentId = su.getTenantId();//从session的User中获取租客id
        List<SysRoleListVO> resultList = new ArrayList<>();
        SysRole role = new SysRole();
        role.setOrgid(tanentId);
        QueryWrapper<SysRole> wrapper = new QueryWrapper<SysRole>(role);
        wrapper.orderByDesc("createtime");

        List<SysRole> list = sysRoleService.list(wrapper);
        if (CollectionUtils.isNotEmpty(list)){
            Set<String> userids=list.stream().map(r ->{
                return r.getCreaterid();
            }).collect(Collectors.toSet());
            List<SysUser> userList=sysUserMapper.selectBatchIds(userids);
            Map<String,String> userMap=new HashMap<String,String>();
            userList.forEach(user->{
                userMap.put(user.getId(), user.getUsername());
            });
            for (SysRole r : list)
            {
                SysRoleListVO target = new SysRoleListVO();
                BeanUtils.copyProperties(r, target);
                target.setRoleid(r.getId());
                if(null!=userMap.get(r.getCreaterid())) {
                    target.setCreatername(userMap.get(r.getCreaterid()));
                }
                resultList.add(target);
            }
                return ResultVO.ok(resultList);
        }
        return ResultVO.badRequest("1024","没有匹配的信息");

    }
    
    @Deprecated
    @ApiOperation(value = "角色关联的账户", notes = "查询角色关联的账户")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/account", method = RequestMethod.GET)
    public ResultVO<RoleResultVO> roleAccount(Model model, HttpServletRequest request, @PathVariable String id)
    {
        RoleResultVO v=new RoleResultVO();
        LOGGER.info("RoleAccount id="+id);
        try
        {
            SysRole role = new SysRole();
            role.setId(id);;
            
            SysUser user = new SysUser();
            user.setRoleid(id);
            QueryWrapper<SysUser> queryUserWrapper = new QueryWrapper<>(user);

            List<SysUser> userList= sysUserService.list(queryUserWrapper);
            if(userList.size()>0) {
                List<UserVO> userVoList=new ArrayList<>();
                for(SysUser u:userList) {
                    UserVO uv=new UserVO();
                    uv.setRealname(u.getRealname());
                    uv.setUsername(u.getUsername());
                    userVoList.add(uv);
                }
                v.setList(userVoList);
                return ResultVO.ok(v);
            }
            
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage(),e);
        }
        return ResultVO.ok(v);
    }
    
    /**
     * @Title: delSysRole 
     * @author shidandan
     * @date 2018年12月13日 上午9:39:08 
     * @Description: 删除角色
     * @param @param
     *            model
     * @param @param
     *            request
     * @param @param
     *            id
     * @param @return 507错误码,角色已关联账户,无法删除,DeleteRoleResultVO中的list为关联的账户列表
     *             参数说明 
     * @return ResultVO<Boolean>    返回类型  @throws 
     */
    @ApiOperation(value = "删除角色", notes = "删除角色")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/del", method = RequestMethod.GET)
    public ResultVO<RoleResultVO> delSysRole(Model model, HttpServletRequest request, @PathVariable String id)
    {
        RoleResultVO v=new RoleResultVO();
        LOGGER.info("delSysRole id="+id);
        try
        {
            SysRole role = new SysRole();
            role.setId(id);
            SysUser user = new SysUser();
            user.setRoleid(id);
            QueryWrapper<SysUser> queryUserWrapper = new QueryWrapper<>(user);

            List<SysUser> userList= sysUserService.list(queryUserWrapper);
            if(userList.size()>0) {
                List<UserVO> userVoList=new ArrayList<>();
                for(SysUser u:userList) {
                    UserVO uv=new UserVO();
                    uv.setRealname(u.getRealname());
                    uv.setUsername(u.getUsername());
                    userVoList.add(uv);
                }
                v.setList(userVoList);
                
                ResultVO<RoleResultVO> result= ResultVO.badRequest(CodeConstants.SYS_ROLE_INUSE, "角色已关联账户,无法删除"); 
                result.setData(v);
                return result;
            }
            
            QueryWrapper<SysRole> wrapper = new QueryWrapper<SysRole>(role);
            sysRoleService.remove(wrapper);
            SysRolePermission rolePermission = new SysRolePermission();
            rolePermission.setRoleid(role.getId());
            QueryWrapper<SysRolePermission> wrapperPermission = new QueryWrapper<SysRolePermission>(rolePermission);
            sysRolePermissionService.remove(wrapperPermission);
            return ResultVO.ok(v);
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage(),e);
        }
        return ResultVO.ok(v);
    }
}

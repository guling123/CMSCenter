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
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import cn.people.commons.constants.CodeConstants;
import cn.people.commons.utils.SessionUtil;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SessionUser;
import cn.people.controller.vo.SysGroupCreateVO;
import cn.people.controller.vo.SysGroupDetailVO;
import cn.people.controller.vo.SysGroupListVO;
import cn.people.controller.vo.SysGroupUpdateVO;
import cn.people.entity.SysGroup;
import cn.people.entity.SysUser;
import cn.people.mapper.SysUserMapper;
import cn.people.service.ISysGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 管理账户组表 前端控制器
 * </p>
 *
 * @author shidandan
 * @since 2018-12-13
 */
@RestController
@RequestMapping("/site/userGroup")
@Api(value = "账户组信息管理", description = "账户组信息管理")
public class SysGroupController {

    @Autowired
    private ISysGroupService iSysGroupService;
    
    @Autowired
    private SysUserMapper sysUserMapper;
    
    /**
     * 
    * @Title: getSysGroupList 
    * @author shidandan
    * @date 2018年12月13日 下午2:45:38 
    * @Description: 查询某租户下得账户组信息
    * @param @param request
    * @param @return  参数说明 
    * @return ResultVO<List<SysGroupVO>>    返回类型 
     * @throws Exception 
    * @throws 
     */
    @ApiOperation(value = "查询某租户下得账户组信息", notes = "查询某租户下得账户组信息")
    @RequestMapping(value = "/{siteid}/list",method = RequestMethod.GET)
    public ResultVO<List<SysGroupListVO>> getSysGroupList(@PathVariable(value="siteid")String siteid) throws Exception {
        //获取租户IP从登陆信息种
        if(StringUtils.isEmpty(siteid)) {
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "站点ID不能为空");
        }
        SessionUser sessionUser=SessionUtil.getUserPrincipal();
        String orgid=sessionUser.getTenantId();
        List<SysGroup> groupList=iSysGroupService.getSysGroupList(siteid, orgid);
        List<SysGroupListVO> result=new ArrayList<SysGroupListVO>();
        if(!CollectionUtils.isEmpty(groupList)) {
            Set<String> userids=groupList.stream().map(r ->{
                return r.getCreaterid();
            }).collect(Collectors.toSet());
            List<SysUser> userList=sysUserMapper.selectBatchIds(userids);
            Map<String,String> userMap=new HashMap<String,String>();
            userList.forEach(user->{
                userMap.put(user.getId(), user.getUsername());
            });
            groupList.forEach(group ->{
                SysGroupListVO vo=new SysGroupListVO();
                BeanUtils.copyProperties(group, vo);
                if(null!=userMap.get(group.getCreaterid())) {
                    vo.setCreatername(userMap.get(group.getCreaterid()));
                }
                result.add(vo);
            });
        }
        
        
        return ResultVO.ok(result);  
    }
    
    /**
     * 
    * @Title: createSysGroup 
    * @author shidandan
    * @date 2018年12月17日 下午5:19:27 
    * @Description: 新增账户组 
    * @param @param sysGroup
    * @param @param request
    * @param @return
    * @param @throws Exception  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "新增账户组信息", notes = "新增账户组信息")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultVO<Boolean> createSysGroup(@Valid @RequestBody SysGroupCreateVO sysGroup) throws Exception {
      // 获取登录人信息
        SessionUser user=SessionUtil.getUserPrincipal();
        String createrid = user.getUserId();
      return ResultVO.ok(iSysGroupService.createSysGroup(sysGroup, createrid));  
    }
    
    /**
     * 
    * @Title: getSysGroup 
    * @author shidandan
    * @date 2018年12月17日 下午5:50:50 
    * @Description: 获取账户组详情
    * @param @param request
    * @param @param id
    * @param @return
    * @param @throws Exception  参数说明 
    * @return ResultVO<SysGroupDetailVO>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "获取账户组详情", notes = "获取账户组详情")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/detail",method = RequestMethod.GET)
    public ResultVO<SysGroupDetailVO> getSysGroup(@PathVariable(value="id") String id) throws Exception {

        if(StringUtils.isEmpty(id)) {
            return null;
        }
        
        // 未知站点，已知租户
        SessionUser user=SessionUtil.getUserPrincipal();
        String orgid=user.getTenantId();
        return ResultVO.ok(iSysGroupService.getSysGroup(id, orgid));  
    }
    
    /**
     * 
    * @Title: updateSysGroup 
    * @author shidandan
    * @date 2018年12月17日 下午6:09:39 
    * @Description: 更新账户组信息
    * @param @param sysGroup
    * @param @param id
    * @param @return
    * @param @throws Exception  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "更新账户组信息", notes = "更新账户组信息")
    @RequestMapping(value = "/{id}/update",method = RequestMethod.POST)
    public ResultVO<Boolean> updateSysGroup(@Valid @RequestBody SysGroupUpdateVO sysGroup,@PathVariable(value="id")String id) throws Exception {

        return ResultVO.ok(iSysGroupService.updateSysGroup(sysGroup, id));  
    }
    
    /**
     * 
    * @Title: delSysGroup 
    * @author shidandan
    * @date 2018年12月17日 下午6:11:04 
    * @Description: 删除账户组
    * @param @param model
    * @param @param request
    * @param @param id
    * @param @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
     * @throws Exception 
    * @throws 
     */
    @ApiOperation(value = "删除账户组", notes = "删除账户组")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/del",method = RequestMethod.GET)
    public ResultVO<Boolean> delSysGroup(@PathVariable String id) throws Exception {

        return ResultVO.ok(iSysGroupService.delSysGroup(id));  
    }
}

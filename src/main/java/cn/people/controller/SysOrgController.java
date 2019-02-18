package cn.people.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import cn.people.controller.vo.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;

import cn.people.commons.constants.CodeConstants;
import cn.people.commons.utils.SessionUtil;
import cn.people.entity.SysOrg;
import cn.people.service.ISysOrgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 租户表 前端控制器
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@RestController
@RequestMapping("/sysorg")
@Api(value = "租户管理", description = "租户管理")
public class SysOrgController {

    @Autowired
    private ISysOrgService iSysOrgService;
    
    /**
     * 
    * @Title: createSysOrg 
    * @author shidandan
    * @date 2018年12月12日 下午7:54:38 
    * @Description: 新增租户
    * @param @param createVO
    * @param @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
     * @throws Exception 
    * @throws 
     */
    @ApiOperation(value = "新增租户", notes = "新增租户")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultVO<Boolean> createSysOrg(@Valid @RequestBody SysOrgCreateVO createVO) throws Exception {
      // 获取登录人
      SessionUser user=SessionUtil.getUserPrincipal();
      String createrid = user.getUserId();
      return ResultVO.ok(iSysOrgService.createSysOrg(createVO, createrid));  
    }
    
    /**
     * 
    * @Title: getSysOrg 
    * @author shidandan
    * @date 2018年12月13日 下午6:04:44 
    * @Description: 获取租户详情 
    * @param @param id
    * @param @return  参数说明 
    * @return ResultVO<SysOrgUpdateVO>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "获取租户详情", notes = "获取租户详情")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/detail",method = RequestMethod.GET)
    public ResultVO<SysOrgUpdateVO> getSysOrg(@PathVariable String id) {
      if(StringUtils.isEmpty(id)) {
          return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "id不能为空");
      }
      return ResultVO.ok(iSysOrgService.getSysOrg(id));  
    }

    /**
     * @author guling
     * @Title   获取超管详细信息
     * @Date    2019/2/1 9:30
     * @param   [orgid]  租户id
     * @return  cn.people.controller.vo.SysOrgdetailVO
     * @throws
     * @Description 获取超管详细信息
     */
    @ApiOperation(value = "获取超管详情", notes = "获取超管详情")
    @ApiImplicitParam(name = "orgid", value = "orgid", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{orgid}/admin/detail",method = RequestMethod.GET)
    public ResultVO<SysOrgdetailVO> getSysOrgUser(@PathVariable String orgid) throws Exception{
        if(StringUtils.isEmpty(orgid)) {
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "orgid不能为空");
        }
        SysOrgdetailVO sysOrgAdminDetail = iSysOrgService.getSysOrgAdminDetail(orgid);
        if (sysOrgAdminDetail == null){
            return ResultVO.badRequest("1024","没有匹配的信息");
        }else {
            return ResultVO.ok(sysOrgAdminDetail);
        }

    }
    /**
     * 
    * @Title: updateSysOrg 
    * @author shidandan
    * @date 2018年12月13日 上午9:21:25 
    * @Description: 更新租户信息 
    * @param @param updateVO
    * @param @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
     * * @throws Exception
    * @throws 
     */
    @ApiOperation(value = "更新租户信息 ", notes = "更新租户信息 ")
    @RequestMapping(value = "/{id}/update",method = RequestMethod.POST)
    public ResultVO<Boolean> updateSysOrg(@Valid @RequestBody SysOrgUpdateVO updateVO) throws Exception {
        
      return ResultVO.ok(iSysOrgService.updateSysOrg(updateVO));  
    }
    
    /**
     * 
    * @Title: getSysOrgPaged 
    * @author shidandan
    * @date 2018年12月13日 上午9:37:52 
    * @Description: 租户列表查询
    * @param @param model
    * @param @param request
    * @param @return  参数说明 
    * @return ResultVO<IPage<SysOrg>>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "租户列表查询", notes = " 租户列表查询")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ResultVO<IPage<SysOrgListResultVO>> getSysOrgPaged(HttpServletRequest request,@RequestBody SysOrgListVO listVO) {
        
      return ResultVO.ok(iSysOrgService.getSysOrgPaged(listVO));  
    }
    
    /**
     * 
    * @Title: enabledSysOrg 
    * @author shidandan
    * @date 2018年12月13日 下午2:21:54 
    * @Description: 启用租户
    * @param @param request
    * @param @param id
    * @param @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
     * @throws Exception 
    * @throws 
     */
    @ApiOperation(value = "启用租户", notes = "启用租户")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/enabled",method = RequestMethod.GET)
    public ResultVO<Boolean> enabledSysOrg(HttpServletRequest request,@PathVariable String id) throws Exception {
      if(StringUtils.isEmpty(id)) {
          return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "id不能为空");
      }     
      return ResultVO.ok(iSysOrgService.updateSysOrgStatus(id, "1"));  
    }
    
    /**
     * 
    * @Title: disableSysOrg 
    * @author shidandan
    * @date 2018年12月13日 下午2:22:05 
    * @Description: 禁用租户(暂时先不做)
    * @param @param request
    * @param @param id
    * @param @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
     * @throws Exception 
    * @throws 
     */
    @Deprecated
    @ApiOperation(value = "禁用租户", notes = "禁用租户")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/disable",method = RequestMethod.GET)
    public ResultVO<Boolean> disableSysOrg(HttpServletRequest request,@PathVariable String id) throws Exception {
      if(StringUtils.isEmpty(id)) {
          return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "id不能为空");
      }
      return ResultVO.ok(iSysOrgService.updateSysOrgStatus(id, "0"));  
    }
    
}

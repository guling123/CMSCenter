package cn.people.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.people.commons.utils.SessionUtil;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SessionUser;
import cn.people.controller.vo.SysUserChannelListVO;
import cn.people.controller.vo.SysUserChannelVO;
import cn.people.service.ISysUserChannelService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 管理员账户组表 前端控制器
 * </p>
 *
 * @author shidandan
 * @since 2018-12-17
 */
@RestController
@RequestMapping("/site/userGtoup")
public class SysUserChannelController {

    @Autowired
    private ISysUserChannelService iSysUserChannelService;
    /**
     * 
    * @Title: getSysUserByOrgid 
    * @author shidandan
    * @date 2018年12月17日 下午7:23:54 
    * @Description: 查询某账户组下的人员信息 
    * @param @param groupid
    * @param @return  参数说明 
    * @return ResultVO<List<SysUserVO>>    返回类型 
     * @throws Exception 
    * @throws 
     */
    @ApiOperation(value = "查询某账户组下的人员信息", notes = "查询某账户组下的人员信息")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/users",method = RequestMethod.GET)
    public ResultVO<SysUserChannelListVO> getSysUserByGroupid(@PathVariable(value="id") String id) throws Exception {

        SessionUser user=SessionUtil.getUserPrincipal();
        String orgid=user.getTenantId();
        return ResultVO.ok(iSysUserChannelService.getSysUserByOrgid(id,orgid));  
    }
    
    /**
     * 
    * @Title: createSysUserChannel 
    * @author shidandan
    * @date 2018年12月17日 下午7:42:54 
    * @Description: 账户组添加人员
    * @param @param createVO
    * @param @return
    * @param @throws Exception  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "账户组新增人员", notes = "账户组新增人员")
    @RequestMapping(value = "/{id}/updateUsers",method = RequestMethod.POST)
    public ResultVO<Boolean> updateUsers(@RequestBody SysUserChannelVO createVO,@PathVariable(value="id")String id) throws Exception {

        return ResultVO.ok(iSysUserChannelService.updateUsers(createVO,id));  
    }
    
}

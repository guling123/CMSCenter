package cn.people.controller;

import cn.people.commons.constants.CodeConstants;
import cn.people.commons.utils.SessionUtil;
import cn.people.controller.vo.*;
import cn.people.service.IChannelService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 
* @ClassName: ChannelController 
* @Description: 栏目信息管理
* @author shidandan
* @date 2019年1月17日 下午4:53:45 
*  
 */
@RestController
@RequestMapping("/channel")
@Api(value = "栏目信息管理", description = "栏目信息管理")
public class ChannelController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelController.class);

    @Autowired
    private IChannelService iChannelService;
    
    /**
     * 
    * @Title: 按照权限查询某站点下得栏目信息 
    * @author shidandan
    * @date 2019年1月17日 下午4:53:56 
    * @Description: 按照权限查询某站点下得栏目信息
    * @param siteid 站点ID
    * @return 栏目树
    * @throws Exception  参数说明 
    * @return ResultVO<ChannelTreeVO>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "按照权限查询某站点下得栏目信息", notes = "按照权限查询某站点下得栏目信息")
    @RequestMapping(value = "/permission/{siteid}/list",method = RequestMethod.GET)
    public ResultVO<ChannelListVO> getChannelByPermissionSite(@PathVariable(value="siteid")String siteid) throws Exception {
        SessionUser user=SessionUtil.getUserPrincipal();
        String orgid=user.getTenantId();
        String userid=user.getUserId();
        if(StringUtils.isEmpty(siteid)) {
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "站点ID不能为空");
        }
        return iChannelService.getChannelByPermissionSite(siteid, orgid,userid);  
    }
    /**
     * 
    * @Title: 查询某站点下得栏目信息 
    * @author shidandan
    * @date 2019年2月2日 上午10:45:41 
    * @Description: 查询某站点下得栏目信息 
    * @param siteid 站点ID
    * @return
    * @throws Exception  参数说明 
    * @return ResultVO<ChannelListVO>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "查询某站点下得栏目信息", notes = "查询某站点下得栏目信息")
    @RequestMapping(value = "/{siteid}/list",method = RequestMethod.GET)
    public ResultVO<ChannelListVO> getChannelBySite(@PathVariable(value="siteid")String siteid) throws Exception {
      SessionUser user=SessionUtil.getUserPrincipal();
        String orgid=user.getTenantId();
        if(StringUtils.isEmpty(siteid)) {
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "站点ID不能为空");
        }
        //return iChannelService.getChannelBySite(siteid, orgid);
        return iChannelService.getChannelBySite(siteid, null);
    }
    /**
     * 
    * @Title: 新增子栏目 
    * @author shidandan
    * @date 2019年1月17日 下午4:54:23 
    * @Description: 新增子栏目 
    * @param channelCreateVO 子栏目信息
    * @return 成功返回true
    * @throws Exception  参数说明
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "新增子栏目", notes = "新增子栏目")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultVO<Boolean> createChannel(@Valid @RequestBody ChannelCreateVO channelCreateVO) throws Exception {
      SessionUser user=SessionUtil.getUserPrincipal();
      
      String createrid=user.getUserId();
      ChannelCreateRemoteVO param=new ChannelCreateRemoteVO();
     
      BeanUtils.copyProperties(channelCreateVO, param);
      param.setCreaterId(createrid);
      return iChannelService.createChannel(param);
    }
    
    /**
     * 
    * @Title: 获取栏目详情 
    * @author shidandan
    * @date 2019年1月17日 下午4:54:55 
    * @Description: 获取栏目详情 
    * @param id 栏目ID
    * @return 栏目详情
    * @throws Exception  参数说明 
    * @return ResultVO<ChannelDetailVO>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "获取栏目详情", notes = "获取栏目详情")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/detail",method = RequestMethod.GET)
    public ResultVO<ChannelDetailVO> getChannel(@PathVariable(value="id") String id) throws Exception {

        if(StringUtils.isEmpty(id)) {
            return null;
        }
        return iChannelService.getChannel(id);  
    }
    
   /**
    * 
   * @Title: 更新栏目信息 
   * @author shidandan
   * @date 2019年1月17日 下午4:55:19 
   * @Description: 更新栏目信息 
   * @param channel 栏目信息
   * @param id 栏目ID
   * @return 成功返回true
   * @throws Exception  参数说明 
   * @return ResultVO<Boolean>    返回类型 
   * @throws 
    */
    @ApiOperation(value = "更新栏目信息", notes = "更新账户组信息")
    @RequestMapping(value = "/{id}/update",method = RequestMethod.POST)
    public ResultVO<Boolean> updateChannel(@Valid @RequestBody ChannelCreateVO channel,@PathVariable(value="id")String id) throws Exception {
        if(StringUtils.isEmpty(id) || null==channel) {
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "参数有误");
        }
      return iChannelService.updateChannel(channel, id);  
    }
    
    /**
     * 
    * @Title: 删除栏目 
    * @author shidandan
    * @date 2019年1月17日 下午4:56:39 
    * @Description: 删除栏目 
    * @param id 栏目ID
    * @return 成功返回true
    * @throws Exception  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "删除栏目", notes = "删除栏目")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/del",method = RequestMethod.GET)
    public ResultVO<Boolean> delChannel(@PathVariable(value="id") String id) throws Exception {

        if(StringUtils.isEmpty(id)) {
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "参数有误");
        }
        return iChannelService.delChannel(id); 
    }
    
    /**
     * 
    * @Title: 栏目下线
    * @author fanchengkui
    * @date 2019年1月25日 上午11:29:29 
    * @Description: 栏目下线
    * @param  栏目下线资源入参对象
    * @return  成功返回true
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "栏目下线", notes = "栏目下线")
    @PostMapping(value = "/offline")
    public ResultVO<Boolean> offlineChannel(@RequestBody PublishChanneRequest publishChanneRequest) {
        LOGGER.info("栏目下线入参publishChanneRequest="+JSON.toJSONString(publishChanneRequest));

        return iChannelService.offlineChannel(publishChanneRequest); 
    }
    
    /**
     * 
    * @Title: 栏目发布 
    * @author fanchengkui
    * @date 2019年1月25日 下午1:32:31 
    * @Description: 栏目发布 
    * @param  栏目发布资源入参对象
    * @return  成功返回true
    * @return ResultVO<Boolean>    返回类型 
     * @throws Exception 
    * @throws 
     */
    @ApiOperation(value = "栏目发布", notes = "栏目发布")
    @PostMapping(value = "/publish")
    public ResultVO<Boolean> publishChannel(@RequestBody PublishChanneRequest publishChanneRequest) throws Exception {
        LOGGER.info("栏目发布入参publishChanneRequest="+JSON.toJSONString(publishChanneRequest));
        SessionUser user=SessionUtil.getUserPrincipal(); 
        return iChannelService.publishChannel(publishChanneRequest,user.getUserId()); 
    }
    
    
}

package cn.people.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import cn.people.commons.constants.CodeConstants;
import cn.people.commons.utils.SessionUtil;
import cn.people.controller.vo.ContentSourceCreateVO;
import cn.people.controller.vo.ContentSourceListVO;
import cn.people.controller.vo.ContentSourceVO;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SessionUser;
import cn.people.entity.ContentSource;
import cn.people.service.IContentSourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 稿件来源表 前端控制器
 * </p>
 *
 * @author shidandan
 * @since 2018-12-18
 */
@RestController
@RequestMapping("/site/source")
@Api(value = "稿源信息管理", description = "稿源信息管理")
public class ContentSourceController {

    @Autowired
    private IContentSourceService iContentSourceService;
    /**
     * 
    * @Title: createContentSource 
    * @author shidandan
    * @date 2018年12月18日 下午2:37:07 
    * @Description: 新增稿源
    * @param @param createVO
    * @param @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
     * @throws Exception 
    * @throws 
     */
    @ApiOperation(value = "新增稿源", notes = "新增稿源")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultVO<Boolean> createContentSource(@Valid @RequestBody ContentSourceCreateVO createVO) throws Exception {
      SessionUser user=SessionUtil.getUserPrincipal();
      String createrid=user.getUserId();//
      return ResultVO.ok(iContentSourceService.createContentSource(createVO, createrid));  
    }
    
    /**
     * 
    * @Title: getContentSource 
    * @author shidandan
    * @date 2018年12月18日 下午2:46:58 
    * @Description: 获取稿源详情 
    * @param @param id
    * @param @return  参数说明 
    * @return ResultVO<ContentSource>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "获取稿源详情", notes = "获取稿源详情")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/detail",method = RequestMethod.GET)
    public ResultVO<ContentSource> getContentSource(@PathVariable String id) {
      if(StringUtils.isEmpty(id)) {
          return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "id不能为空");
      }
      return ResultVO.ok(iContentSourceService.getById(id));  
    }
    
    
    /**
     * 
    * @Title: updateContentSource 
    * @author shidandan
    * @date 2018年12月18日 下午2:56:56 
    * @Description: 更新稿源信息  
    * @param @param createVO
    * @param @param id
    * @param @return
    * @param @throws Exception  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "更新稿源信息 ", notes = "更新稿源信息 ")
    @RequestMapping(value = "/{id}/update",method = RequestMethod.POST)
    public ResultVO<Boolean> updateContentSource(@Valid @RequestBody ContentSourceCreateVO createVO,@PathVariable(value="id")String id) throws Exception {
        
      return ResultVO.ok(iContentSourceService.updateContentSource(createVO, id));  
    }
    

    /**
     * 
    * @Title: getContentSourcePaged 
    * @author shidandan
    * @date 2018年12月18日 下午3:19:54 
    * @Description: 稿源列表查询
    * @param @param listVO
    * @param @return  参数说明 
    * @return ResultVO<IPage<ContentSource>>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "稿源列表查询", notes = "稿源列表查询")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ResultVO<IPage<ContentSourceVO>> getContentSourcePaged(@RequestBody ContentSourceListVO listVO) {
        
      return ResultVO.ok(iContentSourceService.getContentSourcePaged(listVO));  
    }

    /**
     * 
    * @Title: enabledSysOrg 
    * @author shidandan
    * @date 2018年12月18日 下午3:27:04 
    * @Description: 启用稿源 
    * @param @param request
    * @param @param id
    * @param @return
    * @param @throws Exception  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "启用稿源", notes = "启用稿源")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/enabled",method = RequestMethod.GET)
    public ResultVO<Boolean> enabledContentSource(HttpServletRequest request,@PathVariable String id) throws Exception {
      if(StringUtils.isEmpty(id)) {
          return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "id不能为空");
      }     
      return ResultVO.ok(iContentSourceService.updateContentSourceStatus(id, 1));  
    }

    /**
     * 
    * @Title: disableSysOrg 
    * @author shidandan
    * @date 2018年12月18日 下午3:27:13 
    * @Description: 禁用稿源 
    * @param @param request
    * @param @param id
    * @param @return
    * @param @throws Exception  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "禁用稿源", notes = "禁用稿源")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/disable",method = RequestMethod.GET)
    public ResultVO<Boolean> disableContentSource(HttpServletRequest request,@PathVariable String id) throws Exception {
      if(StringUtils.isEmpty(id)) {
          return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "id不能为空");
      }
      return ResultVO.ok(iContentSourceService.updateContentSourceStatus(id, 0));  
    }
    
    /**
     * 
    * @Title: getEnabledContentSource 
    * @author shidandan
    * @date 2018年12月18日 下午3:36:48 
    * @Description: 查询所有启用的稿源
    * @param @return  参数说明 
    * @return ResultVO<List<ContentSource>>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "查询所有启用的稿源", notes = "查询所有启用的稿源")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{siteid}/listEnabled",method = RequestMethod.GET)
    public ResultVO<List<ContentSource>> getEnabledContentSource(@PathVariable(value="siteid") String siteid) {
       ContentSource contentSource=new ContentSource();
       contentSource.setSiteid(siteid);
       contentSource.setStatus(1);
      return ResultVO.ok(iContentSourceService.list(new QueryWrapper<ContentSource>(contentSource)));  
    }
}

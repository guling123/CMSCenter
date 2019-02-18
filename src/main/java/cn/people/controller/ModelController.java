package cn.people.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.people.commons.utils.SessionUtil;
import cn.people.commons.constants.CodeConstants;
import cn.people.controller.vo.Model;
import cn.people.controller.vo.ModelDetailVO;
import cn.people.controller.vo.ModelListRequestVO;
import cn.people.controller.vo.ModelTypeVO;
import cn.people.controller.vo.ModelVO;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SessionUser;
import cn.people.service.IModelService;
import cn.people.service.IModelTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 
* @ClassName: ModelController 
* @Description: 模板信息管理 前端控制器 
* @author shidandan
* @date 2019年1月17日 下午2:15:38 
*  
 */
@RestController
@RequestMapping("/model")
@Api(value = "模板信息管理", description = "模板信息管理")
public class ModelController {


    private static final Logger LOGGER = LoggerFactory.getLogger(ModelController.class);

    @Autowired
    private IModelService iModelService;
    
    @Autowired
    private IModelTypeService iModelTypeService;
    /**
     * 
    * @Title: 修改模板详细信息
    * @author shidandan
    * @date 2019年1月18日 下午1:33:19 
    * @Description: 修改模板详细信息
    * @param model 模板详细信息
    * @param id 模板id
    * @return 成功返回true
    * @throws Exception  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "修改模板详细信息", notes = "修改模板详细信息")
    @RequestMapping(value ="/{id}/update", method = RequestMethod.POST)
    public ResultVO<Boolean> modelUpdate(@RequestBody ModelVO model,@PathVariable(value="id") String id) throws Exception{
        LOGGER.info("修改模板详细信息,入参：{}",JSON.toJSONString(model));
        
        return iModelService.modelUpdate(model, id);
    }   
    
    /**
     * 
    * @Title: 添加新模板
    * @author shidandan
    * @date 2019年1月18日 下午1:37:06 
    * @Description: 添加新模板 
    * @param modelVo 模板信息
    * @return  成功返回模板id
    * @throws Exception  参数说明 
    * @return ResultVO<String>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "添加新模板", notes = "添加新模板")
    @PostMapping(value ="/add")
    public ResultVO<String> createModel(@Valid @RequestBody ModelVO modelVo) throws Exception{
        LOGGER.info("添加新模板,入参：{}",JSON.toJSONString(modelVo));
        // 获取登录人信息
        SessionUser user=SessionUtil.getUserPrincipal();
        String createrid = user.getUserId();
        modelVo.setCreaterid(createrid); 
        return iModelService.createModel(modelVo);
    }
    
    /**
     * 
    * @Title: 获取模板详细信息 
    * @author shidandan
    * @date 2019年1月18日 下午1:39:02 
    * @Description: 获取模板详细信息 
    * @param id 模板id
    * @return 成功返回模板详细信息
    * @throws Exception  参数说明 
    * @return ResultVO<ModelVO>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "获取模板详细信息", notes = "获取模板详细信息")
    @ApiImplicitParam(name = "id", value = "id", paramType = "path", required = true, dataType = "String")
    @GetMapping(value ="/{id}/detail")
    public ResultVO<ModelDetailVO> getModel(@PathVariable(value="id") String id) throws Exception{
        LOGGER.info("查询模板详情,入参：{}",id);
        
        return iModelService.getModel(id);
    }
    
    /**
     * 
    * @Title: 查询模板列表 
    * @author shidandan
    * @date 2019年1月18日 下午1:40:06 
    * @Description: 查询模板列表 
    * @param modelListRequestVo 模板信息
    * @return 成功返回模板列表
    * @throws Exception  参数说明 
    * @return ResultVO<Page<Model>>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "查询模板列表", notes = "查询模板列表")
    @PostMapping(value ="/list")
    public ResultVO<Page<Model>> getModelPaged(@Valid @RequestBody ModelListRequestVO modelListRequestVo) throws Exception{
        LOGGER.info("查询模板列表,入参：{}",JSON.toJSONString(modelListRequestVo));
       
        return iModelService.getModelPaged(modelListRequestVo);
    }
    /**
     * 
    * @Title: 查询某个站点下某种类型的模板 
    * @author shidandan
    * @date 2019年1月22日 下午7:12:51 
    * @Description: 查询某个站点下某种类型的模板
    * @param siteid 站点ID
    * @param typeid 类型ID
    * @return
    * @throws Exception  参数说明 
    * @return ResultVO<List<Model>>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "查询模板列表", notes = "查询模板列表")
    @GetMapping(value ="/{siteid}/{typeid}/list")
    public ResultVO<List<Model>> getModel(@PathVariable(value="siteid")String siteid,@PathVariable(value="typeid")String typeid) throws Exception{
        
        return iModelService.getModel(siteid,typeid);
    }
    /**
     * 
    * @Title: 启用模板
    * @author fanchengkui
    * @date 2019年1月18日 下午1:41:20 
    * @Description: 启用模板
    * @param id 模板id
    * @return 成功返回true
    * @throws Exception  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "启用模板", notes = "启用模板")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value ="/{id}/enabled", method = RequestMethod.GET)
    public ResultVO<Boolean> enabledModel(@PathVariable(value="id") String id) throws Exception{
        LOGGER.info("启用模板详细信息,入参：id="+id);
        
        return ResultVO.ok(iModelService.enabledModel(id));
    }
    
    /**
     * 
    * @Title: 禁用模板
    * @author fanchengkui
    * @date 2019年1月18日 下午1:41:20 
    * @Description: 禁用模板
    * @param id 模板id
    * @return 成功返回true
    * @throws Exception  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "禁用模板", notes = "禁用模板")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value ="/{id}/disable", method = RequestMethod.GET)
    public ResultVO<Boolean> disableModel(@PathVariable(value="id") String id) throws Exception{
        LOGGER.info("禁用模板详细信息,入参：id="+id);
        
        return ResultVO.ok(iModelService.disableModel(id));
    }
    
     /**
      * 
     * @Title: 删除模板
     * @author shidandan
     * @date 2019年1月18日 下午1:42:49 
     * @Description: 删除模板
     * @param id 模板id
     * @return 成功返回true
     * @throws Exception  参数说明 
     * @return ResultVO<Boolean>    返回类型 
     * @throws 
      */
    @ApiOperation(value = "删除模板", notes = "删除模板")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @GetMapping(value ="/{id}/del")
    public ResultVO<Boolean> delModel(@PathVariable(value="id") String id) throws Exception{
        LOGGER.info("修改模板详细信息,入参：id="+id);
        
        return ResultVO.ok(iModelService.delModel(id));
    }
    
    /**
     * @author guling
     * @Title   createContent
     * @Date    2019/1/15 9:31
     * @param   param
     * @return  cn.people.controller.vo.ResultVO<cn.people.controller.vo.ContentCreateResultVO>
     * @throws
     * @Description 添加接口
     */
    @ApiOperation(value = "通过siteid查询模型种类列表", notes = "通过siteid查询模型种类列表")
    @ApiImplicitParam(name = "siteId", value = "siteId", paramType = "path", required = true)
    @GetMapping("/type/{siteId}/list")
    public ResultVO<List<ModelTypeVO>> getModelTypeListBySiteId(@PathVariable(value="siteId") String siteId) throws Exception {
        LOGGER.info("通过siteid查询模型种类列表,入参,param={}",JSON.toJSONString(siteId));
        if (siteId == null || "".equals(siteId)) {
            // 获取失败直接返回
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "内容id不存在，请确认参数是否正确");
        }
        return iModelTypeService.getModelTypeListBySiteId(siteId);
    }
}

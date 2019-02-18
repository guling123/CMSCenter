package cn.people.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SessionUser;
import cn.people.controller.vo.SplitCreateVO;
import cn.people.commons.utils.SessionUtil;
import cn.people.controller.vo.ModelSplit;
import cn.people.controller.vo.ModelSplitDetailVO;
import cn.people.controller.vo.ModelSplitPageVO;
import cn.people.controller.vo.SplitPageVO;
import cn.people.controller.vo.SplitUpdateVO;
import cn.people.service.IModelSplitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 模板碎片表 前端控制器
 * </p>
 *
 * @author shidandan
 * @since 2018-12-19
 */
@RestController
@RequestMapping("/model/split")
@Api(value = "模板碎片信息管理", description = "模板碎片信息管理")
public class ModelSplitController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModelSplitController.class);

    @Autowired
    private IModelSplitService iModelSplitService;
    /**
     *
     * @Title: 创建碎片 
     * @author shidandan
     * @date 2018年12月19日 下午1:54:22 
     * @Description: 添加碎片
     * @param split split 创建碎片参数
     * @throws Exception  参数说明 
     * @return ResultVO<Boolean>    返回结果 
     * @throws 
     */
    @ApiOperation(value = "添加新模板碎片", notes = "添加新模板碎片")
    @RequestMapping(value ="/add", method = RequestMethod.POST)
    public ResultVO<Boolean> createModelSplit(@RequestBody SplitCreateVO split) throws Exception{
        LOGGER.info("添加新模板碎片,入参",JSON.toJSONString(split));
        SessionUser user=SessionUtil.getUserPrincipal();
        String createrid = user.getUserId();
        split.setCreaterId(createrid);
        return iModelSplitService.createModelSplit(split);

    }
    /**
     * 
    * @Title: updateSplit 
    * @author shidandan
    * @date 2019年1月7日 下午7:50:20 
    * @Description: 修改碎片
    * @param  split 修改碎片参数
    * @param id 碎片id
    * @throws Exception  
    * @return ResultVO<Boolean>    返回结果
     */
    @ApiOperation(value = "修改模板碎片", notes = "修改模板碎片")
    @RequestMapping(value ="/{id}/update", method = RequestMethod.POST)
    public ResultVO<Boolean> updateSplit(@RequestBody SplitUpdateVO split,@PathVariable String id) throws Exception{
        LOGGER.info("修改模板碎片,入参",JSON.toJSONString(split));
        return iModelSplitService.updateSplit(split, id);

    }
    
   /**
    * 
   * @Title: 模板碎片列表查询 
   * @author shidandan
   * @date 2018年12月5日 下午4:20:16 
   * @Description: 碎片列表查询
   * @param split 碎片列表查询
   * @param modelid 碎片id
   * @throws Exception  参数说明 
   * @return ResultVO<IPage<ModelSplit>>    返回结果集
    */
    @ApiOperation(value = "模板碎片列表查询", notes = "模板碎片列表查询")
    @RequestMapping(value ="/{modelid}/page", method = RequestMethod.POST)
    public ResultVO<ModelSplitPageVO> getSplitPaged(@RequestBody SplitPageVO split,@PathVariable(value="modelid") String modelid) throws Exception{
        LOGGER.info("模板碎片列表查询,入参",JSON.toJSONString(split));
        
        return ResultVO.ok(iModelSplitService.getSplitPaged(split, modelid));
    }
    /**
     * 
    * @Title: 查询模板下的所有碎片 
    * @author shidandan
    * @date 2019年1月22日 下午1:38:13 
    * @Description: 查询模板下的所有碎片 
    * @param modelid 模板ID
    * @return
    * @throws Exception  参数说明 
    * @return ResultVO<List<ModelSplit>>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "模板碎片列表查询", notes = "模板碎片列表查询")
    @RequestMapping(value ="/{modelid}/list", method = RequestMethod.GET)
    public ResultVO<List<ModelSplit>> getModelSplit(@PathVariable(value="modelid") String modelid) throws Exception{

        return iModelSplitService.getModelSplit(modelid);
    }
    /**
     * 
    * @Title: 获取模板碎片详细信息 
    * @author shidandan
    * @date 2018年12月19日 下午2:23:55 
    * @Description: 获取模板碎片详细信息
    * @param id 碎片id
    * @throws Exception  参数说明 
    * @return ResultVO<SplitDetailVO>    返回类结果集
    * @throws 
     */
    @ApiOperation(value = "获取模板碎片详细信息", notes = "获取模板碎片详细信息")
    @ApiImplicitParam(name = "id", value = "id", paramType = "path", required = true, dataType = "String")
    @GetMapping(value ="/{id}/detail")
    public ResultVO<ModelSplitDetailVO> getModelSplitDetail(@PathVariable(value="id") String id) throws Exception{
        LOGGER.info("获取模板碎片详细信息,入参：{}",id);
        
        return iModelSplitService.getModelSplitDetail(id);
    }
    
    /**
     * 
    * @Title: 删除模板碎片 
    * @author shidandan
    * @date 2019年1月7日 下午8:06:56 
    * @Description: 删除碎片 
    * @param  id 碎片id
    * @throws Exception  参数说明 
    * @return ResultVO<Boolean>    返回类型结果集 
     */
    @ApiOperation(value = "删除模板碎片", notes = "删除模板碎片")
    @ApiImplicitParam(name = "id", value = "id", paramType = "path", required = true, dataType = "String")
    @GetMapping(value ="/{id}/del")
    public ResultVO<Boolean> delModelSplit(@PathVariable(value="id") String id) throws Exception{
        LOGGER.info("删除模板碎片,入参：{}",id);
        return iModelSplitService.delModelSplit(id);

    }
}

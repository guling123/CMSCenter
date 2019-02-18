package cn.people.controller;

import cn.people.commons.constants.CodeConstants;
import cn.people.commons.utils.SessionUtil;
import cn.people.controller.vo.*;
import cn.people.service.IContentService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 内容主体表 前端控制器
 * </p>
 *
 * @author shidandan
 * @since 2018-12-04
 */
@RestController
@RequestMapping("/content")
@Api(value = "内容信息管理", description = "内容信息管理")
public class ContentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContentController.class);

    @Autowired
    private IContentService iContentService;
    /**
     * @author guling
     * @Title   createContent
     * @Date    2019/1/15 9:31
     * @param   param
     * @return  cn.people.controller.vo.ResultVO<cn.people.controller.vo.ContentCreateResultVO>
     * @throws
     * @Description 添加接口
    */
    @ApiOperation(value = "添加内容", notes = "添加内容")
    @PostMapping("/add")
    public ResultVO<ContentCreateResultVO> createContent(@RequestBody ContentCreateVO param) throws Exception {
        LOGGER.info("添加内容,入参,param={}",JSON.toJSONString(param));
        /*SessionUser user=SessionUtil.getUserPrincipal();
        String userid=user.getUserId();
        String userName=user.getUsername();
        param.setCreaterid(userid);
        param.setCreatername(userName);*/
        return iContentService.createContent(param);
    }

    /**
     * @author guling
     * @Title   回收站列表查询
     * @Date    2019/1/15 13:28
     * @param   param  回收站内容列表查询参数
     * @return  cn.people.controller.vo.ResultVO<java.util.List<cn.people.controller.vo.Content>>
     * @throws
     * @Description 回收站列表查询
     */
    @ApiOperation(value = "回收站列表查询", notes = "回收站列表查询")
    @ApiImplicitParam(name = "ContentCreateVO", value = "param", paramType = "query", required = true, dataType = "ContentCreateVO")
    @GetMapping("/recycled")
    public ResultVO<List<Content>> getContentRecycledPaged(@RequestBody ContentRecycledListVO param) {
        LOGGER.info("回收站列表查询,入参,param={}",JSON.toJSONString(param));
        if (param.getSiteid() == null || "".equals(param.getSiteid())) {
            // 获取失败直接返回
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "站点id不存在，请确认参数是否正确");
        }
        return iContentService.getContentRecycledPaged(param);
    }

    /**
     * @param @param  内容查询参数
     * @return List<Content>    返回类型 
     * @Title: getContentPaged 
     * @author guling
     * @date 2018年12月15日 上午11:02:21 
     * @Description: 内容列表查询
     * @throws 
     */
    @ApiOperation(value = "内容列表查询", notes = "内容列表查询")
    @PostMapping("/list")
    public ResultVO<Page<ContentListVO>> getContentPaged(@RequestBody ContentQueryVO param) {
        LOGGER.info("修改碎片对应的内容列表,入参,param={}",JSON.toJSONString(param));
        if (param.getSiteid() == null || "".equals(param.getSiteid())) {
            // 获取失败直接返回
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "站点id不存在，请确认参数是否正确");
        }
        return iContentService.getContentPaged(param);
    }


    /**
     * @param   id 内容id
     * @param @return
     * @param @throws Exception  参数说明 
     * @return Content    返回类型 
     * @Title: getContentById 
     * @author shidandan
     * @date 2018年12月5日 上午9:36:19 
     * @Description: 获取内容详情
     * @throws 
     */
    @ApiOperation(value = "获取内容详情", notes = "获取内容详情")
    @ApiImplicitParam(name = "id", value = "Content id", paramType = "path", required = true)
        @GetMapping("/{id}/detail")
    public ResultVO<ContentDetailVO> getContentById(@PathVariable("id") String id) throws Exception {
        LOGGER.info("获取内容详情,入参,param={}",JSON.toJSONString(id));
        if (id == null || "".equals(id)) {
            // 获取失败直接返回
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "内容id不存在，请确认参数是否正确");
        }
        return ResultVO.ok(iContentService.getContentById(id));
    }

    /**
     * 
    * @Title: 删除内容 
    * @author shidandan
    * @date 2019年1月15日 下午7:29:30 
    * @Description: 删除内容 
    * @param  id 内容id
    * @return ResultVO<ContentDelResultVO>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "删除内容", notes = "删除内容")
    @ApiImplicitParam(name = "id", value = "Content id", paramType = "path", required = true)
    @GetMapping("/{id}/del")
    public ResultVO<Boolean> delContent(@PathVariable("id") String id) {
        LOGGER.info("删除内容详情,入参,param={}",JSON.toJSONString(id));
        if (id == null || "".equals(id)) {
            // 获取失败直接返回
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "内容id不存在，请确认参数是否正确");
        }
        return iContentService.delContent(id);
    }

    /**
     * @author guling
     * @Title   内容审核
     * @Date    2019/1/17 13:45
     * @param   id  内容id
     * @return  cn.people.controller.vo.ResultVO<java.lang.Boolean>
     * @throws Exception 
     * @throws
     * @Description 内容的审核通过
    */
    @ApiOperation(value = "内容的审核通过", notes = "内容的审核通过")
    @GetMapping("/{id}/pass")
    public ResultVO<Boolean> passContent(@PathVariable("id") String id) throws Exception {
        LOGGER.info("内容的审核,入参,param={}",JSON.toJSONString(id));
        if (id == null || "".equals(id)) {
            // 获取失败直接返回
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "内容id不存在，请确认参数是否正确");
        }
        SessionUser user=SessionUtil.getUserPrincipal();
        String userid=user.getUserId();
        String userName=user.getUsername();
        ContentAuditVO auditVO=new ContentAuditVO();
        auditVO.setOperatorid(userid);
        auditVO.setOperatorname(userName);
        return iContentService.passContent(id,auditVO);
    }

    /**
     * 
    * @Title: 内容的审核驳回 
    * @author shidandan
    * @date 2019年1月25日 下午2:09:23 
    * @Description: 内容的审核驳回 
    * @param id 内容ID
    * @param auditVO
    * @return
    * @throws Exception  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "内容的审核驳回", notes = "内容的审核驳回")
    @PostMapping("/{id}/reject")
    public ResultVO<Boolean> rejectContent(@PathVariable("id") String id,@RequestBody ContentAuditVO auditVO) throws Exception {
        LOGGER.info("内容的审核,入参,param={}",JSON.toJSONString(id));
        if (id == null || "".equals(id)) {
            // 获取失败直接返回
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "内容id不存在，请确认参数是否正确");
        }
        SessionUser user=SessionUtil.getUserPrincipal();
        String userid=user.getUserId();
        String userName=user.getUsername();
        auditVO.setOperatorid(userid);
        auditVO.setOperatorname(userName);
        return iContentService.rejectContent(id,auditVO);
    }
    /**
     * @author guling
     * @Title   从回收站还原内容
     * @Date    2019/1/17 13:52
     * @param   id  内容id
     * @return  cn.people.controller.vo.ResultVO<cn.people.controller.vo.ContentRestoreResultVO>
     * @throws
     * @Description 从回收站还原内容通过内容id
    */
    
    @ApiOperation(value = "从回收站还原内容", notes = "从回收站还原内容")
    @PatchMapping("/{id}/restore")
    public ResultVO<ContentRestoreResultVO> restoreContent(@PathVariable("id") String id) {
        LOGGER.info("内容的审核,入参,param={}",JSON.toJSONString(id));
        if (id == null || "".equals(id)) {
            // 获取失败直接返回
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "内容id不存在，请确认参数是否正确");
        }
        return  iContentService.restoreContent(id);
    }

   /**
    * @author guling
    * @Title   更新内容
    * @Date    2019/1/17 13:55
    * @param   id, content  内容id  content内容参数
    * @return  cn.people.controller.vo.ResultVO<cn.people.controller.vo.ContentUpdateResultVO>
    * @throws Exception 
    * @throws
    * @Description 更新内容
   */
    @ApiOperation(value = "更新内容", notes = "更新内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Content id", paramType = "path", required = true),
            @ApiImplicitParam(name = "content", value = "content", paramType = "body", required = true)
    })
    @PostMapping("/{id}/update")
    public ResultVO<ContentUpdateResultVO> updateContent(@PathVariable("id") String id,
                                                         @RequestBody ContentUpdateVO content) throws Exception {
        LOGGER.info("内容的审核,入参,param={}",JSON.toJSONString(id));
        if (id == null || "".equals(id)) {
            // 获取失败直接返回
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "内容id不存在，请确认参数是否正确");
        }
        SessionUser user=SessionUtil.getUserPrincipal();
        String userid=user.getUserId();
        String userName=user.getUsername();
        content.setOperatorid(userid);
        content.setOperatorname(userName);
        return iContentService.updateContent(id, content);
    }

    /**
     * @author guling
     * @Title   内容版本列表
     * @Date    2019/1/17 13:57
     * @param   id 内容id ,current 当前页, pageSize 每页条数
     * @return  cn.people.controller.vo.ResultVO<com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.people.controller.vo.ContentVersion>>
     * @throws
     * @Description 内容版本列表
    */
    @ApiOperation(value = "内容版本列表", notes = "内容版本列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "path", required = true)
            /*@ApiImplicitParam(name = "current", value = "current", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", paramType = "query", required = true) */

    })
    @PostMapping("/{id}/version")
   /* public ResultVO<Page<ContentVersion>> getContentVersionPaged(@PathVariable("id") String id,@ApiParam(value="当前页",required=true)@RequestParam("current")int current,
                                                                  @ApiParam(value="每页条数",required=true)@RequestParam("pageSize")int pageSize) {*/
 public ResultVO<Page<ContentVersion>> getContentVersionPaged(@PathVariable("id") String id,@RequestBody PageVO pageVO) {

        LOGGER.info("内容的审核,入参,id={}",JSON.toJSONString(id));

        if (id == null || "".equals(id)) {
            // 获取失败直接返回
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "内容id不存在，请确认参数是否正确");
        }
       // return iContentService.getContentVersionPaged(id, contentQueryVO.getPageNo(),contentQueryVO.getPageSize());
        return iContentService.getContentVersionPaged(id, pageVO.getCurrent(),pageVO.getPageSize());
    }

    /**
     * @param @param  param
     * @param @return  参数说明 
     * @return ContentVersionVO    返回类型 
     * @Title: getContentVersionInfo
     * @author gaoyongjiu
     * @date 2018年12月05日 上午11:02:21 
     * @Description: 获取版本详细信息
     * @throws 
     */
    @ApiOperation(value = "获取版本详细信息", notes = "获取版本详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "path", required = true),
            @ApiImplicitParam(name = "versionid", value = "versionid", paramType = "path", required = true)
    })
    @GetMapping("/{id}/version/{versionid}/detail")
    public ResultVO<ContentVersionVO> getContentVersionInfo(@PathVariable("id") String id,
                                                            @PathVariable("versionid") String versionid) {

        return iContentService.getContentVersionInfo(id, versionid);
    }

    /**
     * @author guling
     * @Title   获取版本详细信息
     * @Date    2019/1/17 14:02
     * @param   id 内容id
     * @param  versionid  版本id
     * @return  cn.people.controller.vo.ResultVO<cn.people.controller.vo.ContentVersionVO>
     * @throws
     * @Description 获取版本详细信息
    */
    @ApiOperation(value = "获取版本详细信息", notes = "获取版本详细信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "id", paramType = "path", required = true),
        @ApiImplicitParam(name = "versionid", value = "versionid", paramType = "path", required = true)
    })
    @GetMapping("/{id}/version/{versionid}")
    public ResultVO<ContentVersionVO> restoreContent(@PathVariable("id") String id,
                                                            @PathVariable("versionid") String versionid) {
        LOGGER.info("内容的审核,入参,param={}",JSON.toJSONString(id));
        if (id == null || "".equals(id)) {
            // 获取失败直接返回
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "内容id不存在，请确认参数是否正确");
        }
        if (versionid == null || "".equals(versionid)) {
            // 获取失败直接返回
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "版本id不存在，请确认参数是否正确");
        }
        return iContentService.getContentVersionInfo(id, versionid);
    }
    
    /**
     * 
    * @Title: 稿件下线
    * @author fanchengkui
    * @date 2019年1月25日 上午10:56:31 
    * @Description: 稿件下线
    * @param id 稿件id
    * @return  成功返回true
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "稿件下线", notes = "稿件下线")
    @PostMapping(value = "/{id}/offline")
    public ResultVO<Boolean> offlineContent(@PathVariable("id") String id){
        LOGGER.info("稿件下线入参id="+id);
        if(StringUtils.isEmpty(id)) {
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "参数有误");
        }
        
        return iContentService.offlineContent(id);
    }
    
    /**
     * 
    * @Title: 稿件发布
    * @author fanchengkui
    * @date 2019年1月25日 上午11:08:28 
    * @Description: 稿件发布
    * @param id 稿件id
    * @return  成功返回true 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "稿件发布", notes = "稿件发布")
    @PostMapping(value = "/{id}/publish")
    public ResultVO<Boolean> publishContent(@PathVariable("id") String id){
        LOGGER.info("稿件下线入参id="+id);
        if(StringUtils.isEmpty(id)) {
            return ResultVO.badRequest(CodeConstants.RESULT_ERR_PARAM, "参数有误");
        }
        
        return iContentService.publishContent(id);
    }
    
}

package cn.people.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.people.controller.vo.ContentOperateLogVO;
import cn.people.controller.vo.ResultVO;
import cn.people.service.IContentOperateLogService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 内容操作记录表 前端控制器 
 * </p>
 *
 * @author gaoyongjiu
 * @since 2018-12-04
 */
@RestController
@RequestMapping("/content/operateLog")
public class ContentOperateLogController {
    @Autowired
    private IContentOperateLogService iContentOperateLogService;
    
    /**
     * 
    * @Title: getContentById 
    * @author shidandan
    * @date 2018年12月26日 下午5:57:09 
    * @Description: 获取内容操作日志集合 
    * @param @param id
    * @param @return
    * @param @throws Exception  参数说明 
    * @return ResultVO<List<ContentOperateLogVO>>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "获取内容操作日志集合", notes = "获取内容操作日志集合")
    @ApiImplicitParam(name = "id", value = "Content id", paramType = "path", required = true)
    @GetMapping("/{id}/list")
    public ResultVO<List<ContentOperateLogVO>> getContentById(@PathVariable("id") String id) throws Exception {
        
        return ResultVO.ok(iContentOperateLogService.getContentById(id));
    }
}

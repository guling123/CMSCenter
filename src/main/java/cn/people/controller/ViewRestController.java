package cn.people.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.people.controller.vo.ModelSplitMapResponseVO;
import cn.people.controller.vo.ResultVO;
import cn.people.remote.ViewRemote;
import cn.people.service.IViewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * 模板预览Controller
 * 
 * @ClassName: ViewController 
 * @Description: 模板预览Controller
 * @author zhangchengchun
 * @date 2019年1月15日 下午8:02:57    
 */
@RestController
@RequestMapping("/edit")
@Api(value = "栏目可视化", description = "栏目可视化")
public class ViewRestController
{
    @Autowired
    private IViewService iViewService;


    /**
     * 
    * @Title: 栏目可视化
    * @author zhangchengchun
    * @date 2019年1月17日 下午1:34:41 
    * @Description: 栏目可视化
    * @param logicId 栏目逻辑id
    * @param pageNo 当前页码，可以不传
    * @param info 调试信息，支持值：info|debug
    * @param vtype 预览类型，预览时不传，静态化时传publish
    * @param @throws Exception  参数说明 
    * @return ResultVO<String>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "预览栏目的模板", notes = "预览栏目的模板")
    @RequestMapping(value = "/{logicId}/channel", method = RequestMethod.GET)
    public ResultVO<String> getChannelTemplate(@ApiParam(value = "栏目逻辑id", required = true) @PathVariable(value = "logicId") Integer logicId,
                                   @ApiParam(value = "浏览第几页，可不传", required = false) @RequestParam(value="pageNo",defaultValue="0",required=false) Integer pageNo,
                                   @ApiParam(value = "是否返回日志，支持值：info|debug", required = false) @RequestParam(value="info",defaultValue="",required=false) String info,
                                   @ApiParam(value = "是否要静态化", required = false) @RequestParam(value="vtype",defaultValue="",required=false) String vtype,
                                   HttpServletResponse response)
        throws Exception
    {
        return  iViewService.getChannelTemplate(logicId, pageNo, info, "edit");
    }
}

/**   
* @Title: ViewController.java 
* @Package cn.people.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2019年2月1日 上午9:47:51 
* @version V1.0   
*/
package cn.people.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.people.controller.vo.ResultVO;
import cn.people.service.IViewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/** 
* @ClassName: ViewController 
* @Description: 栏目文章预览 
* @author shidandan
* @date 2019年2月1日 上午9:47:51 
*  
*/
@Controller
@RequestMapping("/view")
@Api(value = "模板预览", description = "模板预览")
public class ViewController
{
    @Autowired
    private IViewService iViewService;
    
    /**
     * 
    * @Title: 栏目预览支持分页 
    * @author shidandan
    * @date 2019年2月1日 上午9:54:02 
    * @Description: 栏目预览支持分页 
    * @param logicId 栏目逻辑ID
    * @param pageNo 浏览第几页
    * @param info 是否返回日志，支持值：info|debug
    * @param vtype 是否要静态化
    * @param response
    * @throws Exception  参数说明 
    * @return void    返回类型 
    * @throws 
     */
    @ApiOperation(value = "预览栏目的模板", notes = "预览栏目的模板")
    @RequestMapping(value = "/{logicId}/channel", method = RequestMethod.GET)
    public void getChannelTemplate(@ApiParam(value = "栏目逻辑id", required = true) @PathVariable(value = "logicId") Integer logicId,
                                   @ApiParam(value = "浏览第几页，可不传", required = false) @RequestParam(value="page",defaultValue="0",required=false) Integer pageNo,
                                   @ApiParam(value = "是否返回日志，支持值：info|debug", required = false) @RequestParam(value="info",defaultValue="",required=false) String info,
                                   @ApiParam(value = "是否要静态化", required = false) @RequestParam(value="vtype",defaultValue="",required=false) String vtype,
                                   HttpServletResponse response)
        throws Exception
    {
        ResultVO<String> result = iViewService.getChannelTemplate(logicId, pageNo, info, vtype);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(result.getData());
    }

    /**
     * 
    * @Title: 稿件预览支持分页 
    * @author shidandan
    * @date 2019年2月1日 上午9:55:52 
    * @Description: 稿件预览支持分页
    * @param contentId 稿件id
    * @param pageNo 浏览第几页
    * @param info 是否返回日志，支持值：info|debug
    * @param vtype 是否要静态化
    * @param response
    * @throws Exception  参数说明 
    * @return void    返回类型 
    * @throws 
     */
    @ApiOperation(value = "预览稿件的模板", notes = "预览稿件的模板")
    @RequestMapping(value = "/{contentLogicId}/content", method = RequestMethod.GET)
    public void getContentTemplate(@ApiParam(value = "稿件id", required = true) @PathVariable(value = "contentLogicId") Integer contentLogicId,
                                   @ApiParam(value = "浏览第几页，可不传", required = false) @RequestParam(value = "page", defaultValue = "0", required = false) Integer pageNo,
                                   @ApiParam(value = "是否返回日志，支持值：info|debug", required = false) @RequestParam(value = "info", defaultValue = "", required = false) String info,
                                   @ApiParam(value = "是否要静态化", required = false) @RequestParam(value = "vtype", defaultValue = "", required = false) String vtype,
                                   HttpServletResponse response)
        throws Exception
    {
        ResultVO<String> result = iViewService.getContentTemplate(contentLogicId, pageNo, info, vtype);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(result.getData());
    }

}

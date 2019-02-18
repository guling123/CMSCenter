/**   
* @Title: ChannelRemote.java 
* @Package cn.people.remote 
* @Description: 栏目服务调用
* @author shidandan
* @date 2019年1月10日 下午2:35:02 
* @version V1.0   
*/
package cn.people.remote;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.people.controller.vo.ChannelCreateRemoteVO;
import cn.people.controller.vo.ChannelCreateVO;
import cn.people.controller.vo.ChannelDetailVO;
import cn.people.controller.vo.ChannelTreeVO;
import cn.people.controller.vo.ModelSplitMapResponseVO;
import cn.people.controller.vo.ResultVO;
import io.swagger.annotations.ApiParam;

/**
 * 模板预览调用服务
* @ClassName: ViewRemote 
* @Description: 模板预览调用服务
* @author zhangchengchun
* @date 2019年1月16日 下午6:52:29 
*  
 */
@FeignClient("contentService")
public interface ViewRemote
{   
    @RequestMapping(value = "/view/channel/{logicId}/mod",method = RequestMethod.GET)
    ResultVO<String> getChannelTemplateMod(@PathVariable(value = "logicId") Integer logicId);
    
    @RequestMapping(value = "/view/channel/{logicId}/splits",method = RequestMethod.GET)
    ResultVO<List<ModelSplitMapResponseVO>> getChannelTemplateSplits(@PathVariable(value = "logicId") Integer logicId);
 
    @RequestMapping(value = "/view/channel/{logicId}",method = RequestMethod.GET)
    ResultVO<String> getChannelTemplate(@ApiParam(value = "栏目逻辑id", required = true) @PathVariable(value = "logicId") Integer logicId,
                                    @ApiParam(value = "浏览第几页，可不传", required = false) @RequestParam(value="page",defaultValue="0",required=false) Integer pageNo,
                                    @ApiParam(value = "是否返回日志，支持值：info|debug", required = false) @RequestParam(value="info",defaultValue="",required=false) String info,
                                    @ApiParam(value = "是否要静态化", required = false) @RequestParam(value="vtype",defaultValue="",required=false) String vtype);
    
    @RequestMapping(value = "/view/content/{contentLogicId}",method = RequestMethod.GET)
    ResultVO<String> getContentTemplate(@ApiParam(value = "稿件id", required = true)@PathVariable(value = "contentLogicId") Integer contentLogicId,
                                 @ApiParam(value = "浏览第几页，可不传", required = false) @RequestParam(value="page",defaultValue="0",required=false) Integer pageNo,
                                 @ApiParam(value = "是否返回日志，支持值：info|debug", required = false) @RequestParam(value="info",defaultValue="",required=false) String info,
                                 @ApiParam(value = "是否要静态化", required = false) @RequestParam(value="vtype",defaultValue="",required=false) String vtype);
}

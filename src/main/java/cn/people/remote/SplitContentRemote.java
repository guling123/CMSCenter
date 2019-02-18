/**   
* @Title: SplitContentRemote.java 
* @Package cn.people.remote 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2018年12月25日 上午11:08:03 
* @version V1.0   
*/
package cn.people.remote;

import java.util.List;

import cn.people.controller.vo.SplitContentDelVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SplitContentAddVO;
import cn.people.controller.vo.SplitContentVO;

/** 
* @ClassName: SplitContentRemote 
* @Description: 碎片内容服务
* @author shidandan
* @date 2018年12月25日 上午11:08:03 
*  
*/
@FeignClient("contentService")
public interface SplitContentRemote{

    @RequestMapping(value ="/split/content/{modelSplitId}/{channelId}/list", method = RequestMethod.GET)
    ResultVO<List<SplitContentVO>> querySplitContentList(@PathVariable("modelSplitId") String modelSplitId,@PathVariable("channelId") String channelId);
    
    @RequestMapping(value ="/split/content/{id}/detail", method = RequestMethod.GET)
    ResultVO<SplitContentVO> getSplitContent(@PathVariable("id") String id);
    
    @RequestMapping(value ="/split/content/{id}/del", method = RequestMethod.GET)
    ResultVO<Boolean> delSplitContent(@PathVariable("id") String id);
    
    @RequestMapping(value ="/split/content/{id}/show", method = RequestMethod.GET)
    ResultVO<Boolean> showSplitContent(@PathVariable("id") String id);
    
    @RequestMapping(value ="/split/content/{id}/hide", method = RequestMethod.GET)
    ResultVO<Boolean> hideSplitContent(@PathVariable("id") String id);
    
    @RequestMapping(value ="/split/content/{id}/update", method = RequestMethod.POST)
    ResultVO<Boolean> updateSplitContent(@PathVariable(value="id") String id,@RequestBody SplitContentVO splitContentVO);
    
    @RequestMapping(value ="/split/content/add", method = RequestMethod.POST)
    ResultVO<Boolean> addSplitContent(@RequestBody SplitContentAddVO splitContentVO);

    @RequestMapping(value ="/split/content/ids/del", method = RequestMethod.POST)
    ResultVO<Boolean> delSplitContentByIds(SplitContentDelVO splitContentDelVO);
}

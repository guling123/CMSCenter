/**   
* @Title: ModelSplitPropRemote.java 
* @Package cn.people.remote 
* @Description: 模板碎片属性服务
* @author shidandan
* @date 2019年1月16日 下午3:34:36 
* @version V1.0   
*/
package cn.people.remote;

import java.util.List;

import cn.people.controller.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/** 
* @ClassName: ModelSplitPropRemote 
* @Description: 模板碎片属性服务
* @author shidandan
* @date 2019年1月16日 下午3:34:36 
*  
*/
@FeignClient("contentService")
public interface ModelSplitPropRemote
{
   @RequestMapping(value ="/model/spilt/prop/{modelSpiltId}/add", method = RequestMethod.POST)
   ResultVO<Boolean> createModelSplitProp(@PathVariable(value="modelSpiltId")String modelSpiltId,
                                                 @RequestBody ModelSplitPropCreateVO createVO);

   @RequestMapping(value ="/model/spilt/prop/{id}/update", method = RequestMethod.POST)
   ResultVO<Boolean> updateModelSplitProp(@RequestBody ModelSplitPropUpdateVO updateVO,@PathVariable(value="id")String id);

   @RequestMapping(value ="/model/spilt/prop/updateByChannel", method = RequestMethod.POST)
   ResultVO<Boolean> updateModelSplitPropByChannel(@RequestBody ModelSplitPropBatchUpdateVO updateVO);

   @RequestMapping(value ="/model/spilt/prop/{modelSpiltLogicId}/{channelId}/list", method = RequestMethod.GET)
   ResultVO<List<SplitPropListVO>> getModelSplitPropListByChannel(@PathVariable(value="channelId")String channelId, @PathVariable(value="modelSpiltLogicId")String modelSpiltLogicId);

   @RequestMapping(value ="/model/spilt/prop/{modelSpiltId}/list", method = RequestMethod.POST)
   ResultVO<ModelSplitPropListParentVO> getModelSplitPropList(@PathVariable(value="modelSpiltId")String modelSpiltId);

   @GetMapping(value ="/model/spilt/prop/{id}/del")
   ResultVO<Boolean> delModelSplitProp(@PathVariable(value="id") String id);
}

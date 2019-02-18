/**   
* @Title: ModelSplitRemote.java 
* @Package cn.people.remote 
* @Description: 碎片模板服务
* @author shidandan
* @date 2018年12月25日 上午10:48:30 
* @version V1.0   
*/
package cn.people.remote;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.Split;
import cn.people.controller.vo.SplitProp;

/** 
* @ClassName: ModelSplitRemote 
* @Description: 碎片模板服务
* @author shidandan
* @date 2018年12月25日 上午10:48:30 
*  
*/
@FeignClient("contentService")
public interface SplitRemote
{
    
    @RequestMapping(value ="/split/list", method = RequestMethod.GET)
    ResultVO<List<Split>> getSplit();
    
    @RequestMapping(value ="/split/prop/{splitId}/{modelSpiltId}/list", method = RequestMethod.GET)
    ResultVO<List<SplitProp>> getSplitProp(@PathVariable(value="splitId")String splitId,@PathVariable(value="modelSpiltId")String modelSpiltId);
}

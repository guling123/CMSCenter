/**   
* @Title: SplitModRemote.java 
* @Package cn.people.remote 
* @Description: 碎片方案服务
* @author shidandan
* @date 2019年1月16日 下午3:45:42 
* @version V1.0   
*/
package cn.people.remote;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SplitMod;
import cn.people.controller.vo.SplitModCreateVO;

/** 
* @ClassName: SplitModRemote 
* @Description: 碎片方案服务
* @author shidandan
* @date 2019年1月16日 下午3:45:42 
*  
*/
@FeignClient("contentService")
public interface SplitModRemote
{
    @RequestMapping(value ="/split/mod/{splitId}/list", method = RequestMethod.GET)
    ResultVO<List<SplitMod>> getSplitMod(@PathVariable(value="splitId")String splitId);
    
    @RequestMapping(value ="/split/mod/{splitId}/add", method = RequestMethod.POST)
    ResultVO<Boolean> createSplitMod(@PathVariable(value="splitId")String splitId,@RequestBody SplitModCreateVO createVO);

}

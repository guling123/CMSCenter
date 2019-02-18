/**   
* @Title: ChannelRemote.java 
* @Package cn.people.remote 
* @Description: 栏目服务调用
* @author shidandan
* @date 2019年1月10日 下午2:35:02 
* @version V1.0   
*/
package cn.people.remote;

import cn.people.controller.vo.*;
import cn.people.hystrix.ChannelRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/** 
* @ClassName: ChannelRemote 
* @Description: 栏目服务调用
* @author shidandan
* @date 2019年1月10日 下午2:35:02 
*  
*/
//@FeignClient(value = "contentService")
@FeignClient(value = "contentService", fallback = ChannelRemoteHystrix.class)
public interface ChannelRemote
{
    @PostMapping("/channel/{siteid}/{orgid}/list")
    ResultVO<ChannelListVO> getChannelBySite(@PathVariable(value="siteid")String siteid, @PathVariable(value="orgid")String orgid,@RequestBody ChannelListRequestVO requestVO);

    @RequestMapping(value = "/channel/listAll",method = RequestMethod.POST)
    ResultVO<List<Channel>> getChannelList(@RequestBody ChannelListRequestVO requestVO);
    
    @RequestMapping(value = "/channel/add",method = RequestMethod.POST)
    ResultVO<ChannelCreateResultVO> createChannel(@RequestBody ChannelCreateRemoteVO channelCreateVO);
    
    @RequestMapping(value = "/channel/{id}/detail",method = RequestMethod.GET)
    ResultVO<ChannelDetailVO> getChannel(@PathVariable(value="id") String id);
 
    @RequestMapping(value = "/channel/{id}/update",method = RequestMethod.POST)
    ResultVO<Boolean> updateChannel(@RequestBody ChannelCreateVO channel,@PathVariable(value="id")String id);
    
    @RequestMapping(value = "/channel/{id}/del",method = RequestMethod.GET)
    ResultVO<Boolean> delChannel(@PathVariable(value="id") String id);
}

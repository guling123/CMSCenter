package cn.people.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cn.people.controller.vo.PublishChanneRequest;
import cn.people.controller.vo.ResultVO;

@FeignClient("outputService")
public interface OutputChannelRemote
{

    @PostMapping(value = "/channel/offline")
    ResultVO<Boolean> offlineChannel(@RequestBody PublishChanneRequest publishChanneRequest);
    
    @PostMapping(value = "/channel/publish")
    ResultVO<Boolean> publishChannel(@RequestBody PublishChanneRequest publishChanneRequest);

}

package cn.people.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cn.people.controller.vo.ResultVO;

@FeignClient("outputService")
public interface OutputContentRemote
{

    @PostMapping(value = "/content/{id}/offline")
    ResultVO<Boolean> offlineContent(@PathVariable(value = "id") String id);
    
    @PostMapping(value = "/content/{id}/publish")
    ResultVO<Boolean> publishContent(@PathVariable(value = "id") String id);
}

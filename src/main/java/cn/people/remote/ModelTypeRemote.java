package cn.people.remote;

import cn.people.controller.vo.ModelTypeVO;
import cn.people.controller.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


/**
 * @author guling
 * @ClassName: ModelTypeRemote
 * @Description: 模型种类fegin调用(这里用一句话描述这个接口的作用)
 * @date 2019/1/22 10:13
 */
@FeignClient("contentService")
public interface ModelTypeRemote
{
    @GetMapping("/model/type/{siteid}/list")
    ResultVO<List<ModelTypeVO>> getModelTypeListBySiteId(@PathVariable(value="siteid") String siteid);


}

/**   
* @Title: ModelSplitRemote.java 
* @Package cn.people.remote 
* @Description: 模板碎片服务
* @author shidandan
* @date 2019年1月16日 下午3:06:08 
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
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.people.controller.vo.ModelSplit;
import cn.people.controller.vo.ModelSplitDetailVO;
import cn.people.controller.vo.ModelSplitPageVO;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SplitCreateVO;
import cn.people.controller.vo.SplitPageVO;
import cn.people.controller.vo.SplitUpdateVO;

/** 
* @ClassName: ModelSplitRemote 
* @Description: 模板碎片服务
* @author shidandan
* @date 2019年1月16日 下午3:06:08 
*  
*/
@FeignClient("contentService")
public interface ModelSplitRemote
{
    @RequestMapping(value ="/model/split/add", method = RequestMethod.POST)
    ResultVO<Boolean> createModelSplit(@RequestBody SplitCreateVO split);
    
    @RequestMapping(value ="/model/split/{id}/update", method = RequestMethod.POST)
    ResultVO<Boolean> updateSplit(@RequestBody SplitUpdateVO split,@PathVariable(value="id") String id);
    
    @RequestMapping(value ="/model/split/{modelid}/page", method = RequestMethod.POST)
    ResultVO<ModelSplitPageVO> getSplitPaged(@RequestBody SplitPageVO split,@PathVariable(value="modelid") String modelid);
    
    @GetMapping(value ="/model/split/{id}/detail")
    ResultVO<ModelSplitDetailVO> getModelSplitDetail(@PathVariable String id);
    
    @GetMapping(value ="/model/split/{id}/del")
    ResultVO<Boolean> delModelSplit(@PathVariable String id);
    
    @GetMapping(value ="/model/split/{modelid}/list")
    ResultVO<List<ModelSplit>> getSplit(@PathVariable(value="modelid") String modelid);

}

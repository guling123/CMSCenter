/**   
* @Title: ModelRemote.java 
* @Package cn.people.remote 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2018年12月25日 上午10:20:42 
* @version V1.0   
*/
package cn.people.remote;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.people.controller.vo.Model;
import cn.people.controller.vo.ModelDetailVO;
import cn.people.controller.vo.ModelListRequestVO;
import cn.people.controller.vo.ModelVO;
import cn.people.controller.vo.ResultVO;

/** 
* @ClassName: ModelRemote 
* @Description: 模板模块
* @author shidandan
* @date 2018年12月25日 上午10:20:42 
*  
*/
@FeignClient("contentService")
public interface ModelRemote
{
    
    @RequestMapping(value ="/model/{id}/update", method = RequestMethod.POST)
    ResultVO<Boolean> modelUpdate(@RequestBody ModelVO model,@PathVariable(value="id") String id);

    @PostMapping(value ="/model/add")
    ResultVO<String> createModel(@RequestBody ModelVO modelVo);
    
    @GetMapping(value ="/model/{id}/detail")
    ResultVO<ModelDetailVO> getModel(@PathVariable(value="id") String id);
    
    @PostMapping(value ="/model/{siteid}/list")
    ResultVO<Page<Model>> getModelPaged(@PathVariable(value="siteid") String siteid,@RequestBody ModelListRequestVO modelListRequestVo);
    
    @RequestMapping(value ="/model/{id}/enabled", method = RequestMethod.GET)
    ResultVO<Boolean> enabledModel(@PathVariable(value="id") String id);
    
    @RequestMapping(value ="/model/{id}/disable", method = RequestMethod.GET)
    ResultVO<Boolean> disableModel(@PathVariable(value="id") String id);
    
    @RequestMapping(value ="/model/{id}/del", method = RequestMethod.GET)
    ResultVO<Boolean> delModel(@PathVariable(value="id") String id);

    @GetMapping(value ="/model/{siteid}/{typeid}/list")
    ResultVO<List<Model>> getModel(@PathVariable(value="siteid")String siteid,@PathVariable(value="typeid")String typeid);
}

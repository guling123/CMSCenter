/**   
* @Title: SplitVersionRemote.java 
* @Package cn.people.remote 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2018年12月25日 下午1:58:29 
* @version V1.0   
*/
package cn.people.remote;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SplitVersion;

/** 
* @ClassName: SplitVersionRemote 
* @Description: 碎片模板
* @author shidandan
* @date 2018年12月25日 下午1:58:29 
*  
*/
@FeignClient("contentService")
public interface SplitVersionRemote
{
    @RequestMapping(value ="/split/version/{splitid}/list", method = RequestMethod.POST)
    ResultVO<List<SplitVersion>> getSplitVersion(@PathVariable(value="splitid")String splitid);
}

/**   
* @Title: ContentOperateLogRemote.java 
* @Package cn.people.remote 
* @Description: 内容操作日志服务类 
* @author shidandan
* @date 2018年12月26日 下午5:04:51 
* @version V1.0   
*/
package cn.people.remote;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cn.people.controller.vo.ContentOperateLogVO;
import cn.people.controller.vo.ResultVO;

/** 
* @ClassName: ContentOperateLogRemote 
* @Description: 内容操作日志服务类
* @author shidandan
* @date 2018年12月26日 下午5:04:51 
*  
*/
@FeignClient("contentService")
public interface ContentOperateLogRemote
{
    
    @GetMapping("/content/operateLog/{id}/list")
    ResultVO<List<ContentOperateLogVO>> getContentById(@PathVariable("id") String id);

}

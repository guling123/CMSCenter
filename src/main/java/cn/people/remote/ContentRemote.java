/**
 *   
 *
 * @Title: ContentSiteRemote.java 
 * @Package cn.people.remote 
 * @Description: 调用内容服务远程接口 
 * @author shidandan
 * @date 2018年12月12日 下午3:02:06 
 * @version V1.0   
 */
package cn.people.remote;


import cn.people.controller.vo.*;
import cn.people.entity.Site;
import cn.people.hystrix.ContentRemoteHystrix;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *  
 *
 * @ClassName: ContentSiteRemote 
 * @Description: 调用内容服务远程接口
 * @author shidandan
 * @date 2018年12月12日 下午3:02:06    
 */
@FeignClient(value = "contentService", fallback = ContentRemoteHystrix.class)
//@FeignClient(name = "contentService", url = "http://127.0.0.1:8082")
public interface ContentRemote
{

    @RequestMapping(method = RequestMethod.POST, value = "/site/init", consumes = "application/json")
    ResultVO<Boolean> createSite(Site param);

    @RequestMapping(method = RequestMethod.POST, value = "/site/update", consumes = "application/json")
    ResultVO<Boolean> updateSite(Site param);

    @PostMapping("/content/add")
    ResultVO<ContentCreateResultVO> createContent(@RequestBody ContentCreateVO param);

    @PostMapping("/content/list")
    ResultVO<Page<ContentListVO>> getContentPaged(@RequestBody ContentQueryVO param);

    @GetMapping("/content/{id}/detail")
    ResultVO<ContentDetailVO> getContentById(@PathVariable("id") String id);

    @GetMapping("/content/{id}/del")
    ResultVO<Boolean> delContent(@PathVariable("id") String id);

    @PutMapping("/content/{id}/update")
    ResultVO<ContentUpdateResultVO> updateContent(@PathVariable("id") String id,
                                                  @RequestBody ContentUpdateVO content);

    @GetMapping("/content/{id}/version")
    ResultVO<Page<ContentVersion>> getContentVersionPaged(@PathVariable("id") String id,
                                                          @RequestParam("pageNo") int pageNo,
                                                          @RequestParam("pageSize") int pageSize);

    @GetMapping("/content/{id}/{versionid}/version")
    ResultVO<ContentVersionVO> getContentVersionInfo(@PathVariable("id") String id,
                                                     @PathVariable("versionid") String versionid);

    @PostMapping("/content/{id}/pass")
    ResultVO<Boolean> passContent(@PathVariable("id")String id,@RequestBody ContentAuditVO auditVO);
    
    @PostMapping("/content/{id}/reject")
    ResultVO<Boolean> rejectContent(@PathVariable("id")String id,@RequestBody ContentAuditVO auditVO);

    @GetMapping("/content/recycled")
    ResultVO<List<Content>> getContentRecycledPaged(ContentRecycledListVO param);

    @PatchMapping("/content/{id}/restore")
    ResultVO<ContentRestoreResultVO> restoreContent(String id);
}

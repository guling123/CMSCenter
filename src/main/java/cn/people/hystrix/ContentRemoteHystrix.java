package cn.people.hystrix;

import cn.people.controller.vo.*;
import cn.people.entity.Site;
import cn.people.remote.ContentRemote;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;


/**
 * @author guling
 * @ClassName: ContentRemoteHystrix
 * @Description: (这里用一句话描述这个类的作用)
 * @date 2019/2/13 14:36
 */
public class ContentRemoteHystrix implements ContentRemote
{
    @Override public ResultVO<Boolean> createSite(Site param)
    {
        return null;
    }

    @Override public ResultVO<Boolean> updateSite(Site param)
    {
        return null;
    }

    @Override public ResultVO<ContentCreateResultVO> createContent(ContentCreateVO param)
    {
        return null;
    }

    @Override public ResultVO<Page<ContentListVO>> getContentPaged(ContentQueryVO param)
    {
        return null;
    }

    @Override public ResultVO<ContentDetailVO> getContentById(String id)
    {
        return null;
    }

    @Override public ResultVO<Boolean> delContent(String id)
    {
        return null;
    }

    @Override public ResultVO<ContentUpdateResultVO> updateContent(String id,
                                                                   ContentUpdateVO content)
    {
        return null;
    }

    @Override public ResultVO<Page<ContentVersion>> getContentVersionPaged(String id, int pageNo,
                                                                           int pageSize)
    {
        return null;
    }

    @Override public ResultVO<ContentVersionVO> getContentVersionInfo(String id, String versionid)
    {
        return null;
    }

    @Override public ResultVO<Boolean> passContent(String id, ContentAuditVO auditVO)
    {
        return null;
    }

    @Override public ResultVO<Boolean> rejectContent(String id, ContentAuditVO auditVO)
    {
        return null;
    }

    @Override public ResultVO<List<Content>> getContentRecycledPaged(ContentRecycledListVO param)
    {
        return null;
    }

    @Override public ResultVO<ContentRestoreResultVO> restoreContent(String id)
    {
        return null;
    }
}

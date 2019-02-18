package cn.people.service.impl;

import cn.people.controller.vo.*;
import cn.people.entity.SysUser;
import cn.people.mapper.SysUserMapper;
import cn.people.remote.ContentRemote;
import cn.people.remote.OutputContentRemote;
import cn.people.service.IContentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * <p> 内容主体表 服务实现类 </p>
 *
 * @author shidandan
 * @since 2018-12-04
 */
@Service
public class ContentServiceImpl  implements IContentService {

    @Autowired
    private ContentRemote contentRemote;
    
    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Autowired
    private OutputContentRemote outputContentRemote;

    /*
     * Title: getContentById
     * @author shidandan
     * @date 2018年12月21日 下午2:59:04  Description:
     * @param id
     * @return
     * @see cn.people.service.IContentService#getContentById(java.lang.String)
     */
    @Override
    public ContentDetailVO getContentById(String id)
    {
        return contentRemote.getContentById(id).getData();


    }

    /**
     * @author guling
     * @Title 添加内容
     * @Date 2019/1/17 13:23
     * @param param
     *            添加内容请求参数
     * @return cn.people.controller.vo.ResultVO<cn.people.controller.vo.ContentCreateResultVO>
     * @throws @Description
     *             添加内容
     */
    @Override
    public ResultVO<ContentCreateResultVO> createContent(ContentCreateVO param)
    {
        return contentRemote.createContent(param);
    }

    /**
     * @author guling
     * @Title getContentRecycledPaged
     * @Date 2019/1/17 13:31
     * @param param
     *            //TODO (描述参数)
     * @return cn.people.controller.vo.ResultVO<java.util.List<cn.people.controller.vo.Content>>
     * @throws @Description
     *             //TODO(这里用一句话描述这个方法的作用)
     */
    @Override
    public ResultVO<List<Content>> getContentRecycledPaged(ContentRecycledListVO param)
    {

        return contentRemote.getContentRecycledPaged(param);
    }

    /**
     * @param @param
     *            内容查询参数
     * @return List<Content>    返回类型 
     * @Title: getContentPaged 
     * @author guling
     * @date 2018年12月15日 上午11:02:21 
     * @Description: 内容列表查询 @throws 
     */
    @Override
    public ResultVO<Page<ContentListVO>> getContentPaged(ContentQueryVO param)
    {
        //将传入创建人转换为创建人id进行模糊查询
        if (!StringUtils.isEmpty(param.getCreateName())) {
            QueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>();
            wrapper.like("realname", param.getCreateName());
            List<SysUser> userList=sysUserMapper.selectList(wrapper);
            if(!CollectionUtils.isEmpty(userList)) {
                Set<String> userIds = userList.stream().map(user -> {return user.getId();}).collect(Collectors.toSet());
                param.setCreateIds(userIds);
            }
        }

        return contentRemote.getContentPaged(param);
    }

    /**
     * @Title: 删除内容 
     * @author guling
     * @date 2019年1月15日 下午7:29:30 
     * @Description: 删除内容 
     * @param id
     *            内容id
     * @return ResultVO<ContentDelResultVO>    返回类型 
     * @throws 
     */
    @Override
    public ResultVO<Boolean> delContent(String id)
    {
        return contentRemote.delContent(id);
    }

    /**
     * @author guling
     * @Title 内容审核
     * @Date 2019/1/17 13:45
     * @param id
     *            内容id
     * @return cn.people.controller.vo.ResultVO<java.lang.Boolean>
     * @throws @Description
     *             内容的审核
     */
    @Override
    public ResultVO<Boolean> passContent(String id,ContentAuditVO auditVO)
    {
        return contentRemote.passContent(id,auditVO);
    }
    /**
     * Title: rejectContent
     * @author shidandan
     * @date 2019年1月25日 下午2:10:10 
     * @Description: 
     * @param id
     * @param auditVO
     * @return 
     * @see cn.people.service.IContentService#rejectContent(java.lang.String, cn.people.controller.vo.ContentAuditVO) 
     */
     @Override
     public ResultVO<Boolean> rejectContent(String id, ContentAuditVO auditVO)
     {
         return contentRemote.rejectContent(id,auditVO);
     }
    /**
     * @author guling
     * @Title 从回收站还原内容
     * @Date 2019/1/17 13:52
     * @param id
     *            内容id
     * @return cn.people.controller.vo.ResultVO<cn.people.controller.vo.ContentRestoreResultVO>
     * @throws @Description
     *             从回收站还原内容通过内容id
     */
    @Override
    public ResultVO<ContentRestoreResultVO> restoreContent(String id)
    {
        return contentRemote.restoreContent(id);
    }

    /**
     * @author guling
     * @Title 更新内容
     * @Date 2019/1/17 13:55
     * @param id
     *             内容id
     * @param  content
     *              内容参数
     * @return cn.people.controller.vo.ResultVO<cn.people.controller.vo.ContentUpdateResultVO>
     * @throws @Description
     *             更新内容
     */
    @Override
    public ResultVO<ContentUpdateResultVO> updateContent(String id, ContentUpdateVO content)
    {
        return contentRemote.updateContent(id, content);
    }

    /**
     * @author guling
     * @Title 内容版本列表
     * @Date 2019/1/17 13:57
     * @param id
     *            内容id
     * @param current
     *            当前页
     * @param pageSize
     *            每页条数
     * @return cn.people.controller.vo.ResultVO<com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.people.controller.vo.ContentVersion>>
     * @throws @Description
     *             内容版本列表
     */
    @Override
    public ResultVO<Page<ContentVersion>> getContentVersionPaged(String id, int current,
                                                                 int pageSize)
    {
        return contentRemote.getContentVersionPaged(id, current, pageSize);
    }

    /**
     * @author guling
     * @Title 获取版本详细信息
     * @Date 2019/1/17 14:02
     * @param id
     *            内容id
     * @param versionid
     *            版本id
     * @return cn.people.controller.vo.ResultVO<cn.people.controller.vo.ContentVersionVO>
     * @throws @Description
     *             获取版本详细信息
     */
    @Override
    public ResultVO<ContentVersionVO> getContentVersionInfo(String id, String versionid)
    {
        return contentRemote.getContentVersionInfo(id, versionid);
    }
    
    /**
     * 
    * Title: 稿件下线
    * @author fanchengkui
    * @date 2019年1月25日 上午10:56:31 
    * @Description: 稿件下线
    * @param id 稿件id
    * @return  成功返回true
    * @see cn.people.service.IContentService#offlineContent(java.lang.String)
     */
    @Override
    public ResultVO<Boolean> offlineContent(String id)
    {
        return outputContentRemote.offlineContent(id);
    }
    
    /**
     * 
    * Title: 稿件发布
    * @author fanchengkui
    * @date 2019年1月25日 上午11:08:28 
    * @Description: 稿件发布
    * @param id 稿件id
    * @return  成功返回true 
    * @see cn.people.service.IContentService#publishContent(java.lang.String)
     */
    @Override
    public ResultVO<Boolean> publishContent(String id)
    {
        return outputContentRemote.publishContent(id);
    }

   

}

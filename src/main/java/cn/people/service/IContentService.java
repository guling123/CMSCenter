package cn.people.service;

import cn.people.controller.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;


/**
 * <p>
 * 内容主体表 服务类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-04
 */
public interface IContentService{


    /**
     * 
    * @Title: getContentById 
    * @author shidandan
    * @date 2018年12月21日 下午2:58:35 
    * @Description: 获取内容详情 
    * @param @param id
    * @param @return  参数说明 
    * @return ContentDetailVO    返回类型 
    * @throws 
     */
    ContentDetailVO getContentById(String id);

    /**
     * @author guling
     * @Title   添加内容
     * @Date    2019/1/17 13:23
     * @param   param  添加内容请求参数
     * @return  cn.people.controller.vo.ResultVO<cn.people.controller.vo.ContentCreateResultVO>
     * @throws
     * @Description 添加内容
    */
    ResultVO<ContentCreateResultVO> createContent(ContentCreateVO param);

    /**
     * @author guling
     * @Title   回收站列表查询
     * @Date    2019/1/15 13:30
     * @param   param  回收站内容列表查询参数
     * @return  cn.people.controller.vo.ResultVO<java.util.List<cn.people.controller.vo.Content>>
     * @throws
     * @Description 回收站内容列表查询列表
    */
    ResultVO<List<Content>> getContentRecycledPaged(ContentRecycledListVO param);

    /**
     * @param @param  内容查询参数
     * @return List<Content>    返回类型 
     * @Title: getContentPaged 
     * @author guling
     * @date 2018年12月15日 上午11:02:21 
     * @Description: 内容列表查询
     * @throws 
     */
    ResultVO<Page<ContentListVO>> getContentPaged(ContentQueryVO param);

    /**
     *
     * @Title: 删除内容 
     * @author shidandan
     * @date 2019年1月15日 下午7:29:30 
     * @Description: 删除内容 
     * @param  id 内容id
     * @return ResultVO<ContentDelResultVO>    返回类型 
     * @throws 
     */
    ResultVO<Boolean> delContent(String id);

    /**
     * @author guling
     * @Title   内容的审核
     * @Date    2019/1/17 13:44
     * @param   id  内容id   dstatus 状态
     * @return  cn.people.controller.vo.ResultVO<java.lang.Boolean>
     * @throws
     * @Description 内容的审核
     */
    ResultVO<Boolean> passContent(String id, ContentAuditVO auditVO);
    
    ResultVO<Boolean> rejectContent(String id, ContentAuditVO auditVO);

    /**
     * @author guling
     * @Title   从回收站还原内容
     * @Date    2019/1/17 13:52
     * @param   id  内容id
     * @return  cn.people.controller.vo.ResultVO<cn.people.controller.vo.ContentRestoreResultVO>
     * @throws
     * @Description 从回收站还原内容通过内容id
     */
    ResultVO<ContentRestoreResultVO> restoreContent(String id);

    /**
     * @author guling
     * @Title   更新内容
     * @Date    2019/1/17 13:55
     * @param   id, content  内容id  content内容参数
     * @return  cn.people.controller.vo.ResultVO<cn.people.controller.vo.ContentUpdateResultVO>
     * @throws
     * @Description 更新内容
     */
    ResultVO<ContentUpdateResultVO> updateContent(String id, ContentUpdateVO content);

    /**
     * @author guling
     * @Title   内容版本列表
     * @Date    2019/1/17 13:57
     * @param   id 内容id ,current 当前页, pageSize 每页条数
     * @return  cn.people.controller.vo.ResultVO<com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.people.controller.vo.ContentVersion>>
     * @throws
     * @Description 内容版本列表
     */
    ResultVO<Page<ContentVersion>> getContentVersionPaged(String id, int current, int pageSize);

    /**
     * @author guling
     * @Title   获取版本详细信息
     * @Date    2019/1/17 14:02
     * @param   id 内容id
     * @param  versionid  版本id
     * @return  cn.people.controller.vo.ResultVO<cn.people.controller.vo.ContentVersionVO>
     * @throws
     * @Description 获取版本详细信息
     */
    ResultVO<ContentVersionVO> getContentVersionInfo(String id, String versionid);
    
    /**
     * 
    * @Title: 稿件下线
    * @author fanchengkui
    * @date 2019年1月25日 上午10:56:31 
    * @Description: 稿件下线
    * @param id 稿件id
    * @return  成功返回true
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    ResultVO<Boolean> offlineContent(String id);
    
    /**
     * 
    * @Title: 稿件发布
    * @author fanchengkui
    * @date 2019年1月25日 上午11:08:28 
    * @Description: 稿件发布
    * @param id 稿件id
    * @return  成功返回true 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    ResultVO<Boolean> publishContent(String id);
}

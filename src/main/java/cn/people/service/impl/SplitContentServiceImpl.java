/**   
* @Title: SplitContentServiceImpl.java 
* @Package cn.people.service.impl 
* @Description: 碎片内容实现类 
* @author shidandan
* @date 2019年1月16日 下午2:55:54 
* @version V1.0   
*/
package cn.people.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import cn.people.controller.vo.SplitContentDelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SplitContentAddVO;
import cn.people.controller.vo.SplitContentVO;
import cn.people.entity.SysUser;
import cn.people.mapper.SysUserMapper;
import cn.people.remote.SplitContentRemote;
import cn.people.service.ISplitContentService;

/** 
* @ClassName: SplitContentServiceImpl 
* @Description: 碎片内容实现类 
* @author shidandan
* @date 2019年1月16日 下午2:55:54 
*  
*/
@Service
public class SplitContentServiceImpl implements ISplitContentService
{
    @Autowired
    private SplitContentRemote splitContentRemote;
    
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 
    * Title: 查询模板碎片内容列表
    * @author shidandan
    * @date 2019年1月17日 下午7:29:09 
    * @Description: 查询模板碎片内容列表
    * @param modelSplitId 模板碎片ID
    * @param channelId 栏ID
    * @return 
    * @see cn.people.service.ISplitContentService#querySplitContentList(java.lang.String, java.lang.String)
     */
    @Override
    public List<SplitContentVO> querySplitContentList(String modelSplitLogicId, String channelId)
    {
        List<SplitContentVO> list= splitContentRemote.querySplitContentList(modelSplitLogicId, channelId).getData();
        
        if(CollectionUtils.isNotEmpty(list)) {
            Set<String> idList=list.stream().map(s -> {
                return s.getImporter();
            }).collect(Collectors.toSet());
            List<SysUser> userList=sysUserMapper.selectBatchIds(idList);
            Map<String,String> userMap=new HashMap<String,String>();
            if(!CollectionUtils.isEmpty(userList)) {
                userList.forEach(user ->{
                    userMap.put(user.getId(), user.getUsername());
                });
            }
            list.forEach(splitContent->{
                if(null!=userMap.get(splitContent.getImporter())) {
                    splitContent.setImporter(userMap.get(splitContent.getImporter()));
                }
            });
            
        }
        return list;
    }

    /**
    * Title: 查询模板碎片内容
    * @author shidandan
    * @date 2019年1月17日 下午7:28:48 
    * @Description: 查询模板碎片内容
    * @param id 模板碎片内容ID
    * @return 
    * @see cn.people.service.ISplitContentService#getSplitContent(java.lang.String) 
    */
    @Override
    public ResultVO<SplitContentVO> getSplitContent(String id)
    {
        return splitContentRemote.getSplitContent(id);
    }

    /**
    * Title: 删除模板碎片内容
    * @author shidandan
    * @date 2019年1月17日 下午7:28:48 
    * @Description: 删除模板碎片内容
    * @param id 模板碎片内容ID
    * @return 
    * @see cn.people.service.ISplitContentService#delSplitContent(java.lang.String) 
    */
    @Override
    public ResultVO<Boolean> delSplitContent(String id)
    {
        return splitContentRemote.delSplitContent(id);
    }

    /**
    * Title: 显示模板碎片内容
    * @author shidandan
    * @date 2019年1月17日 下午7:28:48 
    * @Description: 显示模板碎片内容
    * @param id 模板碎片内容ID
    * @return 
    * @see cn.people.service.ISplitContentService#showSplitContent(java.lang.String) 
    */
    @Override
    public ResultVO<Boolean> showSplitContent(String id)
    {
        return splitContentRemote.showSplitContent(id);
    }

    /**
    * Title: 隐藏模板碎片内容
    * @author shidandan
    * @date 2019年1月17日 下午7:28:48 
    * @Description: 隐藏模板碎片内容
    * @param id 模板碎片内容ID
    * @return 
    * @see cn.people.service.ISplitContentService#hideSplitContent(java.lang.String) 
    */
    @Override
    public ResultVO<Boolean> hideSplitContent(String id)
    {
        return splitContentRemote.hideSplitContent(id);
    }

    /**
    * Title: 更新模板碎片内容
    * @author shidandan
    * @date 2019年1月17日 下午7:28:48 
    * @Description: 更新模板碎片内容
    * @param id 模板碎片内容ID
    * @param splitContentVO
    * @return 
    * @see cn.people.service.ISplitContentService#updateSplitContent(java.lang.String, cn.people.controller.vo.SplitContentVO) 
    */
    @Override
    public ResultVO<Boolean> updateSplitContent(String id, SplitContentVO splitContentVO)
    {
        return splitContentRemote.updateSplitContent(id, splitContentVO);
    }

    /**
    * Title: 增加模板碎片内容
    * @author shidandan
    * @date 2019年1月17日 下午7:28:48 
    * @Description: 增加模板碎片内容
    * @param modelSpiltId 模板碎片ID
    * @param channelId 栏目ID
    * @param splitContentVO
    * @return 
    * @see cn.people.service.ISplitContentService#addSplitContent(java.lang.String, java.lang.String, cn.people.controller.vo.SplitContentAddVO) 
    */
    @Override
    public ResultVO<Boolean> addSplitContent(SplitContentAddVO splitContentVO)
    {
        return splitContentRemote.addSplitContent(splitContentVO);
    }

    /**
     *
     * @Title: 批量删除碎片内容 
     * @author guling
     * @date 2019年1月29日 10点31分
     * @Description: 批量删除碎片内容 
     * @param splitContentDelVO 模板碎片内容ID集合
     * @return 成功返回true
     * @throws Exception  参数说明 
     * @return ResultVO<Boolean>    返回类型 
     * @throws 
     */
    @Override public ResultVO<Boolean> delSplitContentByIds(SplitContentDelVO splitContentDelVO)
    {
        return splitContentRemote.delSplitContentByIds(splitContentDelVO);
    }

}

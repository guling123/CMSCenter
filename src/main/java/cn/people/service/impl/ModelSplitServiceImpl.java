/**   
* @Title: ModelSplitServiceImpl.java 
* @Package cn.people.service.impl 
* @Description: 模板碎片逻辑处理
* @author shidandan
* @date 2019年1月16日 下午3:23:49 
* @version V1.0   
*/
package cn.people.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import cn.people.commons.constants.CodeConstants;
import cn.people.controller.vo.*;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.people.entity.SysUser;
import cn.people.mapper.SysUserMapper;
import cn.people.remote.ModelSplitRemote;
import cn.people.service.IModelSplitService;

/** 
* @ClassName: ModelSplitServiceImpl 
* @Description: 模板碎片逻辑处理
* @author shidandan
* @date 2019年1月16日 下午3:23:49 
*  
*/
@Service
public class ModelSplitServiceImpl implements IModelSplitService
{
    @Autowired
    private ModelSplitRemote modelSplitRemote;
    
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     *
     * @Title: 模板碎片列表查询 
     * @author shidandan
     * @date 2018年12月5日 下午4:20:16 
     * @Description: 碎片列表查询
     * @param split 碎片列表查询
     * @param modelid 碎片id
     * @throws Exception  参数说明 
     * @return ResultVO<IPage<ModelSplit>>    返回结果集
     */
    @Override
    public ModelSplitPageVO getSplitPaged(SplitPageVO split, String modelid)
    {
      //将传入创建人转换为创建人id进行模糊查询
        if (!StringUtils.isEmpty(split.getCreaterName())) {
          QueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>();
          wrapper.like("realname", split.getCreaterName());
          List<SysUser> userList=sysUserMapper.selectList(wrapper);
          if(!CollectionUtils.isEmpty(userList)) {
              Set<String> userIds = userList.stream().map(user -> {return user.getId();}).collect(Collectors.toSet());
              split.setCreaterIds(userIds);
          }
      }
        
        ModelSplitPageVO pageResult=modelSplitRemote.getSplitPaged(split, modelid).getData();
        
        
        if(null!=pageResult && CollectionUtils.isNotEmpty(pageResult.getRecords())) {
            Set<String> idList=pageResult.getRecords().stream().map(s -> {return s.getCreateId();}).collect(Collectors.toSet());
            List<SysUser> userList=sysUserMapper.selectBatchIds(idList);
            Map<String,String> userMap=new HashMap<String,String>();
            if(!CollectionUtils.isEmpty(userList)) {
                userList.forEach(user ->{
                    userMap.put(user.getId(), user.getUsername());
                });
            }
            pageResult.getRecords().forEach(record->{
                if(null!=userMap.get(record.getCreateId())) {
                    record.setCreateName(userMap.get(record.getCreateId()));
                }
            });
            
        }
        return pageResult;
    }

    /**
     *
     * @Title: 创建碎片 
     * @author shidandan
     * @date 2018年12月19日 下午1:54:22 
     * @Description: 添加碎片
     * @param split split 创建碎片参数
     * @throws Exception  参数说明 
     * @return ResultVO<Boolean>    返回结果 
     * @throws 
     */
    @Override
    public ResultVO<Boolean> createModelSplit(SplitCreateVO split)
    {
        return modelSplitRemote.createModelSplit(split);
    }

    /**
     *
     * @Title: updateSplit 
     * @author shidandan
     * @date 2019年1月7日 下午7:50:20 
     * @Description: 修改碎片
     * @param  split 修改碎片参数
     * @param id 碎片id
     * @throws Exception  
     * @return ResultVO<Boolean>    返回结果
     */
    @Override
    public ResultVO<Boolean> updateSplit(SplitUpdateVO split,String id)
    {
        return modelSplitRemote.updateSplit(split, id);
    }

    /**
     *
     * @Title: 获取模板碎片详细信息 
     * @author shidandan
     * @date 2018年12月19日 下午2:23:55 
     * @Description: 获取模板碎片详细信息
     * @param id 碎片id
     * @throws Exception  参数说明 
     * @return ResultVO<SplitDetailVO>    返回类结果集
     * @throws 
     */
    @Override public ResultVO<ModelSplitDetailVO> getModelSplitDetail(String id)
    {
        return modelSplitRemote.getModelSplitDetail(id);
    }

    /**
     *
     * @Title: 删除模板碎片 
     * @author shidandan
     * @date 2019年1月7日 下午8:06:56 
     * @Description: 删除碎片 
     * @param  id 碎片id
     * @throws Exception  参数说明 
     * @return ResultVO<Boolean>    返回类型结果集 
     */
    @Override public ResultVO<Boolean> delModelSplit(String id)
    {
        return modelSplitRemote.delModelSplit(id);
    }

    /**
    * Title: getModelSplit
    * @author shidandan
    * @date 2019年1月22日 下午1:40:37 
    * @Description: 
    * @param modelid
    * @return 
    * @see cn.people.service.IModelSplitService#getModelSplit(java.lang.String) 
    */
    @Override
    public ResultVO<List<ModelSplit>> getModelSplit(String modelid)
    {
        ResultVO<List<ModelSplit>> result=modelSplitRemote.getSplit(modelid);
        
        if(result.getCode().equals(CodeConstants.RESULT_OK) && CollectionUtils.isNotEmpty(result.getData())) {
            result.getData().forEach(data ->{
                data.setSplitTag("{TAG_"+data.getLogicId()+"_TAG}");
            });
        }
        return result;
    }

}

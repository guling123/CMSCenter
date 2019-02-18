/**   
* @Title: ModelSplitPropServiceImpl.java 
* @Package cn.people.service.impl 
* @Description: 模板碎片属性实现类
* @author shidandan
* @date 2019年1月16日 下午3:41:52 
* @version V1.0   
*/
package cn.people.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import cn.people.controller.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import cn.people.entity.SysUser;
import cn.people.mapper.SysUserMapper;
import cn.people.remote.ModelSplitPropRemote;
import cn.people.service.IModelSplitPropService;

/** 
* @ClassName: ModelSplitPropServiceImpl 
* @Description: 模板碎片属性实现类
* @author shidandan
* @date 2019年1月16日 下午3:41:52 
*  
*/
@Service
public class ModelSplitPropServiceImpl implements IModelSplitPropService
{
    @Autowired
    private ModelSplitPropRemote modelSplitPropRemote;
    
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     *
     * @Title: 模板碎片属性列表查询 
     * @author shidandan
     * @date 2019年1月8日 上午10:43:55 
     * @Description: 模板碎片属性列表查询
     * @param @param modelSpiltId 模型碎片id
     * @throws Exception   
     * @return ResultVO<IPage<SplitProp>>    返回类结果集
     * @throws 
     */
    @Override
    public ModelSplitPropListParentVO getModelSplitPropList(String modelSpiltId)
    {

        ModelSplitPropListParentVO modelSplitPropListParentVO= modelSplitPropRemote.getModelSplitPropList(modelSpiltId).getData();

        if(null!=modelSplitPropListParentVO && 
            CollectionUtils.isNotEmpty(modelSplitPropListParentVO.getRecords())) {
            ArrayList<ModelSplitPropListVO> result = modelSplitPropListParentVO.getRecords();
            Set<String> idList=result.stream().map(s -> {
                return s.getCreateId();
            }).collect(Collectors.toSet());
            List<SysUser> userList=sysUserMapper.selectBatchIds(idList);
            Map<String,String> userMap=new HashMap<String,String>();
            if(!CollectionUtils.isEmpty(userList)) {
                userList.forEach(user ->{
                    userMap.put(user.getId(), user.getUsername());
                });
            }
            result.forEach(record->{
                if(null!=userMap.get(record.getCreateId())) {
                    record.setCreateName(userMap.get(record.getCreateId()));
                }
            });
            modelSplitPropListParentVO.setRecords(result);
        }
        return modelSplitPropListParentVO;
    }
    /**
     *
     * @Title: 添加新模板碎片属性 
     * @author shidandan
     * @date 2019年1月8日 上午9:54:27 
     * @Description: 添加新模板碎片属性
     * @param modelSpiltId 碎片id
     * @param createVO 模板碎片属性创建参数
     * @throws Exception  参数说明 
     * @return ResultVO<Boolean>    返回类型 
     */
    @Override
    public ResultVO<Boolean> createModelSplitProp(String modelSpiltId,
                                                            ModelSplitPropCreateVO createVO)
    {
        return modelSplitPropRemote.createModelSplitProp(modelSpiltId, createVO);
    }

    /**
     *
     * @Title: 修改模板碎片属性 
     * @author shidandan
     * @date 2019年1月8日 上午9:49:41 
     * @Description: 修改模板碎片属性 
     * @param updateVO 模板碎片属性修改参数
     * @param id 碎片id
     * @throws Exception  参数说明 
     * @return ResultVO<Boolean>    返回类型结果集 
     * @throws 
     */
    @Override
    public ResultVO<Boolean> updateModelSplitProp(ModelSplitPropUpdateVO updateVO,
                                                            String id)
    {
        return modelSplitPropRemote.updateModelSplitProp(updateVO, id);
    }

    /**
     *
     * @Title: 修改某栏目对应模板碎片属性值 
     * @author shidandan
     * @date 2019年1月8日 上午10:51:02 
     * @Description: 修改某栏目对应模板碎片属性值
     * @param updateVO 模板碎片属性修改参数
     * @param id 碎片id
     * @param  channelId 栏目id
     * @throws Exception  参数说明 
     * @return ResultVO<Boolean>    返回类结果集
     */
    @Override
    public ResultVO<Boolean> updateModelSplitPropByChannel(
        ModelSplitPropBatchUpdateVO updateVO)
    {
        return modelSplitPropRemote.updateModelSplitPropByChannel(updateVO);
    }

    /**
     *
     * @Title: 根据栏目查询模板碎片属性列表 
     * @author shidandan
     * @date 2019年1月8日 上午9:44:13 
     * @Description: 根据栏目查询模板碎片属性列表
     * @param  channelId 栏目id
     * @param  modelSpiltId 模型碎片id
     * @throws Exception  
     * @return ResultVO<List<SplitProp>>    返回类型结果集 
     */
    @Override public ResultVO<List<SplitPropListVO>> getModelSplitPropListByChannel(
        String channelId, String modelSpiltLogicId)
    {
        return modelSplitPropRemote.getModelSplitPropListByChannel(channelId, modelSpiltLogicId);
    }

    /**
     *
     * @Title: 删除模板碎片属性 
     * @author shidandan
     * @date 2019年1月8日 上午9:46:20 
     * @Description: 删除模板碎片属性
     * @param  id 模板id
     * @throws Exception  
     * @return ResultVO<Boolean>    返回类型结果集
     * @throws 
     */
    @Override public ResultVO<Boolean> delModelSplitProp(String id)
    {
        return modelSplitPropRemote.delModelSplitProp(id);
    }

}

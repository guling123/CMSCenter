package cn.people.service.impl;

import cn.people.controller.vo.Model;
import cn.people.controller.vo.ModelDetailVO;
import cn.people.controller.vo.ModelListRequestVO;
import cn.people.controller.vo.ModelVO;
import cn.people.controller.vo.ResultVO;
import cn.people.remote.ModelRemote;
import cn.people.service.IModelService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import cn.people.entity.SysUser;
import cn.people.mapper.SysUserMapper;
/**
 * <p>
 * 模板表 服务实现类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-19
 */
@Service
public class ModelServiceImpl implements IModelService {

    @Autowired
    private ModelRemote modelRemote;
    
    @Autowired
    private SysUserMapper sysUserMapper;
    
    /**
     * 
    * Title: 修改模板详细信息
    * @author shidandan
    * @date 2019年1月18日 下午1:55:28 
    * @Description: 修改模板详细信息
    * @param model 模板详细信息
    * @param id 模板id
    * @return 成功返回true
    * @see cn.people.service.IModelService#modelUpdate(cn.people.controller.vo.ModelVO, java.lang.String)
     */
    @Override
    public ResultVO<Boolean> modelUpdate(ModelVO model, String id)
    {
        return modelRemote.modelUpdate(model, id);
    }
    
    /**
     * 
    * Title: 添加新模板
    * @author shidandan
    * @date 2019年1月18日 下午1:53:16 
    * @Description: 添加新模板
    * @param modelVo 模板信息
    * @return 成功返回模板id
    * @see cn.people.service.IModelService#createModel(cn.people.controller.vo.ModelVO)
     */
    @Override
    public ResultVO<String> createModel(ModelVO modelVo)
    {
        return modelRemote.createModel(modelVo);
    }
    
    /**
     * 
    * Title: 获取模板详细信息 
    * @author shidandan
    * @date 2019年1月18日 下午1:52:45 
    * @Description: 获取模板详细信息  
    * @param id 模板id
    * @return 成功返回模板详细信息
    * @see cn.people.service.IModelService#getModel(java.lang.String)
     */
    @Override
    public ResultVO<ModelDetailVO> getModel(String id)
    {
        return modelRemote.getModel(id);
    }
    
    /**
     * 
    * Title: 查询模板列表
    * @author shidandan
    * @date 2019年1月18日 下午1:52:08 
    * @Description: 查询模板列表
    * @param modelListRequestVo 模板信息
    * @return 成功返回模板列表
    * @see cn.people.service.IModelService#getModelPaged(cn.people.controller.vo.ModelListRequestVO)
     */
    @Override
    public ResultVO<Page<Model>> getModelPaged(ModelListRequestVO modelListRequestVo)
    {
        //将传入创建人转换为创建人id进行模糊查询
        if (!StringUtils.isEmpty(modelListRequestVo.getCreateName())) {
          QueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>();
          wrapper.like("realname", modelListRequestVo.getCreateName());
          List<SysUser> userList=sysUserMapper.selectList(wrapper);
          if(!CollectionUtils.isEmpty(userList)) {
              Set<String> userIds = userList.stream().map(user -> {return user.getId();}).collect(Collectors.toSet());
              modelListRequestVo.setCreateIds(userIds);
          }
      }
        
        ResultVO<Page<Model>> pageModel =  modelRemote.getModelPaged(modelListRequestVo.getSiteid(),modelListRequestVo);
        
        //将从模板表查出的创建人id，与用户表交互。前台展示出创建人姓名
        if(null!=pageModel && CollectionUtils.isNotEmpty(pageModel.getData().getRecords())) {
            Set<String> idList=pageModel.getData().getRecords().stream().map(s ->{return s.getCreateId();}).collect(Collectors.toSet());
            List<SysUser> userList=sysUserMapper.selectBatchIds(idList);
            Map<String,String> userMap=new HashMap<String,String>();
            if(!CollectionUtils.isEmpty(userList)) {
                userList.forEach(user ->{
                    userMap.put(user.getId(), user.getUsername());
                });
            }
            pageModel.getData().getRecords().forEach(record->{
                if(null!=userMap.get(record.getCreateId())) {
                    record.setCreateName(userMap.get(record.getCreateId()));
                }
            });
        }

        return pageModel;
    }
    
    /**
     * 
    * Title: 启用模板
    * @author fanchengkui
    * @date 2019年1月18日 下午1:51:43 
    * @Description: 启用模板
    * @param id 模板id
    * @return 成功返回true
    * @see cn.people.service.IModelService#enabledModel(java.lang.String)
     */
	@Override
	@Transactional
	public Boolean enabledModel(String id) 
	{
		return modelRemote.enabledModel(id).getData();
	}
	
	/**
	 * 
	* Title: 禁用模板
	* @author fanchengkui
	* @date 2019年1月18日 下午1:51:07 
	* @Description: 禁用模板
	* @param id 模板id
	* @return 成功返回true
	* @see cn.people.service.IModelService#disableModel(java.lang.String)
	 */
	@Override
	@Transactional
	public Boolean disableModel(String id) 
	{
		return modelRemote.disableModel(id).getData();
	}
	
	/**
	 * 
	* Title: 删除模板
	* @author shidandan
	* @date 2019年1月18日 下午1:49:47 
	* @Description: 删除模板
	* @param id 模板id
	* @return 成功返回true
	* @throws Exception 
	* @see cn.people.service.IModelService#delModel(java.lang.String)
	 */
	@Override
	@Transactional
	public Boolean delModel(String id) throws Exception
	{
	    //调用contentService 删除模板
	    return modelRemote.delModel(id).getData();
	}

    /**
    * Title: getModel
    * @author shidandan
    * @date 2019年1月22日 下午7:12:21 
    * @Description: 
    * @param siteid
    * @param typeid
    * @return 
    * @see cn.people.service.IModelService#getModel(java.lang.String, java.lang.String) 
    */
    @Override
    public ResultVO<List<Model>> getModel(String siteid, String typeid)
    {
        return modelRemote.getModel(siteid, typeid);
    }

    
}

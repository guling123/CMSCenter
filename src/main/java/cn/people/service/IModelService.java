package cn.people.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.people.controller.vo.Model;
import cn.people.controller.vo.ModelDetailVO;
import cn.people.controller.vo.ModelListRequestVO;
import cn.people.controller.vo.ModelSplit;
import cn.people.controller.vo.ModelVO;
import cn.people.controller.vo.ResultVO;

/**
 * <p>
 * 模板表 服务类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-19
 */
public interface IModelService{
    
    /**
     * 
    * @Title: 修改模板详细信息
    * @author shidandan
    * @date 2019年1月18日 下午1:33:19 
    * @Description: 修改模板详细信息
    * @param model 模板详细信息
    * @param id 模板id
    * @return 成功返回true
    * @return Boolean    返回类型 
    * @throws 
     */
    ResultVO<Boolean> modelUpdate(ModelVO model, String id);
    
    /**
     * 
    * @Title: 添加新模板
    * @author shidandan
    * @date 2019年1月18日 下午1:37:06 
    * @Description: 添加新模板 
    * @param modelVo 模板信息
    * @return  成功返回模板id
    * @return ResultVO<String>    返回类型 
    * @throws 
     */
    ResultVO<String> createModel(ModelVO modelVo);
    
    /**
     * 
    * @Title: 获取模板详细信息 
    * @author shidandan
    * @date 2019年1月18日 下午1:39:02 
    * @Description: 获取模板详细信息 
    * @param id 模板id
    * @return 成功返回模板详细信息
    * @return ResultVO<ModelVO>    返回类型 
    * @throws 
     */
    ResultVO<ModelDetailVO> getModel(String id);
    
    /**
     * 
    * @Title: 查询模板列表 
    * @author shidandan
    * @date 2019年1月18日 下午1:40:06 
    * @Description: 查询模板列表 
    * @param modelListRequestVo 模板信息
    * @return 成功返回模板列表
    * @return ResultVO<Page<Model>>    返回类型 
    * @throws 
     */
    ResultVO<Page<Model>> getModelPaged(ModelListRequestVO modelListRequestVo);
    
    /**
     *
    * @Title: 查询某个站点下某种类型的模板 
    * @author shidandan
    * @date 2019年1月22日 下午7:11:44 
    * @Description: 查询某个站点下某种类型的模板
    * @param siteid 站点ID
    * @param typeid 类型ID
    * @return  参数说明 
    * @return ResultVO<List<Model>>    返回类型 
    * @throws 
     */
    ResultVO<List<Model>> getModel(String siteid,String typeid);
    /**
     * 
    * @Title: 启用模板
    * @author fanchengkui
    * @date 2019年1月18日 下午1:41:20 
    * @Description: 启用模板
    * @param id 模板id
    * @return 成功返回true
    * @return Boolean    返回类型 
    * @throws 
     */
    Boolean enabledModel(String id);
    
    /**
     * 
    * @Title: 禁用模板
    * @author fanchengkui
    * @date 2019年1月18日 下午1:41:20 
    * @Description: 禁用模板
    * @param id 模板id
    * @return 成功返回true
    * @return Boolean    返回类型 
    * @throws 
     */
    Boolean disableModel(String id);
    
    /**
     * 
    * @Title: 删除模板
    * @author shidandan
    * @date 2019年1月18日 下午1:42:49 
    * @Description: 删除模板
    * @param id 模板id
    * @return 成功返回true
    * @throws Exception  参数说明 
    * @return Boolean    返回类型 
    * @throws 
     */
    Boolean delModel(String id) throws Exception;

    
}

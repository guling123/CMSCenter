/**   
* @Title: IModelSplitPropService.java 
* @Package cn.people.service 
* @Description: 模板碎片属性接口
* @author shidandan
* @date 2019年1月16日 下午3:41:21 
* @version V1.0   
*/
package cn.people.service;

import java.util.List;

import cn.people.controller.vo.*;


/** 
* @ClassName: IModelSplitPropService 
* @Description: 模板碎片属性接口
* @author shidandan
* @date 2019年1月16日 下午3:41:21 
*  
*/
public interface IModelSplitPropService
{
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
    ModelSplitPropListParentVO getModelSplitPropList(String modelSpiltId);

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
    ResultVO<Boolean> createModelSplitProp(String modelSpiltId, ModelSplitPropCreateVO createVO);

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
    ResultVO<Boolean> updateModelSplitProp(ModelSplitPropUpdateVO updateVO, String id);

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
    ResultVO<Boolean> updateModelSplitPropByChannel(ModelSplitPropBatchUpdateVO updateVO);

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
    ResultVO<List<SplitPropListVO>> getModelSplitPropListByChannel(String channelId, String modelSpiltLogicId);

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
    ResultVO<Boolean> delModelSplitProp(String id);
}

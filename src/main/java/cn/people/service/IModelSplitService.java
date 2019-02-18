/**   
* @Title: IModelSplitService.java 
* @Package cn.people.service 
* @Description: 模板碎片逻辑处理接口
* @author shidandan
* @date 2019年1月16日 下午3:23:29 
* @version V1.0   
*/
package cn.people.service;

import cn.people.controller.vo.*;

import java.util.List;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/** 
* @ClassName: IModelSplitService 
* @Description: 模板碎片逻辑处理接口 
* @author shidandan
* @date 2019年1月16日 下午3:23:29 
*  
*/
public interface IModelSplitService
{
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
    ModelSplitPageVO getSplitPaged(SplitPageVO split,String modelid);

    /**
     * 
    * @Title: 查询模板下所有的碎片 
    * @author shidandan
    * @date 2019年1月22日 下午1:39:55 
    * @Description: 查询模板下所有的碎片 
    * @param modelid 模板ID
    * @return  参数说明 
    * @return ResultVO<List<ModelSplit>>    返回类型 
    * @throws 
     */
    ResultVO<List<ModelSplit>> getModelSplit(String modelid);
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
    ResultVO<Boolean> createModelSplit(SplitCreateVO split);

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
    ResultVO<Boolean> updateSplit(SplitUpdateVO split, String id);

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
    ResultVO<ModelSplitDetailVO> getModelSplitDetail(String id);


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
    ResultVO<Boolean> delModelSplit(String id);
}

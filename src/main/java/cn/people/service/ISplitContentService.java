/**   
* @Title: ISplitContentService.java 
* @Package cn.people.service 
* @Description: 碎片内容接口 
* @author shidandan
* @date 2019年1月16日 下午2:55:21 
* @version V1.0   
*/
package cn.people.service;

import java.util.List;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SplitContentAddVO;
import cn.people.controller.vo.SplitContentDelVO;
import cn.people.controller.vo.SplitContentVO;

/** 
* @ClassName: ISplitContentService 
* @Description: 碎片内容接口
* @author shidandan
* @date 2019年1月16日 下午2:55:21 
*  
*/
public interface ISplitContentService
{
    /**
     * 
    * @Title: 查询模板碎片内容列表 
    * @author shidandan
    * @date 2019年1月16日 下午2:57:12 
    * @Description: 查询碎片内容集合
    * @param @param modelSplitId 模板碎片ID
    * @param @param channelId 栏目ID
    * @param @return  参数说明 
    * @return List<SplitContentVO>    返回类型 
    * @throws 
     */
    List<SplitContentVO> querySplitContentList(String modelSplitId,String channelId);
    
    /**
     * 
    * @Title: 查询模板碎片内容详情 
    * @author shidandan
    * @date 2019年1月17日 下午7:23:15 
    * @Description: 查询模板碎片内容详情
    * @param id 模板碎片内容ID 
    * @return  参数说明 
    * @return ResultVO<SplitContentVO>    返回类型 
    * @throws 
     */
    ResultVO<SplitContentVO> getSplitContent(String id);
    /**
     * 
    * @Title: 删除模板碎片内容 
    * @author shidandan
    * @date 2019年1月17日 下午7:24:54 
    * @Description: 删除模板碎片内容
    * @param id 模板碎片内容ID
    * @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    ResultVO<Boolean> delSplitContent(String id);
    /**
     * 
    * @Title: 显示模板碎片内容 
    * @author shidandan
    * @date 2019年1月17日 下午7:26:39 
    * @Description: 显示模板碎片内容
    * @param id 模板碎片内容ID
    * @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    ResultVO<Boolean> showSplitContent(String id);
    /**
     * 
    * @Title: 隐藏模板碎片内容
    * @author shidandan
    * @date 2019年1月17日 下午7:27:04 
    * @Description: 隐藏模板碎片内容
    * @param id 模板碎片内容ID
    * @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    ResultVO<Boolean> hideSplitContent(String id);
    /**
     * 
    * @Title: 更新模板碎片内容 
    * @author shidandan
    * @date 2019年1月17日 下午7:27:31 
    * @Description: 更新模板碎片内容 
    * @param id 模板碎片内容ID
    * @param splitContentVO
    * @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    ResultVO<Boolean> updateSplitContent(String id,SplitContentVO splitContentVO);
    
    /**
     * 
    * @Title: 增加模板碎片内容 
    * @author shidandan
    * @date 2019年1月17日 下午7:28:00 
    * @Description: 增加模板碎片内容 
    * @param modelSpiltId 模板碎片ID
    * @param channelId 栏目ID
    * @param splitContentVO 模板碎片内容信息
    * @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    ResultVO<Boolean> addSplitContent(SplitContentAddVO splitContentVO);

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
    ResultVO<Boolean> delSplitContentByIds(SplitContentDelVO splitContentDelVO);
}

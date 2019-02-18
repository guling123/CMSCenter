package cn.people.service;

import java.util.List;

import cn.people.controller.vo.ModelSplitMapResponseVO;
import cn.people.controller.vo.ResultVO;

/**
 * 
* @ClassName: IViewService 
* @Description: 预览接口
* @author zhangchengchun
* @date 2019年1月18日 上午9:57:49 
*  
 */
public interface IViewService
{

    /**
     * 
    * @Title: 询栏目的模板原内容  
    * @author zhangchengchun
    * @date 2019年1月17日 下午1:38:26 
    * @Description: 询栏目的模板原内容
    * @param logicId 栏目逻辑id
    * @param @return  参数说明 
    * @return String 栏目内容
    * @throws 
     */
    ResultVO<String> getChannelTemplateMod(Integer logicId);

    /**
     * 
    * @Title: 预览栏目的模板
    * @author zhangchengchun
    * @date 2019年1月17日 下午1:40:20 
    * @Description: 预览栏目的模板
    * @param logicId 栏目逻辑id
    * @param pageNo 当前页码，可以不传
    * @param info 调试信息，支持值：info|debug
    * @param vtype 预览类型，预览时不传，静态化时传publish
    * @param  参数说明 
    * @return String    返回类型 
    * @throws 
     */
    ResultVO<String> getChannelTemplate(Integer logicId, Integer pageNo, String info,
                                        String vtype);

    /**
     * 
    * @Title: 预览稿件的模板 
    * @author zhangchengchun
    * @date 2019年1月17日 下午1:43:03 
    * @Description: 预览稿件的模板 
    * @param contentId 稿件的id
    * @param pageNo 当前页码，可以不传
    * @param info 调试信息，支持值：info|debug
    * @param vtype 预览类型，预览时不传，静态化时传publish
    * @return String    返回类型 
    * @throws 
     */
    ResultVO<String> getContentTemplate(Integer contentLogicId, Integer pageNo, String info,
                                        String vtype);

    /**
     * 
    * @Title: 查询栏目的模板中的标记集合
    * @author zhangchengchun
    * @date 2019年1月17日 下午1:39:35 
    * @Description: 查询栏目的模板中的标记集合
    * @param logicId 栏目逻辑id
    * @param @return  参数说明 
    * @return List<ModelSplitMapResponseVO>    返回类型 
    * @throws 
     */
    ResultVO<List<ModelSplitMapResponseVO>> getChannelTemplateSplits(Integer logicId);

}

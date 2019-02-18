/**   
* @Title: IChannelService.java 
* @Package cn.people.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2019年1月17日 下午4:57:26 
* @version V1.0   
*/
package cn.people.service;
import cn.people.controller.vo.*;

import java.util.List;


/** 
* @ClassName: IModelTypeService 
* @Description: 模型种类接口 
* @author guling
* @date 2019年1月21日 10点11分
*  
*/
public interface IModelTypeService
{
    /**
     *
     * @Title: 根据站点查询栏目信息 
     * @author shidandan
     * @date 2019年1月17日 下午5:00:46 
     * @Description: 根据站点查询栏目树
     * @param siteid 站点ID
     * @param orgid  租户ID
     * @return  参数说明 
     * @return ChannelTreeVO    返回类型 
     * @throws 
     */
    ResultVO<List<ModelTypeVO>> getModelTypeListBySiteId(String siteId);



}

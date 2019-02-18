/**   
* @Title: IChannelService.java 
* @Package cn.people.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2019年1月17日 下午4:57:26 
* @version V1.0   
*/
package cn.people.service;
import org.springframework.web.bind.annotation.PathVariable;

import cn.people.controller.vo.*;


/** 
* @ClassName: IChannelService 
* @Description: 栏目接口 
* @author shidandan
* @date 2019年1月17日 下午4:57:26 
*  
*/
public interface IChannelService
{
    /**
     * 
    * @Title: 根据权限和站点查询栏目信息 
    * @author shidandan
    * @date 2019年1月17日 下午5:00:46 
    * @Description: 根据权限和站点查询栏目信息
    * @param siteid 站点ID
    * @param orgid  租户ID
    * @param userid 用户ID
    * @return  参数说明 
    * @return ChannelTreeVO    返回类型 
    * @throws 
     */
    ResultVO<ChannelListVO> getChannelByPermissionSite(String siteid, String orgid,String userid);
    
    /**
     * 
    * @Title: 按照站点查询栏目信息 
    * @author shidandan
    * @date 2019年2月2日 上午10:47:45 
    * @Description: 按照站点查询栏目信息 
    * @param siteid 站点ID
    * @param orgid 租户ID
    * @return  参数说明 
    * @return ResultVO<ChannelListVO>    返回类型 
    * @throws 
     */
    ResultVO<ChannelListVO> getChannelBySite(String siteid, String orgid);
    /**
     * 
    * @Title: 创建子栏目 
    * @author shidandan
    * @date 2019年1月17日 下午5:01:16 
    * @Description: 创建子栏目
    * @param channelCreateVO 子栏目信息
    * @return  参数说明 
    * @return Boolean    返回类型 
    * @throws 
     */
    ResultVO<Boolean> createChannel(ChannelCreateRemoteVO channelCreateVO);
    /**
     * 
    * @Title: 查询栏目详情 
    * @author shidandan
    * @date 2019年1月17日 下午5:01:48 
    * @Description: 查询栏目详情
    * @param id 栏目ID
    * @return  参数说明 
    * @return ChannelDetailVO    返回类型 
    * @throws 
     */
    ResultVO<ChannelDetailVO> getChannel(String id);
    /**
     * 
    * @Title: 更新栏目信息 
    * @author shidandan
    * @date 2019年1月17日 下午5:02:09 
    * @Description: 更新栏目信息
    * @param channel 栏目信息
    * @param id 栏目ID
    * @return  参数说明 
    * @return Boolean    返回类型 
    * @throws 
     */
    ResultVO<Boolean> updateChannel(ChannelCreateVO channel,String id);
    /**
     * 
    * @Title: 删除栏目 
    * @author shidandan
    * @date 2019年1月17日 下午5:02:35 
    * @Description: 删除栏目
    * @param id 栏目ID
    * @return  参数说明 
    * @return Boolean    返回类型 
    * @throws 
     */
    ResultVO<Boolean> delChannel(String id);
    
    /**
     * 
    * @Title: 栏目下线
    * @author fanchengkui
    * @date 2019年1月25日 上午11:29:29 
    * @Description: 栏目下线
    * @param 栏目下线资源入参对象
    * @return  成功返回true
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    ResultVO<Boolean> offlineChannel(PublishChanneRequest publishChanneRequest);
    
    /**
     * 
    * @Title: 栏目发布 
    * @author fanchengkui
    * @date 2019年1月25日 下午1:32:31 
    * @Description: 栏目发布 
    * @param publishChanneRequest 栏目发布资源入参对象
    * @param userId 当前登录用户id
    * @return  成功返回true
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    ResultVO<Boolean> publishChannel(PublishChanneRequest publishChanneRequest,String userId);
}

/**   
* @Title: IUserChannelService.java 
* @Package cn.people.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2019年1月28日 下午2:09:18 
* @version V1.0   
*/
package cn.people.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SysUserChannelVO;
import cn.people.controller.vo.UserChannelListResultVO;
import cn.people.controller.vo.UserChannelVO;
import cn.people.entity.SysUserChannel;

/** 
* @ClassName: IUserChannelService 
* @Description: 用户常用栏目接口 
* @author shidandan
* @date 2019年1月28日 下午2:09:18 
*  
*/
public interface IUserChannelService
{
    /**
     * 
    * @Title: 新增常用栏目 
    * @author shidandan
    * @date 2019年1月28日 下午2:11:08 
    * @Description: 新增常用栏目 
    * @param createVO
    * @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    ResultVO<Boolean> createSysUserChannel(UserChannelVO createVO);
    
    /**
     * 
    * @Title: 删除用户常用栏目 
    * @author shidandan
    * @date 2019年1月28日 下午2:11:37 
    * @Description: 删除用户常用栏目 
    * @param id
    * @return  参数说明 
    * @return ResultVO<Boolean>    返回类型 
    * @throws 
     */
    ResultVO<Boolean> delSysUserChannel(String id);
    /**
     * 
    * @Title: 查询用户常用栏目 
    * @author shidandan
    * @date 2019年1月28日 下午2:11:24 
    * @Description: 查询用户常用栏目
    * @param userId 用户ID
    * @return  参数说明 
    * @return ResultVO<List<SysUserChannelVO>>    返回类型 
    * @throws 
     */
    ResultVO<List<UserChannelListResultVO>> getSysUserChannel(String userId);

}

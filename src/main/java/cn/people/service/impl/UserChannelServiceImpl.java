/**   
* @Title: UserChannelServiceImpl.java 
* @Package cn.people.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2019年1月28日 下午2:09:52 
* @version V1.0   
*/
package cn.people.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SysUserChannelVO;
import cn.people.controller.vo.UserChannelListResultVO;
import cn.people.controller.vo.UserChannelVO;
import cn.people.entity.SysUserChannel;
import cn.people.remote.UserChannelRemote;
import cn.people.service.IUserChannelService;

/** 
* @ClassName: UserChannelServiceImpl 
* @Description: 用户常用栏目实现类 
* @author shidandan
* @date 2019年1月28日 下午2:09:52 
*  
*/
@Service
public class UserChannelServiceImpl implements IUserChannelService
{

    @Autowired
    private UserChannelRemote userChannelRemote;
    /**
    * Title: createSysUserChannel
    * @author shidandan
    * @date 2019年1月28日 下午2:12:10 
    * @Description: 
    * @param createVO
    * @return 
    * @see cn.people.service.IUserChannelService#createSysUserChannel(cn.people.entity.SysUserChannel) 
    */
    @Override
    public ResultVO<Boolean> createSysUserChannel(UserChannelVO createVO)
    {
        return userChannelRemote.createSysUserChannel(createVO);
    }

    /**
    * Title: delSysUserChannel
    * @author shidandan
    * @date 2019年1月28日 下午2:12:10 
    * @Description: 
    * @param id
    * @return 
    * @see cn.people.service.IUserChannelService#delSysUserChannel(java.lang.String) 
    */
    @Override
    public ResultVO<Boolean> delSysUserChannel(String id)
    {
        return userChannelRemote.delSysUserChannel(id);
    }

    /**
    * Title: getSysUserChannel
    * @author shidandan
    * @date 2019年1月28日 下午2:12:10 
    * @Description: 
    * @param userId
    * @return 
    * @see cn.people.service.IUserChannelService#getSysUserChannel(java.lang.String) 
    */
    @Override
    public ResultVO<List<UserChannelListResultVO>> getSysUserChannel(String userId)
    {
        return userChannelRemote.getSysUserChannel(userId);
    }

}

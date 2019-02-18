package cn.people.service;

import cn.people.controller.vo.SysUserChannelListVO;
import cn.people.controller.vo.SysUserChannelVO;
import cn.people.entity.SysUserChannel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 管理员账户组表 服务类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-17
 */
public interface ISysUserChannelService extends IService<SysUserChannel> {

    /**
     * 
    * @Title: getSysUserByOrgid 
    * @author shidandan
    * @date 2018年12月17日 下午7:24:33 
    * @Description: 查询某账户组下的人员信息
    * @param @param groupid
    * @param @return  参数说明 
    * @return List<SysUserVO>    返回类型 
    * @throws 
     */
    SysUserChannelListVO getSysUserByOrgid(String groupid,String orgid);
    
    /**
     * 
    * @Title: createSysUserChannel 
    * @author shidandan
    * @date 2018年12月17日 下午7:35:42 
    * @Description: 创建账户组人员信息
    * @param @param createVO
    * @param @return  参数说明 
    * @return Boolean    返回类型 
     * @throws Exception 
    * @throws 
     */
    Boolean updateUsers(SysUserChannelVO createVO,String id) throws Exception;
}

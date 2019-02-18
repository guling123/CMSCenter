package cn.people.service;

import cn.people.controller.vo.SysGroupCreateVO;
import cn.people.controller.vo.SysGroupDetailVO;
import cn.people.controller.vo.SysGroupUpdateVO;
import cn.people.entity.SysGroup;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 管理账户组表 服务类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-13
 */
public interface ISysGroupService extends IService<SysGroup> {

    /**
     * 
    * @Title: getSysGroup 
    * @author shidandan
    * @date 2018年12月17日 下午4:46:06 
    * @Description: 查询某站点下账户组的信息 
    * @param @param siteid
    * @param @param orgid
    * @param @return  参数说明 
    * @return List<SysGroup>    返回类型 
     * @throws Exception 
    * @throws 
     */
    List<SysGroup> getSysGroupList(String siteid,String orgid) throws Exception;
    
    /**
     * 
    * @Title: createSysGroup 
    * @author shidandan
    * @date 2018年12月17日 下午5:13:13 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param sysGroup
    * @param @return  参数说明 
    * @return Boolean    返回类型 
     * @throws Exception 
    * @throws 
     */
    Boolean createSysGroup(SysGroupCreateVO sysGroup,String createrid) throws Exception;
    
    /**
     * 
    * @Title: updateSysGroup 
    * @author shidandan
    * @date 2018年12月17日 下午5:53:06 
    * @Description: 更新账户组信息
    * @param @param sysGroup
    * @param @return  参数说明 
    * @return Boolean    返回类型 
     * @throws Exception 
    * @throws 
     */
    Boolean updateSysGroup(SysGroupUpdateVO sysGroup,String id) throws Exception;
    
    /**
     * 
    * @Title: getSysGroup 
    * @author shidandan
    * @date 2018年12月17日 下午5:24:41 
    * @Description: 查询账户组详情
    * @param @param id
    * @param @return  参数说明 
    * @return SysGroupDetailVO    返回类型 
     * @throws Exception 
    * @throws 
     */
    SysGroupDetailVO getSysGroup(String id,String orgid) throws Exception;
    
    /**
     * 
    * @Title: delSysGroup 
    * @author shidandan
    * @date 2018年12月18日 上午11:03:46 
    * @Description: 删除账户组
    * @param @param id
    * @param @return
    * @param @throws Exception  参数说明 
    * @return Boolean    返回类型 
    * @throws 
     */
    Boolean delSysGroup(String id) throws Exception;
}

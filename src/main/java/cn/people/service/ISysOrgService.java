package cn.people.service;

import cn.people.controller.vo.*;
import cn.people.entity.SysOrg;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 租户表 服务类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
public interface ISysOrgService extends IService<SysOrg> {

	public static final String SYSTEM_ORG = "0";	// 系统用户
    /**
     * 
    * @Title: createSysOrg 
    * @author shidandan
    * @date 2018年12月13日 下午5:51:24 
    * @Description: 新增租户
    * @param @param createVO
    * @param @return  参数说明 
    * @return Boolean    返回类型 
     * @throws Exception 
    * @throws 
     */
    Boolean createSysOrg(SysOrgCreateVO createVO,String createrid) throws Exception;
    
    /**
     * 
    * @Title: getSysOrg 
    * @author shidandan
    * @date 2018年12月13日 下午6:02:41 
    * @Description: 获取租户详情
    * @param @param id
    * @param @return  参数说明 
    * @return SysOrgUpdateVO    返回类型 
    * @throws 
     */
    SysOrgUpdateVO getSysOrg(String id);
    
    /**
     * 
    * @Title: updateSysOrg 
    * @author shidandan
    * @date 2018年12月13日 下午6:05:27 
    * @Description: 更新租户信息
    * @param @param updateVO
    * @param @return  参数说明 
    * @return Boolean    返回类型 
     * @throws Exception 
    * @throws 
     */
    Boolean updateSysOrg(SysOrgUpdateVO updateVO) throws Exception;
    
    /**
     * 
    * @Title: updateSysOrgStatus 
    * @author shidandan
    * @date 2018年12月14日 下午3:17:33 
    * @Description: 启用或禁用租户
    * @param @param id
    * @param @param status 1 启用  0 禁用
    * @param @return
    * @param @throws Exception  参数说明 
    * @return Boolean    返回类型 
    * @throws 
     */
    Boolean updateSysOrgStatus(String id,String status) throws Exception;
    
    /**
     * 
    * @Title: getSysOrgPaged 
    * @author shidandan
    * @date 2018年12月13日 下午6:16:24 
    * @Description: 分页查询租户信息 
    * @param @param listVO
    * @param @return  参数说明 
    * @return IPage<SysOrg>    返回类型 
    * @throws 
     */
    IPage<SysOrgListResultVO> getSysOrgPaged(SysOrgListVO listVO);

    /**
     * @author guling
     * @Title   获取超管详细信息
     * @Date    2019/2/1 9:30
     * @param   [orgid]  租户id
     * @return  cn.people.controller.vo.SysOrgdetailVO
     * @throws
     * @Description 获取超管详细信息
    */
    SysOrgdetailVO getSysOrgAdminDetail(String orgid) throws Exception;
}

package cn.people.service;

import cn.people.controller.vo.SysPermissionTreeVO;
import cn.people.entity.SysPermission;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 管理权限表 服务类
 * </p>
 *
 * @author fuqiang
 * @since 2018-12-17
 */
public interface ISysPermissionService extends IService<SysPermission> {

    List<SysPermission> queryPermissoinByUserName(String username);
    
    /**
     * 
    * @Title: 查询权限树
    * @author shidandan
    * @date 2019年1月18日 下午6:16:46 
    * @Description: 查询权限树 
    * @return  参数说明 
    * @return SysPermissionTreeVO    返回类型 
    * @throws 
     */
    SysPermissionTreeVO roleTree(String username);
}

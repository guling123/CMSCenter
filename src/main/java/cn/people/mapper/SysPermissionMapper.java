package cn.people.mapper;

import cn.people.entity.SysPermission;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 管理权限表 Mapper 接口
 * </p>
 *
 * @author fuqiang
 * @since 2018-12-17
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    @Select("SELECT b.* FROM cms.tb_sys_role_permission  a left join tb_sys_permission b on a.permissionid=b.id left join tb_sys_user c on a.roleid=c.roleid where c.username=#{username}")
    List<SysPermission> queryPermissoinByUserName(String username);
    
    @Select("SELECT b.* FROM cms.tb_sys_role_permission  a left join tb_sys_permission b on a.permissionid=b.id left join tb_sys_user c on a.roleid=c.roleid where c.username=#{username} and b.menu_flg='1'")
    List<SysPermission> queryMeunPermissoinByUserName(String username);
}

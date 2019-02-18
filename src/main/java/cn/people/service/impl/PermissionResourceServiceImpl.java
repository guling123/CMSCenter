package cn.people.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.people.controller.vo.SysPermissionMenuVO;
import cn.people.controller.vo.SysPermissionTreeVO;
import cn.people.controller.vo.SysResourceRuleVo;
import cn.people.entity.PermissionResource;
import cn.people.entity.SysPermission;
import cn.people.entity.SysResource;
import cn.people.mapper.PermissionResourceMapper;
import cn.people.mapper.SysResourceMapper;
import cn.people.service.IPermissionResourceService;
import cn.people.service.ISysPermissionService;
import cn.people.service.ISysResourceService;

/**
 * <p>
 * 权限资源关系表 服务实现类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@Service
public class PermissionResourceServiceImpl extends ServiceImpl<PermissionResourceMapper, PermissionResource> implements IPermissionResourceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysResourceServiceImpl.class);
    
    @Autowired
    private ISysPermissionService permissionService;
    
    @Autowired
    private ISysResourceService resourceService;
    
    @Autowired
    private SysResourceMapper sysResourceMapper;
    
    @Autowired
    private PermissionResourceMapper permissionResourceMapper;
    
    /**
     * 
    * @Title: getUserResource 
    * @author fuqiang
    * @date 2018年12月18日 下午5:38:36 
    * @Description: 获取用户可以访问的资源
    * @param @param userId
    * @param @return  参数说明 
    * @return UserResourceVo    返回类型 
    * @throws 
     */
    @Override
    public SysResourceRuleVo getSysResourceRule()
    {
        SysResourceRuleVo result=new SysResourceRuleVo();
        try
        {
        	// 先获取权限资源关联表数据
            List<PermissionResource> permissionResourceList= this.list();
            
            // 获取权限表数据，并以map{权限id:权限ident}结构保存
            List<SysPermission> permissionList =permissionService.list();
            Map<String, String> permissionMap=new HashMap<>();
            for(SysPermission s:permissionList) {
                permissionMap.put(s.getId(), s.getIdent());
            }
            
            // 获取资源表数据，并以map{资源id:资源url}结构保存(url符合spring security match表达式)
            List<SysResource> resourceList =resourceService.list();
            Map<String, String> resourceMap=new HashMap<>();
            for(SysResource r:resourceList) {
                resourceMap.put(r.getId(), r.getResouceuri());
            }
            
            // 组装返回map{资源url:[权限ident...]}
            Map<String,List<String>> map=new HashMap<>();
            for(PermissionResource p:permissionResourceList) {
                
                // 资源url(url符合spring security match表达式)
                String resouceuri=resourceMap.get(p.getResourceid());
                if(resouceuri != null) {

                    String permissionId=p.getPermissionid();
                    if(permissionId==null) {
                    	// 未设置权限
                        LOGGER.warn("getPermissionid==null ,ignore "+p.getId());
                        continue;                    
                    }
                    
                    // 权限ident （*:允许任何人访问）
                    String permissionIdent = PERMIT_ALL;
                    if(!PERMIT_ALL.equals(permissionIdent)) {
                    	// 该资源分配给某些权限时（*:允许任何人访问）
                    	if(permissionMap.containsKey(p.getPermissionid())) {
                    		permissionIdent=permissionMap.get(p.getPermissionid());
                    	}
                    }
                    
                	// 按权限资源url分组
                    if(!map.containsKey(resouceuri)) {
                        map.put(resouceuri, new ArrayList<>());
                    }
                    if(PERMIT_ALL.equals(permissionIdent)) {
                    	// 如果包含*，则其他设置无效
                    	map.get(resouceuri).clear();
                    }
                    map.get(resouceuri).add(permissionIdent); 
                }
            }
            
            result.setResourceMap(map);
            LOGGER.info("getSysResourceRule="+JSON.toJSONString(result));
            
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage(),e);
        }
        return result;
    }

    /**
    * Title: 查询权限信息
    * @author shidandan
    * @date 2019年1月18日 下午4:38:38 
    * @Description: 查询权限信息（登录时使用）
    * @return 
    * @see cn.people.service.IPermissionResourceService#getPermissionMenuTree() 
    */
    @Override
    public SysPermissionMenuVO getPermissionMenu(String username)
    {
        SysPermissionMenuVO result=new SysPermissionMenuVO();
        SysPermissionTreeVO sysPermissionTreeVO=permissionService.roleTree(username);
        
        if(null==sysPermissionTreeVO) {
            return null;
        }
        result.setMenuTree(sysPermissionTreeVO);
        List<SysPermission> permissionList=permissionService.queryPermissoinByUserName(username);
        
        if(CollectionUtils.isNotEmpty(permissionList)) {
            List<String> permissionIdents=permissionList.stream().map(p->{return p.getIdent();}).collect(Collectors.toList());
            result.setPermissions(permissionIdents);
        }
        return result;
    }
}

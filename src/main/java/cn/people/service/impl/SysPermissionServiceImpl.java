package cn.people.service.impl;

import cn.people.controller.SysRoleController;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SysPermissionTreeVO;
import cn.people.entity.SysPermission;
import cn.people.mapper.SysPermissionMapper;
import cn.people.service.ISysPermissionService;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.netflix.discovery.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理权限表 服务实现类
 * </p>
 *
 * @author fuqiang
 * @since 2018-12-17
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysPermissionServiceImpl.class);

    private static final String FIRST_LEVEL_MENU = "0";
    
    @Autowired
    SysPermissionMapper sysPermissionMapper;
    
    @Override
    public List<SysPermission> queryPermissoinByUserName(String username)
    {
        return sysPermissionMapper.queryPermissoinByUserName(username);
    }

    /**
    * Title: roleTree
    * @author shidandan
    * @date 2019年1月18日 下午6:17:19 
    * @Description: 
    * @param username
    * @return 
    * @see cn.people.service.ISysPermissionService#roleTree(java.lang.String) 
    */
    @Override
    public SysPermissionTreeVO roleTree(String username)
    {
        SysPermissionTreeVO result= new SysPermissionTreeVO();
        try
        {
            SysPermission permission=new SysPermission();
            List<SysPermission> userList=new ArrayList<SysPermission>();
            if(StringUtils.isNotBlank(username)) {
                userList= sysPermissionMapper.queryMeunPermissoinByUserName(username);
            }else {
                QueryWrapper<SysPermission> queryUserWrapper = new QueryWrapper<>(permission);
                queryUserWrapper.eq("menu_flg", 1);
                userList= this.list(queryUserWrapper);
            }
            Map<String, List<SysPermissionTreeVO>> map=new HashMap<>();
            for(SysPermission s:userList) {
                map.put(s.getId(), new ArrayList<>());
                if(s.getParentId().equals(FIRST_LEVEL_MENU)) {
                    //1级菜单
                    SysPermissionTreeVO v=new SysPermissionTreeVO();
                    BeanUtils.copyProperties(s, v);
                    result.getSubList().add(v);
                }
            }
            
            result.setSubList(getSortedList(result.getSubList()));
            
            for(SysPermission s:userList) {
                if(map.containsKey(s.getParentId())) {
                    SysPermissionTreeVO v=new SysPermissionTreeVO();
                    BeanUtils.copyProperties(s, v);
                    map.get(s.getParentId()).add(v);
                }
            }
            //排序
            for(String id:map.keySet()) {
                List<SysPermissionTreeVO>  list=getSortedList(map.get(id));
                map.put(id, list);
             }
            //关联叶子节点
            for(List<SysPermissionTreeVO> list:map.values()) {
                for(SysPermissionTreeVO s:list) {
                    s.setSubList(map.get(s.getId()));
                }
            }
            //关联一级节点
            for(SysPermissionTreeVO tv:result.getSubList()) {
                tv.setSubList(map.get(tv.getId()));
            }
            
            LOGGER.info("roleTree resp="+JSON.toJSONString(result));
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage(),e);
        }
        return result;
    }
    /**
     * 
    * @Title: 权限树排序 
    * @author shidandan
    * @date 2019年1月18日 下午6:24:17 
    * @Description: 权限树排序 
    * @param list
    * @return  参数说明 
    * @return List<SysPermissionTreeVO>    返回类型 
    * @throws 
     */
    private List<SysPermissionTreeVO> getSortedList(List<SysPermissionTreeVO> list){
        if(list==null || list.size()<=1) {
            return list;
        }
        
        Collections.sort(list, new Comparator<SysPermissionTreeVO>()
        {
            @Override
            public int compare(SysPermissionTreeVO o1, SysPermissionTreeVO o2)
            {
                return o1.getSortIndex().compareTo(o2.getSortIndex());
            }
        });
        return list;
    }
}

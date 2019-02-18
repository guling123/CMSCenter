package cn.people.controller;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SysPermissionMenuVO;
import cn.people.controller.vo.SysPermissionTreeVO;
import cn.people.controller.vo.SysPermissionVO;
import cn.people.controller.vo.UserVO;
import cn.people.entity.SysPermission;
import cn.people.service.ISysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 管理权限表 前端控制器
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@RestController
@RequestMapping("/permission")
@Api(value = "权限管理", description = "权限管理")
public class SysPermissionController {
    
    private static final String FIRST_LEVEL_MENU = "0";

    private static final Integer PERMISSION_FLAG = 0;//tb_sys_permission.menu_flag权限标志

    private static final Integer MENU_FLAG = 1;//tb_sys_permission.menu_flag菜单标志

    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleController.class);
    
    @Autowired
    ISysPermissionService sysPermissionService;
    
    
    /**
     * 
    * @Title: getPermission 
    * @author fuqiang
    * @date 2018年12月18日 下午16:01:07 
    * @Description: 查询权限信息
    * @param @param model
    * @param @return  参数说明 
    * @return ResultVO<SysPermissionTreeVO>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "查询权限树", notes = "查询权限树")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultVO<SysPermissionTreeVO> roleTree()
    {
        SysPermissionTreeVO result= new SysPermissionTreeVO();
        try
        {
            SysPermission permission=new SysPermission();
            QueryWrapper<SysPermission> queryUserWrapper = new QueryWrapper<>(permission);
            
            List<SysPermission> userList= sysPermissionService.list(queryUserWrapper);
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
        return ResultVO.ok(result);
    }
    
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
    
    /**
     * 
    * @Title: getPermissionMenu 
    * @author shidandan
    * @date 2018年12月13日 上午9:55:02 
    * @Description: 查询所有菜单类权限 
    * @param @return  参数说明 
    * @return ResultVO<List<SysPermissionMenuVO>>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "查询所有菜单类权限 ", notes = "查询所有菜单类权限 ")
    @RequestMapping(value = "/list/menu",method = RequestMethod.GET)
    public ResultVO<List<SysPermissionMenuVO>> getPermissionMenu() {
        //TODO
      return ResultVO.ok(new ArrayList<SysPermissionMenuVO>());  
    }
}

package cn.people.service.impl;

import cn.people.commons.constants.CodeConstants;
import cn.people.commons.exceptions.CMSBussinessException;
import cn.people.controller.vo.SysUserChannelListVO;
import cn.people.controller.vo.SysUserChannelVO;
import cn.people.controller.vo.SysUserVO;
import cn.people.entity.SysGroup;
import cn.people.entity.SysUser;
import cn.people.entity.SysUserChannel;
import cn.people.mapper.SysGroupMapper;
import cn.people.mapper.SysUserChannelMapper;
import cn.people.mapper.SysUserMapper;
import cn.people.service.ISysUserChannelService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 管理员账户组表 服务实现类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-17
 */
@Service
public class SysUserChannelServiceImpl extends ServiceImpl<SysUserChannelMapper, SysUserChannel> implements ISysUserChannelService {

    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Autowired
    private SysGroupMapper sysGroupMapper;
    
    /*
    * Title: getSysUserByOrgid
    * @author shidandan
    * @date 2018年12月17日 下午7:24:50 
    *Description: 
    * @param groupid
    * @return 
    * @see cn.people.service.ISysUserChannelService#getSysUserByOrgid(java.lang.String) 
    */
    @Override
    public SysUserChannelListVO getSysUserByOrgid(String groupid,String orgid)
    {
        if(StringUtils.isEmpty(groupid)) {
            return null;
        }

        //查询租户下的用户信息
        SysUser sysUser=new SysUser();
        sysUser.setOrgid(orgid);
        List<SysUser> userList=sysUserMapper.selectList(new QueryWrapper<SysUser>(sysUser));
        if(CollectionUtils.isEmpty(userList)) {
            return null;
        }
        
        //查询账户组下得人员
        SysUserChannel userChannel=new SysUserChannel();
        userChannel.setGroupid(groupid);
        List<SysUserChannel> list=this.list(new QueryWrapper<SysUserChannel>(userChannel));
        
        return getSysUserByOrgidResult(list,userList);
    }
  
    /*
    * Title: createSysUserChannel
    * @author shidandan
    * @date 2018年12月17日 下午7:36:05 
    *Description: 
    * @param createVO
    * @return 
    * @see cn.people.service.ISysUserChannelService#createSysUserChannel(cn.people.controller.vo.SysUserChannelVO) 
    */
    @Override
    @Transactional
    public Boolean updateUsers(SysUserChannelVO createVO,String id) throws Exception
    {
        Boolean result=false;
        //效验站点是否已经存在
        SysGroup param=sysGroupMapper.selectById(id);
        
        if(param==null) {
            throw new CMSBussinessException(CodeConstants.GROUPNAME_NOT_EXIST, "账户组不存在");
        }
        SysUserChannel sysUserChannel=new SysUserChannel();
        sysUserChannel.setGroupid(id);
        this.remove(new QueryWrapper<SysUserChannel>(sysUserChannel));
        
        if(CollectionUtils.isNotEmpty(createVO.getUserIds())) {
            List<SysUserChannel> entityList=new ArrayList<SysUserChannel>();
            createVO.getUserIds().forEach(userId ->{
                SysUserChannel userChannel=new SysUserChannel();
                userChannel.setGroupid(id);
                userChannel.setSysuerid(userId);
                entityList.add(userChannel);
            });
            result= this.saveBatch(entityList);
        }
        
        return result;
    }
    /**
     * 
    * @Title: getSysUserByOrgidResult 
    * @author shidandan
    * @date 2018年12月20日 下午7:24:33 
    * @Description: 封装查询人员信息得接口的返回集 
    * @param @param list
    * @param @param userList  参数说明 
    * @return void    返回类型 
    * @throws 
     */
    private SysUserChannelListVO getSysUserByOrgidResult(List<SysUserChannel> list,List<SysUser> userList) {
        SysUserChannelListVO result =new SysUserChannelListVO();
        
        if(CollectionUtils.isNotEmpty(list)) {
            Set<String> userIdList=list.stream().map(user -> {return user.getSysuerid();}).collect(Collectors.toSet());
            
            List<SysUser> userChannelList=sysUserMapper.selectBatchIds(userIdList);
            userList.removeAll(userChannelList);
            
            List<SysUserVO> userResultList=new ArrayList<SysUserVO>();
            userList.forEach(u ->{
                SysUserVO vo=new SysUserVO();
                vo.setUserid(u.getId());
                vo.setUsername(u.getUsername());
                userResultList.add(vo);
            });
            result.setUserList(userResultList);
            
            
            List<SysUserVO> userChannelResultList=new ArrayList<SysUserVO>();
            userChannelList.forEach(u ->{
                SysUserVO vo=new SysUserVO();
                vo.setUserid(u.getId());
                vo.setUsername(u.getUsername());
                userChannelResultList.add(vo);
            });
            result.setUserChannelList(userChannelResultList);
        }else {
            List<SysUserVO> userResultList=new ArrayList<SysUserVO>();
            userList.forEach(u ->{
                SysUserVO vo=new SysUserVO();
                vo.setUserid(u.getId());
                vo.setUsername(u.getUsername());
                userResultList.add(vo);
            });
            result.setUserList(userResultList);
        }
        
        return result;
    }
}

package cn.people.service.impl;

import cn.people.commons.constants.CodeConstants;
import cn.people.commons.exceptions.CMSBussinessException;
import cn.people.controller.vo.SysGroupCreateVO;
import cn.people.controller.vo.SysGroupDetailVO;
import cn.people.controller.vo.SysGroupUpdateVO;
import cn.people.entity.Site;
import cn.people.entity.SysGroup;
import cn.people.entity.SysGroupChannel;
import cn.people.entity.SysUserChannel;
import cn.people.mapper.SiteMapper;
import cn.people.mapper.SysGroupMapper;
import cn.people.service.ISysGroupChannelService;
import cn.people.service.ISysGroupService;
import cn.people.service.ISysUserChannelService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * 管理账户组表 服务实现类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-13
 */
@Service
public class SysGroupServiceImpl extends ServiceImpl<SysGroupMapper, SysGroup> implements ISysGroupService {

    @Autowired
    private SiteMapper siteMapper;
    
    @Autowired
    private ISysGroupChannelService iSysGroupChannelService;
    
    @Autowired
    private ISysUserChannelService iSysUserChannelService;
    
    /*
    * Title: getSysGroup
    * @author shidandan
    * @date 2018年12月17日 下午4:46:32 
    *Description: 
    * @param siteid
    * @param orgid
    * @return 
    * @see cn.people.service.ISysGroupService#getSysGroup(java.lang.String, java.lang.String) 
    */
    @Override
    public List<SysGroup> getSysGroupList(String siteid, String orgid) throws Exception
    {
        Site site=siteMapper.selectById(siteid);
        
        if(null==site || !site.getOrgid().equals(orgid)) {
            throw new CMSBussinessException(CodeConstants.PERMISSIONS_ERROR, "没权限查看该站点下的账户组信息");
        }
        
        SysGroup group=new SysGroup();
        group.setSiteid(siteid);
        group.setDstatus(1);
        return this.list(new QueryWrapper<SysGroup>(group));
    }
    /*
    * Title: createSysGroup
    * @author shidandan
    * @date 2018年12月17日 下午5:13:34 
    *Description: 
    * @param sysGroup
    * @param createrid
    * @return 
    * @see cn.people.service.ISysGroupService#createSysGroup(cn.people.controller.vo.SysGroupCreateVO, java.lang.String) 
    */
    @Override
    @Transactional
    public Boolean createSysGroup(SysGroupCreateVO sysGroup, String createrid) throws Exception
    {
        //效验账户组名称是否已经存在
        SysGroup group=new SysGroup();
        
        group.setGroupname(sysGroup.getGroupname());
        int count=this.count(new QueryWrapper<SysGroup>(group));
        
        if(count>0) {
            throw new CMSBussinessException(CodeConstants.GROUPNAME_EXIST, "账户组名称已经存在");
        }
        
        BeanUtils.copyProperties(sysGroup, group);
        group.setCreaterid(createrid);
        group.setCreatetime(new Date());
        group.setDstatus(1);
        Boolean isSuccess=this.save(group);
        if(!CollectionUtils.isEmpty(sysGroup.getChannelIds())&& isSuccess) {
            List<SysGroupChannel> channelList=new ArrayList<SysGroupChannel>();
            sysGroup.getChannelIds().forEach(channelid ->{
                SysGroupChannel groupChannel=new SysGroupChannel();
                groupChannel.setChannelid(channelid);
                groupChannel.setGroupid(group.getId());
                channelList.add(groupChannel);
            });
            isSuccess= iSysGroupChannelService.saveBatch(channelList);
        }
        
        return isSuccess;
    }
    /*
    * Title: getSysGroup
    * @author shidandan
    * @date 2018年12月17日 下午5:25:03 
    *Description: 
    * @param id
    * @return 
    * @see cn.people.service.ISysGroupService#getSysGroup(java.lang.String) 
    */
    @Override
    public SysGroupDetailVO getSysGroup(String id,String orgid) throws Exception
    {
      if(StringUtils.isEmpty(id)) {
         return null;
      }
      
      SysGroup group= this.getById(id);
      
      if(null!=group) {
          SysGroupDetailVO result=new SysGroupDetailVO();
          result.setDescription(group.getDescription());
          result.setGroupname(group.getGroupname());
          result.setId(group.getId());
          result.setSiteid(group.getSiteid());
          SysGroupChannel channel=new SysGroupChannel();
          channel.setGroupid(id);
          //查询账户组下的栏目信息
          List<SysGroupChannel> sysGroupChannelList=iSysGroupChannelService.list(new QueryWrapper<SysGroupChannel>(channel));
          
          //标注当前账户组下的栏目信息为选中
          if(!CollectionUtils.isEmpty(sysGroupChannelList)) {
              Set<String> channelIds =sysGroupChannelList.stream().map(c -> {return c.getChannelid();}).collect(Collectors.toSet());
              result.setChannelList(channelIds);
          }
          
          return result;
      }
      return null;
    }
    /*
    * Title: updateSysGroup
    * @author shidandan
    * @date 2018年12月17日 下午5:53:34 
    *Description: 
    * @param sysGroup
    * @return 
    * @see cn.people.service.ISysGroupService#updateSysGroup(cn.people.controller.vo.SysGroupCreateVO) 
    */
    @Override
    @Transactional
    public Boolean updateSysGroup(SysGroupUpdateVO sysGroup,String id) throws Exception
    {
        //效验账户组是否已经存在
        SysGroup group=this.getById(id);
        
        if(null==group) {
            throw new CMSBussinessException(CodeConstants.GROUPNAME_NOT_EXIST, "账户组不存在");
        }
        
        group.setDescription(sysGroup.getDescription());
        group.setGroupname(sysGroup.getGroupname());
        boolean isSuccess= this.updateById(group);
        
        if(isSuccess) {
            //删除之前的账户组关联的栏目信息
            SysGroupChannel sysGroupChannel=new SysGroupChannel();
            sysGroupChannel.setGroupid(id);
            isSuccess=iSysGroupChannelService.remove(new QueryWrapper<SysGroupChannel>(sysGroupChannel));
            //插入新得栏目信息
            if(!CollectionUtils.isEmpty(sysGroup.getChannelIds())&& isSuccess) {
                List<SysGroupChannel> channelList=new ArrayList<SysGroupChannel>();
                sysGroup.getChannelIds().forEach(channelid ->{
                    SysGroupChannel groupChannel=new SysGroupChannel();
                    groupChannel.setChannelid(channelid);
                    groupChannel.setGroupid(id);
                    channelList.add(groupChannel);
                });
                isSuccess= iSysGroupChannelService.saveBatch(channelList);
            }
        }
        return isSuccess;
    }
    /*
    * Title: delSysGroup
    * @author shidandan
    * @date 2018年12月18日 上午11:04:24 
    *Description: 
    * @param id
    * @return
    * @throws Exception 
    * @see cn.people.service.ISysGroupService#delSysGroup(java.lang.String) 
    */
    @Override
    @Transactional
    public Boolean delSysGroup(String id)
        throws Exception
    {
      //效验账户组是否已经存在
        SysGroup group=this.getById(id);
        
        if(null==group) {
            throw new CMSBussinessException(CodeConstants.GROUPNAME_NOT_EXIST, "账户组不存在");
        }
        group=new SysGroup();
        group.setId(id);
        group.setDstatus(2);
        Boolean isSuccess=this.updateById(group);
        
        if(isSuccess) {
            //账户账户组关联的栏目信息
            SysGroupChannel sysGroupChannel=new SysGroupChannel();
            sysGroupChannel.setGroupid(id);
            isSuccess=iSysGroupChannelService.remove(new QueryWrapper<SysGroupChannel>(sysGroupChannel));
            
            //删除账户组关联的账户信息
            SysUserChannel sysUserChannel=new SysUserChannel();
            sysUserChannel.setGroupid(id);
            isSuccess=iSysUserChannelService.remove(new QueryWrapper<SysUserChannel>(sysUserChannel));
        }
        return isSuccess;
    }
}

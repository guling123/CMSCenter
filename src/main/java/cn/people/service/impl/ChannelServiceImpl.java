/**   
* @Title: ChannelServiceImpl.java 
* @Package cn.people.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2019年1月17日 下午4:57:53 
* @version V1.0   
*/
package cn.people.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import cn.people.commons.constants.CodeConstants;
import cn.people.controller.vo.Channel;
import cn.people.commons.utils.SessionUtil;
import cn.people.controller.vo.ChannelCreateRemoteVO;
import cn.people.controller.vo.ChannelCreateResultVO;
import cn.people.controller.vo.ChannelCreateVO;
import cn.people.controller.vo.ChannelDetailVO;
import cn.people.controller.vo.ChannelListRequestVO;
import cn.people.controller.vo.ChannelListTreeVO;
import cn.people.controller.vo.ChannelListVO;
import cn.people.controller.vo.ImageCreateVO;
import cn.people.controller.vo.PublishChanneRequest;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SessionUser;
import cn.people.entity.SysGroupChannel;
import cn.people.entity.SysUser;
import cn.people.entity.SysUserChannel;
import cn.people.mapper.SysUserChannelMapper;
import cn.people.mapper.SysUserMapper;
import cn.people.remote.ChannelRemote;
import cn.people.remote.FileRemote;
import cn.people.remote.OutputChannelRemote;
import cn.people.service.IChannelService;
import cn.people.service.ISysGroupChannelService;
import cn.people.service.ISysUserChannelService;

/** 
* @ClassName: ChannelServiceImpl 
* @Description: 栏目接口实现类
* @author shidandan
* @date 2019年1月17日 下午4:57:53 
*  
*/
@Service
public class ChannelServiceImpl implements IChannelService
{
    @Autowired
    private ChannelRemote channelRemote;
    
    @Autowired
    private OutputChannelRemote outputChannelRemote;
    
    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Autowired
    private ISysUserChannelService sysUserChannelService;
    
    @Autowired
    private ISysGroupChannelService sysGroupChannelService;
    
    @Autowired
    private FileRemote fileRemote;
    
    @Autowired
    private ISysGroupChannelService iSysGroupChannelService;
    
    @Autowired
    private SysUserChannelMapper sysUserChannelMapper;
    /**
     * Title: 根据站点查询栏目信息
     * @author shidandan
     * @date 2019年2月2日 上午10:49:01 
     * @Description:  根据站点查询栏目信息
     * @param siteid 站点ID
     * @param orgid 租户ID
     * @return 
     * @see cn.people.service.IChannelService#getChannelBySite(java.lang.String, java.lang.String) 
     */
     @Override
     public ResultVO<ChannelListVO> getChannelBySite(String siteid, String orgid)
     {
         ChannelListRequestVO channelListRequet=new ChannelListRequestVO();
         return channelRemote.getChannelBySite(siteid, orgid,channelListRequet);
     }
    /**
    * Title: 根据站点查询栏目信息
    * @author shidandan
    * @date 2019年1月17日 下午5:02:55 
    * @Description: 根据站点查询栏目信息
    * @param siteid 站点ID
    * @param orgid 租户ID
    * @return 栏目树
    * @see cn.people.service.IChannelService#getChannelBySite(java.lang.String) 
    */
    @Override
    public ResultVO<ChannelListVO> getChannelByPermissionSite(String siteid, String orgid,String userid)
    {
        SysUserChannel sysUserChannel=new SysUserChannel();
        sysUserChannel.setSysuerid(userid);
        sysUserChannel=sysUserChannelMapper.selectOne(new QueryWrapper<SysUserChannel>(sysUserChannel));
        
        if(null==sysUserChannel) {
            return ResultVO.ok(null);
        }
        
        SysGroupChannel sysGroupChannel=new SysGroupChannel();
        sysGroupChannel.setGroupid(sysUserChannel.getGroupid());
        List<SysGroupChannel> groupChannelList=iSysGroupChannelService.list(new QueryWrapper<SysGroupChannel>(sysGroupChannel));
        
        if(CollectionUtils.isEmpty(groupChannelList)) {
            return ResultVO.ok(null); 
        }
        Set<String> channelIds=groupChannelList.stream().map(channelId->{return channelId.getChannelid();}).collect(Collectors.toSet());
        ChannelListRequestVO channelListRequet=new ChannelListRequestVO();
        channelListRequet.setChannelIds(channelIds);
        ResultVO<List<Channel>> channelListResult=channelRemote.getChannelList(channelListRequet);
        Set<String> channelIdSet=new HashSet<String>();
        if(channelListResult.getCode().equals(CodeConstants.RESULT_OK)) {
            List<Channel> channelList=channelListResult.getData();
            if(!CollectionUtils.isEmpty(channelList)) {
                channelList.forEach(c->{
                    channelIdSet.add(c.getId());
                    channelIdSet.add(c.getParentId());
                });
                channelListRequet.setChannelIds(channelIdSet);
            }
        }
        
        ResultVO<ChannelListVO> result=channelRemote.getChannelBySite(siteid, orgid,channelListRequet);
        
        if(null!=result.getData()&&CollectionUtils.isNotEmpty(result.getData().getChildren())) {
            Set<String> idList=new HashSet<String>();
            
            getUserIdsByChannel(result.getData().getChildren(),idList);
            List<SysUser> userList=sysUserMapper.selectBatchIds(idList);
            Map<String,String> userMap=new HashMap<String,String>();
            if(!CollectionUtils.isEmpty(userList)) {
                userList.forEach(user ->{
                    userMap.put(user.getId(), user.getUsername());
                });
            }
            setUserNamesByChannel(result.getData().getChildren(),userMap,channelIds);
        }
        return result;
    }

    /**
    * Title: 新增子栏目
    * @author shidandan
    * @date 2019年1月17日 下午5:02:55 
    * @Description: 新增子栏目
    * @param channelCreateVO 子栏目信息
    * @return 成功返回true
    * @see cn.people.service.IChannelService#createChannel(cn.people.controller.vo.ChannelCreateVO) 
    */
    @Override
    public ResultVO<Boolean> createChannel(ChannelCreateRemoteVO channelCreateVO)
    {
        ResultVO<ChannelCreateResultVO> channelCreateResult= channelRemote.createChannel(channelCreateVO);
        
        if(channelCreateResult.getCode().equals(CodeConstants.RESULT_OK)&&channelCreateResult.getData().isSuccess()) {
            if(!StringUtils.isBlank(channelCreateResult.getData().getParentId())&&!channelCreateResult.getData().getParentId().equals("0")) {
                SysGroupChannel entity=new SysGroupChannel();
                entity.setChannelid(channelCreateResult.getData().getParentId());
                List<SysGroupChannel> groupChannelList=iSysGroupChannelService.list(new QueryWrapper<SysGroupChannel>(entity));
                
                if(CollectionUtils.isNotEmpty(groupChannelList)) {
                    List<SysGroupChannel> saveGroupChannelList=new ArrayList<SysGroupChannel>();
                    groupChannelList.forEach(groupChannel->{
                        SysGroupChannel sysGroupChannel=new SysGroupChannel();
                        sysGroupChannel.setChannelid(channelCreateResult.getData().getId());
                        sysGroupChannel.setGroupid(groupChannel.getGroupid());
                        saveGroupChannelList.add(sysGroupChannel);
                    });
                    
                    iSysGroupChannelService.saveBatch(saveGroupChannelList);
                }
            }
            ImageCreateVO imageCreateVO=new ImageCreateVO();
            imageCreateVO.setChannelid(channelCreateResult.getData().getId());
            imageCreateVO.setDtype(4);
            imageCreateVO.setFilepath(channelCreateVO.getImageUrl());
            imageCreateVO.setSiteid(channelCreateResult.getData().getSiteid());
            imageCreateVO.setSourcetype(1);
            fileRemote.createImage(imageCreateVO);
        }
        return ResultVO.ok(false);
    }

    /**
    * Title: 获取栏目详情
    * @author shidandan
    * @date 2019年1月17日 下午5:02:55 
    * @Description: 获取栏目详情
    * @param id 栏目ID
    * @return 
    * @see cn.people.service.IChannelService#getChannel(java.lang.String) 
    */
    @Override
    public ResultVO<ChannelDetailVO> getChannel(String id)
    {
        return channelRemote.getChannel(id);
    }

    /**
    * Title: 更新栏目
    * @author shidandan
    * @date 2019年1月17日 下午5:02:55 
    * @Description: 更新栏目
    * @param channel 栏目信息
    * @param id 栏目ID
    * @return 
    * @see cn.people.service.IChannelService#updateChannel(cn.people.controller.vo.ChannelCreateVO, java.lang.String) 
    */
    @Override
    public ResultVO<Boolean> updateChannel(ChannelCreateVO channel, String id)
    {
        return channelRemote.updateChannel(channel, id);
    }

    /**
    * Title: 删除栏目
    * @author shidandan
    * @date 2019年1月17日 下午5:02:55 
    * @Description: 删除栏目
    * @param id 栏目ID
    * @return 
    * @see cn.people.service.IChannelService#delChannel(java.lang.String) 
    */
    @Override
    public ResultVO<Boolean> delChannel(String id)
    {
        return channelRemote.delChannel(id);
    }
    /**
     * 
    * @Title: 获取栏目的创建人集合 
    * @author shidandan
    * @date 2019年1月22日 上午10:46:23 
    * @Description: 获取栏目的创建人集合 
    * @param children
    * @param idList  参数说明 
    * @return void    返回类型 
    * @throws 
     */
    private void getUserIdsByChannel(List<ChannelListTreeVO> children,Set<String> idList) {
        if(CollectionUtils.isEmpty(children)) {
            return ;
        }
        children.forEach(channel->{
            idList.add(channel.getCreaterId());
            getUserIdsByChannel(channel.getChildren(),idList);
        });
        
    }
    /**
     * 
    * @Title: 栏目列表设置栏目创建人姓名 
    * @author shidandan
    * @date 2019年1月22日 上午10:51:30 
    * @Description: 栏目列表设置栏目创建人姓名
    * @param children
    * @param userMap  创建人ID和姓名信息 
    * @return void    返回类型 
    * @throws 
     */
    private void setUserNamesByChannel(List<ChannelListTreeVO> children,Map<String,String> userMap,Set<String> channelIds) {
        if(CollectionUtils.isEmpty(children)) {
            return ;
        }
        children.forEach(channel->{
            if(null!=userMap.get(channel.getCreaterId())) {
                channel.setCreaterName(userMap.get(channel.getCreaterId()));
            }
            if(channelIds.contains(channel.getId())) {
                channel.setIsPermission(true);
            }else {
                channel.setIsPermission(false);
            }
            setUserNamesByChannel(channel.getChildren(),userMap,channelIds);
        });
        
    }
    
    /**
     * 
    * Title: 栏目下线
    * @author fanchengkui
    * @date 2019年1月25日 上午11:29:29 
    * @Description: 栏目下线
    * @param 栏目下线资源入参对象
    * @return  成功返回true
    * @see cn.people.service.IChannelService#offlineChannel(cn.people.controller.vo.PublishChanneRequest)
     */
    @Override
    public ResultVO<Boolean> offlineChannel(PublishChanneRequest publishChanneRequest)
    {
        return outputChannelRemote.offlineChannel(publishChanneRequest);
    }
    
    /**
     * 
    * Title: 栏目发布 
    * @author fanchengkui
    * @date 2019年1月25日 下午1:32:31 
    * @Description: 栏目发布 
    * @param publishChanneRequest 栏目发布资源入参对象
    * @param userId 当前登录用户id
    * @return  成功返回true
    * @see cn.people.service.IChannelService#publishChannel(cn.people.controller.vo.PublishChanneRequest)
     */
    @Override
    public ResultVO<Boolean> publishChannel(PublishChanneRequest publishChanneRequest ,String userId)
    {
        publishChanneRequest.setAuthorizedChannelIds(getAuthorizedChannelIds(userId));
        
        return outputChannelRemote.publishChannel(publishChanneRequest);
    }

    private Set<String> getAuthorizedChannelIds(String userId)
    {
        Set<String> result = new HashSet<String>();
        QueryWrapper<SysUserChannel> queryWrapper = new QueryWrapper<SysUserChannel>();
        queryWrapper.eq("sysuerid", userId);
        SysUserChannel sysUserChannel = sysUserChannelService.getOne(queryWrapper);
        
        if (null != sysUserChannel)
        {
            QueryWrapper<SysGroupChannel> queryWrapperGc = new QueryWrapper<SysGroupChannel>();
            queryWrapperGc.eq("groupid", sysUserChannel.getGroupid());
            List<SysGroupChannel> gcs = sysGroupChannelService.list(queryWrapperGc);
            gcs.forEach(gc -> {
                result.add(gc.getChannelid());
            });
        }
        
        return result;
    }

}

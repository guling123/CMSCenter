package cn.people.service.impl;

import cn.people.commons.constants.CodeConstants;
import cn.people.commons.exceptions.CMSBussinessException;
import cn.people.controller.vo.ChannelCreateRemoteVO;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SiteCreateVO;
import cn.people.controller.vo.SiteVO;
import cn.people.entity.Site;
import cn.people.entity.SysUser;
import cn.people.mapper.SiteMapper;
import cn.people.mapper.SysUserMapper;
import cn.people.remote.ChannelRemote;
import cn.people.remote.ContentRemote;
import cn.people.remote.ImageRemote;
import cn.people.service.ISiteService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * 站点信息表 服务实现类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@Service
public class SiteServiceImpl extends ServiceImpl<SiteMapper, Site> implements ISiteService {

    @Autowired
    private ContentRemote contentRemote;
    
    @Autowired
    private ImageRemote imageRemote;
    
    @Autowired
    private ChannelRemote channelRemote;
    
    @Autowired
    private SysUserMapper sysUserMapper;
    
    /*
    * Title: createSite
    * @author shidandan
    * @date 2018年12月12日 下午7:05:56 
    *Description: 
    * @param site
    * @return 
    * @see cn.people.service.ISiteService#createSite(cn.people.entity.Site) 
    */
    @Override
    @Transactional
    public Boolean createSite(SiteCreateVO siteVO,String createrid,String orgid) throws Exception
    {
       //效验站点名称是否已经存在
        Site param=new Site();
        param.setSitename(siteVO.getSitename());
        int count=this.count(new QueryWrapper<Site>(param));
        
        if(count>0) {
            throw new CMSBussinessException(CodeConstants.SITENAME_EXIST, "站点名称已经存在");
        }
        
        Site site=new Site();
        BeanUtils.copyProperties(siteVO, site);
        //创建站点
        site.setCreatetime(new Date());
        site.setCreaterid(createrid);
        site.setOrgid(orgid);
        boolean isSuccess=this.save(site);
        
        //同步站点到ContentService
        if(isSuccess) {
            ResultVO<Boolean> createSiteResult=contentRemote.createSite(site);
            if(createSiteResult.getCode().equals(CodeConstants.RESULT_OK)) {
                isSuccess= createSiteResult.getData();
            }
        }
        //创建根栏目
        ChannelCreateRemoteVO channel=new ChannelCreateRemoteVO();
        channel.setChannelName(siteVO.getSitename());
        channel.setSiteid(site.getId());
        channel.setUrl(site.getDomain());
        channel.setDtype(1);
        channel.setCreaterId(createrid);
        channel.setParentId("0");
        channelRemote.createChannel(channel);
        
        
        //同步站点到ImageService
        
        if(isSuccess) {
            ResultVO<Boolean> createSiteResult=imageRemote.createSite(site);
            if(createSiteResult.getCode().equals(CodeConstants.RESULT_OK)) {
               isSuccess= createSiteResult.getData(); }
        }
        //同步站点到OutputService TODO
        
        //同步站点到DynamicComService TODO
        
        return isSuccess;
    }

    /*
    * Title: getSiteList
    * @author shidandan
    * @date 2018年12月17日 下午3:53:43 
    *Description: 
    * @param orgid
    * @return 
    * @see cn.people.service.ISiteService#getSiteList(java.lang.String) 
    */
    @Override
    public List<SiteVO> getSiteList(String orgid)
    {
        if(StringUtils.isEmpty(orgid)) {
            return null;
        }
        Site site=new Site();
        site.setOrgid(orgid);
         QueryWrapper<Site> siteWrapper = new QueryWrapper<>(site);
         siteWrapper.orderByDesc("createtime");
        //List<Site> siteList=this.list(new QueryWrapper<>(site));
        List<Site> siteList=this.list(siteWrapper);

        if(!CollectionUtils.isEmpty(siteList)) {
            Set<String> idList=siteList.stream().map(s -> {
                return s.getCreaterid();
            }).collect(Collectors.toSet());
            List<SysUser> userList=sysUserMapper.selectBatchIds(idList);

            if(!CollectionUtils.isEmpty(userList)) {
                Map<String,String> userMap=new HashMap<String,String>();
                userList.forEach(user ->{
                    userMap.put(user.getId(), user.getUsername());
                });
                
                List<SiteVO> result=new ArrayList<SiteVO>();
                siteList.forEach(param ->{
                    SiteVO vo=new SiteVO();
                    BeanUtils.copyProperties(param, vo);
                    vo.setCreaterName(userMap.get(param.getCreaterid()));
                    result.add(vo);
                });
                return result;
            }
            
            
        }
        return null;
    }

    /*
    * Title: updateSite
    * @author shidandan
    * @date 2018年12月17日 下午4:04:47 
    *Description: 
    * @param id
    * @param site
    * @return 
    * @see cn.people.service.ISiteService#updateSite(java.lang.String, cn.people.entity.Site) 
    */
    @Override
    public Boolean updateSite(String id, SiteCreateVO siteVO) throws Exception
    {
        //效验站点是否已经存在
        Site param=this.getById(id);
        
        if(param==null) {
            throw new CMSBussinessException(CodeConstants.SITE_NOT_EXIST, "站点不存在");
        }
        
        Site site=new Site();
        BeanUtils.copyProperties(siteVO, site);
        site.setId(id);
        
        boolean isSuccess=this.updateById(site);
        
        //同步站点到ContentService
        if(isSuccess) {
            isSuccess= contentRemote.updateSite(site).getData(); 
        }
        //同步站点到ImageService
        
//        if(isSuccess) {
//            isSuccess= imageRemote.updateSite(site).getData(); 
//        }
        
        //同步站点到OutputService TODO
        
        //同步站点到DynamicComService TODO
        
        return isSuccess;
    }



}

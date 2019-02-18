package cn.people.service.impl;

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
import org.springframework.util.CollectionUtils;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.people.commons.constants.CodeConstants;
import cn.people.commons.exceptions.CMSBussinessException;
import cn.people.controller.vo.ContentSourceCreateVO;
import cn.people.controller.vo.ContentSourceListVO;
import cn.people.controller.vo.ContentSourceVO;
import cn.people.entity.ContentSource;
import cn.people.entity.SysUser;
import cn.people.mapper.ContentSourceMapper;
import cn.people.mapper.SysUserMapper;
import cn.people.service.IContentSourceService;
import cn.people.service.IIdGeneraterService;

/**
 * <p>
 * 稿件来源表 服务实现类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-18
 */
@Service
public class ContentSourceServiceImpl extends ServiceImpl<ContentSourceMapper, ContentSource> implements IContentSourceService {

    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Autowired
    private IIdGeneraterService iIdGeneraterService;
    
    /*
    * Title: updateContentSource
    * @author shidandan
    * @date 2018年12月18日 下午2:50:11 
    *Description: 
    * @param createVO
    * @param id
    * @return 
    * @see cn.people.service.IContentSourceService#updateContentSource(cn.people.controller.vo.ContentSourceCreateVO, java.lang.String) 
    */
    @Override
    public Boolean updateContentSource(ContentSourceCreateVO createVO, String id) throws Exception
    {
        ContentSource contentSource=this.getById(id);
        
        if(null==contentSource) {
            throw new CMSBussinessException(CodeConstants.CONTENT_SOURCE_NOT_EXIST, "稿源不存在");
        }
        ContentSource entity=new ContentSource();
        entity.setSiteid(createVO.getSiteid());
        entity.setSourcename(createVO.getSourcename());
        List<ContentSource> contentSourceList=this.list(new QueryWrapper<ContentSource>(entity));
        
        if(!CollectionUtils.isEmpty(contentSourceList)&&!contentSourceList.get(0).getId().equals(id)) {
            throw new CMSBussinessException(CodeConstants.CONTENT_SOURCE_NOT_EXIST, "该站点下该稿源名称已经存在");
        }
        
        BeanUtils.copyProperties(createVO, contentSource);
        return this.updateById(contentSource);
    }

    /*
    * Title: getContentSourcePaged
    * @author shidandan
    * @date 2018年12月18日 下午3:22:17 
    *Description: 
    * @param listVO
    * @return 
    * @see cn.people.service.IContentSourceService#getContentSourcePaged(cn.people.controller.vo.ContentSourceListVO) 
    */
    @Override
    public IPage<ContentSourceVO> getContentSourcePaged(ContentSourceListVO listVO)
    {

        QueryWrapper<ContentSource> wrapper = new QueryWrapper<ContentSource>();
        if (!StringUtils.isEmpty(listVO.getSourcenameOrId())) {
            wrapper.eq("id", listVO.getSourcenameOrId()).or().like("sourcename", listVO.getSourcenameOrId());
        }
        if (null != listVO.getStatus()) {
            wrapper.eq("status", listVO.getStatus());
        }
        if (null != listVO.getReliability()) {
            wrapper.eq("reliability", listVO.getReliability());
        }
        if (null != listVO.getSiteid()) {
            wrapper.eq("siteid", listVO.getSiteid());
        }
        if (null != listVO.getCreaterName()) {
            Map<String, Object> columnMap=new HashMap<String,Object>();
            columnMap.put("realname", listVO.getCreaterName());
            List<SysUser> userList=sysUserMapper.selectByMap(columnMap);
            
            if(!CollectionUtils.isEmpty(userList)) {
                Set<String> userIds = userList.stream().map(user -> {return user.getId();}).collect(Collectors.toSet());
                wrapper.in("createrid", userIds);
            }
            
        }
        IPage<ContentSourceVO> result=new Page<ContentSourceVO>();
        IPage<ContentSource> contentSourceResult=this.page(new Page<>(listVO.getCurrent(), listVO.getPageSize()), wrapper);
        result.setCurrent(contentSourceResult.getCurrent());
        result.setPages(contentSourceResult.getPages());
        result.setSize(contentSourceResult.getSize());
        result.setTotal(contentSourceResult.getTotal());
        
        
        List<ContentSource> list=contentSourceResult.getRecords();
        if(!CollectionUtils.isEmpty(list)) {
            List<ContentSourceVO> voList=new ArrayList<ContentSourceVO>();
            Set<String> userids=list.stream().map(r ->{
                return r.getCreaterid();
            }).collect(Collectors.toSet());
            List<SysUser> userList=sysUserMapper.selectBatchIds(userids);
            Map<String,String> userMap=new HashMap<String,String>();
            userList.forEach(user->{
                userMap.put(user.getId(), user.getUsername());
            });
            list.forEach(source ->{
                ContentSourceVO vo=new ContentSourceVO();
                BeanUtils.copyProperties(source, vo);
                if(null!=userMap.get(source.getCreaterid())) {
                    vo.setCreatername(userMap.get(source.getCreaterid()));
                }
                voList.add(vo);
            });
            result.setRecords(voList); 
        }
        
        return result;
    }

    /*
    * Title: updateContentSourceStatus
    * @author shidandan
    * @date 2018年12月18日 下午3:28:45 
    *Description: 
    * @param id
    * @param status
    * @return 
    * @see cn.people.service.IContentSourceService#updateContentSourceStatus(java.lang.String, java.lang.Integer) 
    */
    @Override
    public Boolean updateContentSourceStatus(String id, Integer status) throws Exception
    {
        ContentSource contentSource=this.getById(id);
        
        if(null==contentSource) {
            throw new CMSBussinessException(CodeConstants.CONTENT_SOURCE_NOT_EXIST, "稿源不存在");
        }
        contentSource=new ContentSource();
        contentSource.setId(id);
        contentSource.setStatus(status);
        
        return this.updateById(contentSource);
    }

    /*
    * Title: createContentSource
    * @author shidandan
    * @date 2018年12月20日 下午5:46:36 
    *Description: 
    * @param createVO
    * @return 
    * @see cn.people.service.IContentSourceService#createContentSource(cn.people.controller.vo.ContentSourceCreateVO) 
    */
    @Override
    public Boolean createContentSource(ContentSourceCreateVO createVO,String createrid) throws Exception
    {
        ContentSource contentSource=new ContentSource();
        contentSource.setSiteid(createVO.getSiteid());
        contentSource.setSourcename(createVO.getSourcename());
        List<ContentSource> contentSourceList=this.list(new QueryWrapper<ContentSource>(contentSource));
        
        if(!CollectionUtils.isEmpty(contentSourceList)) {
            throw new CMSBussinessException(CodeConstants.CONTENT_SOURCE_NOT_EXIST, "该站点下该稿源名称已经存在");
        }
        
        BeanUtils.copyProperties(createVO, contentSource);
        contentSource.setCreatetime(new Date());
        contentSource.setCreaterid(createrid);
        contentSource.setLogicId(iIdGeneraterService.getNextValue(ContentSource.class.getAnnotation(TableName.class).value()));
       
        return  this.save(contentSource);
    }

}

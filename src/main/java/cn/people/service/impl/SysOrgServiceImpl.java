package cn.people.service.impl;

import cn.people.commons.constants.CMSConstants;
import cn.people.commons.constants.CodeConstants;
import cn.people.commons.exceptions.CMSBussinessException;
import cn.people.controller.vo.*;
import cn.people.entity.SysOrg;
import cn.people.entity.SysUser;
import cn.people.mapper.SysOrgMapper;
import cn.people.mapper.SysUserMapper;
import cn.people.service.IIdGeneraterService;
import cn.people.service.ISysOrgService;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * 租户表 服务实现类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@Service
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper, SysOrg> implements ISysOrgService {

    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Autowired
    private IIdGeneraterService iIdGeneraterService;
    
    /*
    * Title: createSysOrg
    * @author shidandan
    * @date 2018年12月13日 下午5:51:39 
    *Description: 
    * @param createVO
    * @return 
    * @see cn.people.service.ISysOrgService#createSysOrg(cn.people.controller.vo.SysOrgCreateVO) 
    */
    @Override
    public Boolean createSysOrg(SysOrgCreateVO createVO,String createrid) throws Exception
    {
        SysOrg org=new SysOrg();
        SysOrg sysOrg=new SysOrg();
        sysOrg.setOrgname(createVO.getOrgname());
        List<SysOrg> sysOrgList=this.list(new QueryWrapper<SysOrg>(sysOrg));
        
        if(!CollectionUtils.isEmpty(sysOrgList)) {
           throw new CMSBussinessException(CodeConstants.SYSORG_EXIST, "租户已经存在"); 
        }
        BeanUtils.copyProperties(createVO, org);
        org.setCreaterid(createrid);
        org.setCreatetime(new Date());
        org.setOrgid(iIdGeneraterService.getNextValue(SysOrg.class.getAnnotation(TableName.class).value()));
        org.setDtatus(1);
        
        return this.save(org);
    }

    /*
    * Title: getSysOrg
    * @author shidandan
    * @date 2018年12月13日 下午6:03:05 
    *Description: 
    * @param id
    * @return 
    * @see cn.people.service.ISysOrgService#getSysOrg(java.lang.String) 
    */
    @Override
    public SysOrgUpdateVO getSysOrg(String id)
    {
        SysOrg org=this.getById(id);
        
        if(null!=org) {
            SysOrgUpdateVO result=new SysOrgUpdateVO();
            BeanUtils.copyProperties(org, result);
            
            return result;
        }
        return null;
    }

    /*
    * Title: updateSysOrg
    * @author shidandan
    * @date 2018年12月13日 下午6:05:41 
    *Description: 
    * @param updateVO
    * @return 
    * @see cn.people.service.ISysOrgService#updateSysOrg(cn.people.controller.vo.SysOrgUpdateVO) 
    */
    @Override
    public Boolean updateSysOrg(SysOrgUpdateVO updateVO) throws Exception
    {
        SysOrg org=this.getById(updateVO.getId());
        //效验租户是否存在
        if(null==org) {
            throw new CMSBussinessException(CodeConstants.SYSORG_NOT_EXIST, "租户不存在");
        }
        
        //效验租户名称是否已经被占用
        SysOrg sysOrg=new SysOrg();
        sysOrg.setOrgname(updateVO.getOrgname());
        List<SysOrg> sysOrgList=this.list(new QueryWrapper<SysOrg>(sysOrg));
        
        if(!CollectionUtils.isEmpty(sysOrgList)) {
            for(SysOrg param:sysOrgList) {
                if(!param.getId().equals(updateVO.getId())) {
                    throw new CMSBussinessException(CodeConstants.SYSORG_EXIST, "租户已经存在");   
                }
            }
        }
        BeanUtils.copyProperties(updateVO, org);
        return  this.updateById(org);
    }

    /*
    * Title: getSysOrgPaged
    * @author shidandan
    * @date 2018年12月13日 下午6:16:42 
    *Description: 分页查询租户信息
    * @param listVO
    * @return 
    * @see cn.people.service.ISysOrgService#getSysOrgPaged(cn.people.controller.vo.SysOrgListVO) 
    */
    @Override
    public IPage<SysOrgListResultVO> getSysOrgPaged(SysOrgListVO listVO)
    {
        QueryWrapper<SysOrg> wrapper = new QueryWrapper<SysOrg>();
        if (!StringUtils.isEmpty(listVO.getOrgidOrName())) {
            wrapper.like("orgid", listVO.getOrgidOrName()).or().like("orgname", listVO.getOrgidOrName());
        }
        if (null != listVO.getDtatus()) {
            wrapper.le("dtatus", listVO.getDtatus());
        }
        if (null != listVO.getCreater()) {
            Map<String, Object> columnMap=new HashMap<String,Object>();
            columnMap.put("realname", listVO.getCreater());
            List<SysUser> userList=sysUserMapper.selectByMap(columnMap);
            
            if(!CollectionUtils.isEmpty(userList)) {
                Set<String> userIds = userList.stream().map(user -> {return user.getId();}).collect(Collectors.toSet());
                wrapper.in("createrid", userIds);
            }
            
        }
        wrapper.orderByDesc("createtime");
        IPage<SysOrg> orgPage=this.page(new Page<>(listVO.getCurrent(), listVO.getPageSize()), wrapper);
        
        if(null!=orgPage) {
            IPage<SysOrgListResultVO> result=new Page<SysOrgListResultVO>();
            result.setCurrent(orgPage.getCurrent());
            result.setPages(orgPage.getPages());
            result.setSize(orgPage.getSize());
            result.setTotal(orgPage.getTotal());
            if(!CollectionUtils.isEmpty(orgPage.getRecords())) {
                
                Set<String> idList=orgPage.getRecords().stream().map(s -> {
                    return s.getCreaterid();
                }).collect(Collectors.toSet());
                List<SysUser> userList=sysUserMapper.selectBatchIds(idList);
                Map<String,String> userMap=new HashMap<String,String>();
                if(!CollectionUtils.isEmpty(userList)) {
                    userList.forEach(user ->{
                        userMap.put(user.getId(), user.getUsername());
                    });
                }
                List<SysOrgListResultVO> list=new ArrayList<SysOrgListResultVO>();
                orgPage.getRecords().forEach(record ->{
                    SysOrgListResultVO vo=new SysOrgListResultVO();
                    BeanUtils.copyProperties(record, vo);
                    if(null!=userMap.get(record.getCreaterid())) {
                        vo.setCreatername(userMap.get(record.getCreaterid()));
                    }
                    vo.setOrgid(record.getOrgid().toString());
                    list.add(vo);
                });
                result.setRecords(list);
            }
            return result;
        }
        
        
        return null;
    }

    /**
     * @author guling
     * @Title   获取超管详细信息
     * @Date    2019/2/1 9:30
     * @param   [orgid]  租户id
     * @return  cn.people.controller.vo.SysOrgdetailVO
     * @throws
     * @Description 获取超管详细信息
     */
    @Override public SysOrgdetailVO getSysOrgAdminDetail(String orgid) throws Exception
    {
        if(null == orgid) {
            throw new CMSBussinessException(CodeConstants.SYSORG_NOT_EXIST, "orgid不存在");
        }
        SysUser sysUser = new SysUser();
        sysUser.setOrgid(orgid);
        sysUser.setRoleid(CMSConstants.SUPER_SYSY_USER_ROLE_ID);
        Wrapper<SysUser> sysUserWrapper = new QueryWrapper<>(sysUser);
        SysUser sysUser1 = sysUserMapper.selectOne(sysUserWrapper);
        SysOrgdetailVO sysOrgdetailVO = new SysOrgdetailVO();
        if (sysUser1 != null){
            BeanUtils.copyProperties(sysUser1, sysOrgdetailVO);
            return  sysOrgdetailVO;
        }
        return null;
    }

    /*
    * Title: updateSysOrgStatus
    * @author shidandan
    * @date 2018年12月14日 下午3:18:18 
    *Description: 启用或禁用租户
    * @param id
    * @param status 1 启用  0 禁用
    * @return
    * @throws Exception 
    * @see cn.people.service.ISysOrgService#updateSysOrgStatus(java.lang.String, java.lang.String) 
    */
    @Override
    public Boolean updateSysOrgStatus(String id, String status)
        throws Exception
    {
        SysOrg org=this.getById(id);
        
        if(null==org) {
            throw new CMSBussinessException(CodeConstants.SYSORG_NOT_EXIST, "租户不存在");
        }
        //status 1 启用  0 禁用
        org=new SysOrg();
        org.setId(id);
        org.setDtatus(Integer.valueOf(status));
        //禁用
        if(status.equals("1")) {
           //TODO 
        }
        
        return this.updateById(org);
    }

}

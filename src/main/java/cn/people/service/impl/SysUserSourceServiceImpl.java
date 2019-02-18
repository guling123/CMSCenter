package cn.people.service.impl;

import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SysUserSourceVO;
import cn.people.entity.SysUserSource;
import cn.people.mapper.SysUserSourceMapper;
import cn.people.service.ISysUserSourceService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户常用稿源表 服务实现类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-18
 */
@Service
public class SysUserSourceServiceImpl extends ServiceImpl<SysUserSourceMapper, SysUserSource> implements ISysUserSourceService {

    @Autowired
    SysUserSourceMapper sysUserSourceMapper;
    
    /*
    * Title: getSysUserSource
    * @author shidandan
    * @date 2018年12月20日 下午5:58:02 
    *Description: 
    * @return 
    * @see cn.people.service.ISysUserSourceService#getSysUserSource() 
    */
    @Override
    public List<SysUserSourceVO> getSysUserSource(String createrId)
    {
        
        //如果常用稿源已经被禁用需要排除出去
        return sysUserSourceMapper.getSysUserSource(createrId);
    }

}

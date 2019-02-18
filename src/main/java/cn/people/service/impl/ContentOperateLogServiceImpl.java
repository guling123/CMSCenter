package cn.people.service.impl;

import cn.people.controller.vo.ContentOperateLogVO;
import cn.people.entity.SysUser;
import cn.people.mapper.SysUserMapper;
import cn.people.remote.ContentOperateLogRemote;
import cn.people.service.IContentOperateLogService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * 内容操作记录表 服务实现类
 * </p>
 *
 * @author gaoyongjiu
 * @since 2018-12-04
 */
@Service
public class ContentOperateLogServiceImpl  implements IContentOperateLogService {

    @Autowired
    private ContentOperateLogRemote contentOperateLogRemote;
    
    /*
    * Title: getContentById
    * @author shidandan
    * @date 2018年12月26日 下午6:02:32 
    *Description: 
    * @param id
    * @return 
    * @see cn.people.service.IContentOperateLogService#getContentById(java.lang.String) 
    */
    @Override
    public List<ContentOperateLogVO> getContentById(String id)
    {
        return contentOperateLogRemote.getContentById(id).getData();
    }

}

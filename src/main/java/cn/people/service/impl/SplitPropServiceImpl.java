package cn.people.service.impl;

import cn.people.controller.vo.SplitProp;
import cn.people.remote.SplitRemote;
import cn.people.service.ISplitPropService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 碎片属性表对应原表TAG_PROP 服务实现类
 * </p>
 *
 * @author shidandan
 * @since 2019-01-07
 */
@Service
public class SplitPropServiceImpl  implements ISplitPropService {

    @Autowired
    private SplitRemote splitRemote;
    
    /**
    * Title: 查询所有模板碎片未添加的碎片属性
    * @author shidandan
    * @date 2019年1月22日 下午7:58:19 
    * @Description: 查询所有模板碎片未添加的碎片属性
    * @param splitId 碎片ID
    * @param modelSpiltId 模板碎片ID
    * @return 
    * @see cn.people.service.ISplitPropService#getSplitProp(java.lang.String, java.lang.String) 
    */
    @Override
    public List<SplitProp> getSplitProp(String splitId, String modelSpiltId)
    {
        return splitRemote.getSplitProp(splitId, modelSpiltId).getData();
    }

}

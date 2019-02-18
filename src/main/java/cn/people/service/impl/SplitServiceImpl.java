package cn.people.service.impl;

import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.Split;
import cn.people.remote.SplitRemote;
import cn.people.service.ISplitService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 碎片表 服务实现类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-19
 */
@Service
public class SplitServiceImpl implements ISplitService {

    @Autowired
    private SplitRemote splitRemote;
    /**
    * Title: 查询未被某个模板关联得碎片
    * @author shidandan
    * @date 2019年1月22日 下午2:08:25 
    * @Description: 查询未被某个模板关联得碎片
    * @param modelid 模板ID
    * @return 
    * @see cn.people.service.ISplitService#getSplit(java.lang.String) 
    */
    @Override
    public ResultVO<List<Split>> getSplit()
    {
        return splitRemote.getSplit();
    }

}

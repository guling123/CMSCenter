package cn.people.service.impl;

import cn.people.controller.vo.ModelTypeVO;
import cn.people.controller.vo.ResultVO;
import cn.people.remote.ModelTypeRemote;
import cn.people.service.IModelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author guling
 * @ClassName: IModelTypeServiceImpl
 * @Description: 模型种类实现类(这里用一句话描述这个类的作用)
 * @date 2019/1/22 10:11
 */
@Service
public class IModelTypeServiceImpl implements IModelTypeService
{

    @Autowired
    private ModelTypeRemote modelTypeRemote;
    /**
     *
     * @Title: 根据站点查询栏目信息 
     * @author shidandan
     * @date 2019年1月17日 下午5:00:46 
     * @Description: 根据站点查询栏目树
     * @param siteid 站点ID
     * @param orgid  租户ID
     * @return  参数说明 
     * @return ChannelTreeVO    返回类型 
     * @throws 
     */
    @Override
    public ResultVO<List<ModelTypeVO>> getModelTypeListBySiteId(String siteId)
    {
        return modelTypeRemote.getModelTypeListBySiteId(siteId);
    }
}

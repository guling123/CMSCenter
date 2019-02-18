package cn.people.service.impl;

import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SplitMod;
import cn.people.controller.vo.SplitModCreateVO;
import cn.people.remote.SplitModRemote;
import cn.people.service.ISplitModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author guling
 * @ClassName: ISplitModServiceImpl
 * @Description: ISplitModService实现类(这里用一句话描述这个类的作用)
 * @date 2019/1/18 18:04
 */
@Service
public class ISplitModServiceImpl implements ISplitModService
{

    @Autowired
    private SplitModRemote splitModRemote;

    /**
     *
     * @Title: getSplitMod 
     * @author shidandan
     * @date 2019年1月8日 上午10:01:48 
     * @Description: 查询所有得碎片方案
     * @param @return
     * @param @throws Exception  参数说明 
     * @return ResultVO<List<SplitMod>>    返回类型 
     * @throws 
     */
    @Override
    public ResultVO<List<SplitMod>> getSplitMod(String splitId)
    {
        return splitModRemote.getSplitMod(splitId);
    }

    /**
     *
     * @Title: 新增碎片方案 
     * @author shidandan
     * @date 2019年1月8日 上午10:07:55 
     * @Description: 新增碎片方案 
     * @param splitId 碎片id
     * @param SplitModCreateVO  碎片方案添加参数
     *  @throws Exception  
     * @return ResultVO<Boolean>    返回类结果集
     */
    @Override
    public ResultVO<Boolean> createSplitMod(String splitId, SplitModCreateVO createVO)
    {
        return splitModRemote.createSplitMod(splitId, createVO);
    }
}

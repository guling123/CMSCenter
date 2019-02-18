package cn.people.service;

import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SplitMod;
import cn.people.controller.vo.SplitModCreateVO;

import java.util.List;


/**
 * @author guling
 * @ClassName: SplitModService
 * @Description: splitmod接口
 * @date 2019/1/18 18:01
 */
public interface ISplitModService
{
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
    public ResultVO<List<SplitMod>> getSplitMod(String splitId);

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
    ResultVO<Boolean> createSplitMod(String splitId, SplitModCreateVO createVO);
}

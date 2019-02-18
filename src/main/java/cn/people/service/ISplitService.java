package cn.people.service;

import java.util.List;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.Split;

/**
 * <p>
 * 碎片表 服务类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-19
 */
public interface ISplitService{

    /**
     * 
    * @Title: 查询未被某个模板关联得碎片 
    * @author shidandan
    * @date 2019年1月22日 下午2:07:09 
    * @Description: 查询未被某个模板关联得碎片 
    * @param modelid 模板ID
    * @return  参数说明 
    * @return List<Split>    返回类型 
    * @throws 
     */
    ResultVO<List<Split>> getSplit();
}

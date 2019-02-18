package cn.people.service;

import java.util.List;
import cn.people.controller.vo.ContentOperateLogVO;

/**
 * <p>
 * 内容操作记录表 服务类
 * </p>
 *
 * @author gaoyongjiu
 * @since 2018-12-04
 */
public interface IContentOperateLogService {

    /**
     * 
    * @Title: getContentById 
    * @author shidandan
    * @date 2018年12月26日 下午6:02:15 
    * @Description: 查询内容得操作日志
    * @param @param id
    * @param @return  参数说明 
    * @return List<ContentOperateLogVO>    返回类型 
    * @throws 
     */
    List<ContentOperateLogVO> getContentById(String id);
}

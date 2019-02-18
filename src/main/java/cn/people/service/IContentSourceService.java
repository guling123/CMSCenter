package cn.people.service;

import cn.people.controller.vo.ContentSourceCreateVO;
import cn.people.controller.vo.ContentSourceListVO;
import cn.people.controller.vo.ContentSourceVO;
import cn.people.entity.ContentSource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 稿件来源表 服务类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-18
 */
public interface IContentSourceService extends IService<ContentSource> {

    /**
     * 
    * @Title: updateContentSource 
    * @author shidandan
    * @date 2018年12月18日 下午2:49:47 
    * @Description: 更新稿源信息
    * @param @param createVO
    * @param @param id
    * @param @return  参数说明 
    * @return Boolean    返回类型 
     * @throws Exception 
    * @throws 
     */
    Boolean updateContentSource(ContentSourceCreateVO createVO,String id) throws Exception;
    
    /**
     * 
    * @Title: getContentSourcePaged 
    * @author shidandan
    * @date 2018年12月18日 下午3:21:10 
    * @Description: 分页查询稿源信息 
    * @param @param listVO
    * @param @return  参数说明 
    * @return IPage<ContentSource>    返回类型 
    * @throws 
     */
    IPage<ContentSourceVO> getContentSourcePaged(ContentSourceListVO listVO);
    
    /**
     * 
    * @Title: updateContentSourceStatus 
    * @author shidandan
    * @date 2018年12月18日 下午3:28:08 
    * @Description: 启用或禁用稿源
    * @param @param id
    * @param @param status 1启用 0禁用
    * @param @return  参数说明 
    * @return Boolean    返回类型 
     * @throws Exception 
    * @throws 
     */
    Boolean updateContentSourceStatus(String id,Integer status) throws Exception;
    
    /**
     * 
    * @Title: createContentSource 
    * @author shidandan
    * @date 2018年12月20日 下午5:46:08 
    * @Description: 创建稿源 
    * @param @param createVO
    * @param @return  参数说明 
    * @return Boolean    返回类型 
     * @throws Exception 
    * @throws 
     */
    Boolean createContentSource(ContentSourceCreateVO createVO,String createrid) throws Exception;
    
}

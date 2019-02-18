package cn.people.service;

import cn.people.controller.vo.SiteCreateVO;
import cn.people.controller.vo.SiteVO;
import cn.people.entity.Site;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 站点信息表 服务类
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
public interface ISiteService extends IService<Site> {

    /**
     * 
    * @Title: createSite 
    * @author shidandan
    * @date 2018年12月12日 下午7:05:41 
    * @Description: 初始化站点信息
    * @param @param site
    * @param @return  参数说明 
    * @return Boolean    返回类型 
     * @throws Exception 
    * @throws 
     */
    Boolean createSite(SiteCreateVO site,String createrid,String orgid) throws Exception;
    
    /**
     * 
    * @Title: getSiteList 
    * @author shidandan
    * @date 2018年12月17日 下午3:53:10 
    * @Description: 查询租户下的站点信息
    * @param @param orgid
    * @param @return  参数说明 
    * @return List<Site>    返回类型 
    * @throws 
     */
    List<SiteVO> getSiteList(String orgid);
    
    /**
     * 
    * @Title: updateSite 
    * @author shidandan
    * @date 2018年12月17日 下午4:04:34 
    * @Description: 更新站点信息
    * @param @param id
    * @param @param site
    * @param @return  参数说明 
    * @return Boolean    返回类型 
     * @throws Exception 
    * @throws 
     */
    Boolean updateSite(String id,SiteCreateVO site) throws Exception;

}

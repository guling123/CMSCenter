/**   
* @Title: ImageRemote.java 
* @Package cn.people.remote 
* @Description: 图片服务远程调用
* @author shidandan
* @date 2018年12月12日 下午7:15:13 
* @version V1.0   
*/
package cn.people.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.people.controller.vo.ResultVO;
import cn.people.entity.Site;

/** 
* @ClassName: ImageRemote 
* @Description: 图片服务远程调用
* @author shidandan
* @date 2018年12月12日 下午7:15:13 
*  
*/
@FeignClient("imageService")
public interface ImageRemote
{

    /**
     * 
    * @Title: createSite 
    * @author shidandan
    * @date 2018年12月12日 下午3:11:41 
    * @Description: 同步站点信息到内容服务
    * @param @param param  参数说明 
    * @return void    返回类型 
    * @throws 
     */
    @RequestMapping(method = RequestMethod.POST, value = "/site/init", consumes = "application/json")
    ResultVO<Boolean> createSite(Site param);
    
    /**
     * 
    * @Title: updateSite 
    * @author shidandan
    * @date 2018年12月17日 下午4:34:11 
    * @Description: 更新站点 
    * @param @param param
    * @param @return  参数说明 
    * @return Boolean    返回类型 
    * @throws 
     */
    @RequestMapping(method = RequestMethod.POST, value = "/site/update", consumes = "application/json")
    ResultVO<Boolean> updateSite(Site param);


}

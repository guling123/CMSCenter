package cn.people.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import cn.people.commons.utils.SessionUtil;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SessionUser;
import cn.people.controller.vo.SiteCreateVO;
import cn.people.controller.vo.SiteVO;
import cn.people.entity.Site;
import cn.people.service.ISiteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


/**
 * <p>
 * 站点信息表 前端控制器
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@RestController
@RequestMapping("/site")
@Api(value = "站点信息管理", description = "站点信息管理")
public class SiteController {

    @Autowired
    private ISiteService iSiteService;
    
    /**
     * 
    * @Title: createSite 
    * @author shidandan
    * @date 2018年12月12日 下午5:52:07 
    * @Description: 初始化站点信息
    * @param @param site
    * @param @return  参数说明 
    * @return String    返回类型 
     * @throws Exception 
    * @throws 
     */
    @ApiOperation(value = "初始化站点信息", notes = "初始化站点信息")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultVO<Boolean> createSite(@RequestBody SiteCreateVO site) throws Exception {
        
      SessionUser user=SessionUtil.getUserPrincipal();
      String createrid = user.getUserId();
      return ResultVO.ok(iSiteService.createSite(site,createrid,user.getTenantId()));  
    }
    
    /**
     * 
    * @Title: getSitePaged 
    * @author shidandan
    * @date 2018年12月12日 下午5:53:37 
    * @Description: 查询站点信息
    * @param @param site
    * @param @return  参数说明 
    * @return String    返回类型 
     * @throws Exception 
    * @throws 
     */
    @ApiOperation(value = "查询站点信息", notes = "查询站点信息")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultVO<List<SiteVO>> getSiteList(HttpServletRequest request) throws Exception {
      //获取租户IP从登陆信息种
      SessionUser sessionUser=SessionUtil.getUserPrincipal();
      String orgid=sessionUser.getTenantId();
      return ResultVO.ok(iSiteService.getSiteList(orgid));
    }
    
    /**
     * 
    * @Title: updateSite 
    * @author shidandan
    * @date 2018年12月12日 下午6:45:35 
    * @Description: 更新站点信息 
    * @param @param model
    * @param @param request
    * @param @param id
    * @param @return  参数说明 
    * @return String    返回类型 
     * @throws Exception 
    * @throws 
     */
    @ApiOperation(value = "更新站点信息", notes = "更新站点信息")
    @RequestMapping(value = "/{id}/update",method = RequestMethod.PUT)
    public ResultVO<Boolean> updateSite(HttpServletRequest request,@PathVariable String id,@RequestBody SiteCreateVO  site) throws Exception {

        return ResultVO.ok(iSiteService.updateSite(id, site));  
    }
    
    /**
     * 
    * @Title: getSite 
    * @author shidandan
    * @date 2018年12月12日 下午6:48:22 
    * @Description: 获取站点详情
    * @param @param model
    * @param @param request
    * @param @param id
    * @param @return  参数说明 
    * @return Site    返回类型 
    * @throws 
     */
    @ApiOperation(value = "获取站点详情", notes = "获取站点详情")
    @ApiImplicitParam(name = "id", value = "id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/{id}/detail",method = RequestMethod.GET)
    public ResultVO<Site> getSite(HttpServletRequest request,@PathVariable String id) {

        if(StringUtils.isEmpty(id)) {
            return null;
        }
        return ResultVO.ok(iSiteService.getById(id));  
    }
}

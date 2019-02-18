package cn.people.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.people.controller.vo.ResultVO;
import cn.people.entity.SysResource;
import cn.people.service.ISysResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 管理资源表 前端控制器
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@RestController
@RequestMapping("/resource")
@Api(value = "资源管理", description = "资源管理")
public class SysResourceController {

    @Autowired
    private ISysResourceService iSysResourceService;
    
    /**
     * 
    * @Title: 查询所有权限信息 
    * @author shidandan
    * @date 2019年1月18日 下午5:55:19 
    * @Description: 查询所有权限信息 
    * @return 返回所有权限信息
    * @throws Exception  参数说明 
    * @return ResultVO<List<SysResource>>    返回类型 
    * @throws 
     */
    @ApiOperation(value = "查询资源信息", notes = "查询资源信息")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultVO<List<SysResource>> getSysResourceList() throws Exception {
        
      return ResultVO.ok(iSysResourceService.list());  
    }
}

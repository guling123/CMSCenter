package cn.people.controller;

import java.util.List;

import cn.people.service.ISplitModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.people.commons.utils.SessionUtil;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SessionUser;
import cn.people.controller.vo.SplitMod;
import cn.people.controller.vo.SplitModCreateVO;
import cn.people.remote.SplitModRemote;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 碎片方案表对应原表TAG_MOD 前端控制器
 * </p>
 *
 * @author shidandan
 * @since 2019-01-07
 */
@RestController
@RequestMapping("/split/mod")
@Api(value = "碎片方案管理", description = "碎片方案管理")
public class SplitModController {

    @Autowired
    private ISplitModService iSplitModService;
    /**
     * 
    * @Title: 查询所有得碎片方案 
    * @author shidandan
    * @date 2019年1月8日 上午10:01:48 
    * @Description: 查询所有得碎片方案
    * @param String 碎片id
    * @throws Exception  参数说明 
    * @return ResultVO<List<SplitMod>>    返回类结果集
    * @throws 
     */
    @ApiOperation(value = "查询所有得碎片方案", notes = "查询所有得碎片方案")
    @RequestMapping(value ="/{splitId}/list", method = RequestMethod.GET)
    public ResultVO<List<SplitMod>> getSplitMod(@PathVariable(value="splitId")String splitId) throws Exception{
        
        return iSplitModService.getSplitMod(splitId);
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
    @ApiOperation(value = "新增碎片方案", notes = "新增碎片方案")
    @RequestMapping(value ="/{splitId}/add", method = RequestMethod.POST)
    public ResultVO<Boolean> createSplitMod(@PathVariable(value="splitId")String splitId,@RequestBody SplitModCreateVO createVO) throws Exception{
        
        SessionUser user=SessionUtil.getUserPrincipal();
        String createrid = user.getUserId();
        createVO.setCreateId(createrid);
        return iSplitModService.createSplitMod(splitId, createVO);

    }
}

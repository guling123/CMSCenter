/**   
* @Title: UserChannelRemote.java 
* @Package cn.people.remote 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2019年1月28日 下午2:07:19 
* @version V1.0   
*/
package cn.people.remote;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.people.commons.constants.CodeConstants;
import cn.people.controller.vo.ResultVO;
import cn.people.controller.vo.SysUserChannelVO;
import cn.people.controller.vo.UserChannelListResultVO;
import cn.people.controller.vo.UserChannelVO;
import cn.people.entity.SysUserChannel;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/** 
* @ClassName: UserChannelRemote 
* @Description: 用户常用栏目 
* @author shidandan
* @date 2019年1月28日 下午2:07:19 
*  
*/
@FeignClient("contentService")
public interface UserChannelRemote
{
    @RequestMapping(value = "/user/channel/add",method = RequestMethod.POST)
    ResultVO<Boolean> createSysUserChannel(@Valid @RequestBody UserChannelVO createVO);
    
    @RequestMapping(value = "/user/channel/{id}/del",method = RequestMethod.GET)
    ResultVO<Boolean> delSysUserChannel(@PathVariable(value="id") String id);

    @RequestMapping(value = "/user/channel/{userId}/list",method = RequestMethod.GET)
    ResultVO<List<UserChannelListResultVO>> getSysUserChannel(@PathVariable(value="userId") String userId);
      

}

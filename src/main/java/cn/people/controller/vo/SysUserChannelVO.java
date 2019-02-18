/**   
* @Title: SysUserChannelVo.java 
* @Package cn.people.controller.vo 
* @Description: 账户组人员信息 
* @author shidandan
* @date 2018年12月17日 下午7:32:54 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysUserChannelVo 
* @Description: 账户组人员信息 
* @author shidandan
* @date 2018年12月17日 下午7:32:54 
*  
*/
@ApiModel(value = "账户组人员信息", description = "账户组人员信息")
public class SysUserChannelVO implements Serializable
{

    private static final long serialVersionUID = 280178255385343186L;

    @ApiModelProperty(value = "用户ID集合")
    private List<String> userIds;

    public List<String> getUserIds()
    {
        return userIds;
    }

    public void setUserIds(List<String> userIds)
    {
        this.userIds = userIds;
    }
    
}

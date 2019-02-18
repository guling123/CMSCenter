/**   
* @Title: SysUserChannelListVO.java 
* @Package cn.people.controller.vo 
* @Description: 账户组配置账户结果 
* @author shidandan
* @date 2018年12月20日 下午6:57:10 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysUserChannelListVO 
* @Description: 账户组配置账户结果
* @author shidandan
* @date 2018年12月20日 下午6:57:10 
*  
*/
@ApiModel(value = "账户组配置账户结果", description = "账户组配置账户结果")
public class SysUserChannelListVO implements Serializable
{
    private static final long serialVersionUID = 3454022279090505406L;

    @ApiModelProperty(value = "已关联账户组得用户集合")
    private List<SysUserVO> userChannelList;
    
    @ApiModelProperty(value = "未关联账户组得用户集合")
    private List<SysUserVO> userList;

    public List<SysUserVO> getUserChannelList()
    {
        return userChannelList;
    }

    public void setUserChannelList(List<SysUserVO> userChannelList)
    {
        this.userChannelList = userChannelList;
    }

    public List<SysUserVO> getUserList()
    {
        return userList;
    }

    public void setUserList(List<SysUserVO> userList)
    {
        this.userList = userList;
    }
    
}

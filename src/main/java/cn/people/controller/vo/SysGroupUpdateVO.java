/**   
* @Title: SysGroupUpdateVO.java 
* @Package cn.people.controller.vo 
* @Description: 更新账户组参数
* @author shidandan
* @date 2018年12月18日 下午4:42:30 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysGroupUpdateVO 
* @Description: 更新账户组参数
* @author shidandan
* @date 2018年12月18日 下午4:42:30 
*  
*/
@ApiModel(value = "更新账户组参数", description = "更新账户组参数")
public class SysGroupUpdateVO implements Serializable
{
    private static final long serialVersionUID = -7555655947682159176L;

    @ApiModelProperty(value = "管理组名称")
    private String groupname;
    
    @ApiModelProperty(value = "管理组描述")
    private String description;
    
    @ApiModelProperty(value = "栏目信息")
    private List<String> channelIds;

    public String getGroupname()
    {
        return groupname;
    }

    public void setGroupname(String groupname)
    {
        this.groupname = groupname;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<String> getChannelIds()
    {
        return channelIds;
    }

    public void setChannelIds(List<String> channelIds)
    {
        this.channelIds = channelIds;
    }
}

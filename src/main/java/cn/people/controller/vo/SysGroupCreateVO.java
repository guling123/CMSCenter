/**   
* @Title: SysGroupCreateVO.java 
* @Package cn.people.controller.vo 
* @Description: 增加账户组参数 
* @author shidandan
* @date 2018年12月17日 下午5:10:14 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysGroupCreateVO 
* @Description: 增加账户组参数
* @author shidandan
* @date 2018年12月17日 下午5:10:14 
*  
*/
@ApiModel(value = "增加账户组参数", description = "增加账户组参数")
public class SysGroupCreateVO implements Serializable
{

    private static final long serialVersionUID = 4201426415190050269L;
    
    @NotBlank(message="站点id不能为空")
    @ApiModelProperty(value = "站点id")
    private String siteid;

    @NotBlank(message="管理组名称不能为空")
    @ApiModelProperty(value = "管理组名称")
    private String groupname;
    
    @ApiModelProperty(value = "管理组描述")
    private String description;
    
    @ApiModelProperty(value = "栏目信息")
    private List<String> channelIds;

    public String getSiteid()
    {
        return siteid;
    }

    public void setSiteid(String siteid)
    {
        this.siteid = siteid;
    }

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

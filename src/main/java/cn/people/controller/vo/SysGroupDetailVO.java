/**   
* @Title: SysGroupDetailVO.java 
* @Package cn.people.controller.vo 
* @Description: 账户组详情 
* @author shidandan
* @date 2018年12月17日 下午5:21:30 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysGroupDetailVO 
* @Description: 账户组详情
* @author shidandan
* @date 2018年12月17日 下午5:21:30 
*  
*/
@ApiModel(value = "账户组详情", description = "账户组详情")
public class SysGroupDetailVO implements Serializable
{

    private static final long serialVersionUID = -2962107496010609403L;
    @ApiModelProperty(value = "管理组id")
    private String id;
    
    @ApiModelProperty(value = "站点id")
    private String siteid;

    @ApiModelProperty(value = "管理组名称")
    private String groupname;
    
    @ApiModelProperty(value = "管理组描述")
    private String description;
    
    @ApiModelProperty(value = "栏目集合")
    private Set<String> channelList;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

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

    public Set<String> getChannelList()
    {
        return channelList;
    }

    public void setChannelList(Set<String> channelList)
    {
        this.channelList = channelList;
    }
    
}

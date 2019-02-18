/**   
* @Title: SysUserListParamVO.java 
* @Package cn.people.controller.vo 
* @Description: 账户列表查询mapper参数 
* @author shidandan
* @date 2018年12月29日 上午9:58:06 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.util.Date;
import java.util.Set;

import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysUserListParamVO 
* @Description: 账户列表查询mapper参数
* @author shidandan
* @date 2018年12月29日 上午9:58:06 
*  
*/
public class SysUserListParamVO extends PageVO
{

    private static final long serialVersionUID = 1191352297957222019L;
    
    @ApiModelProperty(value = "关键字")
    private String key;
    
    @ApiModelProperty(value = "真实姓名")
    private String realname;

    @ApiModelProperty(value = "用户状态,0禁用 , 1启用")
    private Integer dstatus;

    @ApiModelProperty(value = "角色id")
    private String roleid;
    
    @ApiModelProperty(value = "账户组id")
    private String groupid;

    @ApiModelProperty(value = "创建人")
    private Set<String> createrids;
    
    @ApiModelProperty(value = "租户id")
    private String orgid;
    
    @ApiModelProperty(value = "站点id")
    private String siteid;
    
    @ApiModelProperty(value = "创建开始时间")
    private Date createBeginTime;
    
    @ApiModelProperty(value = "创建结束时间")
    private Date createEndTime;
    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getRealname()
    {
        return realname;
    }

    public void setRealname(String realname)
    {
        this.realname = realname;
    }

    public Integer getDstatus()
    {
        return dstatus;
    }

    public void setDstatus(Integer dstatus)
    {
        this.dstatus = dstatus;
    }

    public String getRoleid()
    {
        return roleid;
    }

    public void setRoleid(String roleid)
    {
        this.roleid = roleid;
    }

    public String getGroupid()
    {
        return groupid;
    }

    public void setGroupid(String groupid)
    {
        this.groupid = groupid;
    }

    public Set<String> getCreaterids()
    {
        return createrids;
    }

    public void setCreaterids(Set<String> createrids)
    {
        this.createrids = createrids;
    }

    public String getOrgid()
    {
        return orgid;
    }

    public void setOrgid(String orgid)
    {
        this.orgid = orgid;
    }

    public String getSiteid()
    {
        return siteid;
    }

    public void setSiteid(String siteid)
    {
        this.siteid = siteid;
    }

    public Date getCreateBeginTime()
    {
        return createBeginTime;
    }

    public void setCreateBeginTime(Date createBeginTime)
    {
        this.createBeginTime = createBeginTime;
    }

    public Date getCreateEndTime()
    {
        return createEndTime;
    }

    public void setCreateEndTime(Date createEndTime)
    {
        this.createEndTime = createEndTime;
    }
}

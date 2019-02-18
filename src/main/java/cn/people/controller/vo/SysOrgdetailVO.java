package cn.people.controller.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * @author guling
 * @ClassName: SysOrgdetailVO
 * @Description: 超管详情返回VO
 * @date 2019/2/1 9:22
 */
public class SysOrgdetailVO implements Serializable
{

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "用户ID")
    private String userid;

    @ApiModelProperty(value = "登录用户名")
    private String username;

    @ApiModelProperty(value = "真实姓名")
    private String realname;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    @ApiModelProperty(value = "最后登录时间")
    private Date lastlogintime;

    @ApiModelProperty(value = "创建人id")
    private String createrid;

    @ApiModelProperty(value = "角色id")
    private String roleid;

    @ApiModelProperty(value = "租户id")
    private String orgid;

    @ApiModelProperty(value = "用户状态,0禁用 , 1启用")
    private String dstatus;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUserid()
    {
        return userid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getRealname()
    {
        return realname;
    }

    public void setRealname(String realname)
    {
        this.realname = realname;
    }

    public Date getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(Date createtime)
    {
        this.createtime = createtime;
    }

    public Date getLastlogintime()
    {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime)
    {
        this.lastlogintime = lastlogintime;
    }

    public String getCreaterid()
    {
        return createrid;
    }

    public void setCreaterid(String createrid)
    {
        this.createrid = createrid;
    }

    public String getRoleid()
    {
        return roleid;
    }

    public void setRoleid(String roleid)
    {
        this.roleid = roleid;
    }

    public String getOrgid()
    {
        return orgid;
    }

    public void setOrgid(String orgid)
    {
        this.orgid = orgid;
    }

    public String getDstatus()
    {
        return dstatus;
    }

    public void setDstatus(String dstatus)
    {
        this.dstatus = dstatus;
    }

    @Override public String toString()
    {
        return "SysOrgdetailVO{" + "id='" + id + '\'' + ", userid='" + userid + '\''
               + ", username='" + username + '\'' + ", realname='" + realname + '\''
               + ", createtime=" + createtime + ", lastlogintime=" + lastlogintime
               + ", createrid='" + createrid + '\'' + ", roleid='" + roleid + '\'' + ", orgid='"
               + orgid + '\'' + ", dstatus='" + dstatus + '\'' + '}';
    }
}

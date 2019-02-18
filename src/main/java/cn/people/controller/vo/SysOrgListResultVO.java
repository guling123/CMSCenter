/**   
* @Title: SysOrgListResultVO.java 
* @Package cn.people.controller.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2018年12月13日 下午2:38:36 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;

import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysOrgListResultVO 
* @Description: 租户分页查询结果集
* @author shidandan
* @date 2018年12月13日 下午2:38:36 
*  
*/
public class SysOrgListResultVO implements Serializable
{

    private static final long serialVersionUID = -6781244505407083540L;

    @ApiModelProperty(value = "查询租户详情，更新租户信息需要此id")
    private String id;
    
    @ApiModelProperty(value = "列表展示需要，租户数字id")
    private String orgid;
    
    @ApiModelProperty(value = "租户名称")
    private String orgname;
    
    @ApiModelProperty(value = "状态，0禁用，1可用")
    private Integer dtatus;
    
    @ApiModelProperty(value = "租户描述")
    private String description;
    
    @ApiModelProperty(value = "创建时间")
    @TableField("createtime")
    private Date createtime;

    @ApiModelProperty(value = "创建人")
    @TableField("creatername")
    private String creatername;


    public String getId()
    {
        return id;
    }

    public String getOrgid()
    {
        return orgid;
    }

    public void setOrgid(String orgid)
    {
        this.orgid = orgid;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getOrgname()
    {
        return orgname;
    }

    public void setOrgname(String orgname)
    {
        this.orgname = orgname;
    }

    public Integer getDtatus()
    {
        return dtatus;
    }

    public void setDtatus(Integer dtatus)
    {
        this.dtatus = dtatus;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(Date createtime)
    {
        this.createtime = createtime;
    }

    public String getCreatername()
    {
        return creatername;
    }

    public void setCreatername(String creatername)
    {
        this.creatername = creatername;
    }

}

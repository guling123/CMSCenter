/**   
* @Title: SysGroupListVO.java 
* @Package cn.people.controller.vo 
* @Description: 账户组列表查询 
* @author shidandan
* @date 2019年1月2日 下午2:12:40 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysGroupListVO 
* @Description: 账户组列表查询 
* @author shidandan
* @date 2019年1月2日 下午2:12:40 
*  
*/
@ApiModel(value="账户组列表查询", description="账户组列表查询")
public class SysGroupListVO implements Serializable
{

    private static final long serialVersionUID = 441762316162382892L;
    
    @ApiModelProperty(value = "账户组id")
    private String id;
    
    @ApiModelProperty(value = "站点id")
    private String siteid;

    @ApiModelProperty(value = "管理组名称")
    private String groupname;
    
    @ApiModelProperty(value = "管理组描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    @ApiModelProperty(value = "创建人")
    private String creatername;

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

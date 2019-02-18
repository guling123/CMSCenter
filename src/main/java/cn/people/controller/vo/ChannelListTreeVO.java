package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(value = "栏目树查询", description = "栏目树查询")
public class ChannelListTreeVO implements Serializable{

    private static final long serialVersionUID = -707847564457723174L;
    @ApiModelProperty(value = "栏目名称")
    private String channelName;

    @ApiModelProperty(value = "栏目id")
    private String id;
    
    @ApiModelProperty(value = "逻辑ID 4 位数值，100000起,站点ID内不重复 （暂时不用）")
    private Integer logicId;

    @ApiModelProperty(value = "父栏目id")
    private String parentId;

    @ApiModelProperty(value = "栏目类型 ，1 栏目，2专题")
    private Integer dtype;

    @ApiModelProperty(value = "栏目显示，0隐藏，1显示")
    private Integer display;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人id")
    private String createrId;
    
    @ApiModelProperty(value = "创建人姓名")
    private String createrName;
    
    @ApiModelProperty(value = "是否有权限")
    private Boolean isPermission;

    @ApiModelProperty(value = "下级节点列表") List<ChannelListTreeVO> children =new ArrayList<>();


    public Integer getLogicId()
    {
        return logicId;
    }

    public Boolean getIsPermission()
    {
        return isPermission;
    }

    public void setIsPermission(Boolean isPermission)
    {
        this.isPermission = isPermission;
    }

    public void setLogicId(Integer logicId)
    {
        this.logicId = logicId;
    }

    public String getCreaterName()
    {
        return createrName;
    }

    public void setCreaterName(String createrName)
    {
        this.createrName = createrName;
    }

    public Integer getDtype()
    {
        return dtype;
    }

    public void setDtype(Integer dtype)
    {
        this.dtype = dtype;
    }

    public Integer getDisplay()
    {
        return display;
    }

    public void setDisplay(Integer display)
    {
        this.display = display;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getCreaterId()
    {
        return createrId;
    }

    public void setCreaterId(String createrId)
    {
        this.createrId = createrId;
    }

    public String getChannelName()
    {
        return channelName;
    }

    public void setChannelName(String channelName)
    {
        this.channelName = channelName;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getParentId()
    {
        return parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    public List<ChannelListTreeVO> getChildren()
    {
        return children;
    }

    public void setChildren(List<ChannelListTreeVO> children)
    {
        this.children = children;
    }
    
}


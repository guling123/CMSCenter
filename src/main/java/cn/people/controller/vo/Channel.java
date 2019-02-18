package cn.people.controller.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.people.entity.BaseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 栏目信息表
 * </p>
 *
 * @author shidandan
 * @since 2019-01-07
 */
@ApiModel(value="Channel对象", description="栏目信息表")
public class Channel implements Serializable {

    /** 
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
    */ 
    private static final long serialVersionUID = -3845288402888377360L;

    @ApiModelProperty(value = "站点id")
    private String siteid;
    
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "逻辑ID 4 位数值，100000起,站点ID内不重复 （暂时不用）")
    private Integer logicId;

    @ApiModelProperty(value = "栏目名称")
    private String channelName;

    @ApiModelProperty(value = "栏目标识")
    private String ident;

    @ApiModelProperty(value = "栏目类型 ，1 栏目，2专题")
    private Integer dtype;

    @ApiModelProperty(value = "父栏目id")
    @TableField("parent_id")
    private String parentId;
    
    @ApiModelProperty(value = "父栏目id字符串")
    @TableField("parent_string")
    private String parentString;

    public String getSiteid() {
        return siteid;
    }


    public String getId()
    {
        return id;
    }


    public void setId(String id)
    {
        this.id = id;
    }


    public Channel setSiteid(String siteid) {
        this.siteid = siteid;
        return this;
    }
    public Integer getLogicId() {
        return logicId;
    }

    public Channel setLogicId(Integer logicId) {
        this.logicId = logicId;
        return this;
    }
    public String getChannelName() {
        return channelName;
    }

    public Channel setChannelName(String channelName) {
        this.channelName = channelName;
        return this;
    }
    public String getIdent() {
        return ident;
    }

    public Channel setIdent(String ident) {
        this.ident = ident;
        return this;
    }
    public Integer getDtype() {
        return dtype;
    }

    public Channel setDtype(Integer dtype) {
        this.dtype = dtype;
        return this;
    }
    
    public String getParentId() {
        return parentId;
    }

    public Channel setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getParentString()
    {
        return parentString;
    }

    public void setParentString(String parentString)
    {
        this.parentString = parentString;
    }

    @Override
    public String toString() {
        return "Channel{" +
               "siteid=" + siteid +
               ", logicId=" + logicId +
               ", channelName=" + channelName +
               ", ident=" + ident +
               ", dtype=" + dtype +
               ", parentId=" + parentId +
               ", parentString=" + parentString +
               "}";
    }
}

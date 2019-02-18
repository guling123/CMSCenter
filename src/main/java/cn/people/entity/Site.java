package cn.people.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.people.entity.BaseEntity;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 站点信息表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@TableName("tb_site")
@ApiModel(value="Site对象", description="站点信息表")
public class Site extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "站点名称")
    @TableField("sitename")
    private String sitename;

    @ApiModelProperty(value = "站点名称")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "域名")
    @TableField("domain")
    private String domain;

    @ApiModelProperty(value = "创建时间")
    @TableField("createtime")
    private Date createtime;

    @ApiModelProperty(value = "创建人")
    @TableField("createrid")
    private String createrid;

    @ApiModelProperty(value = "租户id")
    @TableField("orgid")
    private String orgid;

    public String getSitename() {
        return sitename;
    }

    public Site setSitename(String sitename) {
        this.sitename = sitename;
        return this;
    }
    public String getDescription() {
        return description;
    }

    public Site setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getDomain() {
        return domain;
    }

    public Site setDomain(String domain) {
        this.domain = domain;
        return this;
    }
    
    public Date getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(Date createtime)
    {
        this.createtime = createtime;
    }

    public String getCreaterid() {
        return createrid;
    }

    public Site setCreaterid(String createrid) {
        this.createrid = createrid;
        return this;
    }
    public String getOrgid() {
        return orgid;
    }

    public Site setOrgid(String orgid) {
        this.orgid = orgid;
        return this;
    }

    @Override
    public String toString() {
        return "Site{" +
        "sitename=" + sitename +
        ", description=" + description +
        ", domain=" + domain +
        ", createtime=" + createtime +
        ", createrid=" + createrid +
        ", orgid=" + orgid +
        "}";
    }
}

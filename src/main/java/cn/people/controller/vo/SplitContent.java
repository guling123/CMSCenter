package cn.people.controller.vo;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 碎片内容表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-19
 */
@ApiModel(value="SplitContent对象", description="碎片内容表")
public class SplitContent implements Serializable {

    private static final long serialVersionUID = 369768081420134558L;
    @ApiModelProperty(value = "id")
    private String id;
    
    @ApiModelProperty(value = "碎片id")
    private String splitid;

    @ApiModelProperty(value = "显示标题")
    private String showtitle;

    @ApiModelProperty(value = "内容类型,1内容,2外联")
    private Integer dtype;

    @ApiModelProperty(value = "内容id")
    private String contentid;

    @ApiModelProperty(value = "添加时间")
    private Date createtime;

    @ApiModelProperty(value = "排序")
    private Integer subindex;

    @ApiModelProperty(value = "添加人id")
    private String createrid;

    @ApiModelProperty(value = "外联地址")
    private String href;
    
    @ApiModelProperty(value = "缩略图")
    private String thumbnail;

    @ApiModelProperty(value = "状态，0删除，1显示")
    @TableField("dstatus")
    private Integer dstatus;

    @ApiModelProperty(value = "置顶，0未置顶，1置顶")
    @TableField("tops")
    private Integer tops;


    public String getSplitid() {
        return splitid;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public SplitContent setSplitid(String splitid) {
        this.splitid = splitid;
        return this;
    }
    public String getShowtitle() {
        return showtitle;
    }

    public String getThumbnail()
    {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public SplitContent setShowtitle(String showtitle) {
        this.showtitle = showtitle;
        return this;
    }
    public Integer getDtype() {
        return dtype;
    }

    public SplitContent setDtype(Integer dtype) {
        this.dtype = dtype;
        return this;
    }
    public String getContentid() {
        return contentid;
    }

    public SplitContent setContentid(String contentid) {
        this.contentid = contentid;
        return this;
    }
    public Date getCreatetime() {
        return createtime;
    }

    public SplitContent setCreatetime(Date createtime) {
        this.createtime = createtime;
        return this;
    }
    public Integer getSubindex() {
        return subindex;
    }

    public SplitContent setSubindex(Integer subindex) {
        this.subindex = subindex;
        return this;
    }
    public String getCreaterid() {
        return createrid;
    }

    public SplitContent setCreaterid(String createrid) {
        this.createrid = createrid;
        return this;
    }
    public String getHref() {
        return href;
    }

    public SplitContent setHref(String href) {
        this.href = href;
        return this;
    }
    public Integer getDstatus() {
        return dstatus;
    }

    public SplitContent setDstatus(Integer dstatus) {
        this.dstatus = dstatus;
        return this;
    }
    public Integer getTops() {
        return tops;
    }

    public SplitContent setTops(Integer tops) {
        this.tops = tops;
        return this;
    }
    @Override
    public String toString() {
        return "SplitContent{" +
        "splitid=" + splitid +
        ", showtitle=" + showtitle +
        ", dtype=" + dtype +
        ", contentid=" + contentid +
        ", createtime=" + createtime +
        ", subindex=" + subindex +
        ", createrid=" + createrid +
        ", href=" + href +
        ", dstatus=" + dstatus +
        ", tops=" + tops +
        "}";
    }
}

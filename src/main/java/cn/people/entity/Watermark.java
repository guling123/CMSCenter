package cn.people.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * <p>
 * 水印信息表
 * </p>
 *
 * @author shidandan
 * @since 2018-11-29
 */
@ApiModel(value="TbWatermark对象", description="水印信息表")
@TableName(value="tb_watermark")
public class Watermark extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "站点id")
    @TableField("siteid")
    private String siteid;

    @ApiModelProperty(value = "状态。0默认，1备选，2删除")
    @TableField("dstatus")
    private Integer dstatus;

    @ApiModelProperty(value = "水印类型。1图片水印，2文字水印")
    @TableField("dtype")
    private Integer dtype;

    @ApiModelProperty(value = "水印内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "水印地址")
    @TableField("filepath")
    private String filepath;

    @ApiModelProperty(value = "水印位置，1右下，2左下，3左上，4右上，5中间，6平铺")
    @TableField("position")
    private Integer position;

    @ApiModelProperty(value = "水印透明度。百分比")
    @TableField("opac")
    private Integer opac;

    public String getSiteid() {
        return siteid;
    }

    public Watermark setSiteid(String siteid) {
        this.siteid = siteid;
        return this;
    }
    public Integer getDstatus() {
        return dstatus;
    }

    public Watermark setDstatus(Integer dstatus) {
        this.dstatus = dstatus;
        return this;
    }
    public Integer getDtype() {
        return dtype;
    }

    public Watermark setDtype(Integer dtype) {
        this.dtype = dtype;
        return this;
    }
    public String getContent() {
        return content;
    }

    public Watermark setContent(String content) {
        this.content = content;
        return this;
    }
    public String getFilepath() {
        return filepath;
    }

    public Watermark setFilepath(String filepath) {
        this.filepath = filepath;
        return this;
    }
    public Integer getPosition() {
        return position;
    }

    public Watermark setPosition(Integer position) {
        this.position = position;
        return this;
    }
    public Integer getOpac() {
        return opac;
    }

    public Watermark setOpac(Integer opac) {
        this.opac = opac;
        return this;
    }

    @Override
    public String toString() {
        return "TbWatermark{" +
        "siteid=" + siteid +
        ", dstatus=" + dstatus +
        ", dtype=" + dtype +
        ", content=" + content +
        ", filepath=" + filepath +
        ", position=" + position +
        ", opac=" + opac +
        "}";
    }
}

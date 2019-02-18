package cn.people.entity;

import cn.people.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 处理图片表
 * </p>
 *
 * @author shidandan
 * @since 2018-11-29
 */
@ApiModel(value="TbImage对象", description="处理图片表")
@TableName(value="tb_image")
public class Image extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "原始图id")
    @TableField("oriid")
    private String oriid;
    
    @ApiModelProperty(value = "内容id")
    @TableField("contentid")
    private String contentid;
    
    
    @ApiModelProperty(value = "文件位置")
    @TableField("filepath")
    private String filepath;

    @ApiModelProperty(value = "处理方式，位记录。0位是否水印，1位是否裁剪，2位是否缩略")
    @TableField("dealtype")
    private Integer dealtype;

    @ApiModelProperty(value = "水印id")
    @TableField("wmid")
    private String wmid;

    @ApiModelProperty(value = "宽度")
    @TableField("wight")
    private Integer wight;

    @ApiModelProperty(value = "高度")
    @TableField("height")
    private Integer height;

    @ApiModelProperty(value = "大小，单位kb")
    @TableField("size")
    private Integer size;

    
    public String getFilepath() {
        return filepath;
    }

    public Image setFilepath(String filepath) {
        this.filepath = filepath;
        return this;
    }
    public Integer getDealtype() {
        return dealtype;
    }

 
    public String getOriid()
    {
        return oriid;
    }

    public void setOriid(String oriid)
    {
        this.oriid = oriid;
    }

    public String getContentid()
    {
        return contentid;
    }

    public void setContentid(String contentid)
    {
        this.contentid = contentid;
    }

    public Image setDealtype(Integer dealtype) {
        this.dealtype = dealtype;
        return this;
    }
    public String getWmid() {
        return wmid;
    }

    public Image setWmid(String wmid) {
        this.wmid = wmid;
        return this;
    }
    public Integer getWight() {
        return wight;
    }

    public Image setWight(Integer wight) {
        this.wight = wight;
        return this;
    }
    public Integer getHeight() {
        return height;
    }

    public Image setHeight(Integer height) {
        this.height = height;
        return this;
    }
    public Integer getSize() {
        return size;
    }

    public Image setSize(Integer size) {
        this.size = size;
        return this;
    }

    @Override
    public String toString() {
        return "TbImage{" +
        "oriid=" + oriid +
        ", filepath=" + filepath +
        ", dealtype=" + dealtype +
        ", wmid=" + wmid +
        ", wight=" + wight +
        ", height=" + height +
        ", size=" + size +
        "}";
    }
}

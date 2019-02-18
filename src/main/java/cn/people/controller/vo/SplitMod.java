package cn.people.controller.vo;

import cn.people.entity.BaseEntity;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 碎片方案表对应原表TAG_MOD
 * </p>
 *
 * @author shidandan
 * @since 2019-01-07
 */
@ApiModel(value="SplitMod对象", description="碎片方案表对应原表TAG_MOD")
public class SplitMod extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "碎片id")
    private String splitId;

    @ApiModelProperty(value = "碎片方案名称")
    private String modName;

    @ApiModelProperty(value = "碎片方案描述")
    private String modDes;

    @ApiModelProperty(value = "方案html原文")
    private String modHtml;

    @ApiModelProperty(value = "添加时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "添加人")
    private String createId;

    public String getSplitId() {
        return splitId;
    }

    public SplitMod setSplitId(String splitId) {
        this.splitId = splitId;
        return this;
    }
    public String getModName() {
        return modName;
    }

    public SplitMod setModName(String modName) {
        this.modName = modName;
        return this;
    }
    public String getModDes() {
        return modDes;
    }

    public SplitMod setModDes(String modDes) {
        this.modDes = modDes;
        return this;
    }
    public String getModHtml() {
        return modHtml;
    }

    public SplitMod setModHtml(String modHtml) {
        this.modHtml = modHtml;
        return this;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public SplitMod setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }
    public String getCreateId() {
        return createId;
    }

    public SplitMod setCreateId(String createId) {
        this.createId = createId;
        return this;
    }

    @Override
    public String toString() {
        return "SplitMod{" +
        "splitId=" + splitId +
        ", modName=" + modName +
        ", modDes=" + modDes +
        ", modHtml=" + modHtml +
        ", createTime=" + createTime +
        ", createId=" + createId +
        "}";
    }
}

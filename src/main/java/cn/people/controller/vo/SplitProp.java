package cn.people.controller.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.people.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 碎片属性表对应原表TAG_PROP
 * </p>
 *
 * @author shidandan
 * @since 2019-01-07
 */
@ApiModel(value="SplitProp对象", description="碎片属性表对应原表TAG_PROP")
public class SplitProp extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "碎片id")
    private String splitId;

    @ApiModelProperty(value = "属性名称")
    private String propName;

    public String getSplitId() {
        return splitId;
    }

    public SplitProp setSplitId(String splitId) {
        this.splitId = splitId;
        return this;
    }
    public String getPropName() {
        return propName;
    }

    public SplitProp setPropName(String propName) {
        this.propName = propName;
        return this;
    }

    @Override
    public String toString() {
        return "SplitProp{" +
        "splitId=" + splitId +
        ", propName=" + propName +
        "}";
    }
}

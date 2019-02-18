package cn.people.controller.vo;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 碎片版本表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-19
 */
@ApiModel(value="SplitVersion对象", description="碎片版本表")
public class SplitVersion implements Serializable {
    
    private static final long serialVersionUID = -662059215494880968L;

    @ApiModelProperty(value = "碎片ID")
    private String splitid;
    
    @ApiModelProperty(value = "模板内容")
    private String modelcontent;


    public String getModelcontent() {
        return modelcontent;
    }

    public String getSplitid()
    {
        return splitid;
    }
    public void setSplitid(String splitid)
    {
        this.splitid = splitid;
    }
    public SplitVersion setModelcontent(String modelcontent) {
        this.modelcontent = modelcontent;
        return this;
    }

    @Override
    public String toString() {
        return "SplitVersion{" +
        "modelcontent=" + modelcontent +
        "}";
    }
}

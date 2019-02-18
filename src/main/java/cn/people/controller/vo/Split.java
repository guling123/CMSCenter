package cn.people.controller.vo;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 碎片表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-19
 */
@ApiModel(value="Split对象", description="碎片表")
public class Split implements Serializable {
    
    private static final long serialVersionUID = -366548425541903660L;

    @ApiModelProperty(value = "碎片名称")
    private String splitName;

    @ApiModelProperty(value = "碎片ID")
    private String  id;

    public String getSplitName()
    {
        return splitName;
    }

    public void setSplitName(String splitName)
    {
        this.splitName = splitName;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    
}

package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;


/**
 * @author guling
 * @ClassName: SplitContentDelVO
 * @Description: 批量删除的id(这里用一句话描述这个类的作用)
 * @date 2019/1/29 11:21
 */
@ApiModel(value="删除id集合", description="删除id集合")
public class SplitContentDelVO implements Serializable
{

    @ApiModelProperty(value = "批量删除id集合")
    private List<String> ids;

    public List<String> getIds()
    {
        return ids;
    }

    public void setIds(List<String> ids)
    {
        this.ids = ids;
    }

    @Override public String toString()
    {
        return "SplitContentDelVO{" + "ids=" + ids + '}';
    }
}

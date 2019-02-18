package cn.people.controller.vo;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 内容栏目表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-19
 */
@ApiModel(value="ContentChannel对象", description="内容栏目表")
public class ContentChannel implements Serializable{

    private static final long serialVersionUID = -3182127814027788307L;

    @ApiModelProperty(value = "内容id")
    private String contentid;

    @ApiModelProperty(value = "栏目id")
    private String channelid;

    @ApiModelProperty(value = "站点id")
    private String siteid;

    public String getContentid() {
        return contentid;
    }

    public ContentChannel setContentid(String contentid) {
        this.contentid = contentid;
        return this;
    }
    public String getChannelid() {
        return channelid;
    }

    public ContentChannel setChannelid(String channelid) {
        this.channelid = channelid;
        return this;
    }
    public String getSiteid() {
        return siteid;
    }

    public ContentChannel setSiteid(String siteid) {
        this.siteid = siteid;
        return this;
    }

    @Override
    public String toString() {
        return "ContentChannel{" +
        "contentid=" + contentid +
        ", channelid=" + channelid +
        ", siteid=" + siteid +
        "}";
    }
}

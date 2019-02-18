package cn.people.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import cn.people.entity.BaseEntity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 管理资源表
 * </p>
 *
 * @author shidandan
 * @since 2018-12-12
 */
@TableName("tb_sys_resource")
@ApiModel(value="SysResource对象", description="管理资源表")
public class SysResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "资源名称")
    @TableField("resoucename")
    private String resoucename;

    @ApiModelProperty(value = "资源表达式")
    @TableField("resouceuri")
    private String resouceuri;

    @ApiModelProperty(value = "创建时间")
    @TableField("createtime")
    private LocalDateTime createtime;

    public String getResoucename() {
        return resoucename;
    }

    public SysResource setResoucename(String resoucename) {
        this.resoucename = resoucename;
        return this;
    }
    public String getResouceuri() {
        return resouceuri;
    }

    public SysResource setResouceuri(String resouceuri) {
        this.resouceuri = resouceuri;
        return this;
    }
    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public SysResource setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
        return this;
    }

    @Override
    public String toString() {
        return "SysResource{" +
        "resoucename=" + resoucename +
        ", resouceuri=" + resouceuri +
        ", createtime=" + createtime +
        "}";
    }
}

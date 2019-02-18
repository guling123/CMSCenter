/**   
* @Title: SysUserSourceVO.java 
* @Package cn.people.controller.vo 
* @Description: 用户常用稿源
* @author shidandan
* @date 2018年12月20日 下午6:05:36 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SysUserSourceVO 
* @Description: 用户常用稿源 
* @author shidandan
* @date 2018年12月20日 下午6:05:36 
*  
*/
@ApiModel(value="用户常用稿源", description="用户常用稿源")
public class SysUserSourceVO implements Serializable
{

    private static final long serialVersionUID = -4672035362124798040L;
    @ApiModelProperty(value = "用户id")
    private String userid;
    
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "稿源id")
    private String sourceid;
    
    @ApiModelProperty(value = "来源名称")
    private String sourcename;

    public String getUserid()
    {
        return userid;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getSourceid()
    {
        return sourceid;
    }

    public void setSourceid(String sourceid)
    {
        this.sourceid = sourceid;
    }

    public String getSourcename()
    {
        return sourcename;
    }

    public void setSourcename(String sourcename)
    {
        this.sourcename = sourcename;
    }
}

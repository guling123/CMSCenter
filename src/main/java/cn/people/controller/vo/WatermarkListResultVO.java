/**   
* @Title: WatermarkListResultVO.java 
* @Package cn.people.controller.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2018年11月29日 上午10:59:48 
* @version V1.0   
*/
package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/** 
* @ClassName: WatermarkListResultVO 
* @Description: 站点水印列表查询结果
* @author shidandan
* @date 2018年11月29日 上午10:59:48 
*  
*/
@ApiModel(value="站点水印列表结果", description="站点水印列表结果")
public class WatermarkListResultVO  implements Serializable
{

    private static final long serialVersionUID = -3889370842652371122L;
    
    @ApiModelProperty(value = "水印ID")
    private String id;
    
    @ApiModelProperty(value = "站点名称")
    private String siteName;

    @ApiModelProperty(value = "状态。0默认，1备选，2删除")
    private Integer dstatus;

    @ApiModelProperty(value = "水印类型。1图片水印，2文字水印")
    private Integer dtype;

    @ApiModelProperty(value = "水印内容")
    private String content;

    @ApiModelProperty(value = "水印地址")
    private String filepath;

    @ApiModelProperty(value = "水印位置，1右下，2左下，3左上，4右上，5中间，6平铺")
    private Integer position;

    @ApiModelProperty(value = "水印透明度。百分比")
    private Integer opac;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSiteName()
    {
        return siteName;
    }

    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }

    public Integer getDstatus()
    {
        return dstatus;
    }

    public void setDstatus(Integer dstatus)
    {
        this.dstatus = dstatus;
    }

    public Integer getDtype()
    {
        return dtype;
    }

    public void setDtype(Integer dtype)
    {
        this.dtype = dtype;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getFilepath()
    {
        return filepath;
    }

    public void setFilepath(String filepath)
    {
        this.filepath = filepath;
    }

    public Integer getPosition()
    {
        return position;
    }

    public void setPosition(Integer position)
    {
        this.position = position;
    }

    public Integer getOpac()
    {
        return opac;
    }

    public void setOpac(Integer opac)
    {
        this.opac = opac;
    }
    
    
    
}

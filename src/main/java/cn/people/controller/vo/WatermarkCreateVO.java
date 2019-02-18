/**   
* @Title: WatermarkCreateVO.java 
* @Package cn.people.controller.vo 
* @Description: 创建站点水印参数
* @author shidandan
* @date 2018年11月29日 上午10:49:12 
* @version V1.0   
*/
package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/** 
* @ClassName: WatermarkCreateVO 
* @Description: 创建站点水印参数
* @author shidandan
* @date 2018年11月29日 上午10:49:12 
*  
*/
@ApiModel(value="创建站点水印参数", description="创建站点水印参数")
public class WatermarkCreateVO implements Serializable
{

    private static final long serialVersionUID = -4651338926946933141L;

    @ApiModelProperty(value = "站点id")
    private String siteid;

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

    public String getSiteid()
    {
        return siteid;
    }

    public void setSiteid(String siteid)
    {
        this.siteid = siteid;
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

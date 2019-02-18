/**   
* @Title: AddWatermarkVO.java 
* @Package cn.people.controller.vo 
* @Description: 添加水印  
* @author shidandan
* @date 2018年11月29日 上午11:08:37 
* @version V1.0   
*/
package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/** 
* @ClassName: AddWatermarkVO 
* @Description: 添加水印 
* @author shidandan
* @date 2018年11月29日 上午11:08:37 
*  
*/
@ApiModel(value="添加水印对象", description="添加水印请求参数")
public class DealWatermarkVO implements Serializable
{

    private static final long serialVersionUID = 8999920711507820657L;
    
    @ApiModelProperty(value = "水印类型。1图片水印，2文字水印")
    private Integer dtype;

    @ApiModelProperty(value = "水印内容")
    private String content;

    @ApiModelProperty(value = "水印ID")
    private String wmid;

    @ApiModelProperty(value = "水印位置，1右下，2左下，3左上，4右上，5中间，6平铺")
    private Integer position;

    @ApiModelProperty(value = "水印透明度。百分比")
    private Integer opac;
    
    @ApiModelProperty(value = "站点id")
    private String siteid;

    @ApiModelProperty(value = "栏目id")
    private String channelid;
    
    @ApiModelProperty(value = "内容id")
    private String contentid;
    
    @ApiModelProperty(value = "模板id")
    private String modelid;

    @ApiModelProperty(value = "来源类型,1CMS头图,2,CMS内容,3MAM上传,4外部导入")
    private Integer sourcetype;

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

    public String getSiteid()
    {
        return siteid;
    }

    public void setSiteid(String siteid)
    {
        this.siteid = siteid;
    }

   


    public String getChannelid()
    {
        return channelid;
    }

    public void setChannelid(String channelid)
    {
        this.channelid = channelid;
    }

    public String getContentid()
    {
        return contentid;
    }

    public void setContentid(String contentid)
    {
        this.contentid = contentid;
    }

    public String getModelid()
    {
        return modelid;
    }

    public void setModelid(String modelid)
    {
        this.modelid = modelid;
    }

    public Integer getSourcetype()
    {
        return sourcetype;
    }

    public void setSourcetype(Integer sourcetype)
    {
        this.sourcetype = sourcetype;
    }

    public void setContent(String content)
    {
        this.content = content;
    }


    public String getWmid()
    {
        return wmid;
    }

    public void setWmid(String wmid)
    {
        this.wmid = wmid;
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

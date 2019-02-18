/**   
* @Title: DealWatermarkResultVO.java 
* @Package cn.people.controller.vo 
* @Description: 添加水印处理结果 
* @author shidandan
* @date 2018年11月29日 上午11:09:57 
* @version V1.0   
*/
package cn.people.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/** 
* @ClassName: DealWatermarkResultVO 
* @Description: 添加水印处理结果 
* @author shidandan
* @date 2018年11月29日 上午11:09:57 
*  
*/
@ApiModel(value="添加水印", description="添加水印")
public class DealWatermarkResultVO implements Serializable
{

    private static final long serialVersionUID = -5944671468663568288L;
    @ApiModelProperty(value = "文件位置")
    private String filepath;


    @ApiModelProperty(value = "水印id")
    private String wmid;

    @ApiModelProperty(value = "宽度")
    private Integer wight;

    @ApiModelProperty(value = "高度")
    private Integer height;

    @ApiModelProperty(value = "大小，单位kb")
    private Integer size;

    public String getFilepath()
    {
        return filepath;
    }

    public void setFilepath(String filepath)
    {
        this.filepath = filepath;
    }

    public String getWmid()
    {
        return wmid;
    }

    public void setWmid(String wmid)
    {
        this.wmid = wmid;
    }

    public Integer getWight()
    {
        return wight;
    }

    public void setWight(Integer wight)
    {
        this.wight = wight;
    }

    public Integer getHeight()
    {
        return height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public Integer getSize()
    {
        return size;
    }

    public void setSize(Integer size)
    {
        this.size = size;
    }
    
    
    
}

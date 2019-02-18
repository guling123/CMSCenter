/**   
* @Title: ContentSourceVO.java 
* @Package cn.people.controller.vo 
* @Description: 稿源管理 
* @author shidandan
* @date 2018年12月29日 下午3:36:07 
* @version V1.0   
*/
package cn.people.controller.vo;

import cn.people.entity.ContentSource;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: ContentSourceVO 
* @Description: 稿源管理
* @author shidandan
* @date 2018年12月29日 下午3:36:07 
*  
*/
@ApiModel(value = "稿源管理", description = "稿源管理")
public class ContentSourceVO extends ContentSource
{

    private static final long serialVersionUID = -1778245703618394481L;
    
    @ApiModelProperty(value = "创建人姓名")
    private String creatername;

    public String getCreatername()
    {
        return creatername;
    }

    public void setCreatername(String creatername)
    {
        this.creatername = creatername;
    }
    
}

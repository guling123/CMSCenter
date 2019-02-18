/**   
* @Title: SplitListVO.java 
* @Package cn.people.controller.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2018年12月19日 下午2:07:10 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: SplitListVO 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author shidandan
* @date 2018年12月19日 下午2:07:10 
*  
*/
public class SplitListVO implements Serializable
{
    private static final long serialVersionUID = -3939615992797718984L;

    @ApiModelProperty(value = "当前页", required = true)
    private int pageNo = 1;
    
    @ApiModelProperty(value = "每页条数", required = true)
    private int pageSize = 10;
    
    @ApiModelProperty(value = "碎片名称")
    private String splitnameOrId;

    @ApiModelProperty(value = "碎片作用域,1私有碎片,2公有碎片")
    private Integer scope;

    @ApiModelProperty(value = "碎片类型。 1 自动碎片，2手动碎片，3静态碎片")
    private Integer dtype;
    
    @ApiModelProperty(value = "创建人")
    private String createrId;

    public int getPageNo()
    {
        return pageNo;
    }

    public void setPageNo(int pageNo)
    {
        this.pageNo = pageNo;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public String getSplitnameOrId()
    {
        return splitnameOrId;
    }

    public void setSplitnameOrId(String splitnameOrId)
    {
        this.splitnameOrId = splitnameOrId;
    }

    public Integer getScope()
    {
        return scope;
    }

    public void setScope(Integer scope)
    {
        this.scope = scope;
    }

    public Integer getDtype()
    {
        return dtype;
    }

    public void setDtype(Integer dtype)
    {
        this.dtype = dtype;
    }

    public String getCreaterId()
    {
        return createrId;
    }

    public void setCreaterId(String createrId)
    {
        this.createrId = createrId;
    }
}

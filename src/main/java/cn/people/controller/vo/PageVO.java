/**   
* @Title: PageVO.java 
* @Package cn.people.controller.vo 
* @Description: 分页查询参数
* @author gaoyongjiu
* @date 2018年12月04日 上午10:58:59 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: PageVO 
* @Description: 分页查询参数 
* @author gaoyongjiu
* @date 2018年12月04日 上午10:58:59 
*  
*/
@ApiModel(value="分页查询参数", description="分页查询请求参数")
public class PageVO implements Serializable
{
	private static final long serialVersionUID = -3235794387022688702L;

	@ApiModelProperty(value = "当前页", required = true)
    private int current = 1;
    
    @ApiModelProperty(value = "每页条数", required = true)
    private int pageSize = 10;
    
    public int getCurrent()
    {
        return current;
    }

    public void setCurrent(int current)
    {
        this.current = current;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
}

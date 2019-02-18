/**   
* @Title: DeleteRoleResultVO.java 
* @Package cn.people.controller.vo 
* @Description: 账户创建参数 
* @author fuqiang
* @date 2018年12月18日 上午11:00:57 
* @version V1.0   
*/
package cn.people.controller.vo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: DeleteRoleResultVO 
* @Description: 账户创建参数
* @author fuqiang
* @date 2018年12月18日 上午11:00:57 
*  
*/
@ApiModel(value = "角色关联用户对象", description = "添加账户")
public class RoleResultVO implements Serializable
{
    private static final long serialVersionUID = -5746352108776516822L;
    @ApiModelProperty(value = "关联用户列表")
    List<UserVO> list=new ArrayList<>();
    public List<UserVO> getList()
    {
        return list;
    }
    public void setList(List<UserVO> list)
    {
        this.list = list;
    }
    
}

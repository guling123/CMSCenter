/**   
* @Title: LoginResultVO.java 
* @Package cn.people.controller.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2019年1月18日 上午9:40:10 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
* @ClassName: LoginResultVO 
* @Description: 登陆成功 
* @author shidandan
* @date 2019年1月18日 上午9:40:10 
*  
*/
@ApiModel(value = "登陆结果", description = "登陆结果")
public class LoginResultVO implements Serializable
{

    private static final long serialVersionUID = 8508088689301216530L;
    
    @ApiModelProperty(value = "权限信息")
    private List<SysPermissionMenuVO> permissionList;

    public List<SysPermissionMenuVO> getPermissionList()
    {
        return permissionList;
    }

    public void setPermissionList(List<SysPermissionMenuVO> permissionList)
    {
        this.permissionList = permissionList;
    }
}

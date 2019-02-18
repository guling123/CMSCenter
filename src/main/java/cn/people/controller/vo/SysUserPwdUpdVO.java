/**   
* @Title: SysUserPwdUpdVO.java 
* @Package cn.people.controller.vo 
* @Description: 修改密码参数 
* @author gaoyongjiu
* @date 2018年12月20日 上午10:00:57
* @version V1.0   
*/
package cn.people.controller.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  
 * @ClassName: SysUserPwdUpdVO 
 * @Description: 修改密码
 * @author gaoyongjiu
 * @date 2018年12月20日 上午10:00:57    
 */
@ApiModel(value = "修改密码", description = "修改密码")
public class SysUserPwdUpdVO implements Serializable {

	private static final long serialVersionUID = -1220864712049373205L;

	@NotBlank(message = "原密码不能为空")
	@ApiModelProperty(value = "原密码")
	private String oldpwd;

	@NotBlank(message = "新密码不能为空")
	@ApiModelProperty(value = "新密码")
	private String newpwd;

	public String getOldpwd() {
		return oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

}

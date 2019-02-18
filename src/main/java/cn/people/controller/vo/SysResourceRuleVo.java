/**   
* @Title: UserResourceVo.java 
* @Package cn.people.controller.vo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author fuqiang
* @date 2018年12月18日 下午4:35:43 
* @version V1.0   
*/
package cn.people.controller.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* @ClassName: UserResourceVo 
* @Description: 用户访问资源对象
* @author fuqiang
* @date 2018年12月18日 下午4:35:43 
*  
*/
public class SysResourceRuleVo
{
    //key为permissionid,value为url路径
    Map<String, List<String>> resourceMap=new HashMap<>();

    public Map<String, List<String>> getResourceMap()
    {
        return resourceMap;
    }

    public void setResourceMap(Map<String, List<String>> resourceMap)
    {
        this.resourceMap = resourceMap;
    }
    
}

/**   
* @Title: SysOrgControllerTest.java 
* @Package cn.people.test.controller 
* @Description: 租户测试类
* @author shidandan
* @date 2018年12月14日 下午3:02:49 
* @version V1.0   
*/
package cn.people.test.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.people.controller.vo.SysResourceRuleVo;
import cn.people.service.IPermissionResourceService;

/** 
* @ClassName: SysPermissionResourceTest 
* @Description: 系统资源权限测试类 
* @author fuqiang
* @date 2018年12月18日 下午6:02:49 
*  
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysPermissionResourceTest
{
    @Autowired
    IPermissionResourceService permissionResourceService;


    @Test
    public void testGetSysResourceRule() throws Exception {
        
        SysResourceRuleVo v= permissionResourceService.getSysResourceRule();
        System.out.println(v.getResourceMap());
        Assert.assertTrue(v.getResourceMap().size()>0);
    }

}

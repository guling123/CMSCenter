/**   
* @Title: SysOrgControllerTest.java 
* @Package cn.people.test.controller 
* @Description: 租户测试类
* @author shidandan
* @date 2018年12月14日 下午3:02:49 
* @version V1.0   
*/
package cn.people.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.alibaba.fastjson.JSON;

import cn.people.controller.vo.SysRoleCreateVO;

/** 
* @ClassName: SysOrgControllerTest 
* @Description: 租户测试类 
* @author shidandan
* @date 2018年12月14日 下午3:02:49 
*  
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SysRoleControllerTest
{
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testCreate() throws Exception {
        
        SysRoleCreateVO param=new SysRoleCreateVO();
        param.setRolename("角色1");
        param.setRoleDesc("这是角色的描述1");
        List<String> permissionids=new ArrayList<>();
        permissionids.add("permission1");
        permissionids.add("permission2");
        permissionids.add("permission3");
        param.setPermissionids(permissionids);
        Cookie cookie=new Cookie("SESSION", "ZWUyYWZkZDAtODI1NC00MTA3LTllMWUtZDA3NDMyZjNmZmE1");
        MvcResult mvcResult = mockMvc.perform( 
            post("/role/add") .contentType(MediaType.APPLICATION_JSON).cookie(cookie) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
        
    }
    
    @Test
    public void testUpdate() throws Exception {
        
        SysRoleCreateVO param=new SysRoleCreateVO();
        param.setRolename("角色1");
        param.setRoleDesc("这是角色的描述2");
        List<String> permissionids=new ArrayList<>();
        permissionids.add("permission4");
        permissionids.add("permission2");
        permissionids.add("permission3");
        param.setPermissionids(permissionids);
        Cookie cookie=new Cookie("SESSION", "ZWUyYWZkZDAtODI1NC00MTA3LTllMWUtZDA3NDMyZjNmZmE1");
        
        MvcResult mvcResult = mockMvc.perform( 
            post("/role/3093a527b751af02694b0a8272a14783/update") .contentType(MediaType.APPLICATION_JSON).cookie(cookie) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    
    @Test
    public void testView() throws Exception {
        
        Cookie cookie=new Cookie("SESSION", "ZWUyYWZkZDAtODI1NC00MTA3LTllMWUtZDA3NDMyZjNmZmE1");
        MvcResult mvcResult = mockMvc.perform( 
            get("/role/3093a527b751af02694b0a8272a14783") .contentType(MediaType.APPLICATION_JSON).cookie(cookie) 
//            .content(JSON.toJSONString(param))
            )
            .andExpect(status().isOk())
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void testDel() throws Exception {
        
        Cookie cookie=new Cookie("SESSION", "ZWUyYWZkZDAtODI1NC00MTA3LTllMWUtZDA3NDMyZjNmZmE1");
        MvcResult mvcResult = mockMvc.perform( 
            get("/role/5628ab4c56d38d1eabe8c1889b440c72/del") .contentType(MediaType.APPLICATION_JSON).cookie(cookie) 
//            .content(JSON.toJSONString(param))
            )
            .andExpect(status().isOk())
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

}

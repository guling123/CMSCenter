/**   
* @Title: SysUserSourceControllerTest.java 
* @Package cn.people.test.controller 
* @Description: 用户常用稿源测试类 
* @author shidandan
* @date 2018年12月18日 下午6:32:37 
* @version V1.0   
*/
package cn.people.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import cn.people.controller.vo.SysUserCreateVO;
import cn.people.controller.vo.SysUserListVO;

/** 
* @ClassName: SysUserControllerTest 
* @Description: 账户测试类 
* @author gaoyongjiu
* @date 2018年12月18日 下午6:32:37 
*  
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SysUserControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    //@Transactional
    public void testCreateSysUserSource() throws Exception {
        
        SysUserCreateVO param=new SysUserCreateVO();
        param.setIdent("1");
        param.setPwd("123qwe");
        param.setRealname("超管管1");
        param.setUsername("管管1");
        MvcResult mvcResult = mockMvc.perform( 
            post("/account/add") .contentType(MediaType.APPLICATION_JSON) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.success").value(true))
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    
    @Test
    //@Transactional
    public void testGetSysUserPaged() throws Exception {
        
        SysUserListVO param=new SysUserListVO();
        param.setCreatername("管");
        MvcResult mvcResult = mockMvc.perform( 
            post("/account/list") .contentType(MediaType.APPLICATION_JSON) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.success").value(true))
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}

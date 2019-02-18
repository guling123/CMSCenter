/**   
* @Title: SiteControllerTest.java 
* @Package cn.people.test.controller 
* @Description: 站点管理测试类 
* @author shidandan
* @date 2018年12月18日 下午3:58:24 
* @version V1.0   
*/
package cn.people.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

import cn.people.entity.Site;

/** 
* @ClassName: SiteControllerTest 
* @Description: 站点管理测试类
* @author shidandan
* @date 2018年12月18日 下午3:58:24 
*  
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SiteControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    //@Transactional
    public void testCreateSite() throws Exception {
        
        Site param=new Site();
        param.setSitename("测试站点44444");
        param.setDescription("测试测试4444");
        param.setDomain("http://baidu.com");
        param.setOrgid("0");
        
        MvcResult mvcResult = mockMvc.perform( 
            post("/site/add") .contentType(MediaType.APPLICATION_JSON) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.success").value(true))
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    
    @Test
    public void testGetSiteList() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/site/list"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }
    
     @Test
     @Transactional
     public void testUpdateSite() throws Exception {
         
         Site param=new Site();
         param.setSitename("测试站点2222222");
         param.setDescription("测试11111测试");
         param.setDomain("http://baidu.com");
         param.setOrgid("11111");
         
         MvcResult mvcResult = mockMvc.perform( //
             
             put("/site/f4b600b5f0e239d27e4f0e0a37bd4391/update").contentType(MediaType.APPLICATION_JSON) 
             .content(JSON.toJSONString(param)))
             .andExpect(status().isOk())
             //.andExpect(jsonPath("$.data.success").value(true))
             .andReturn(); 
         
         System.out.println(mvcResult.getResponse().getContentAsString());
     }
     
     
     @Test
     public void testGetSite() throws Exception {
         MvcResult mvcResult = mockMvc.perform( 
              get("/site/f4b600b5f0e239d27e4f0e0a37bd4391/detail"))
             .andExpect(status().isOk())
             //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
             .andReturn();
             
             System.out.println(mvcResult.getResponse().getContentAsString());

     }

}

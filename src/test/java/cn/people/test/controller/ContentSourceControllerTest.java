/**   
* @Title: ContentSourceControllerTest.java 
* @Package cn.people.test.controller 
* @Description:  稿源测试类
* @author shidandan
* @date 2018年12月18日 下午5:26:55 
* @version V1.0   
*/
package cn.people.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

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

import cn.people.controller.vo.ContentSourceCreateVO;
import cn.people.controller.vo.ContentSourceListVO;

/** 
* @ClassName: ContentSourceControllerTest 
* @Description: 稿源测试类
* @author shidandan
* @date 2018年12月18日 下午5:26:55 
*  
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContentSourceControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    @Transactional
    public void testCreateContentSource() throws Exception {
        
        ContentSourceCreateVO param=new ContentSourceCreateVO();
        param.setSiteid("f4b600b5f0e239d27e4f0e0a37bd4391");
        param.setLimitDate(new Date());
        param.setReliability(1);
        param.setSourcename("ssss");
        param.setSourceUrl("http://baidu.com");
        param.setStatus(1);
        param.setDomain("http://baidu.com");
        
        MvcResult mvcResult = mockMvc.perform( 
            post("/site/source/add") .contentType(MediaType.APPLICATION_JSON) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.success").value(true))
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    
    @Test
    public void getContentSource() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/site/source/e3f57d181470b0ebef11ddc7c42be703/detail"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }
    
    @Test
    @Transactional
     public void testUpdateContentSource() throws Exception {
         
         ContentSourceCreateVO param=new ContentSourceCreateVO();
         param.setSiteid("f4b600b5f0e239d27e4f0e0a37bd4391");
         param.setLimitDate(new Date());
         param.setReliability(1);
         param.setSourcename("ss22222ss");
         param.setSourceUrl("http://baidu.com");
         param.setStatus(1);
         param.setDomain("http://baidu.com");
         
         MvcResult mvcResult = mockMvc.perform( 
             post("/site/source/e3f57d181470b0ebef11ddc7c42be703/update") .contentType(MediaType.APPLICATION_JSON) 
             .content(JSON.toJSONString(param)))
             .andExpect(status().isOk())
             //.andExpect(jsonPath("$.data.success").value(true))
             .andReturn(); 
         
         System.out.println(mvcResult.getResponse().getContentAsString());
     }
    
    @Test
     public void testGetContentSourcePaged() throws Exception {
         
        ContentSourceListVO param=new ContentSourceListVO();
         param.setReliability(1);
         param.setStatus(1);
         
         MvcResult mvcResult = mockMvc.perform( 
             post("/site/source/list") .contentType(MediaType.APPLICATION_JSON) 
             .content(JSON.toJSONString(param)))
             .andExpect(status().isOk())
             //.andExpect(jsonPath("$.data.success").value(true))
             .andReturn(); 
         
         System.out.println(mvcResult.getResponse().getContentAsString());
     }
    
    @Test
    public void getListEnabled() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/site/source/listEnabled"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }
    
    @Test
    @Transactional
    public void getDisableContentSource() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/site/source/e3f57d181470b0ebef11ddc7c42be703/disable"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }
    
    @Test
    @Transactional
    public void getEnabledContentSource() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/site/source/e3f57d181470b0ebef11ddc7c42be703/enabled"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }

}

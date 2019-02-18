/**   
* @Title: ChannelControllerTest.java 
* @Package cn.people.test.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shidandan
* @date 2018年12月18日 下午5:42:15 
* @version V1.0   
*/
package cn.people.test.controller;

import cn.people.controller.vo.ChannelCreateVO;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** 
* @ClassName: ChannelControllerTest 
* @Description: 栏目测试类
* @author shidandan
* @date 2018年12月18日 下午5:42:15 
*  
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ChannelControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetChannellist() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
            get("/channel/9b5c1733ba7e93a02b18a1ed2627b35d/list"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

    }
    @Test
    public void testGetChannel() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/channel/f4b600b5f0e239d27e4f0e0a37bd4391/detail"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }
    @Test
    public void testCreateChannel() throws Exception {

        
        ChannelCreateVO param=new ChannelCreateVO();
        param.setDescription("测试测试4444");
        
        MvcResult mvcResult = mockMvc.perform( 
            post("/channel/add") .contentType(MediaType.APPLICATION_JSON) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.success").value(true))
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    
    }
    
    @Test
    public void testUpdateChannel() throws Exception {

        
        ChannelCreateVO param=new ChannelCreateVO();
        param.setDescription("测试测试4444");
        
        MvcResult mvcResult = mockMvc.perform( 
            post("/channel/1/update") .contentType(MediaType.APPLICATION_JSON) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.success").value(true))
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    
    }
    
    @Test
    public void testGetChannelBySite() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/channel/f4b600b5f0e239d27e4f0e0a37bd4391/list"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }
    @Test
    public void testDelChannel() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/channel/f4b600b5f0e239d27e4f0e0a37bd4391/del"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }
}

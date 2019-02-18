/**   
* @Title: SysGroupControllerTest.java 
* @Package cn.people.test.controller 
* @Description: 账户组测试类
* @author shidandan
* @date 2018年12月18日 下午4:25:09 
* @version V1.0   
*/
package cn.people.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

import cn.people.controller.vo.SysGroupCreateVO;

/** 
* @ClassName: SysGroupControllerTest 
* @Description: 账户组测试类
* @author shidandan
* @date 2018年12月18日 下午4:25:09 
*  
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SysGroupControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    

    @Test
    public void testGetSysGroupList() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/site/userGroup/f4b600b5f0e239d27e4f0e0a37bd4391/list"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }
    
    @Test
    @Transactional
    public void testCreateSysGroup() throws Exception {
        
        SysGroupCreateVO param=new SysGroupCreateVO();
        List<String> channelIds=new ArrayList<String>();
        channelIds.add("f4b600b5f0e239d27e4f0e0a37bd4391");
        param.setChannelIds(channelIds);
        param.setDescription("sdd");
        param.setGroupname("1111");
        param.setSiteid("f4b600b5f0e239d27e4f0e0a37bd4391");
        
        MvcResult mvcResult = mockMvc.perform( 
            post("/site/userGroup/add") .contentType(MediaType.APPLICATION_JSON) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.success").value(true))
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    
    @Test
    @Transactional
    public void testUpdateSysGroup() throws Exception {
        
        SysGroupCreateVO param=new SysGroupCreateVO();
        List<String> channelIds=new ArrayList<String>();
        channelIds.add("f4b600b5f0e239d27e4f0e0a37bd4391");
        param.setChannelIds(channelIds);
        param.setDescription("sdd");
        param.setGroupname("222222");
        param.setSiteid("f4b600b5f0e239d27e4f0e0a37bd4391");
        
        MvcResult mvcResult = mockMvc.perform( 
            post("/site/userGroup/4abfec8282ca538de36ee6c94cf0982a/update") .contentType(MediaType.APPLICATION_JSON) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.success").value(true))
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    
    @Test
    public void testGetSysGroup() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/site/userGroup/4abfec8282ca538de36ee6c94cf0982a/detail"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }
    
    @Test
    public void testDelSysGroup() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/site/userGroup/4abfec8282ca538de36ee6c94cf0982a/del"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }
}

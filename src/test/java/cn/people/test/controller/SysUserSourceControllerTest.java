/**   
* @Title: SysUserSourceControllerTest.java 
* @Package cn.people.test.controller 
* @Description: 用户常用稿源测试类 
* @author shidandan
* @date 2018年12月18日 下午6:32:37 
* @version V1.0   
*/
package cn.people.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import cn.people.controller.vo.SysUserListVO;
import cn.people.entity.SysUserSource;

/** 
* @ClassName: SysUserSourceControllerTest 
* @Description: 用户常用稿源测试类 
* @author shidandan
* @date 2018年12月18日 下午6:32:37 
*  
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SysUserSourceControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    //@Transactional
    public void testCreateSysUserSource() throws Exception {
        
        SysUserSource param=new SysUserSource();
        param.setSourceid("e3f57d181470b0ebef11ddc7c42be703");
        param.setUserid("1111");
        MvcResult mvcResult = mockMvc.perform( 
            post("/site/account/source/add") .contentType(MediaType.APPLICATION_JSON) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.success").value(true))
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    
    @Test
    public void testGetSysUserSource() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/site/account/source/list"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }
    
    @Test
    @Transactional
    public void testDelSysUserSource() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/site/account/source/942aed06cdd5c307b0b1d3898fd5135a/del"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }

    
    @Test
    @Transactional
    public void testAccountList() throws Exception {
        
    	SysUserListVO param=new SysUserListVO();
    	param.setCurrent(1);
    	param.setPageSize(10);
    	param.setSiteid("0");
        MvcResult mvcResult = mockMvc.perform( 
            post("/account/list") .contentType(MediaType.APPLICATION_JSON) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.success").value(true))
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}

/**   
* @Title: SysUserChannelControllerTest.java 
* @Package cn.people.test.controller 
* @Description: 用户账户组单元测试 
* @author shidandan
* @date 2018年12月18日 下午4:50:13 
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

import com.alibaba.fastjson.JSON;

import cn.people.controller.vo.SysUserChannelVO;

/** 
* @ClassName: SysUserChannelControllerTest 
* @Description: 用户账户组单元测试
* @author shidandan
* @date 2018年12月18日 下午4:50:13 
*  
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SysUserChannelControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testGetSysUserByGroupid() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/sysuser/channel/list/4e2967126092b9ff4981098cb758e84f"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }
    
    @Test
    //@Transactional
    public void testCreateSysUserChannel() throws Exception {
        
        SysUserChannelVO param=new SysUserChannelVO();
        
        //param.setGroupid("4e2967126092b9ff4981098cb758e84f",);
        
        List<String> userIds=new ArrayList<String>();
        userIds.add("1111");
        param.setUserIds(userIds);
        MvcResult mvcResult = mockMvc.perform( 
            post("/sysuser/channel/add") .contentType(MediaType.APPLICATION_JSON) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.success").value(true))
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

}

/**   
* @Title: SplitContentControllerTest.java 
* @Package cn.people.test.controller 
* @Description: 碎片内容测试类
* @author shidandan
* @date 2018年12月26日 下午3:13:41 
* @version V1.0   
*/
package cn.people.test.controller;

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

import cn.people.controller.vo.SplitContent;
import cn.people.controller.vo.SplitContentListVO;
import cn.people.entity.Site;

/** 
* @ClassName: SplitContentControllerTest 
* @Description: 碎片内容测试类
* @author shidandan
* @date 2018年12月26日 下午3:13:41 
*  
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SplitContentControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    @Transactional
    public void testUpdateSplitContents() throws Exception {
        
        SplitContentListVO param=new SplitContentListVO();
        param.setCreaterid("1111");
        
        List<SplitContent> splitList=new ArrayList<SplitContent>();
        
        MvcResult mvcResult = mockMvc.perform( 
            post("/split/71150a58abc724f06db07af23aa3f843/contents/update") .contentType(MediaType.APPLICATION_JSON) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.success").value(true))
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

}

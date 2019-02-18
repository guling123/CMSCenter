/**   
* @Title: SysOrgControllerTest.java 
* @Package cn.people.test.controller 
* @Description: 租户测试类
* @author shidandan
* @date 2018年12月14日 下午3:02:49 
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

import cn.people.controller.vo.SysOrgCreateVO;
import cn.people.controller.vo.SysOrgListVO;
import cn.people.controller.vo.SysOrgUpdateVO;

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
public class SysOrgControllerTest
{
    @Autowired
    private MockMvc mockMvc;


    @Test
    //@Transactional
    public void testCreateSite() throws Exception {
        
        SysOrgCreateVO param=new SysOrgCreateVO();
        param.setOrgname("测试租户001");
        param.setDescription("sdd");
        
        MvcResult mvcResult = mockMvc.perform( 
            post("/sysorg/add") .contentType(MediaType.APPLICATION_JSON) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.success").value(true))
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    /**
     * @author guling
     * @Title   获取超管详细信息
     * @Date    2019/2/1 9:45
     * @param   [orgid]  租户id
     * @return  cn.people.controller.vo.SysOrgdetailVO
     * @throws
     * @Description 获取超管详细信息
     */
    @Test
    public void getSysOrgUser() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
            get("/sysorg/1/admin/detail"))
            .andExpect(status().isOk())
            .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getSysOrg() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/sysorg/11111/detail"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }
    
    @Test
    //@Transactional
    public void testUpdateSysOrg() throws Exception {
        
        SysOrgUpdateVO param=new SysOrgUpdateVO();
        param.setId("11111");
        param.setOrgname("测试租户");
        param.setDescription("sdd");
        
        MvcResult mvcResult = mockMvc.perform( 
            post("/sysorg/11111/update") .contentType(MediaType.APPLICATION_JSON) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.success").value(true))
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    
    @Test
    //@Transactional
    public void testGetContentRecycledPaged() throws Exception {
        
        SysOrgListVO param=new SysOrgListVO();
        
//        param.setCreater(creater);
//        param.setDtatus(1);
        param.setOrgidOrName("测试");
        
        MvcResult mvcResult = mockMvc.perform( 
            post("/sysorg/list") .contentType(MediaType.APPLICATION_JSON) 
            .content(JSON.toJSONString(param)))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.records").isNotEmpty())
            .andReturn(); 
        
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    
    @Test
    public void testEnabledSysOrg() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/sysorg/11111/enabled"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }
    
    @Test
    public void testDisableSysOrg() throws Exception {
        MvcResult mvcResult = mockMvc.perform( 
             get("/sysorg/11111/disable"))
            .andExpect(status().isOk())
            //.andExpect(jsonPath("$.data.siteid").value("6601476df7196f07c9b4bffb1fd30516"))
            .andReturn();
            
            System.out.println(mvcResult.getResponse().getContentAsString());

    }
}

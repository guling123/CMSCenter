package cn.people.entity.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import cn.people.controller.vo.SysResourceRuleVo;
import cn.people.service.IPermissionResourceService;

@EnableWebSecurity
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 36000)
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;
    
    @Autowired
    IPermissionResourceService permisionService;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
        throws Exception
    {
        auth.userDetailsService(userDetailsService);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //获取系统资源访问规则
        SysResourceRuleVo rule= permisionService.getSysResourceRule();
        // map{资源url:[权限ident...]}
        Map<String, List<String>> resourceMap = rule.getResourceMap();
        // 基本规则设置
        http.authorizeRequests()
                .and().formLogin()
                .loginPage("/login")
                .and().csrf().disable().exceptionHandling().accessDeniedHandler(new SecurityDeniedHandler()); //401

        //用重写的Filter替换掉原有的UsernamePasswordAuthenticationFilter
        http.addFilterAt(customAuthenticationFilter(),
        UsernamePasswordAuthenticationFilter.class);
        
        // 获取*（允许任何人访问）资源，并从map中移除
        List<String> permitAllResource= new ArrayList<>();
        //注册需要角色授权的url pattern
        for(String k:resourceMap.keySet()) {
        	// {资源url:[权限ident...]}
            List<String> idents=resourceMap.get(k);
            if(IPermissionResourceService.PERMIT_ALL.equals(idents.get(0))) {
            	// *（允许任何人访问）资源
            	permitAllResource.add(k);
            	continue;
            }
            idents.add("ADMIN"); // 测试用允许ADMIN访问
            http.authorizeRequests().antMatchers(k).hasAnyRole(idents.toArray(new String[0]));
        }
        //设置无需权限的url,包括login,logout等
        permitAllResource.add("swagger-ui.html**");
        http.authorizeRequests().antMatchers(permitAllResource.toArray(new String[0])).permitAll();
        
    }
    
    @Bean
    MyAuthenticationFilter customAuthenticationFilter() throws Exception {
        MyAuthenticationFilter filter = new MyAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(new LoginSuccessHandler());
        filter.setAuthenticationFailureHandler(new LoginFailureHandler());

        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }
}

/**   
* @Title: CMSApplication.java 
* @Package cn.people 
* @Description: CMSCenter启动类
* @author shidandan
* @date 2018年12月12日 下午2:27:34 
* @version V1.0   
*/
package cn.people;

import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** 
* @ClassName: CMSApplication 
* @Description: CMSCenter启动类
* @author shidandan
* @date 2018年12月12日 下午2:27:34 
*  
*/
@MapperScan(basePackages = {"cn.people.mapper"})
@EnableEurekaClient
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableAutoConfiguration
@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cn.people.remote"})
public class CMSApplication
{
    public static void main(String[] args) {
        SpringApplication.run(CMSApplication.class, args);
    }
    
    /**
     * SQL执行效率插件
     */
    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }
}

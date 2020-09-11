package com.cloud.mack.springboot.conf;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidCofig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    /*配置 druid 后台管理servlet*/

    /*配置管理后台的servlet*/
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean stat = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> map = new HashMap();
        map.put("loginUsername","admin");
        map.put("loginPassword", "123456");
        map.put("allow", "");
        stat.setInitParameters(map);
        return stat;
    }

    /*配置监控的filter*/
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistration=new FilterRegistrationBean();
        filterRegistration.setFilter(new WebStatFilter());
        Map<String, String> filter = new HashMap<>();
        filter.put("exclusions", "*.js,*.css,/druid/*");
        filterRegistration.setInitParameters(filter);

        filterRegistration.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistration;
    }

}

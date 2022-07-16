package com.suiwei.config;

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

/**
 * @author suiwei
 * @date 2021-07-26 16:02
 */
@Configuration
public class DruidConfig {
    /**
     * 把spring.datasource开头的配置注入new的数据源中*/
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        return  new DruidDataSource();
    }

    //以下两个bean为配置druid监控
    //后台地址：http://localhost:8080/druid/

    /**
     * 第一步：配置一个管理后台的servlet*/
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","suiwei");
        initParams.put("loginPassword","suiwei");
        initParams.put("allow","");//value为空字符串的话，默认允许所有地址访问
        //initParams.put("deny","");拒绝访问
        bean.setInitParameters(initParams);
        return bean;
    }

    /**
     * 第二步：配置一个web监控的filter*/
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        //exclusions排除拦截
        initParams.put("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return  bean;
    }

}

package com.zhujuming.vip.webapp.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixConfig {

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet hys = new HystrixMetricsStreamServlet();
        ServletRegistrationBean source = new ServletRegistrationBean(hys);
        source.setLoadOnStartup(2);
        source.addUrlMappings("/hystrix.stream");
        source.setName("HystrixMetricsStreamServlet");
        return source;
    }
}

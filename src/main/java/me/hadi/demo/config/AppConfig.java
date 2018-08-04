package me.hadi.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

import static java.net.Proxy.Type.HTTP;

@Configuration
public class AppConfig {

    @Bean
    @Qualifier("withProxy")
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(HTTP, new InetSocketAddress("proxyAddress", 8080));
        factory.setProxy(proxy);

        return new RestTemplate(factory);
    }


    @Bean
    public RestTemplate simpleRestTemplate() {
        //other config ...
        return new RestTemplate();
    }


}

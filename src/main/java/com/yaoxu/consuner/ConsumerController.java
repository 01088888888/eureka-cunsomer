package com.yaoxu.consuner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.commons.httpclient.DefaultOkHttpClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;


import java.util.List;

@Controller
@RequestMapping("consumer")
public class ConsumerController {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("testv1")
    @ResponseBody
    public String testOrderWithEureka(){
        String restlt = restTemplate.getForObject("http://order/order/create?name=yao", String.class, "");

        return restlt;
    }


}

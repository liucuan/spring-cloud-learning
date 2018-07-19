package com.tone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author zhaoxiang.liu
 * @date 2018/7/11
 */
@Service
public class ConsumerService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        throw new RuntimeException("1");
        // return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }

    public String fallback() {
        return "fallback";
    }
}

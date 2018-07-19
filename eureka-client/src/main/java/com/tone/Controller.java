package com.tone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoxiang.liu
 * @date 2018/7/6
 */
@RestController
public class Controller {
    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    private Registration registration;

    @GetMapping("/dc")
    public String dc() {
        // try {
        // Thread.sleep(5000L);
        // }catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}

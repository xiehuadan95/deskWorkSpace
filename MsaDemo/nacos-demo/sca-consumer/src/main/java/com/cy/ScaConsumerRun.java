package com.cy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ScaConsumerRun {
    public static void main(String[] args) {
        SpringApplication.run(ScaConsumerRun.class, args);
    }

    /*springboot 工程中可以使用此对象调用第三方服务*/
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    @LoadBalanced
    public RestTemplate loadBalancedRestTemplate(){
        return new RestTemplate();
    }
    @RestController
    public class ConsumerController {
        @Value("${spring.application.name}")
        private String consumerName;
        //通过这个对象去请求资源RestTemplate 系统自带的Spring注入的
        //需要创建一个对象 用@Bean
        @Autowired
        private RestTemplate restTemplate;

        @GetMapping("/consumer/doEcho")
        public String doEcho() {
            //定义服务提供方的地址
            String url = "http://localhost:8081/provider/echo/" + consumerName;
            //调用服务提供方（sca-provider)
            return restTemplate.getForObject(url, String.class);
        }

        //  底层基于 Ribbon通过此组件 实现负载均衡
        @Autowired
        private LoadBalancerClient loadbalancerClient;

        @GetMapping("/consumer/doEcho2")
        public String doEcho2() {
            //基于一定的负载均衡算法获取服务实例  通过nacos的服务名sca-provider 找到的
            ServiceInstance choose = loadbalancerClient.choose("sca-provider");
            String ip = choose.getHost();//获取实例的ip地址
            int port = choose.getPort();//获取实例的端口号
            //String url = "http://" + ip + ":" + port + "/provider/echo/" + consumerName;
            //加入不想用字符串拼接，可以使用如下方式操作，%s我占位符，传值时一定注意顺序
           String url= String.format("http://%s:%s/provider/echo/%s", ip,port,consumerName);
           //通过restTemplate调用服务提供方（sca-provider)
            return restTemplate.getForObject(url, String.class);
        }


    }


}

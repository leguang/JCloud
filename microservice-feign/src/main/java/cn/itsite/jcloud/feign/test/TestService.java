package cn.itsite.jcloud.feign.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@FeignClient(value = "microservice-eureka-client", fallback = TestService.TestServiceFallback.class)
public interface TestService {
    @GetMapping("/test")
    Map test();

    @Component
    class TestServiceFallback implements TestService {

        @Override
        public Map test() {
            Map<String, String> map = new HashMap<>();
            map.put("11", "TestServiceFallback");
            return map;
        }
    }
}
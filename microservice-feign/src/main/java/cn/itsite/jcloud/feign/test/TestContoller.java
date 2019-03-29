package cn.itsite.jcloud.feign.test;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestContoller {

    @Autowired
    TestService testService;

    @HystrixCommand(fallbackMethod = "ribbonFallback")
    @GetMapping("/test")
    public Map getUser() {

        return testService.test();
    }

    public Map ribbonFallback() {
        Map<String, String> map = new HashMap<>();
        map.put("11", "ribbonFallback");
        return map;
    }
}

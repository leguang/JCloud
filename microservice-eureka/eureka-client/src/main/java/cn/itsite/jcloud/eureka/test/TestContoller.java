package cn.itsite.jcloud.eureka.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class TestContoller {

    @Value("${cn.itsite}")
    private String port;

    @GetMapping("/test")
    public Map getUser() {

        Map<String, String> map = new HashMap<>();
        map.put("11", port);

//        if (true)
//            throw new NullPointerException();
        return map;
    }

}

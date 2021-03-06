package cn.itsite.jbase.test;

import cn.itsite.jbase.common.base.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class TestContoller {

    @GetMapping("/test")
    public BaseResponse getUser() {
        Map<String, String> map = new HashMap<>();
        map.put("11", "11");
        return BaseResponse.success(map);
    }
}

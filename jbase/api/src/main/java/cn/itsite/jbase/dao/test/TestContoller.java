package cn.itsite.jbase.test;

import cn.itsite.jbase.common.base.BaseResponse;
import cn.itsite.jbase.common.test.User;
import cn.itsite.jbase.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class TestContoller {
    @Autowired
    public TestService testService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/test")
    public BaseResponse getUser(@Valid User user) {
        /**
         * 0.参数、请求方法等校验，只需要运用@Valid/@Validated等注解即可，
         * 如果有异常会在全局异常那里捕获到，并作出参数错误的特定响应。
         */
        /**
         * 1.调用service层完成业务逻辑
         */
        SysUser user1 = testService.getUser(user);
        /**
         * 2.拼装统一的响应对象
         */
        return BaseResponse.success(user1);
    }

    //    @PostMapping("/test")
    public Object test(@Validated User user) {
        System.out.println("1111111111111111111111111");
        log.info("111111111111111");
        /**
         * 0.校验参数，只需要调用下面这一行代码即可，
         * 如果有异常会在全局异常那里捕获到，并作出参数错误的特定响应。
         */
//        ValidatorHelper.validate(result);
        /**
         * 1.调用service层完成业务逻辑
         */
//        User user1 = testService.getUser(user);
        /**
         * 2.拼装统一的响应对象
         */
        return "11111111";
    }

    @GetMapping("/language")
    public String language() {
        String[] param = {"11111111", "222222222222"};
        return messageSource.getMessage("403", param, LocaleContextHolder.getLocale());
    }

    @Value("${cn.ev}")
    public String ev;

    @GetMapping("/ev")
    public String ev() {
        return ev;
    }
}

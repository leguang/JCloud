package cn.itsite.jbase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.itsite.jbase.mapper")
public class JBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(JBaseApplication.class, args);
    }
}

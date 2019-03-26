package cn.itsite.jbase.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: leguang
 * @e-mail: langmanleguang@qq.com
 * @version: v0.0.0
 * @blog: https://github.com/leguang
 * @time: 2018/11/25 0025 20:13
 * @description:
 */

@Configuration
@ConfigurationProperties(prefix = "cn.itsite")
@PropertySource(value = "classpath:resource.properties")
public class Resource {
    private String test;

}

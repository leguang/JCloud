package cn.itsite.jbase.common.test;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author: leguang
 * @e-mail: langmanleguang@qq.com
 * @version: v0.0.0
 * @blog: https://github.com/leguang
 * @time: 2018/11/25 0025 20:13
 * @description:
 */
@Data
public class User {
    @NotNull(message = "name {NotNull}")
    private String name;
    @Min(value = 0, message = "age不能小于0")
    @Max(value = 100, message = "age不能大于100")
    private Integer age;
    @NotNull(message = "gender不能为空")
    private String gender;
}

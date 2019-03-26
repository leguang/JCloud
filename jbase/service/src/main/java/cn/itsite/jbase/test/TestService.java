package cn.itsite.jbase.test;

import cn.itsite.jbase.common.test.User;
import cn.itsite.jbase.entity.SysUser;

/**
 * @author: leguang
 * @e-mail: langmanleguang@qq.com
 * @version: v0.0.0
 * @blog: https://github.com/leguang
 * @time: 2019/2/20 0020 21:01
 * @description:
 */
public interface TestService {
    SysUser getUser(User user);
}

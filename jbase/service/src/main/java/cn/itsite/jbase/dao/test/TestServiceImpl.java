package cn.itsite.jbase.test;

import cn.itsite.jbase.common.test.User;
import cn.itsite.jbase.entity.SysUser;
import cn.itsite.jbase.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    public SysUserMapper sysUserMapper;

    @Override
    public SysUser getUser(@Validated User user) {
        /**
         * 0.参数校验，只需要运用@Valid/@Validated等注解即可，
         * 如果有异常会在全局异常那里捕获到，并作出参数错误的特定响应。
         */
        /**
         * 1.调用 dao 层完成业务逻辑
         */
        SysUser user1 = sysUserMapper.selectByPrimaryKey(user.getName());
        /**
         * 2.做相关处理并返回相应数据
         */
        return user1;
    }
}
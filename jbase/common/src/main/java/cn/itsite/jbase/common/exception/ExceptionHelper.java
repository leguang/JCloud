package cn.itsite.jbase.common.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: leguang
 * @e-mail: langmanleguang@qq.com
 * @version: v0.0.0
 * @blog: https://github.com/leguang
 * @time: 2018/11/25 0025 20:03
 * @description:
 */
@Slf4j
public class ExceptionHelper {

    public static void handle(Throwable t) {
        if (t != null) {
            t.printStackTrace();
            log.info("ExceptionHelper-->" + t.getMessage(), t);
        }
    }
}

package cn.itsite.jbase.common.exception;

import cn.itsite.jbase.common.base.BaseResponse;
import lombok.Data;

/**
 * @author: leguang
 * @e-mail: langmanleguang@qq.com
 * @version: v0.0.0
 * @blog: https://github.com/leguang
 * @time: 2018/11/25 0025 19:14
 * @description:
 */

@Data
public class ParamsException extends RuntimeException {
    private Integer code = BaseResponse.PARAMS_ERROR;
    private Object data;

    public ParamsException(Integer code, Object data) {
        super();
        this.code = code;
        this.data = data;
    }

    public ParamsException(Integer code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public static ParamsException paramsError(Object data) {
        return new ParamsException(BaseResponse.Response.PARAMS_ERROR.getCode(), data);
    }
}

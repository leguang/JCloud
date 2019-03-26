package cn.itsite.jbase.common.exception;

import cn.itsite.jbase.common.base.BaseResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: leguang
 * @e-mail: langmanleguang@qq.com
 * @version: v0.0.0
 * @blog: https://github.com/leguang
 * @time: 2018/11/25 0025 20:03
 * @description:
 */

@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        ExceptionHelper.handle(e);
        return BaseResponse.error(BaseResponse.Response.UNKNOW_ERROR);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Object RequestMethodErrorHandler(HttpRequestMethodNotSupportedException e) throws Exception {
        ExceptionHelper.handle(e);
        return BaseResponse.errorRequestMethod(e);
    }

    @ExceptionHandler(value = ParamsException.class)
    public Object paramsExceptionHandler(ParamsException e) throws Exception {
        ExceptionHelper.handle(e);
        Object data = e.getData();
        if (e.getData() != null) {
            List<FieldError> fieldErrors = ((List<FieldError>) e.getData());
            data = fieldErrors.stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
        }
        return BaseResponse.errorParams(data);
    }

    @ExceptionHandler(value = BindException.class)
    public Object validateExceptionHandler(BindException e) {
        ExceptionHelper.handle(e);
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        Object data = errors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return BaseResponse.errorParams(data);
    }
}

package cn.itsite.jbase.common.base;

import cn.itsite.jbase.common.helper.JsonHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Objects;

/**
 * @author: leguang
 * @e-mail: langmanleguang@qq.com
 * @version: v0.0.0
 * @blog: https://github.com/leguang
 * @time: 2018/11/25 0025 17:31
 * @description:
 */
@Slf4j
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> implements Serializable {
    public static final Integer SUCCESS = 200;//成功
    public static final Integer REQUEST_METHOD_ERROR = 405;//请求方法错误
    public static final Integer LOGOUT = 678;//登出、注销、账户在其他地方登录
    public static final Integer PARAMS_ERROR = 601;//非法参数：可能是格式不对，可能是类型不对，具体看message提示
    public static final Integer REPEAT_ERROR = 609;//重复请求，如：验证码[10]分钟内有效
    public static final Integer UNKNOW_ERROR = -1;//未知错误
    public Integer code;
    public String message;
    public Integer page;
    public Integer pageSize;
    public String first;
    public String next;
    public String previous;
    public String last;
    public T data;

    @Autowired
    private MessageSource messageSource;

    public BaseResponse() {
    }

    public BaseResponse(Integer code) {
        this.code = code;
        this.message = getMessage(code + "", null);
    }

    public BaseResponse(Integer code, String message) {
        this(code);
        this.message = message;
    }

    public BaseResponse(Integer code, String message, T data) {
        this(code, message);
        this.data = data;
    }

    public BaseResponse(Integer code, T data) {
        this(code);
        this.data = data;
    }

    public BaseResponse(Response response) {
        this.code = response.getCode();
        this.message = getMessage(code + "", null);
    }

    public BaseResponse(Response response, T data) {
        this(response);
        this.data = data;
    }

    public BaseResponse(BaseResponse<T> response) {
        this.code = response.code;
        this.message = response.message;
        this.data = response.data;
        this.page = response.page;
        this.pageSize = response.pageSize;
        this.first = response.first;
        this.next = response.next;
        this.previous = response.previous;
        this.last = response.last;
    }

    @JsonIgnore
    public Boolean isSuccessful() {
        return Objects.equals(code, SUCCESS);
    }

    @JsonIgnore
    public Boolean isLogout() {
        return Objects.equals(code, LOGOUT);
    }

    public Integer getCode() {
        return code;
    }

    public BaseResponse<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public Integer getPage() {
        return page;
    }

    public BaseResponse<T> setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public BaseResponse<T> setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public String getFirst() {
        return first;
    }

    public BaseResponse<T> setFirst(String first) {
        this.first = first;
        return this;
    }

    public String getNext() {
        return next;
    }

    public BaseResponse<T> setNext(String next) {
        this.next = next;
        return this;
    }

    public String getPrevious() {
        return previous;
    }

    public BaseResponse<T> setPrevious(String previous) {
        this.previous = previous;
        return this;
    }

    public String getLast() {
        return last;
    }

    public BaseResponse<T> setLast(String last) {
        this.last = last;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public BaseResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        String json = JsonHelper.object2String(this);
        log.debug("json-->" + json);
        return json;
    }

    public BaseResponse<T> newBuilder() {
        return new BaseResponse<T>(this);
    }

    public static BaseResponse success() {
        return success(null);
    }

    public static <T> BaseResponse<T> success(T data) {
        BaseResponse<T> response = new BaseResponse<>(SUCCESS, "success");
        response.setData(data);
        return response;
    }

    public static <T> BaseResponse<T> error(Integer code, String message) {
        return new BaseResponse<T>(code, message);
    }

    public static <T> BaseResponse<T> error(Integer code, String message, T data) {
        return new BaseResponse<T>(code, message, data);
    }

    public static <T> BaseResponse<T> error(Integer code, T data) {
        return new BaseResponse<T>(code, data);
    }

    public static <T> BaseResponse<T> error(Integer code) {
        return new BaseResponse<T>(code);
    }

    public static <T> BaseResponse<T> error(Response response) {
        return new BaseResponse<T>(response);
    }

    public static <T> BaseResponse<T> error(Response response, Object data) {
        return new BaseResponse(response, data);
    }

    public static <T> BaseResponse<T> errorParams(T data) {
        return error(Response.PARAMS_ERROR.getCode(), data);
    }

    public static <T> BaseResponse<T> errorLogout() {
        return error(Response.LOGOUT);
    }

    public static <T> BaseResponse<T> errorRequestMethod(Exception e) {
        return error(Response.REQUEST_METHOD_ERROR, e.getMessage());
    }

    public enum Response {
        SUCCESS(BaseResponse.SUCCESS),
        REQUEST_METHOD_ERROR(BaseResponse.REQUEST_METHOD_ERROR),
        LOGOUT(BaseResponse.LOGOUT),
        PARAMS_ERROR(BaseResponse.PARAMS_ERROR),
        REPEAT_ERROR(BaseResponse.REPEAT_ERROR),
        UNKNOW_ERROR(BaseResponse.UNKNOW_ERROR);

        private Integer code;

        Response(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }

    /**
     * 国际化
     * 注：通过@Autowired private MessageSource messageSource无法获取
     *
     * @param result
     * @return
     */
    public String getMessage(String result, Object[] params) {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setCacheSeconds(-1);
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.setBasenames("/i18n/message");

        String message = "";
        try {
            Locale locale = LocaleContextHolder.getLocale();
            message = messageSource.getMessage(result, params, locale);
        } catch (Exception e) {
            log.error("parse message error! ", e);
        }
        return message;
    }
}

package cn.itsite.jbase.common.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: leguang
 * @e-mail: langmanleguang@qq.com
 * @version: v0.0.0
 * @blog: https://github.com/leguang
 * @time: 2018/11/25 0025 17:31
 * @description:
 */
public abstract class BaseController {

    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

//	/**
//	 * 统一异常处理
//	 * @param request
//	 * @param response
//	 * @param exception
//	 */
//	@ExceptionHelper
//	public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
//		LOGGER.error("统一异常处理：", exception);
//		request.setAttribute("ex", exception);
//		if (null != request.getHeader("X-Requested-With") && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
//			request.setAttribute("requestHeader", "ajax");
//		}
//		// shiro没有权限异常
//		if (exception instanceof UnauthorizedException) {
//			return "/403.jsp";
//		}
//		// shiro会话已过期异常
//		if (exception instanceof InvalidSessionException) {
//			return "/error.jsp";
//		}
//		return "/error.jsp";
//	}
//
//	/**
//	 * 返回jsp视图
//	 * @param path
//	 * @return
//	 */
//	public static String jsp(String path) {
//		return path.concat(".jsp");
//	}
//
//	/**
//	 * 返回thymeleaf视图
//	 * @param path
//	 * @return
//	 */
//	public static String thymeleaf(String path) {
//		String folder = PropertiesFileUtil.getInstance().get("app.name");
//		return "/".concat(folder).concat(path).concat(".html");
//	}

}

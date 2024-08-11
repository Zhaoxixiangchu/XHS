package org.example.xhs.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import org.example.xhs.exception.ApiException;
import org.example.xhs.response.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class DefaultExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public AjaxResult handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e, HttpServletRequest request){
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',不支持'{}'请求", requestURI, e.getMethod());
        return AjaxResult.error(e.getMessage());
    }

    /**
     * 未登录
     */
    @ExceptionHandler(NotLoginException.class)
    public AjaxResult handleNotLoginException(NotLoginException e, HttpServletRequest request)
    {
        log.error(e.getMessage(), e);
        Integer code = e.getCode();
        if (code == 11001 || code == 11011 || code == 11012 || code == 11013){
            return AjaxResult.error(code, "会话超时，请重新登录");
        }
        return code != null ? AjaxResult.error(code, e.getMessage()) : AjaxResult.error(e.getMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(ApiException.class)
    public AjaxResult handleServiceException(ApiException e, HttpServletRequest request)
    {
        log.error(e.getMessage(), e);
        Integer code = e.getCode();
        return code != null ? AjaxResult.error(code, e.getMessage()) : AjaxResult.error(e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public AjaxResult handleRuntimeException(RuntimeException e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生未知异常.", requestURI, e);
        return AjaxResult.error(e.getMessage());
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return AjaxResult.error(e.getMessage());
    }

    // 权限异常拦截
    @ExceptionHandler(NotPermissionException.class)
    public AjaxResult handlerException(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return AjaxResult.error("您无权进行该操作");
    }


}

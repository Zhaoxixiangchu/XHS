package org.example.xhs.exception;

import lombok.Data;
import org.example.xhs.enums.ResultCode;

/**
 * 自定义异常
 */
@Data
public final class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    /**
     * 默认构造函数
     */
    public ApiException() {
        super();
    }

    /**
     * 有参构造函数
     *
     * @param message 错误信息
     */
    public ApiException(String message) {
        this.message = message;
        this.code = ResultCode.ERROR.getCode();
    }

    /**
     * 有参构造函数
     *
     * @param message 错误信息
     * @param code 错误码
     */
    public ApiException(String message, Integer code){
        this.message = message;
        this.code = code;
    }

    /**
     * 构造函数
     *
     * @param message 错误信息
     * @param cause   父异常
     */
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造函数
     *
     * @param cause 父类异常
     */
    public ApiException(Throwable cause) {
        super(cause);
    }
}

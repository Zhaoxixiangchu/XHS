package org.example.xhs.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.xhs.enums.ResultCode;

@Data
@AllArgsConstructor
public class AjaxResult<T> {

    private Integer code;

    private String message;

    //泛型 类似Object对象，非指明的某个实体 任何一个东西都可以 User
    private T data;

    public AjaxResult(){
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMessage();
    }

    public AjaxResult(T data){
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMessage();;
        this.data = data;
    }

    public AjaxResult(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public AjaxResult(String message){
        this.code = ResultCode.SUCCESS.getCode();
        this.message = message;
    }

    public AjaxResult(int code, String message){
        this.code = code;
        this.message = message;
    }

    public AjaxResult(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static AjaxResult success(){
        return new AjaxResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    public static AjaxResult success(Object data){
        return new AjaxResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static AjaxResult error(){
        return new AjaxResult(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMessage(), null);
    }

    public static AjaxResult error(String message){
        return new AjaxResult(ResultCode.ERROR.getCode(), message, null);
    }

    public static AjaxResult error(int code, String message){
        return new AjaxResult(code, message, null);
    }

}

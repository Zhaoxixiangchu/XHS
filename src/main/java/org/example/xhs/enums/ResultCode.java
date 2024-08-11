package org.example.xhs.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @description 响应码
 * @author LinXin
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ResultCode {

    SUCCESS(200, "success"),

    ERROR(500, "error");

    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }
}
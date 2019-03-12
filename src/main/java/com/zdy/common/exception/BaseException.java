package com.zdy.common.exception;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import lombok.NonNull;

import java.util.Map;
import java.util.Objects;

/**
 * @author zzw
 */
public class BaseException extends IllegalArgumentException {
    /**
     * serialVersionUID：
     *
     * @since 1.0.0
     */

    private static final long serialVersionUID = -6153700463406664192L;
    private String module;
    private int statusCode;
    private Object[] args;
    private String defaultMessage;

    /**
     * 创建一个新的实例 BaseException.
     */
    public BaseException() {
        super();
    }

    public BaseException(Object code, String message) {
        super(failure(code, message));
    }

    public BaseException(int statusCode, Object[] args) {
        this(null, statusCode, args, null);
    }

    public BaseException(int statusCode, String defaultMessage) {
        this(null, statusCode, null, defaultMessage);
    }

    public BaseException(String module, int statusCode, String defaultMessage, Throwable cause) {
        this(module, statusCode, null, defaultMessage, cause);
    }

    public BaseException(int statusCode, String defaultMessage, Throwable cause) {
        this(null, statusCode, null, defaultMessage, cause);
    }

    public BaseException(String module, int statusCode, Object[] args) {
        this(module, statusCode, args, null);
    }

    public BaseException(Object code, int status, String message) {
        super(failure(code, message, status));
    }

    public BaseException(String module, int statusCode, Object[] args, String defaultMessage) {
        this.module = module;
        this.statusCode = statusCode;
        this.args = args;
        this.defaultMessage = defaultMessage;

    }

    public BaseException(String module, int statusCode, Object[] args, String defaultMessage, Throwable cause) {
        super(defaultMessage, cause);
        this.module = module;
        this.statusCode = statusCode;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public Object[] getArgs() {
        return this.args;
    }

    public String getDefaultMessage() {
        return this.defaultMessage;
    }

    @Override
    public String getMessage() {
        String message = null;

        if (message == null) {
            message = this.defaultMessage;
        }
        if (message == null) {
            message = super.getMessage();
        }
        return message;
    }

    public String getModule() {
        return this.module;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public String toString() {
        return super.getClass() + "{" + "module='" + this.module + '\'' + ", message='" + getMessage() + '\'' + '}';
    }

    public String getCode() {
        if (Objects.nonNull(module)) {
            return module.concat("." + this.getStatusCode());
        }
        return "error." + this.getStatusCode();
    }

    public String toJson() {

        Map<Object, Object> map = Maps.newConcurrentMap();
        map.put("code", getCode());
        map.put("message", getMessage());

        return JSON.toJSONString(map);
    }

    public static String failure(Object message) {
        return failure("error", message);
    }

    public static String failure(Object code, @NonNull Object message) {
        if (message == null) {
            throw new NullPointerException("message");
        } else {
            Map<Object, Object> map = Maps.newConcurrentMap();
            if (Objects.nonNull(code)) {
                map.put("code", code);
            } else {
                map.put("code", "error");
            }

            map.put("message", message);
            return JSON.toJSONString(map);
        }
    }

    public static String failure(Object code, @NonNull Object message, int status) {
        if (message == null) {
            throw new NullPointerException("message");
        } else {
            Map<Object, Object> map = Maps.newConcurrentMap();
            if (Objects.nonNull(code)) {
                map.put("code", code);
            } else {
                map.put("code", "error");
            }
            map.put("status", status);
            map.put("message", message);
            return JSON.toJSONString(map);
        }
    }

}

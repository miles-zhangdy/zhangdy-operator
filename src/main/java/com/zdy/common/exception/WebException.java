package com.zdy.common.exception;

public class WebException extends BaseException {
    private static final long serialVersionUID = 3662587660039395257L;

    public WebException() {
    }

    public WebException(Object code, String message) {
        super(code, message);
    }

    public WebException(String message) {
        super(message, message);
    }
}

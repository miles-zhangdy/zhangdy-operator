package com.zdy.common.exception;


public class AuthenticationTokenException extends BaseException {

    /**
     *
     */
    private static final long serialVersionUID = 6707812859002506197L;


    public AuthenticationTokenException() {
    }

    public AuthenticationTokenException(Object code, String message) {
        super(code, message);
    }


    public AuthenticationTokenException(Object code, String message, int statusCode) {
        super(code, statusCode,  message);
    }

}

package com.ty.token.exception;

/**
 * @author tangyu
 * @date 2020-06-29 10:25
 */
public class IllegalRequestException extends RuntimeException {

    public IllegalRequestException(String message) {
        super(message);
    }

    public IllegalRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}

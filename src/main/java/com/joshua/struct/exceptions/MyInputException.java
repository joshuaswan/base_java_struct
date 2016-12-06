package com.joshua.struct.exceptions;

/**
 * Created by joshua on 2016/12/6.
 */
public class MyInputException extends RuntimeException {
    public MyInputException() {
        super();
    }

    public MyInputException(String message) {
        super(message);
    }
}

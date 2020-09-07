package com.qiumingjie.exception;

/**
 * @author QiuMingJie
 * @date 2020-09-07 22:27
 * @description
 */
public class SignServiceException extends Exception {
    public SignServiceException(Exception e) {

    }
    public SignServiceException(String msg) {
        super(msg);
    }
}

package com.qiumingjie.handler;

import com.qiumingjie.exception.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author QiuMingJie
 * @date 2020-03-16 16:45
 * @description
 */
@RestControllerAdvice
@Slf4j
public class ExceptHandler {
    @ExceptionHandler(ValidateException.class)
    public JsonHandler handleValidateException(ValidateException e) {
        e.printStackTrace();
        log.error(e.getMessage(), e);
        return JsonHandler.fail(e.getMessage());
    }

    /**
     * 方法参数无效异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonHandler handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        log.error(e.getMessage(), e);
        return JsonHandler.fail(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * 方法参数无效异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public JsonHandler handleBindException(BindException e) {
        e.printStackTrace();
        log.error(e.getMessage(), e);
        return JsonHandler.fail(e.getBindingResult().getFieldError().getDefaultMessage());
    }


    @ExceptionHandler(RuntimeException.class)
    public JsonHandler handleBindException(RuntimeException e) {
        e.printStackTrace();
        log.error(e.getMessage(), e);
        return JsonHandler.fail(e.getMessage());
    }
}

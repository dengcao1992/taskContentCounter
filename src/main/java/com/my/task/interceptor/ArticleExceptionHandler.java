package com.my.task.interceptor;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.MalformedURLException;

@ControllerAdvice
public class ArticleExceptionHandler {
//    @ExceptionHandler(MalformedURLException.class)
    @ResponseBody
    ResponseEntity UrlExceptionHandler(){
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

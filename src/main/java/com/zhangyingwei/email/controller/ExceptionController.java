package com.zhangyingwei.email.controller;

import com.zhangyingwei.email.common.Ajax;
import com.zhangyingwei.email.exception.EmailServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: zhangyw
 * @date: 2017/6/28
 * @time: 下午8:59
 * @desc:
 */
@Controller
@ControllerAdvice
public class ExceptionController {
    private Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ResponseBody
    @ExceptionHandler(value = {EmailServerException.class,Exception.class})
    public Object bindExceptionHandler(Exception ex){
        String message = "";
        if(ex instanceof BindException){
            BindException bex = (BindException) ex;
            message = bex.getFieldError().getDefaultMessage();
        }else{
            message = ex.getMessage();
        }
        logger.info("hello exception: "+message);
        return Ajax.error(message);
    }

}

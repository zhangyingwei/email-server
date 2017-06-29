package com.zhangyingwei.email.controller;

import com.zhangyingwei.email.common.Ajax;
import com.zhangyingwei.email.exception.EmailServerException;
import com.zhangyingwei.email.model.Email;
import com.zhangyingwei.email.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author: zhangyw
 * @date: 2017/6/28
 * @time: 下午8:55
 * @desc: email controller
 */
@RestController
@RequestMapping("/email")
public class EmailController {
    Logger logger = LoggerFactory.getLogger(EmailController.class);
    @Value("${auth.key}")
    private String authKey;
    @Value("${email.username}")
    private String username;

    @Autowired
    private EmailService emailService;

    @GetMapping("/hello")
    @ResponseBody
    public Map hello() {
        return Ajax.success("hello");
    }

    @PostMapping("/push")
    public Map send(@Valid Email email,String key) throws EmailServerException {
        if(!authKey.equals(key)){
            logger.info("认证未通过");
            return Ajax.error("认证未通过");
        }
        this.emailService.sendEmail(email);
        logger.info("from:"+username);
        logger.info("to:"+email.getToAddress());
        logger.info("email:"+email);
        return Ajax.success("发送成功");
    }
}

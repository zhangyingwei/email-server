package com.zhangyingwei.email.controller;

import com.zhangyingwei.email.common.Ajax;
import com.zhangyingwei.email.exception.EmailServerException;
import com.zhangyingwei.email.model.Email;
import com.zhangyingwei.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EmailService emailService;

    @GetMapping("/hello")
    @ResponseBody
    public Map hello() {
        return Ajax.success("hello");
    }

    @PostMapping("/publish")
    public Map send(@Valid Email email) throws EmailServerException {
        this.emailService.sendEmail(email);
        return Ajax.success("发送成功");
    }
}

package com.zhangyingwei.email.service;

import com.zhangyingwei.email.exception.EmailServerException;
import com.zhangyingwei.email.model.Email;
import com.zhangyingwei.smail.Smail;
import com.zhangyingwei.smail.config.SmailConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

/**
 * @author: zhangyw
 * @date: 2017/6/28
 * @time: 下午9:17
 * @desc:
 */
@Service
public class EmailService {
    @Value("${email.username}")
    private String username;
    @Value("${email.password}")
    private String password;
    public void sendEmail(Email email) throws EmailServerException {
        try {
            new Smail(new SmailConfig().setStarttls(true)).auth(username, password).to(email.getToAddress()).send(email.getSubject(), email.getContent(),null);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new EmailServerException(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new EmailServerException(e.getMessage());
        }
    }
}

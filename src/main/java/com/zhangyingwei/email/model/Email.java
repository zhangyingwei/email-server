package com.zhangyingwei.email.model;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author: zhangyw
 * @date: 2017/6/28
 * @time: 下午9:18
 * @desc:
 */

public class Email {
    @NotNull(message = "收件人不能为空")
    private String toAddress;
    private String nikeName;
    @NotNull(message = "主题不能为空")
    private String subject;
    private List<String> ccAddress;
    @NotNull(message = "内容不能为空")
    private String content;

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<String> getCcAddress() {
        return ccAddress;
    }

    public void setCcAddress(List<String> ccAddress) {
        this.ccAddress = ccAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "toAddress='" + toAddress + '\'' +
                ", nikeName='" + nikeName + '\'' +
                ", subject='" + subject + '\'' +
                ", ccAddress=" + ccAddress +
                ", content='" + content + '\'' +
                '}';
    }
}

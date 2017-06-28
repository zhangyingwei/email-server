package com.zhangyingwei.email.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author: zhangyw
 * @date: 2017/6/28
 * @time: 下午9:18
 * @desc:
 */
@Data
public class Email {
    @NotNull(message = "收件人不能为空")
    private String toAddress;
    @NotNull(message = "主题不能为空")
    private String subject;
    private List<String> ccAddress;
    @NotNull(message = "内容不能为空")
    private String content;
}

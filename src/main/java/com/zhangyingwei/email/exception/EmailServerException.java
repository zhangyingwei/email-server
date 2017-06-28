package com.zhangyingwei.email.exception;

/**
 * @author: zhangyw
 * @date: 2017/6/28
 * @time: 下午9:29
 * @desc:
 */
public class EmailServerException extends Exception {
    public EmailServerException() {
        super();
    }

    public EmailServerException(String message) {
        super(message);
    }

    public EmailServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailServerException(Throwable cause) {
        super(cause);
    }

    protected EmailServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

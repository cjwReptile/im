package com.reptile.cheng.im.message;

/**
 * @Auther: cjw
 * @Date: 2019/4/4 17:47
 * @Description:
 */
public class Request {

    private Long userId;

    private Long toUser;

    private String message;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getToUser() {
        return toUser;
    }

    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

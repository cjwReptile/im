package com.reptile.cheng.im.message;

/**
 * @Auther: cjw
 * @Date: 2019/4/4 15:52
 * @Description:
 */
public class Reponse {

    private Long toUser;

    private Long fromUser;

    private String message;

    public Long getToUser() {
        return toUser;
    }

    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    public Long getFromUser() {
        return fromUser;
    }

    public void setFromUser(Long fromUser) {
        this.fromUser = fromUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.reptile.cheng.im.session;

import io.netty.channel.Channel;

/**
 * @Auther: cjw
 * @Date: 2019/4/4 15:40
 * @Description:
 */
public class Session {

    private Long userId;

    private Channel channel;

    public Session(Long userId, Channel channel) {
        this.userId = userId;
        this.channel = channel;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}

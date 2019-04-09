package com.reptile.cheng.im.session;

import io.netty.channel.Channel;
import io.netty.util.AttributeKey;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: cjw
 * @Date: 2019/4/4 15:39
 * @Description: 管理用户状态
 */
public class SessionManager {

    //管理在线用户
    private static final ConcurrentHashMap<Long,Channel> onlineUserMap = new ConcurrentHashMap<>();

    //这里的sesson也就是channel
    public static Session register(Long userId,Channel channel){
        Session session = new Session(userId,channel);
        if(onlineUserMap.get(userId) == null){
            channel.attr(AttributeKey.newInstance("session")).set(session);
            onlineUserMap.put(userId,channel);
        }
        return session;
    }

    /**
     *
     * 功能描述: 根据用户id获取回话
     * @param:
     * @return:
     * @auther: cjw
     * @date: 2019/4/9 10:34
     */
    public static Channel getChannel(Long userId){
        Channel channel =  onlineUserMap.get(userId);
        return channel == null ? null:channel;
    }

    /**
     *
     * 功能描述:用户下线，从map中移除
     * @param:
     * @return:
     * @auther: cjw
     * @date: 2019/4/9 10:35
     */
    public static boolean unregister(Long userId){
        Channel channel = onlineUserMap.remove(userId);
        return channel == null ? false:true;
    }

}

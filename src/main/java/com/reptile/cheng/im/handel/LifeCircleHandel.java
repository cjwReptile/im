package com.reptile.cheng.im.handel;

import com.reptile.cheng.im.message.Reponse;
import com.reptile.cheng.im.message.Request;
import com.reptile.cheng.im.session.SessionManager;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: cjw
 * @Date: 2019/4/4 11:04
 * @Description: 了解netty的各事件的生命周期
 */
public class LifeCircleHandel extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(!(msg instanceof Request)){
            return;
        }
        Request request = (Request)msg;
        Channel channel =SessionManager.getChannel(request.getUserId());
        if(channel == null){
            SessionManager.register(request.getUserId(),ctx.channel());
        }
        System.out.println(request.getMessage());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){

        }
        super.userEventTriggered(ctx, evt);
    }
}

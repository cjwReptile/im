package com.reptile.cheng.im.server;

import com.reptile.cheng.im.codec.IMDecode;
import com.reptile.cheng.im.codec.IMEncode;
import com.reptile.cheng.im.handel.LifeCircleHandel;
import com.reptile.cheng.im.message.Reponse;
import com.reptile.cheng.im.message.Request;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: cjw
 * @Date: 2019/4/4 10:50
 * @Description:
 */
public class ImServer {

    private static final Logger log = LoggerFactory.getLogger(ImServer.class);

    private ConcurrentHashMap<Long,Channel> users = new ConcurrentHashMap<>();

    //链接线程
    private final static EventLoopGroup bossGroup = new NioEventLoopGroup();

    //处理线程
    private final static EventLoopGroup workerGroup = new NioEventLoopGroup();



    public static Channel run(int port) throws InterruptedException {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        nioSocketChannel.pipeline().addLast(new IMDecode(Request.class));
                        nioSocketChannel.pipeline().addLast(new IMEncode());
                        nioSocketChannel.pipeline().addLast(new LifeCircleHandel());
                    }
                });
         ChannelFuture future = serverBootstrap.bind(port).sync();
         Channel channel = future.channel();
         return channel;
    }

}

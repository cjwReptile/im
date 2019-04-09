package com.reptile.cheng.im.codec;

import com.reptile.cheng.im.message.Reponse;
import com.reptile.cheng.im.message.Request;
import com.reptile.cheng.im.serializer.Serializer;
import com.reptile.cheng.im.serializer.impl.JsonSerializer;
import com.reptile.cheng.im.serializer.impl.ProtoStuffSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: cjw
 * @Date: 2019/4/4 16:03
 * @Description:
 */
public class IMDecode extends ByteToMessageDecoder  {


    private Class<?> clazz;


    public IMDecode(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if(byteBuf.readableBytes() < 4){
            return;
        }
        //跳过魔数,每个java对象其实都有一个魔数开头
        byteBuf.skipBytes(4);
        //获取序列化类型
        byte serializertype = byteBuf.readByte();

        //获取数据类型
        byte command = byteBuf.readByte();

        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];

        byteBuf.readBytes(bytes);

        Serializer serializer = new JsonSerializer();

        Object reponse = serializer.deserializer(clazz,bytes);

        list.add(reponse);
    }

}

package com.reptile.cheng.im.codec;

import com.reptile.cheng.im.message.Request;
import com.reptile.cheng.im.serializer.Serializer;
import com.reptile.cheng.im.serializer.impl.JsonSerializer;
import com.reptile.cheng.im.serializer.impl.ProtoStuffSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Auther: cjw
 * @Date: 2019/4/4 17:13
 * @Description:
 */
public class IMEncode extends MessageToByteEncoder {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        Serializer serializer = new JsonSerializer();
        byte[] bytes = serializer.serializer(o);
        //魔数
        byteBuf.writeInt(0x12345678);
        //指令类型
        byteBuf.writeByte(1);
        //序列化算法
        byteBuf.writeByte(1);
        //数据流长度
        byteBuf.writeInt(bytes.length);

        byteBuf.writeBytes(bytes);
    }
}

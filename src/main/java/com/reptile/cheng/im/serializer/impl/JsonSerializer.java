package com.reptile.cheng.im.serializer.impl;

import com.alibaba.fastjson.JSON;
import com.reptile.cheng.im.serializer.Serializer;

/**
 * @Auther: cjw
 * @Date: 2019/4/8 15:31
 * @Description:
 */
public class JsonSerializer implements Serializer {
    @Override
    public byte getSerializerAlogrithm() {
        return 0;
    }

    @Override
    public <T> byte[] serializer(T msg) {
        return JSON.toJSONBytes(msg);
    }

    @Override
    public <T> T deserializer(Class<T> clazz, byte[] bytes) {

        return JSON.parseObject(bytes,clazz);
    }
}

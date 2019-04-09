package com.reptile.cheng.im.serializer;

/**
 * @Auther: cjw
 * @Date: 2019/4/4 13:49
 * @Description:
 */
public interface Serializer {

    /**
     *
     * 功能描述:
     * @param:
     * @return: 序列化协议
     * @auther: cjw
     * @date: 2019/4/4 13:51
     */
    byte getSerializerAlogrithm();

    /**
     *
     * 功能描述: 序列化对象
     * @param:
     * @return:
     * @auther: cjw
     * @date: 2019/4/4 13:52
     */
    <T> byte[] serializer(T msg);

    /**
     *
     * 功能描述: 反序列化对象
     * @param:
     * @return:
     * @auther: cjw
     * @date: 2019/4/4 13:52
     */
    <T> T deserializer(Class<T> clazz,byte[] bytes);
}

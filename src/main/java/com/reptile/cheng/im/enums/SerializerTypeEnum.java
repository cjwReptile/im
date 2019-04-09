package com.reptile.cheng.im.enums;

/**
 * @Auther: cjw
 * @Date: 2019/4/4 13:56
 * @Description:
 */
public enum SerializerTypeEnum {

    PROTOSTUFF((byte)1),

    JSONSERIALIZABLE((byte)2);

    public byte type;

    SerializerTypeEnum(byte type) {
        this.type = type;
    }
}

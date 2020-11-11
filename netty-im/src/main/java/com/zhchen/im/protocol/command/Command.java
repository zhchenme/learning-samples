package com.zhchen.im.protocol.command;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/06
 */
public interface Command {

    Byte LOGIN_REQUEST = 1;
    Byte LOGIN_RESPONSE = 2;
    Byte MESSAGE_REQUEST = 3;
    Byte MESSAGE_RESPONSE = 4;
    Byte LOGOUT_REQUEST = 5;
    Byte LOGOUT_RESPONSE = 6;
    Byte CREATE_GROUP_REQUEST = 7;
    Byte CREATE_GROUP_RESPONSE = 8;
    Byte JOIN_GROUP_REQUEST = 9;
    Byte JOIN_GROUP_RESPONSE = 10;
    Byte QUIT_GROUP_REQUEST = 11;
    Byte QUIT_GROUP_RESPONSE = 12;
}

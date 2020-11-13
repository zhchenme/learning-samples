package com.zhchen.im.protocol;

import com.zhchen.im.protocol.command.Command;
import com.zhchen.im.protocol.request.*;
import com.zhchen.im.protocol.response.*;
import com.zhchen.im.protocol.serializer.JSONSerializer;
import com.zhchen.im.protocol.serializer.Serializer;
import io.netty.buffer.ByteBuf;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/06
 */
public class PacketCodec {

    public static final int MAGIC_NUMBER = 0x12345678;
    public static final PacketCodec INSTANCE = new PacketCodec();

    private static final Map<Byte, Class<? extends Packet>> PACKET_TYPE_MAP;
    private static final Map<Byte, Serializer> SERIALIZER_MAP;

    static {
        PACKET_TYPE_MAP = new HashMap<>();
        PACKET_TYPE_MAP.put(Command.LOGIN_REQUEST, LoginRequestPacket.class);
        PACKET_TYPE_MAP.put(Command.LOGIN_RESPONSE, LoginResponsePacket.class);

        PACKET_TYPE_MAP.put(Command.MESSAGE_REQUEST, MessageRequestPacket.class);
        PACKET_TYPE_MAP.put(Command.MESSAGE_RESPONSE, MessageResponsePacket.class);

        PACKET_TYPE_MAP.put(Command.LOGOUT_REQUEST, LogoutRequestPacket.class);
        // PACKET_TYPE_MAP.put(Command.LOGOUT_RESPONSE, Logo.class);

        PACKET_TYPE_MAP.put(Command.CREATE_GROUP_REQUEST, CreateGroupRequestPacket.class);
        PACKET_TYPE_MAP.put(Command.CREATE_GROUP_RESPONSE, CreateGroupResponsePacket.class);

        PACKET_TYPE_MAP.put(Command.JOIN_GROUP_REQUEST, JoinGroupRequestPacket.class);
        PACKET_TYPE_MAP.put(Command.JOIN_GROUP_RESPONSE, JoinGroupResponsePacket.class);

        PACKET_TYPE_MAP.put(Command.QUIT_GROUP_REQUEST, QuitGroupRequestPacket.class);
        PACKET_TYPE_MAP.put(Command.QUIT_GROUP_RESPONSE, QuitGroupResponsePacket.class);

        PACKET_TYPE_MAP.put(Command.LIST_GROUP_MEMBERS_REQUEST, ListGroupMembersRequestPacket.class);
        PACKET_TYPE_MAP.put(Command.LIST_GROUP_MEMBERS_RESPONSE, ListGroupMembersResponsePacket.class);

        PACKET_TYPE_MAP.put(Command.GROUP_MESSAGE_REQUEST, GroupMessageRequestPacket.class);
        PACKET_TYPE_MAP.put(Command.GROUP_MESSAGE_RESPONSE, GroupMessageResponsePacket.class);

        PACKET_TYPE_MAP.put(Command.HEARTBEAT_REQUEST, HeartBeatRequestPacket.class);
        PACKET_TYPE_MAP.put(Command.HEARTBEAT_RESPONSE, HeartBeatResponsePacket.class);

        SERIALIZER_MAP = new HashMap<>();
        Serializer serializer = new JSONSerializer();
        SERIALIZER_MAP.put(serializer.getSerializerAlgorithm(), serializer);
    }

    public ByteBuf encode(ByteBuf byteBuf, Packet packet) {
        /*--- 数据编码格式：魔数-版本-序列化算法-命令-数据字节长度-真实数据 ---*/
        byte[] bytes = Serializer.DEFAULT.serialize(packet);
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }

    public Packet decode(ByteBuf byteBuf) {
        byteBuf.skipBytes(4);
        byteBuf.skipBytes(1);
        byte serializeAlgorithm = byteBuf.readByte();
        byte command = byteBuf.readByte();
        int length = byteBuf.readInt();
        byte[] destBytes = new byte[length];
        byteBuf.readBytes(destBytes);
        Class<? extends Packet> packetType = this.getPacketType(command);
        Serializer serializer = this.getSerializer(serializeAlgorithm);
        if (null == packetType || null == serializer) {
            throw new IllegalArgumentException();
        }
        return serializer.deserialize(packetType, destBytes);
    }

    private Serializer getSerializer(byte serializeAlgorithm) {
        return SERIALIZER_MAP.get(serializeAlgorithm);
    }

    private Class<? extends Packet> getPacketType(byte command) {
        return PACKET_TYPE_MAP.get(command);
    }
}

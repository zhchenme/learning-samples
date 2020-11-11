package com.zhchen.im.util;

import com.zhchen.im.attribute.Attributes;
import com.zhchen.im.protocol.Session;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/11
 */
public class SessionUtil {

    private static final Map<String, Channel> USER_ID_CHANNEL_MAP = new ConcurrentHashMap<>();
    private static final Map<String, ChannelGroup> GROUP_ID_CHANNEL_GROUP_MAP = new ConcurrentHashMap<>();

    private SessionUtil() {
    }

    public static void bindSession(Session session, Channel channel) {
        USER_ID_CHANNEL_MAP.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    public static void unBindSession(Channel channel) {
        if (hasLogin(channel)) {
            USER_ID_CHANNEL_MAP.remove(getSession(channel).getUserId());
            channel.attr(Attributes.SESSION).set(null);
        }
    }

    public static boolean hasLogin(Channel channel) {
        return channel.hasAttr(Attributes.SESSION);
    }

    public static Session getSession(Channel channel) {
        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String userId) {
        return USER_ID_CHANNEL_MAP.get(userId);
    }

    public static void bindChannelGroup(String groupId, ChannelGroup channelGroup) {
        GROUP_ID_CHANNEL_GROUP_MAP.put(groupId, channelGroup);
    }

    public static ChannelGroup getChannelGroup(String groupId) {
        return GROUP_ID_CHANNEL_GROUP_MAP.get(groupId);
    }
}

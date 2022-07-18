package com.inspur.gs.commonutils.demo.socket.netty.utils;


import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelId;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 存储整个工程的全局配置
 * @author tianjinzan
 */
public class NettyUtils {
    /**
     * 存储每一个客户端接入进来时的channel对象
     */
    public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    /**
     * 储存每一个客户端接入进来时的channel键值对 对象
     */
    public static ConcurrentHashMap<String, ChannelId> cannelMap = new ConcurrentHashMap<>();

    /**
     * tcp连接计数器
     */
    private static final AtomicLong TCP_COUNTER = new AtomicLong(0);

    /**
     * 消息计数器
     */
    private static final AtomicLong MSG_COUNTER = new AtomicLong(0);

    /**
     * 储存netty客户端channel管道
     */
    public static void addChannel(String key, Channel channel) {
        group.add(channel);
        cannelMap.put(key, channel.id());
    }

    /**
     * 查询客户端channel管道
     */
    public static Channel findChannel(String key) {
        return group.find(cannelMap.get(key));
    }

    /**
     * 移除客户端channel管道
     */
    public static void removeChannel(Channel channel) {
        NettyUtils.group.remove(channel);
    }

    /**
     * 根据设备标识移除客户端channel
     */
    public static void removeChannel(String key, Channel channel) {
        group.remove(channel);
        cannelMap.remove(key);
    }

    /**
     * 根据设备标识找到客户端channel并发送消息
     */
    public ChannelFuture send(String key, Object value) {

        return findChannel(key).writeAndFlush(value);
    }

    /**
     * 根据客户端channel直接发送消息
     */
    public static void send(Channel channel, Object value) {
        channel.writeAndFlush(value);
    }

    /**
     * 群发消息
     */
    public static void sendAll(Object value) {
        group.writeAndFlush(value);
    }

    /**
     * tcp连接数添加(+1)
     */
    public static long tcpConnIncrementAndGet() {
        return TCP_COUNTER.incrementAndGet();
    }

    /**
     *	tcp连接数添加(-1)
     */
    public static long tcpConnDecrementAndGet() {
        return TCP_COUNTER.decrementAndGet();
    }

    /**
     *	获取tcp连接数
     */
    public static long tcpConnCount() {
        return TCP_COUNTER.longValue();
    }

    /**
     *	消息数添加(+1)
     */
    public static long msgIncrementAndGet() {
        return MSG_COUNTER.incrementAndGet();
    }

    /**
     *	消息数添加(-1)
     */
    public static long msgDecrementAndGet() {
        return MSG_COUNTER.decrementAndGet();
    }

    /**
     *	获取Msg数
     */
    public static long msgCount() {
        return MSG_COUNTER.longValue();
    }
}


package com.inspur.gs.commonutils.demo.socket.netty.server;

import com.inspur.gs.commonutils.demo.socket.netty.utils.NettyUtils;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component(value = "nettyServerHandlerTestDemo")
@ChannelHandler.Sharable
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }

    /**
     * 客户端连接会触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        //tcp连接数加1
        NettyUtils.tcpConnIncrementAndGet();
        //存储channel
        NettyUtils.addChannel(ctx.name(), ctx.channel());
        log.info("客户成功连接!{}",ctx.channel().remoteAddress());
    }

    /**
     * 客户端发消息会触发
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        List tmpList = (List) msg;
        String message;
        Map paraMap = null;
        //获取头部信息通过servCode进入不同服务
        String servCode = ((HashMap)tmpList.get(0)).get("serviceCode").toString().replace("\"","");
        String msgId = ((HashMap)tmpList.get(0)).get("msgId").toString().replace("\"","");
        String source = ((HashMap)tmpList.get(0)).get("source").toString().replace("\"","");
        String msgTime = ((HashMap)tmpList.get(0)).get("msgTime").toString().replace("\"","");
    }

    /**
     * 发生异常触发
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 通知处理器最后的channelread()是当前批处理中的最后一条消息时调用(连接4)(断开1)
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    /**
     * 闲置的(断开2)
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        //tcp连接数减1
        NettyUtils.tcpConnDecrementAndGet();
        //移除channel
        NettyUtils.removeChannel(ctx.channel());
        log.info("客户断开连接!{}",ctx.channel().remoteAddress());
        ctx.close();
    }

    /**
     * tcp断开连接时调用(断开3)
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
    }

    /**
     * 读写空闲触发
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    /**
     * 水位控制
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        super.channelWritabilityChanged(ctx);
    }
}

package com.inspur.gs.commonutils.demo.socket.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

//@Component(value = "nettyClientTestDemo")
public class NettyClient {

    private final Integer port = 1234;

    private final String host = "127.0.0.1";

    private EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

    private final ClientHandlerInitializer clientHandlerInitializer;

    public NettyClient(ClientHandlerInitializer clientHandlerInitializer) {
        this.clientHandlerInitializer = clientHandlerInitializer;
    }

    public static boolean connectFlag = false;

    @PostConstruct
    public void initClient() {
        try {
            try {
                //声明客户端启动类
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(eventLoopGroup)
                        .channel(NioSocketChannel.class)
                        .option(ChannelOption.SO_KEEPALIVE, true)
                        .handler(clientHandlerInitializer)
                        .remoteAddress(host, port);

                ChannelFuture channelFuture = bootstrap.connect().sync();
                channelFuture.channel().close().sync();
            } finally {
                //优雅关闭
                eventLoopGroup.shutdownGracefully();
            }
        } catch (Exception e) {
            System.out.println("连接客户端失败,ip="+host+" 端口："+port);
        }
    }

}

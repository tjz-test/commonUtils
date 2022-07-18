package com.inspur.gs.commonutils.demo.socket.netty.client;

import com.inspur.gs.commonutils.demo.socket.netty.decoder.MessageDecoder;
import com.inspur.gs.commonutils.demo.socket.netty.encoder.MessageEncoder;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component(value = "clientHandlerInitializerTestDemo")
public class ClientHandlerInitializer extends ChannelInitializer<SocketChannel> {

    private final NettyClientHandler channelHandlerAdapter;

    public ClientHandlerInitializer(NettyClientHandler channelHandlerAdapter) {
        this.channelHandlerAdapter = channelHandlerAdapter;
    }

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //添加编解码
        socketChannel.pipeline().addLast("encoder", new MessageEncoder());
        socketChannel.pipeline().addLast("decoder", new MessageDecoder());
        // 处理客户端的请求的数据，并且进行响应
        socketChannel.pipeline().addLast(channelHandlerAdapter);
    }

}

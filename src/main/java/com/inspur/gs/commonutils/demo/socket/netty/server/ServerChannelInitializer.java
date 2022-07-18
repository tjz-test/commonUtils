package com.inspur.gs.commonutils.demo.socket.netty.server;

import com.inspur.gs.commonutils.demo.socket.netty.decoder.MessageDecoder;
import com.inspur.gs.commonutils.demo.socket.netty.encoder.MessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.security.KeyStore;

@Component(value = "serverChannelInitializerTestDemo")
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    /**
     * 服务器证书路径
     */
    private static final String SERVER_PRIVATE_KEY = "D:\\SSLKey\\kserver.keystore";
    /**
     * 信任的证书列表,即客户端证书路径
     */
    private static final String TRUST_KEY = "D:\\SSLKey\\tserver.keystore";
    /**
     * 服务端证书密码
     */
    private static final String SERVER_KEY_STORE_PASSWORD = "123456";
    /**
     * 授信证书密码
     */
    private static final String SERVER_TRUST_KEY_STORE_PASS_WORD = "123456";

    /**
     * 业务控制器
     */
    private final NettyServerHandler channelHandlerAdapter;

    public ServerChannelInitializer(NettyServerHandler channelHandlerAdapter) {
        this.channelHandlerAdapter = channelHandlerAdapter;
    }

    /**
     * ssl认证，加载适配器
     */
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //ssl双向认证
        SSLContext sslCtx = SSLContext.getInstance("SSL");
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        KeyStore ks = KeyStore.getInstance("JKS");
        KeyStore tks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream(SERVER_PRIVATE_KEY), SERVER_KEY_STORE_PASSWORD.toCharArray());
        tks.load(new FileInputStream(TRUST_KEY), SERVER_TRUST_KEY_STORE_PASS_WORD.toCharArray());
        kmf.init(ks, SERVER_KEY_STORE_PASSWORD.toCharArray());
        tmf.init(tks);
        sslCtx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        SSLEngine sslEngine = sslCtx.createSSLEngine();
        sslEngine.setUseClientMode(false);
        socketChannel.pipeline().addFirst(new SslHandler(sslEngine));
        // 编码器
        socketChannel.pipeline().addLast("encoder",new MessageEncoder());
        // 解码器
        socketChannel.pipeline().addLast("decoder",new MessageDecoder());
        // 业务处理器
        socketChannel.pipeline().addLast(channelHandlerAdapter);
    }
}

package com.inspur.gs.commonutils.demo.socket.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.ResourceLeakDetector;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * @author tianjinzan01
 */
@Component(value = "nettyServerTestDemo")
public class NettyServer {

    /**
     * boss 线程组用于处理连接工作
     */
    private final EventLoopGroup boss = new NioEventLoopGroup(2);
    /**
     * work 线程组用于数据处理
     */
    private final EventLoopGroup work = new NioEventLoopGroup(4);

    /**
     * 处理I/O事件或拦截I/O操作，并将其转发到其ChannelPipeline(业务处理链)中的下一个处理程序
     */
    private final ServerChannelInitializer serverChannelInitializer;

    public NettyServer(ServerChannelInitializer serverChannelInitializer) {
        this.serverChannelInitializer = serverChannelInitializer;
    }


    /**
     * SpringBoot 启动的时候 调用
     */
    @PostConstruct
    public void init() {
        System.out.println("正在启动netty服务");
        try {
            //启动服务
            ServerBootstrap bootstrap = new ServerBootstrap();
            /*端口号*/
            int port = 1234;
            bootstrap
                    //配置线程数
                    .group(boss, work)
                    //NioSocketChannel，异步的客户端 TCP Socket 连接
                    //NioServerSocketChannel，异步的服务器端 TCP Socket 连接
                    //NioDatagramChannel，异步的 UDP 连接
                    //NioSctpChannel，异步的客户端 Sctp 连接
                    //NioSctpServerChannel，异步的 Sctp 服务器端连接
                    .channel(NioServerSocketChannel.class)
                    //使用指定的端口设置套接字地址
                    .localAddress(new InetSocketAddress(port))
                    //服务端可连接队列数,对应TCP/IP协议listen函数中backlog参数
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    //设置TCP长连接,一般如果两个小时内没有数据的通信时,TCP会自动发送一个活动探测数据报文
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    //将小的数据包包装成更大的帧进行传送，提高网络的负载,即TCP延迟传输
                    .childOption(ChannelOption.TCP_NODELAY, false)
                    //通道初始值设定
                    .childHandler(serverChannelInitializer);
            //注册监听
            ChannelFuture future = bootstrap.bind().sync();
            if (future.isSuccess()) {
                //使用SIMPLE，以较小开销判断是否内存泄漏
                ResourceLeakDetector.setLevel(ResourceLeakDetector.Level.SIMPLE);
                //解决epollBug
                System.setProperty("org.jboss.netty.epollBugWorkaround", "true");
                System.out.println("Netty Server启动成功，端口号：" + port);
            }
        }catch (Exception e){
            e.printStackTrace();
            //断开链接清理内存
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }

    /**
     * SpringBoot 销毁的时候，断开链接清理内存
     */
    @PreDestroy
    public void destroy() {
        boss.shutdownGracefully();
        work.shutdownGracefully();
    }
}

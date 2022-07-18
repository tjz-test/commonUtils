package com.inspur.gs.commonutils.demo.socket.netty.encoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码器
 * @author tianjinzan01
 */
public class MessageEncoder extends MessageToByteEncoder {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out){
        byte[] bytes = null;
        try
        {
            //msg处理
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        out.writeBytes(bytes);
    }
}

package com.zx.demo.netty.handler;

import com.zx.demo.msg.IMessages;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ClientHandler.channelRead()");
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("ClientHandler.channelReadComplete()");
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("ClientHandler.channelActive()");
        super.channelActive(ctx);
        ctx.writeAndFlush(initMsg());
    }

    private IMessages.IMessage initMsg() {
        IMessages.IRequestMsg.Builder builder = IMessages.IRequestMsg.newBuilder();
        builder.setCgLogin(IMessages.CGPlayerLoginMsg.newBuilder().setRid("1001_1").build());
        IMessages.IMessage message = IMessages.IMessage.newBuilder().setType(IMessages.IMessage.MsgType.CG_PLAYER_LOGIN).setRequest(builder).build();
        return message;
    }

}

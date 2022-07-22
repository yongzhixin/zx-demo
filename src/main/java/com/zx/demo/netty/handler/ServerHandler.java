package com.zx.demo.netty.handler;

import com.zx.demo.msg.IMessages;
import com.zx.demo.msg.handle.IClientHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.SingleThreadEventLoop;

public class ServerHandler extends SimpleChannelInboundHandler<IMessages.IMessage> {

    private IClientHandler clientHandler;

    public ServerHandler(IClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ServerHandler.channelRead() " + Thread.currentThread().getName());
        super.channelRead(ctx, msg);

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("ServerHandler.channelReadComplete() " + Thread.currentThread().getName());
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("ServerHandler.channelActive() " + Thread.currentThread().getName());
        super.channelActive(ctx);
//		ctx.
//		IMsg msg = createSessionMsg();
//		CreateSessionMsg msg = new 
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, IMessages.IMessage msg) throws Exception {
        System.out.println("ServerHandler.channelRead0() " + Thread.currentThread());
        IMessages.IMessage.MsgType type = msg.getType();
        System.out.println(type);
//		ctx.channel().eventLoop().
        EventLoop eventLoop = ctx.channel().eventLoop();
        System.err.println(eventLoop instanceof SingleThreadEventLoop);
        System.err.println((eventLoop.inEventLoop(Thread.currentThread())));

        System.err.println(ctx.channel().eventLoop().parent());
        // this.dispatcher.dispatch(msg);
    }

}
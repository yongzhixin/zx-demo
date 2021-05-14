package com.zx.demo.netty.handler;

import com.zx.demo.msg.IMessage;
import com.zx.demo.msg.MessageType.MsgType;
import com.zx.demo.msg.handle.IClientHandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler extends SimpleChannelInboundHandler<IMessage.IMsg> {

	private IClientHandler clientHandler;

	public ServerHandler(IClientHandler clientHandler) {
		this.clientHandler = clientHandler;
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("ServerHandler.channelRead()" + Thread.currentThread().getName());
		super.channelRead(ctx, msg);

	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.println("ServerHandler.channelReadComplete()" + Thread.currentThread().getName());
		super.channelReadComplete(ctx);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("ServerHandler.channelActive()" + Thread.currentThread().getName());
		super.channelActive(ctx);
//		ctx.
//		IMsg msg = createSessionMsg();
//		CreateSessionMsg msg = new 
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, IMessage.IMsg msg) throws Exception {
		System.out.println("ServerHandler.channelRead0()" + Thread.currentThread().getName());
		MsgType type = msg.getType();
		System.out.println(type);
		// this.dispatcher.dispatch(msg);
	}

}
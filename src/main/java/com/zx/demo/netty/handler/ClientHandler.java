package com.zx.demo.netty.handler;

import com.zx.demo.msg.CGReqPlayer.ReqPlayer;
import com.zx.demo.msg.IMessage;
import com.zx.demo.msg.IMessage.IMsg;
import com.zx.demo.msg.IMessage.IMsg.Builder;
import com.zx.demo.msg.IRequestMsg.IReqMsg;
import com.zx.demo.msg.MessageType.MsgType;

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

	private IMsg initMsg() {
		Builder builder = IMessage.IMsg.newBuilder();
		com.zx.demo.msg.IRequestMsg.IReqMsg.Builder requestBuilder = builder.getRequestBuilder();
		com.zx.demo.msg.CGReqPlayer.ReqPlayer.Builder playerBuilder = requestBuilder.getReqPlayerBuilder();
		builder.setType(MsgType.REQ_PLAYER);
		ReqPlayer reqPlayer = playerBuilder.build();
		requestBuilder.setReqPlayer(reqPlayer);
		requestBuilder.setId(1);
		IReqMsg reqMsg = requestBuilder.build();
		builder.setRequest(reqMsg);
		builder.setSequence(1);
		return builder.build();
	}

}

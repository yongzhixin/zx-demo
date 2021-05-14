package com.zx.demo.msg;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Message;

import io.netty.channel.ChannelHandlerContext;

public class CreateSessionMsg extends GeneratedMessageV3 {

	private ChannelHandlerContext ctx;

	public CreateSessionMsg(ChannelHandlerContext ctx) {
		this.ctx = ctx;
	}

	public ChannelHandlerContext getCtx() {
		return ctx;
	}

	@Override
	public com.google.protobuf.Message.Builder newBuilderForType() {
		return null;
	}

	@Override
	public com.google.protobuf.Message.Builder toBuilder() {
		return null;
	}

	@Override
	public Message getDefaultInstanceForType() {
		return null;
	}

	@Override
	protected FieldAccessorTable internalGetFieldAccessorTable() {
		return null;
	}

	@Override
	protected com.google.protobuf.Message.Builder newBuilderForType(BuilderParent parent) {
		return null;
	}

}

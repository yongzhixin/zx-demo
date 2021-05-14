package com.zx.demo.msg.handle;

import io.netty.channel.ChannelHandlerContext;

public interface IClientHandler {

	public void onClient(ChannelHandlerContext ctx);

}

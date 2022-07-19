package com.zx.demo.netty;

import com.zx.demo.msg.IMessages;
import com.zx.demo.netty.handler.ClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

import java.net.InetSocketAddress;

public class NettyClient {

	public void start() throws Exception {
		EventLoopGroup worker = new NioEventLoopGroup();

		Bootstrap client = new Bootstrap();
		client.group(worker).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
				ch.pipeline().addLast(new ProtobufDecoder(IMessages.IMessage.getDefaultInstance()));
				ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
				ch.pipeline().addLast(new ProtobufEncoder());
				ch.pipeline().addLast(new ClientHandler());
			}
		}).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 100000).option(ChannelOption.SO_KEEPALIVE, true);
		try {
			ChannelFuture future = client.connect(new InetSocketAddress("127.0.0.1", 9999)).sync();
			System.out.println("已成功连接到服务器");
			future.channel().closeFuture().sync();
		} finally {
			worker.shutdownGracefully();
		}

	}

}

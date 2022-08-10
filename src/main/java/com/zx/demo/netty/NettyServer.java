package com.zx.demo.netty;

import com.zx.demo.msg.IMessages;
import com.zx.demo.msg.handle.ServerClientHandler;
import com.zx.demo.netty.handler.ServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.util.concurrent.DefaultThreadFactory;

public class NettyServer {

    private int port;

    public NettyServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup boss = new NioEventLoopGroup(1, new DefaultThreadFactory("acceptor"));
        EventLoopGroup workers = new NioEventLoopGroup(16, new DefaultThreadFactory("ioThread"));

        ServerBootstrap server = new ServerBootstrap();
        server.group(boss, workers).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                        ch.pipeline().addLast(new ProtobufDecoder(IMessages.IMessage.getDefaultInstance()));
                        ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                        ch.pipeline().addLast(new ProtobufEncoder());
                        ch.pipeline().addLast(new ServerHandler(new ServerClientHandler()));
                    }
                }).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);
        try {
            ChannelFuture future = server.bind(port).sync();
            System.out.println("服务器启动成功...");
            future.channel().closeFuture().sync();
        } finally {
            workers.shutdownGracefully();
            boss.shutdownGracefully();
        }
    }

}

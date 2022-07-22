package com.zx.demo.netty;

public class ServerApp {

    public static void main(String[] args) {
        NettyServer server = new NettyServer(8088);
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

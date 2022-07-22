package com.zx.demo.netty;

public class ClientApp {

    public static void main(String[] args) {
        NettyClient client = new NettyClient();
        try {
            client.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

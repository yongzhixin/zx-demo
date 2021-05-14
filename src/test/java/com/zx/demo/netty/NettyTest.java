package com.zx.demo.netty;

import junit.framework.TestCase;

public class NettyTest extends TestCase {

	public void serverStart() throws Exception {
		NettyServer server = new NettyServer(9999);
		server.start();
	}

	public void clientStart() throws Exception {
		NettyClient client = new NettyClient();
		client.start();
	}

}

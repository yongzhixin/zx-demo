package com.zx.demo.netty.processor;

import com.google.protobuf.Message;

public interface IProcessor {
	
	public void putMessage(Message message);

	public void start();

	public void shutdown();

}

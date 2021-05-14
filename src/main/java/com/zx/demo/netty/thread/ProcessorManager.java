package com.zx.demo.netty.thread;

import java.util.HashMap;
import java.util.Map;

import com.google.protobuf.Message;
import com.zx.demo.netty.processor.IoProcessor;

public class ProcessorManager {

	private ProcessorManager() {
	}

	private static class SingletonHolder {
		private final static ProcessorManager INSTANCE = new ProcessorManager();
	}

	public static ProcessorManager getInstance() {
		return SingletonHolder.INSTANCE;
	}

	private Map<Long, IoProcessor> ioProcessors = new HashMap<Long, IoProcessor>();

	public void putMessageToIOProcessor(long workerID, Message message) {
		IoProcessor iot = this.ioProcessors.get(workerID);
		if (iot == null) {
			throw new IllegalArgumentException("unkown io work thread id " + workerID);
		}
		iot.putMessage(message);
	}
}

package com.zx.demo.msg.dispatcher;

import com.zx.demo.msg.IMessage.IMsg;
import com.zx.demo.msg.IRequestMsg.IReqMsg;
import com.zx.demo.msg.IResponseMsg.IRespMsg;
import com.zx.demo.msg.MessageType.MsgType;
import com.zx.demo.msg.handle.OpHandlerManager;

public class MessageDispatcher implements IMessageDispatcher {

	@Override
	public void dispatch(IMsg msg) {
		MsgType type = msg.getType();
		int msgType = type.getNumber();// 消息号
		IReqMsg reqMsg = msg.getRequest();
		IRespMsg respMsg = OpHandlerManager.execute(msgType, reqMsg);
		
		
	}

}

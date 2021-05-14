package com.zx.demo.msg.dispatcher;

import com.zx.demo.msg.IMessage.IMsg;

public interface IMessageDispatcher {

	public void dispatch(IMsg msg);

}

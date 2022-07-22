package com.zx.demo.msg.dispatcher;

import com.zx.demo.msg.IMessages;

public interface IMessageDispatcher {

	public void dispatch(IMessages.IRequestMsg msg);

}

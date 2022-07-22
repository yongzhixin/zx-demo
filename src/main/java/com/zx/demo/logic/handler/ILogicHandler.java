package com.zx.demo.logic.handler;

import com.zx.demo.msg.IMessages;

import java.util.HashMap;
import java.util.Map;

public interface ILogicHandler {

    Map<IMessages.IMessage.MsgType, IMessages.IRequestMsg> msgMaps = new HashMap<>();

    public void register(IMessages.IMessage.MsgType type, IMessages.IRequestMsg msg);

}

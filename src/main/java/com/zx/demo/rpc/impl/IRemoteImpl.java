package com.zx.demo.rpc.impl;

import java.rmi.RemoteException;

import com.zx.demo.rpc.IRemote;

public class IRemoteImpl implements IRemote {

	public void doSomething(String args0) throws RemoteException {
		System.out.println("remote invoke : doSomething---" + args0);
	}

}

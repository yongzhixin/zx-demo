package com.zx.demo.rpc;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import junit.framework.TestCase;

public class RpcClient extends TestCase {

	public void start() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost");
		IRemote r = (IRemote) registry.lookup("remote");
		r.doSomething("hello");
	}

}

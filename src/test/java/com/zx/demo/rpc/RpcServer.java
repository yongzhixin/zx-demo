package com.zx.demo.rpc;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.zx.demo.rpc.impl.IRemoteImpl;

import junit.framework.TestCase;

public class RpcServer extends TestCase {

	public void start() throws Exception {
		String name = "remote";
		IRemote r = new IRemoteImpl();
		UnicastRemoteObject.exportObject(r, 8888);
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.rebind(name, r);
		System.in.read();
	}

}

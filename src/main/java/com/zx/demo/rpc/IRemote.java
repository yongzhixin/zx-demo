package com.zx.demo.rpc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemote extends Remote {

	public void doSomething(String args0) throws RemoteException;

}

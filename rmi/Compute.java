package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * define remote object interface
 */
public interface Compute extends Remote {
    <T> T executeTask(Task<T> t) throws RemoteException;
}

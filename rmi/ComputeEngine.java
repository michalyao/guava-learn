package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ComputeEngine implements Compute {

    public ComputeEngine() {
    }

    @Override
    public <T> T executeTask(Task<T> t) throws RemoteException {
        return t.execute();
    }

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        String name = "Compute";
        Compute engine = new ComputeEngine();
        try {
            // export remote object
            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
            // registry
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("ComputeEngine Serivce Bound");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

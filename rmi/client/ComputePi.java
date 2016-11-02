package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;
import compute.Compute;

public class ComputePi {
    public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // get registry
            Sting name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            // get remote object
            Compute comp = (Compute)registry.lookup(name);
            Pi task = new Pi(Integer.parseInt(args[1]));
            // invoke remote method
            BigDecimal pi = comp.executeTask(task);
            System.out.println(pi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
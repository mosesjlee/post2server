/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post2;

/**
 *
 * @author moseslee
 */
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.registry.Registry;


public class POST2Server {

    public static void main(String args[]) throws IOException
    {
        Registry r = null;
        System.out.println("Starting the security protocols");
        if(System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());
        System.out.println("-------------------------------------------------");
        
        
        //Start the registry
        LocateRegistry.createRegistry(1099);
        try
        {
            r = LocateRegistry.getRegistry();
        }
        catch (RemoteException e)
        {
            System.out.println("Could not locate registry");
        }
        
        System.out.println("Found registry");
        System.out.println("-------------------------------------------------");
        
        //Have the manager class start off the store and communicator
        System.out.println("Manager is starting the store");
        ServerManager startStore = new ServerManager(r);
        
        
        System.out.println("-------------------------------------------------");
        
        //Starts the communicator and binds the registry
        System.out.println("Starting the client server communicator ");
        startStore.startServerClientCommunicator();
        
    }
    
}


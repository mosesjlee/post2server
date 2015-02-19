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


public class POST2Server {

    public static void main(String args[]) throws IOException
    {
        //Create the POST object to start the store
        POST p = new POST();
        p.createProductDataBase("products.txt");
        
        //Create the server/client communicator object
        PostClientServerComm communicator = 
                new PostClientServerComm(p);
        
        //Check for security policy
        if(System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());
        
        //Locate the registry and attempt to bind the 
        //object
        try{
            Registry postRegistry = LocateRegistry.getRegistry();
            postRegistry.rebind("post2comm", communicator);
        }
        catch (RemoteException e){
            System.out.println("Cannot bind the communicator");
        }
        
        
        
        
    }
    
}


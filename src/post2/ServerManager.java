package post2;

import java.rmi.RemoteException;
import java.rmi.registry.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moseslee
 */
public class ServerManager {
    Store s;
    PostClientServerComm communicator;
    Registry r;
    
    public ServerManager(Registry currReg) throws RemoteException
    {
        s = new Store();
        s.createProductDataBase("products.txt");
        r = currReg;
    }
    
    public void startServerClientCommunicator() throws RemoteException
    {
        communicator = new PostClientServerComm(s);
        try
        {
            r.rebind("postComm", communicator);
        }
        catch (RemoteException e)
        {
            System.out.println("Registry cannot be bound");
        }
    }
}

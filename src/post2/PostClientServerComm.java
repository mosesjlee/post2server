/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author moseslee
 */
public class PostClientServerComm extends UnicastRemoteObject
implements PostClientServerCommInterface
{
    InvoiceForm invoice;
    
    public PostClientServerComm() 
            throws RemoteException
    {
        
    }
    
    public ArrayList<Product> getProductListFromHostToClient()
            throws RemoteException
    {
        return null;
    }
    
    public boolean getIsPaymentValidFromHostToClient()
            throws RemoteException
    {
        return true;
    }
        
    public double getFinalTotalPriceFromHostToClient()
            throws RemoteException
    {
        return 0.0;
    }
    public double getAmountReturnedFromHostToClient()
            throws RemoteException
    {
        return 0.0;
    }
    
    public void sendInvoiceFormObjectFromClientToHost(InvoiceForm invoice)
            throws RemoteException
    {
        this.invoice = invoice;
    }
    
}

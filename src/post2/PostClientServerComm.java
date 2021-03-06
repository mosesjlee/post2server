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
    ArrayList <Product> productDBList;
    Store storeReference;
    
    public PostClientServerComm(Store p) 
            throws RemoteException
    {
        //Get the reference to the parent POST object
        storeReference = p;
    }
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    public ArrayList<Product> getProductListFromHostToClient()
            throws RemoteException
    {
        return storeReference.getProductDataBaseList();
    }
    
    public boolean getIsPaymentValidFromHostToClient()
            throws RemoteException
    {
        return storeReference.getCurrentTransaction().isValidTransaction();
    }
        
    public double getFinalTotalPriceFromHostToClient()
            throws RemoteException
    {
        return storeReference.getCurrentTransaction().getTotalPrice();
    }
    public double getAmountReturnedFromHostToClient()
            throws RemoteException
    {
        return storeReference.getCurrentTransaction().getAmountReturned();
    }
    
    public void sendInvoiceFormObjectFromClientToHost(InvoiceForm invoice)
            throws RemoteException
    {
        storeReference.setCurrentInvoiceForm(invoice);
        storeReference.processTransaction();
        storeReference.printReceipt();
    }
}

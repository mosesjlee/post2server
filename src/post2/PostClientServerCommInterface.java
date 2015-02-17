package post2;


import java.rmi.RemoteException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moseslee
 */
public interface PostClientServerCommInterface extends java.rmi.Remote {
    //Client requesting information from the server
    public ArrayList<Product> getProductListFromHostToClient()
            throws RemoteException;
    public boolean getIsPaymentValidFromHostToClient()
            throws RemoteException;
    public double getFinalTotalPriceFromHostToClient()
            throws RemoteException;
    public double getAmountReturnedFromHostToClient()
            throws RemoteException;
    
    public void getInvoiceFormObjectFromClientToHost()
            throws RemoteException;
}

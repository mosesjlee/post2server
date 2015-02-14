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
    
    //Client sending information to the server
    public void sendCustomerNameFromClientToHost(String customerName)
            throws RemoteException;
    public void sendPaymentTypeFromClienToHost(String paymentType)
            throws RemoteException;
    public void sendPaymentAmountFromClientToHost(double amount)
            throws RemoteException;
    public void sendCheckOrCreditNumFromClientToHost(String num)
            throws RemoteException;
    public void sendTransactionDateAndTimeFromClientToHost(String date)
            throws RemoteException;
    public void sendPurchasedProductsListFromClientToHost(ArrayList<Product> prodList)
            throws RemoteException;
}

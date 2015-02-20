/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post2;

import FileReader.ProductsFile;
import java.util.ArrayList;

/**
 *
 * @author moseslee
 */
public class Store {
    Transaction currentTransaction = null;
    Payment customerPayment = null;
    Receipt currentReceipt = null;
    InvoiceForm form = null;
    ProductsFile productDB = null;
    
    public Store()
    {
    }
    
    public void setCurrentInvoiceForm(InvoiceForm currentForm)
    {
        form = currentForm;
    }
    
    public void createProductDataBase(String filename)
    {
        productDB = new ProductsFile(filename);
    }
    
    public ArrayList<Product> getProductDataBaseList()
    {
        return productDB.getProducts();
    }
    
    public Transaction getCurrentTransaction()
    {
        return currentTransaction;
    }
    
    public void processTransaction()
    {
        if(form == null) return;
        
        String name = form.getCustomerName();
        String dateAndTime = form.getDateAndTime();
        String paymentType = form.getPaymentType();
        int accountNumber;
        try{
            accountNumber = Integer.parseInt(form.getAccountNumber());
        }
        catch (NumberFormatException e) {
            accountNumber = -1;
        }
        
        ArrayList<Product> purchasedProductList = form.getPurchasedProductsList();
        
        if(paymentType.equals("credit")){
            customerPayment = new CreditPayment(accountNumber);
        } else if(paymentType.equals("check")) {
            customerPayment = new CheckPayment(accountNumber);
        } else if (paymentType.equals("cash")) {
            customerPayment = new CashPayment();
        } else {
            System.out.println("Not a valid payment form");
            return;
        }
          
        currentTransaction = new Transaction(name, customerPayment, 
                                    purchasedProductList, dateAndTime); 
    }
    
    public void printReceipt()
    {
        if(currentTransaction != null)
        {
            currentReceipt = new Receipt(currentTransaction);
            currentReceipt.WriteFile("SalesLog");
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package post2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Optimus Prime
 */
public class InvoiceForm  implements Serializable {
    
    private String customerName;
    private String paymentType;
    private String accountNumber;
    private double amountPaid;
    private String dateAndTime;
    private ArrayList<Product> purchasedProductsList;

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType the paymentType to set
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * @return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the amountPaid
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * @param amountPaid the amountPaid to set
     */
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * @return the dateAndTime
     */
    public String getDateAndTime() {
        return dateAndTime;
    }

    /**
     * @param dateAndTime the dateAndTime to set
     */
    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    /**
     * @return the purchasedProductsList
     */
    public ArrayList<Product> getPurchasedProductsList() {
        return purchasedProductsList;
    }

    /**
     * @param purchasedProductsList the purchasedProductsList to set
     */
    public void setPurchasedProductsList(ArrayList<Product> purchasedProductsList) {
        this.purchasedProductsList = purchasedProductsList;
    }
    
}

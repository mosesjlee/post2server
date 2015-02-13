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
public class CreditPayment extends Payment
{
        private int creditNumber;
        private String type;
    
    public CreditPayment(int newCreditNumber){
        this.creditNumber=newCreditNumber;
        this.type = "Credit";
    }
    
    public void setCreditNumber(int newCreditNumber){
        this.creditNumber = newCreditNumber;
    }
    public int getCreditNumber(){
        return this.creditNumber;
    }
    public String getType(){
        return type;
    }
}
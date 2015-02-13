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
public class CashPayment extends Payment{
    CashPayment()
    {
    
    }
    
    /*
    *Cash Payment should always return true
    *Assuming that the cash is never forged
    */
    public boolean isValid()
    {
        return true;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post2;

import java.util.Random;

public class Payment {
    Payment()
    {
    }
    
     public boolean isValid(){
        Random rand = new Random();
        int randomInt = rand.nextInt(100);
        return randomInt%10 != 0;
    }
     
}
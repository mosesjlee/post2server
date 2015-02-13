/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Optimus Prime
 */
public class CustomerFile 
{
    String fileName;
    String custName;
    ArrayList <String> USBNS = new ArrayList <String>();
    ArrayList <String> proNames = new ArrayList <String>();
    String methodOfPay;
    ArrayList <Integer> quant = new ArrayList <Integer>(); 
    String checkOrCreditNum;
    
    CustomerFile ()
    {
    fileName = "";
    }
    
    
    ///////////////////////////////////////////////
    // Constructor... Calls Method To start Parsing
    ///////////////////////////////////////////////
    CustomerFile (String a) throws FileNotFoundException, IOException
    {
        fileName = a;
        Go();
    }
    
    
    ////////////////////////////////////////
    // This Methid Parses and Reads The File
    /////////////////////////////////////////
    void Go () throws FileNotFoundException, IOException
    {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader (fr);
        String temp = "";
        int count = 0;
        while ( (temp = br.readLine()) != null)
        {
        System.out.println("This is Current Temp: " + temp);
        
        ///////////////////////////////////////////////
        //At the end Of File checking method of payment
        ///////////////////////////////////////////////
        if(temp.contains("Payment") == true)
        {
            String[] str_array = temp.split(";");
            System.out.println("This is in here...");
            for(int i = 0; i < str_array.length; i++)
            {
            System.out.println(str_array[i]);
            }
            methodOfPay = str_array[1];
            if(methodOfPay.equalsIgnoreCase("credit") || methodOfPay.equalsIgnoreCase("check"))
            {
             checkOrCreditNum = str_array[2];   
            }
           else
            {
            checkOrCreditNum = "N/A";
            }
            break;
        }
        /////////////
        // GetName
        /////////////
        if(count == 0)
        {
            custName = temp;
        }
        
        ///////////////////////////
        // Get USBN and Name Quant
        ///////////////////////////
        if(count >= 1)
        {
        String[] str_array = temp.split(";");
        USBNS.add(str_array[0]);
        int tempInt = Integer.parseInt(str_array[1]);
        quant.add(tempInt);
        proNames.add(str_array[2]);
        }
        count++;
        } // End of the While loop for Looking Through A File...
        fr.close();
    } ///////////////// END OF THE GO METHOD ///////////////////////
    
    /////////////
    
    void printAllData ()
    {
        int count = 0;
        for(String s: USBNS)
        {
            System.out.println("USBNS: " + s + "...at: " + count);
            count++;
        }
        count = 0;
         for(String s: proNames)
        {
            System.out.println("ProductNames: " + s + "...at: " + count);
            count++;
        }
        count = 0;
        for( Integer i: quant)
        {
             System.out.println("Quant: " + i + "...at: " + count);
             count++;
        }
    }
    
    //////////////////////
    // Getters For Data
    /////////////////////
    ArrayList<String> getArrayListOfUPC (){return USBNS;}
    ArrayList<String> getArrayListOfProductNames(){return proNames;}
    ArrayList<Integer> getArrayListOfQuantity () {return quant;}
    String getName (){return custName;} 
}

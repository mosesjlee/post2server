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
public class TransactionFile
{
    String fileName;
    String custName;
    ArrayList<String> names = new ArrayList();
    ArrayList <String> USBNS = new ArrayList ();
    ArrayList <String> proNames = new ArrayList ();
    String methodOfPay;
    ArrayList <Integer> quant = new ArrayList(); 
    String checkOrCreditNum;
    boolean newCustomer = true;
    ArrayList<Product> pros;
    ArrayList<Product> myProducts = new ArrayList();
    ArrayList<Transaction> transactions = new ArrayList();
    double amount;
    
    TransactionFile ()
    {
    fileName = "";
    }
    
    
    ///////////////////////////////////////////////
    // Constructor... Calls Method To start Parsing
    ///////////////////////////////////////////////
    TransactionFile (String a,ArrayList<Product> p) throws FileNotFoundException, IOException
    {
        fileName = a;
        pros = p;
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
        boolean start = true;
        newCustomer = true;
        while ( (temp = br.readLine()) != null )
        {   
            
        // Checks if the String is Empty Starting a New Transaction...
      //  if(temp == null || temp.isEmpty())
      //  {
      //  newCustomer = true;
      //  }
     //   System.out.println("This is Current Temp: " + temp);
        
        ///////////////////////////////////////////////
        //At the end Of File checking method of payment
        ///////////////////////////////////////////////
         if( (newCustomer == true))
        {
            System.out.println("Found a new Customer...");
            //custName = temp;
            names.clear();
            names.add(temp);
            newCustomer = false;
        }
         
       else if(temp.contains("Payment") == true  &&  newCustomer == false)
        {
            String[] str_array = temp.split("\\s+");
         //   System.out.println("This is in here...");
            for(int i = 0; i < str_array.length; i++)
            {
        //    System.out.println(str_array[i]);
            }
            methodOfPay = str_array[1];
            if(methodOfPay.equalsIgnoreCase("credit") || methodOfPay.equalsIgnoreCase("check"))
            {
             checkOrCreditNum = str_array[2];  
             if(methodOfPay.equalsIgnoreCase("check"))
             {
                 amount = Double.parseDouble(str_array[3]);
             }
            }
           else
            {
            checkOrCreditNum = "0";
            amount = Double.parseDouble(str_array[2]);
            }
            newCustomer = true;
            ////////////////////////////////
            // Begin Creating Transaction
            ///////////////////////////////
            Payment p;
            int tempC = Integer.parseInt(checkOrCreditNum);
            
            if(methodOfPay.equalsIgnoreCase("Credit"))
            {
            p = new CreditPayment(tempC);
            }
            
            else if(methodOfPay.equalsIgnoreCase("Check"))
            {
            p = new CheckPayment(tempC);
            }
            else
            {
                p = new CashPayment();
            }
            Transaction t = new Transaction(names.get(0),p,myProducts, "");            
            if(p instanceof CheckPayment || p instanceof CashPayment){t.setAmountTendered(amount);}
            transactions.add(t);
            names.clear();
            USBNS.clear();
            myProducts.clear();
            quant.clear();
            
            names.add(temp);
            
            
            br.readLine();
        }
        /////////////
        // GetName
        /////////////
        
        ///////////////////////////////////////////////////////
        // Get USBN and Name Quant also Checking for Validity
        //////////////////////////////////////////////////////
       else if (count >= 1 && newCustomer == false)
        {
            boolean valid = false;
            String[] str_array = temp.split("\\s+");
            Product insertPro = null;
            
            // Checking the Products and Currently Selected UPC
            for(Product p: pros)
            {
                if(p.getUPC().equalsIgnoreCase(str_array[0]))
                {
                valid = true;
                insertPro = p;
                break;
                }
            }
            if(valid == false){System.out.println("Invalid Item...Will Not Count");}
            else
            {
              int tempInt = 1;
              USBNS.add(str_array[0]);
              if(str_array.length == 1)
              {
              quant.add(1);
              }
              else
              {
              tempInt = Integer.parseInt(str_array[1]);
              quant.add(tempInt);
              }
              
              for(int i = 0; i < tempInt; i ++ )
              {
              myProducts.add(insertPro);
              }
            }
        }
       
        count++;
        //System.out.print("Here ");
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
        /*
         for(String s: proNames)
        {
            System.out.println("ProductNames: " + s + "...at: " + count);
            count++;
        }
                */
        
        for(String s: names)
        {
        System.out.println("Names: " + s);
        }
        count = 0;
        for( Integer i: quant)
        {
             System.out.println("Quant: " + i + "...at: " + count);
             count++;
        }
    }
    
    void setProductDB (ArrayList<Product> p)
    {
    pros = p;
    
    }
    
    
    
    //////////////////////
    // Getters For Data
    /////////////////////
    ArrayList<String> getArrayListOfUPC (){return USBNS;}
    ArrayList<String> getArrayListOfProductNames(){return proNames;}
    ArrayList<Integer> getArrayListOfQuantity () {return quant;}
    ArrayList<String> getNamesList (){return names;}
    ArrayList<Product> getCustomerProducts () {return myProducts;}
    ArrayList<Transaction> getTransactions() {return transactions;}
    String getName (){return custName;} 
}


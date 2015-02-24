/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post2;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.text.DecimalFormat;

public class Receipt {
    Transaction currTrans;
    ArrayList <Transaction> transList;
    private String storeName;
    private String date;
    private String time;
    private String customerName;
    private String productName;
    private double totalPrice;
    private double amountReturned;
    private double amountTendered;
    DecimalFormat df = new DecimalFormat("0.00##");
    
    
    Receipt(Transaction t)
    {
        currTrans = t;
    }
    
    Receipt(ArrayList<Transaction> t)
    {
        transList = t;
    }
    
    public void WriteFile(String fileName){
        PrintWriter out;
        File file = new File("Receipts");
        file.mkdir();
        ArrayList<Product> foundProducts = new ArrayList();
        try{
            if (fileName.equalsIgnoreCase("ReceiptList.txt"))
            {
        out = new PrintWriter(new FileWriter(fileName, true));
            }

            else{
                fileName = fileName.replaceAll(" ", "_");
                fileName = fileName.replaceAll("/", "_");
                
                out = new PrintWriter(new FileWriter("Receipts/"+fileName.replaceAll(":", "_")+".txt", true));
            } 
        out.println("--------------------");
        out.println("STORE NAME \n");
        out.println("");
        out.println(currTrans.getName() + " " + currTrans.getDateAndTime());
        out.println("");
        for (Product p : currTrans.getProducts()){
            if (foundProducts.contains(p)==false)
            {
            out.println("Item " + p.getName() + " " + 
                    currTrans.getQuantity(p) + " @ " + 
                    df.format(p.getPrice()));
            foundProducts.add(p);
            }
        }
        out.println("Total: " + df.format(currTrans.getTotalPrice()));
        out.print("Amount Tendered: " + df.format(currTrans.getAmountTendered()));
        if (currTrans.getType().equals("cash"))
        {
            out.println("Cash");
        }
        else if (currTrans.getType().equals("check")){ 
           out.println("check #: " + 
                   ((CheckPayment)currTrans.getPayType()).getCheckNumber());
        }
        else{
            out.println("credit card #: " + 
                    ((CreditPayment)currTrans.getPayType()).getCreditNumber());
        }
        out.println("Amount Returned: " + df.format(currTrans.getAmountReturned()));
        out.println("--------------------");
        out.close();
        }
        catch(Exception e){System.out.println("File not found");}
    }

}


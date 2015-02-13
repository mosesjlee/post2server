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
import FileReader.ProductsFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class POST2Server {

    public static void main(String args[]) throws IOException
    {
        //Variables tat the entire program needs
        ProductsFile productDB = new ProductsFile("products.txt");
        ArrayList <Product> productDBList = productDB.getProducts();
        ArrayList <Product> custProductList;
        ArrayList <Transaction> currentTransaction = null;
        
        //Variables if the user reads from order file
        int hasOrderForm = 1;   //1 to read from a transaction file else to manually input
        String fileName;        //User specified order file
        TransactionFile orderForm = null; //Class to process the order

        //Variables if the user manually inputs
        String name;
        Payment payType;

        //Greeting and intro
        System.out.println("Welcome to Point of Sale Terminal!");
        System.out.println("Enter the name of the file with the transactions");
        System.out.println("Afterwards a receipt will be printed for you");
        Scanner inputScan = new Scanner(System.in);

        //Begin the user interaction
        while(hasOrderForm >= 0)
        {

           System.out.println("Input 1 if you want to enter a file");
           System.out.println("Input anything else if you want to quit");
           try
           {
               hasOrderForm = inputScan.nextInt();
           }
           catch (InputMismatchException e)
           {
               break;
           }
           if(hasOrderForm != 1) break;
           
           //Reads the order form
           System.out.println("Enter in the order file name: ");
           fileName = inputScan.next();
           try
           {
               orderForm = new TransactionFile(fileName, productDBList);

           }
           catch (Exception e)
           {
               System.out.println("Invalid File Try Again");
               break;
           }


           currentTransaction = orderForm.getTransactions();

           System.out.println("Printing receipt");
           for(Transaction t : currentTransaction)
           {
               Receipt test = new Receipt(t);
               test.WriteFile("ReceiptList.txt");
               test.WriteFile(t.getDateAndTime());
           }
        }
    }   
}


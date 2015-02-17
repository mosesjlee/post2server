package post2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author moseslee
 */
public class Transaction
{
	double totalPrice;                             //total price
	double amountTendered;                         //amount paid
	double amountReturned;                         //change
	boolean validTransaction;                      //if its valid payment
	Payment customerPayment;                               //Payment object 
	String custName;                               //Customers name
        String dateAndTime;                            //Date and Time
        String type;                                   //Type of payment name
        Date d;                                        //For the date object
        DateFormat dateFormat;                         //To format the date
	ArrayList <Product> products;                  //list of products
        //Variable names for the type
        private final static String checkType = "check";
        private final static String cashType = "cash";
        private final static String creditType = "credit";
        
        /**
         * Default Constructor
         */
        Transaction()
        {
            products = new ArrayList();
        }
        
        /**
         * Constructor that takes in customer name, payment object, and 
         * array list of products
         * @param name Customer's name
         * @param pay payment object. Could be credit, check, cash payment
         * @param custProdList list of customer's valid product
         */
        Transaction(String name, Payment pay, ArrayList <Product> custProdList)
        {
           //Save default 
           custName = name;
           products = new ArrayList();
           if(pay instanceof CreditPayment) type = creditType;
           else if(pay instanceof CheckPayment) type = checkType;
           else if(pay instanceof CashPayment) type = cashType;
           
           customerPayment = pay;
           
           //Create a date object to get relevant date information
           d = new Date();
           dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
           dateAndTime = dateFormat.format(d);
           
           //Check to see if the payment is valid
           setValidTransaction();
           
           
           //Copy the product list from the customers list
           for(Product c : custProdList)
               products.add(c);
           
           //Calculate Total Price
           calculateTotalPrice();
           
           //If its cash payment calculate the change
           if(type.equals(cashType) || type.equals(checkType))
           {
               calculateAmountReturned();
           }
        }

        /**
         * Calculates total price
         */
	private void calculateTotalPrice()
	{
            for (Product p : products)
            {
                totalPrice += p.getPrice();
            }
	}
        
        /**
         * Returns total price
         * @return total price
         */
        double getTotalPrice()
        {
            return totalPrice;
        }
        
        /**
         * Sets the amount tendered
         * @param amount the amount tendered
         * If credit than amount tendered is the total price
         * else amount is the specified users amount
         */
        void setAmountTendered(double amount)
        {
            amountTendered = amount;
            calculateAmountReturned();
        }
        
        /**
         * Returns the amount tendered
         * @return the amount tendered
         */
        double getAmountTendered()
        {
            return amountTendered;
        }
        
        /**
         * Caclualate the change
         */
        private void calculateAmountReturned()
        {
            amountReturned = amountTendered - totalPrice;
        }
        
        /**
         * Returns the amount of change
         * @return amountReturned
         */
        double getAmountReturned()
        {
            return amountReturned;
        }

        /**
         * Returns true if its a valid transaction
         * else false
         * @return 
         */
	boolean isValidTransaction()
	{
            return validTransaction;
	}
        
        /**
         * Checks to see if payment is valid
         */
        private void setValidTransaction()
        {
            validTransaction = customerPayment.isValid();
        }
       
        
        /**
         * Returns the date in string
         * @return the date
         */
        public String getDateAndTime()
        {
            return dateAndTime;
        }
        
        /**
         * Returns the custoemrs name
         * @return customers name
         */
        public String getName()
        {
            return custName;
        }
        
        /**
         * Returns the payment object
         * @return payType
         */
        public Payment getPayType()
        {
            return customerPayment;
        }
        public String getType()
        {
            return type;
        }

        public int getQuantity(Product p)
        {
            int count = 0;
            for (Product product : products)
            {
                if (product.equals(p))
                {
                    count++;
                }
            }
            return count;
        }
        
        /**
         * Returns the list of products customer buys
         * @return products
         */
        public ArrayList<Product> getProducts()
        {
            return products;
        }

}


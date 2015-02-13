package post2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moseslee
 */

public class Product 
{
    private String upc;
    private String name;
    double price;
    
    public Product(String upc, String name, double price){
        this.upc=upc;
        this.name=name;
        this.price=price;
    }
    
    public String getUPC(){
        return this.upc;
    }
    public void setUPC(String newUPC){
        this.upc=newUPC;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name=newName;
    }
    public double getPrice(){
        return price;
    }
    
}
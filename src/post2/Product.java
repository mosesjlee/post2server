package post2;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moseslee
 * Implements serializable in order to pass through RMI
 */

public class Product implements Serializable
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

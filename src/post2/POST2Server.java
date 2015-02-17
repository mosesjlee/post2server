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

public class POST2Server {

    public static void main(String args[]) throws IOException
    {
        //Create the POST object
        POST p = new POST();
        
        //Create the server/client communicator object
        PostClientServerComm communicator = new PostClientServerComm();
    }
    
}


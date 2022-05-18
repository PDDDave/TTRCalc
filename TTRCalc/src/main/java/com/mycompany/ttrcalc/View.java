/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ttrcalc;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class View {
    Scanner keyboard = new Scanner(System.in);
    Art a = new Art();
    
    
    
     /**
     * This method formats a String to start with a capital letter.
     * @return 
     */
    public String inCapString(){
        String capString= "";
        char small;
        String big;
        String inString;
        
        //get capital letter
        inString = keyboard.nextLine().toLowerCase();
        small = inString.charAt(0);
        big = String.valueOf(small).toUpperCase();
        
        capString = big + inString.replaceFirst(String.valueOf(small), "");
        
        return capString;
    }
    
    /**
     * This method is used to read user input as a String
     * @return Returns the input as String
     */
    public String inString(){
        return keyboard.nextLine().toLowerCase();
    }
    
    public void printString(String outPut){
        System.out.println(outPut);
    }
    
}

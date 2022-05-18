/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ttrcalc;

/**
 *
 * @author David
 */
public class USA1910Game extends ClassicGame {
    
    public void addBonus (Player tPlayer){
        int tBonus = 15;
        tPlayer.setpScore(tPlayer.getpScore() + tBonus);
    }
    
}

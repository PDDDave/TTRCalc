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
public class MegaGame extends ClassicGame {
    
    public MegaGame(int pCount){
        super(pCount);
        super.setGameType(4);
    }
    public void addBonus(Player lPlayer, Player tPlayer){
        int lBonus = 10;
        int tBonus = 15;
        lPlayer.setpScore(lPlayer.getpScore() + lBonus);
        tPlayer.setpScore(tPlayer.getpScore() + tBonus);
    }
}

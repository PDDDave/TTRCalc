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
public class ClassicGame {
    
    private int playerCount = 0;
    
    public ClassicGame(int pCount){
        playerCount = pCount;
    }

    public void addBonus(Player IPlayer){
        int IBonus = 10;
        IPlayer.setpScore(IBonus);
    }
    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
    
    
    
}

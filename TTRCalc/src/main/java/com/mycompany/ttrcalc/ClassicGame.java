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
    private int gameType = 1;
    
    public ClassicGame(int pCount){
        playerCount = pCount;
    }

    public void addBonus(Player lPlayer){
        int lBonus = 10;
        lPlayer.setpScore(lPlayer.getpScore() + lBonus);
    }
    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }
    
    
    
}

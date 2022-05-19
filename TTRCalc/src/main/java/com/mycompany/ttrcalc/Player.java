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
public class Player {
    
    private String pName;
    private int pNum;
    private int pScore;
    private int scoredRoutes;
    private int remainRoutes;
    
    public Player(String name,int number){
        pName = name;
        pNum = number;
        pScore = 0;
        scoredRoutes = 0;
        remainRoutes = 0;
    }
    public int calculateScore(){
        pScore = (pScore + scoredRoutes) - remainRoutes;
        
        return pScore;
    }
    
    @Override public String toString(){
        String message = "Player Name: \t" + pName +"\n"
                       + "Player Score:\t" + pScore +"\n";
        
        return message;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpNum() {
        return pNum;
    }

    public void setpNum(int pNum) {
        this.pNum = pNum;
    }

    public int getpScore() {
        return pScore;
    }

    public void setpScore(int pScore) {
        this.pScore = pScore;
    }

    public int getScoredRoutes() {
        return scoredRoutes;
    }

    public void setScoredRoutes(int scoredRoutes) {
        this.scoredRoutes = scoredRoutes;
    }

    public int getRemainRoutes() {
        return remainRoutes;
    }

    public void setRemainRoutes(int remainRoutes) {
        this.remainRoutes = remainRoutes;
    }
    

    
}

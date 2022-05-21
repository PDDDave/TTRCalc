/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ttrcalc;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Controller {
    View v = new View();
    ClassicGame game;
    Player[] allPlayers;
    String fileName = "C:\\Code\\halloffame.txt";
    
    public void calcStart() throws InterruptedException, FileNotFoundException{
        int choice;
        boolean again = false;
        v.printString(v.a.train);
        v.printString(v.a.sTitle);
        v.enterToCont();

        
        do{
            v.printString("Would you like to Play a new game(1), view the Hall of fame?(2) or quit(3)");
            choice = v.inInt();
            switch (choice){
            case 1:
                again = false;
                gameSetup();
                break;
            case 2:
                again = true;
                hallOfFame();
                break;
            case 3:
                v.printString(v.a.thanks);
                System.exit(0);
            default:
                v.printString("Unknown Value");
                break;
        }
        }while(again == true);
        
        //gameSetup();
    }

    private void gameSetup() throws InterruptedException {
        int players;
        int gameType;
        
        v.printString(v.a.gSetup);
        v.waitASec();
        v.printString("How many Players? (2-4)");
        players = v.inInt();
        v.printString("What game type are you playing?(1 - 4)\n"
                + "1 - Classic\n2 -USA 1910\n3 - Big Cities\n4 - Mega");
        gameType = v.inInt();
        
        allPlayers = createPlayers(players);
        game = createGame(gameType, players);
        
        gameStart(gameType, allPlayers);
    }

    private Player[] createPlayers(int count) {
        
        Player[] players = new Player[count];
      
        for(int i=0; i<players.length; i++){
            v.printString("Enter Player #" + (i + 1) + "'s name:");
            players[i] = new Player(v.inCapString(),i+1);
        }
        
        return players;
    }
    
    private ClassicGame createGame(int gameType, int players){
            switch (gameType){
            case 1:
                 game = new ClassicGame(players);
                break;
            case 2: 
                 game = new USA1910Game(players);
                break;
            case 3:
                 game = new BigCitiesGame(players);
                break;
            case 4:
                 game = new MegaGame(players);
                break;       
        }
         return game;
    }

    private void gameStart(int gameType, Player[] allPlayers) throws InterruptedException {
        //game running logic
        boolean cont = true;
        String action = "";
        String[] pNames;
        String quickHelp = "Enter a command (List, A Player's name, All, Help, Game Over):";
        String controlls = "When a player scores or draws a new ticket you will need to enter that information into the app.\n"
                + "In order to do that you will need to enter the player's name in order to view"
                + "thier current score stats as well as record a new score!\n"
                + "Once the game is over, Enter 'Game Over' to apply bonuses and final scoring!\n"
                + "(Type HELP to see this message again)";
        
        
        v.printString(controlls);
        v.printString("Game Start!  Good luck!");
        v.waitASec();
        
        //get player names
        
        
        do{
        //main loop
        v.printString(v.a.mMenu + "\n");
        v.printString(quickHelp);
        action = v.inString();
        
        switch (action){
            case "list":    
                String list = "";
                for(int i = 0; i<allPlayers.length;i++){
                    list = list + allPlayers[i].getpName() + "\n";
                }
                v.printString(list);
                v.enterToCont();
                break;
            case "help":
                v.printString(controlls);
                v.enterToCont();
                break;
            case "all":
                allPlayers();
                v.enterToCont();
                break;
            case "game over":
                gameOver();
                break;
            default:
                if(isPlayer(action)){
                    for(int i=0; i<allPlayers.length;i++){
                        if(action.equals(allPlayers[i].getpName().toLowerCase())){
                            playerAction(allPlayers[i]);
                        }
                    }
                    break;
                }
                else{
                    v.printString("Unknown Value, please try again");
                    break;
                }

            }        
        
        }while(cont==true);     
    }


    private boolean isPlayer(String action) {
        boolean result = false;
        
        for(int i=0;i<allPlayers.length;i++){
            if(action.equals(allPlayers[i].getpName().toLowerCase())){
                result = true;
            }
        }
        
        return result;
        
    }

    private void playerAction(Player player) throws InterruptedException {
        String pInstructions = "Enter a command: Score, Back";
        String action = "";
        
        
        v.printString(v.a.pStats);
        v.printString(player.toString());
        v.waitASec();
        v.printString(pInstructions);
        action = v.inString();
        
        switch(action){
            case "back":
                break;
            case "score":
               // v.printString("Scoring");
                playerScore(player);
                break;
            default:
                v.printString("Unknown value, please try again");
                v.enterToCont();
                break;
        }
    }
        
        
//        v.printString("Game Starting....");
//        v.enterToCont();
//        
//        for(int i=0;i<allPlayers.length;i++){
//            v.printString(allPlayers[i].toString());
//        }
//        v.printString(Integer.toString(gameType));

    private void allPlayers() {
        for(int i=0;i<allPlayers.length;i++){
            v.printString(allPlayers[i].toString());
        }
    }

    private void playerScore(Player player) throws InterruptedException {
        int trains;
        int points=0;
        boolean cont;
        
        v.printString(v.a.score);
        v.waitASec();

        
        do{
            v.printString("How many Trains did " + player.getpName() + " score?");
            v.printString("**(Enter 0 to cancel)**");
            cont = false;
            trains = v.inInt();
            switch(trains){
                case 1:
                    points =1;
                    break;
                case 2:
                    points =2;
                    break;
                case 3:
                    points =4;
                    break;
                case 4:
                    points =7;
                    break;
                case 5:
                    points =10;
                    break;
                case 6:
                    points =15;
                    break;
                case 0:
                    break;
                default:
                    v.printString(Integer.toString(trains) + " is not a valid number, please try again");
                    cont = true;
                    
                    v.enterToCont();                    
            }
        }while(cont == true);
        
        player.setpScore(player.getpScore() + points);
        v.printString("A route with " +Integer.toString(trains) + " trains is worth " + 
                Integer.toString(points) + " points.");
        v.printString(player.getpName() + "'s score is now: " + player.getpScore());
        v.enterToCont();
    }

    private void gameOver() {
        Player lPlayer = allPlayers[0];
        Player tPlayer = allPlayers[0];
        Player winner = allPlayers[0];
        String contents;
        boolean cont = false;
        int choice =0;
        int highScore=0;
        int remain;
        int destinationPoints;
        v.printString(v.a.gameOver);
        v.enterToCont();
        //add destination tickets
        for(int i=0;i<allPlayers.length;i++){
            v.printString("How many points were " + allPlayers[i].getpName()+ "'s SCORED destination tickets worth?");
            destinationPoints = v.inInt();
            v.printString("How many points were " + allPlayers[i].getpName()+"'s NOT-SCORED destination tickets worth (enter 0 if none)?:");
            remain = v.inInt();
           
            allPlayers[i].setpScore((allPlayers[i].getpScore() + destinationPoints) - remain);
        }
        
        //calculate bonuses and winner
        switch(game.getGameType()){
            case 1:
                v.printString("Which player had the longest road?");
                for(int i=0;i<allPlayers.length;i++){
                    v.printString((i+1) + ".\t" + allPlayers[i].getpName());
                }
                choice = v.inInt();
                do{
                    cont = false;
                    switch(choice){
                    case 1:
                        v.printString(allPlayers[0].getpName() + " has the longest road");
                        lPlayer = allPlayers[0];
                        break;
                    case 2:
                        v.printString(allPlayers[1].getpName() + " has the longest road");
                        lPlayer = allPlayers[1];
                        break;
                    case 3:
                        v.printString(allPlayers[2].getpName() + " has the longest road");
                        lPlayer = allPlayers[2];
                        break;
                    case 4:
                        v.printString(allPlayers[3].getpName() + " has the longest road.");
                        lPlayer = allPlayers[3];
                        break; 
                    default:
                        v.printString("Unknown value.");
                        cont = true;
                        break;
                        }
                }while(cont == true);
                //finish adding player bonuses
                game.addBonus(lPlayer);
                break;
            case 2:
                v.printString("Which player had the most Destination tickets?");
                for(int i=0;i<allPlayers.length;i++){
                    v.printString((i+1) + ".\t" + allPlayers[i].getpName());
                }
                choice = v.inInt();
                do{
                    cont = false;
                    switch(choice){
                    case 1:
                        v.printString(allPlayers[0].getpName() + " has the most destination tickets!");
                        tPlayer = allPlayers[0];
                        break;
                    case 2:
                        v.printString(allPlayers[1].getpName() + " has the most destination tickets!");
                        tPlayer = allPlayers[1];
                        break;
                    case 3:
                        v.printString(allPlayers[2].getpName() + " has the most destination tickets!");
                        tPlayer = allPlayers[2];
                        break;
                    case 4:
                        v.printString(allPlayers[3].getpName() + " has the most destination tickets!");
                        tPlayer = allPlayers[3];
                        break; 
                    default:
                        v.printString("Unknown value.");
                        cont = true;
                        break;
                        }
                }while(cont == true);
                game.addBonus(tPlayer);
                break;
            case 3:
                
                break;
            case 4:
                v.printString("Which player had the longest road?");
                for(int i=0;i<allPlayers.length;i++){
                    v.printString((i+1) + ".\t" + allPlayers[i].getpName());
                }
                choice = v.inInt();
                do{
                    cont = false;
                    switch(choice){
                    case 1:
                        v.printString(allPlayers[0].getpName() + " has the longest road");
                        lPlayer = allPlayers[0];
                        break;
                    case 2:
                        v.printString(allPlayers[1].getpName() + " has the longest road");
                        lPlayer = allPlayers[1];
                        break;
                    case 3:
                        v.printString(allPlayers[2].getpName() + " has the longest road");
                        lPlayer = allPlayers[2];
                        break;
                    case 4:
                        v.printString(allPlayers[3].getpName() + " has the longest road.");
                        lPlayer = allPlayers[3];
                        break; 
                    default:
                        v.printString("Unknown value.");
                        cont = true;
                        break;
                        }
                }while(cont == true);
                //finish adding player bonuses
                game.addBonus(lPlayer);
                
                                v.printString("Which player had the most Destination tickets?");
                for(int i=0;i<allPlayers.length;i++){
                    v.printString((i+1) + ".\t" + allPlayers[i].getpName());
                }
                choice = v.inInt();
                do{
                    cont = false;
                    switch(choice){
                    case 1:
                        v.printString(allPlayers[0].getpName() + " has the most destination tickets!");
                        tPlayer = allPlayers[0];
                        break;
                    case 2:
                        v.printString(allPlayers[1].getpName() + " has the most destination tickets!");
                        tPlayer = allPlayers[1];
                        break;
                    case 3:
                        v.printString(allPlayers[2].getpName() + " has the most destination tickets!");
                        tPlayer = allPlayers[2];
                        break;
                    case 4:
                        v.printString(allPlayers[3].getpName() + " has the most destination tickets!");
                        tPlayer = allPlayers[3];
                        break; 
                    default:
                        v.printString("Unknown value.");
                        cont = true;
                        break;
                        }
                }while(cont == true);
                game.addBonus(tPlayer);
                break;
        }
        //calcWinner
        for(int i=0;i<allPlayers.length;i++){
            if(allPlayers[i].getpScore() > highScore){
                highScore=allPlayers[i].getpScore();
                winner = allPlayers[i];
            }
        }
        v.printString(v.a.winnerIs);
        v.printString(winner.getpName() + "!!!!");
        v.printString("Final Score:\t" + winner.getpScore());
        v.printString("..recording win..");
        v.enterToCont();
        contents = winner.getpName() +","+winner.getpScore() ;
        v.writeToFile(fileName, contents);
        v.printString(v.a.thanks);
        //exits the application
        System.exit(0);
    }

    private void hallOfFame() throws FileNotFoundException {
        //read from file the names of previous winners into array for display
        ArrayList<String> hallOfFame = new ArrayList<String>();
        String line;
        String player;
        String score;
        hallOfFame = v.readArray(fileName);
        
        v.printString(v.a.hall);
        v.printString("Winner\t\tScore");
        for(int i=0;i<hallOfFame.size();i++){
            String[]parts;
            line = hallOfFame.get(i);
            parts = line.split(",");
            v.printString(parts[0] + "\t\t" + parts[1]);
        }
        v.enterToCont();
    }
    

}

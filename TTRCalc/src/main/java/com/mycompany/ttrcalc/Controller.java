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
public class Controller {
    View v = new View();
    ClassicGame game;
    Player[] allPlayers;
    public void calcStart() throws InterruptedException{
        v.printString(v.a.train);
        v.printString(v.a.mTitle);
        v.printString(v.a.sTitle);
        v.enterToCont();
        gameSetup();
    }

    private void gameSetup() throws InterruptedException {
        int players;
        int gameType;
        
        v.printString(v.a.gSetup);
        v.waitASec();
        v.printString("How many Players? (1-4)");
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
        String quickHelp = "Enter a command (List, a player's name, Help):";
        String controlls = "When a player scores or draws a new ticket you will need to enter that information into the app."
                + "In order to do that you will need to enter information for that player.  Enter the player's name in order to view"
                + "thier current score stats as well as record a new score!  (Type HELP to see this message again)";
        
        
        v.printString(controlls);
        v.printString("Game Start!  Good luck!");
        v.waitASec();
        
        //get player names
        
        
        do{
        //main loop
        v.printString(quickHelp);
        action = v.inString();
        
        switch (action){
            case "list":    
                String list = "";
                for(int i = 0; i<allPlayers.length;i++){
                    list = list + allPlayers[i].getpName() + "\n";
                }
                v.printString(list);
                break;
            case "help":
                v.printString(controlls);
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

    private void playerAction(Player player) {
        v.printString("Selected player: " + player.getpName());
    }
        
        
//        v.printString("Game Starting....");
//        v.enterToCont();
//        
//        for(int i=0;i<allPlayers.length;i++){
//            v.printString(allPlayers[i].toString());
//        }
//        v.printString(Integer.toString(gameType));
}

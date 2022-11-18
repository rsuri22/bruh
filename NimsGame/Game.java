package NimsGame;

import java.util.Scanner;
public class Game {
    private int pieces;
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private Scanner sc = new Scanner(System.in);

    //Sets up the game with a random amount of pieces between 10 and 50
    //Sets up the players so they can be accessed
    public Game(Player p1, Player p2){
        pieces = (int)(Math.random()*41 + 10);
        this.p1 = p1;
        this.p2 = p2;
    }

    //Allows a player to take a specific amount of pieces.
    //Adds the amount of pieces taken to the user's score.
    public int takePiece(){
        System.out.println("There are "+ pieces+" remaining!");
        System.out.println("How many would " + currentPlayer.getName() + " like to take?");
        int take = Integer.parseInt(sc.nextLine());

        while (!isLegal(take)){
            System.out.println("Sorry, that move is not allowed. Try again.");
            take = Integer.parseInt(sc.nextLine());
        }

        pieces -= take;

        System.out.println("There are "+ pieces+" remaining!");
        System.out.println("-----------------------");
        return take;
    }

    public int AIMove(){
        int take = 0;
        for (int i = 6; i > 1; i--){
            int tempTake = pieces/2;
            while (tempTake > 2){
                if ((pieces - tempTake) == (Math.pow(2, i) - 1)){
                    take = tempTake;
                    break;
                }
                tempTake--;
            }
        }
        if (take == 0){
            take = 1;
        }
        pieces -= take;
        System.out.println("The AI takes " + take + " pieces!");
        System.out.println("There are "+ pieces+" remaining!");
        System.out.println("-----------------------");
        return take;
    }

    
    //**TO DO**//
    public Player getNextPlayer(){
    //Changes which players turn it is and returns the current player.
        if (currentPlayer == p1){
            currentPlayer = p2;
        }
        else {
            currentPlayer = p1;
        }
       
        return currentPlayer;
    }

    //Checks whether or not the user's requested move is allowed or not.
    public boolean isLegal(int x){
        boolean check = true;
        if (x == 1) {
            check = true;
        }
        else if (x * 2 > pieces) {
            check = false;
        }
        return check;
    }


    //DO NOT CHANGE
    public boolean isComplete(){

        if (pieces == 0){ return true;}
        return false;
    }

    //DO NOT CHANGE
    public void setFirstPlayer(Player p){
        currentPlayer = p;
    }

}
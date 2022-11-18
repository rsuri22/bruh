package NimsGame;

public class Player {
    private int score = 0;
    private String name;

    //DO NOT CHANGE
    public Player(String name){

        this.name = name;
    }

    //TO DO
    public int getScore(){
        return score;
     
    }
    //TO DO
    public String getName(){
        return name;
    }

    public void addToScore(int x){
        score += x;
    }
}

class AI extends Player {
    private int score = 0;
    private String name = "AI";

    public AI(String name){
        super(name);
    }
}


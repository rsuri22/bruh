package NimsGame;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Player player1 = null;
        Player player2 = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to play against another player (1) or an AI (2)?");
        String choice = sc.nextLine();
        if (choice.equals("1")){
            System.out.println("What is player1's name?: ");
            player1 = new Player(sc.nextLine());
    
            System.out.println("What is player2's name?: ");
            player2 = new Player(sc.nextLine());
        }

        else if (choice.equals("2")){
            System.out.println("What is player1's name?: ");
            player1 = new Player(sc.nextLine());

            player2 = new AI("AI");
        }

        String again = "Literally any string";
        Player currentPlayer;
        
        //Runs the game
        while (!again.equals("q")){
            //Generates the game
            Game game = new Game(player1, player2);
            if (Math.random() > 0.5){
                currentPlayer = player1;
            }
            else {
                currentPlayer = player2;
            }

            game.setFirstPlayer(currentPlayer);

            while(!game.isComplete()){
                if (currentPlayer.getName().equals("AI")){
                    currentPlayer.addToScore(game.AIMove());
                }
                else {
                    currentPlayer.addToScore(game.takePiece());
                }
 //               currentPlayer.addToScore(game.takePiece());
                currentPlayer = game.getNextPlayer();
            }

            System.out.println(currentPlayer.getName()+ " Won!!");
            System.out.println(player1.getName() +" had removed "+ player1.getScore()+" pieces!");
            System.out.println(player2.getName() +" had removed "+ player2.getScore()+" pieces!");
            System.out.println("------------------------------------------");
            System.out.println("Enter q to quit, enter anything else to play again.");
            again = sc.nextLine();
        }
        System.out.println("Thank you for playing!");
        sc.close();
    }
}




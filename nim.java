import java.util.Scanner;
import java.util.Random;

public class nim {
    public static void main(String[] args) {
        //initiate
        Scanner in = new Scanner(System.in);
        Random r = new Random();

        //set out the piles
        int pile1 = 1 + r.nextInt(5);;
        int pile2 = 1 + r.nextInt(5);;
        int pile3 = 1 + r.nextInt(5);;
        int piles = pile1 + pile2 + pile3;

        //turns
        int turn = 1;

        //player set up
        System.out.print("Player 1, enter your name: ");
        String player1 = in.next();
        System.out.print("Player 2, enter your name: ");
        String player2 = in.next();
        String currentPlayer = "empty";
        String lastPlayer = "empty";

        
        //a turn
        while (piles > 0) {
            if (turn % 2 == 0) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }

            System.out.println("\nA: " + pile1 + "\tB: " + pile2 
            + "\tC: " + pile3);

            
            System.out.print(currentPlayer + ", choose a pile: ");
            String pile = in.next();
            System.out.print("How many to remove from pile " + pile + "? ");
            int amount = in.nextInt();

            if (pile.equals("a") || pile.equals("A")) {
                pile1 -= amount;
            } else if (pile.equals("B") || pile.equals("b")) {
                pile2 -= amount;
            } else if (pile.equals("C") || pile.equals("c")) {
                pile3 -= amount;
            }

            //housekeeping
            turn++;
            piles = pile1 + pile2 + pile3;
        }

        if (currentPlayer.equals(player1))
            System.out.println(player2 + ", you win!");
        else
            System.out.println(player1 + ", you win!");


    }


}

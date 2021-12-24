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
        String player1 = in.next().toUpperCase();
        System.out.print("Player 2, enter your name: ");
        String player2 = in.next().toUpperCase();
        String currentPlayer = "";

        //variables
        String pile = "";
        
        //a turn
        while (piles > 1) {
            pile = "";

            if (turn % 2 == 0) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }

            //display the rows
            int pile1count = pile1;
            int pile2count = pile2;
            int pile3count = pile3;

           //find the largest number

            int totalLines = 0;

            if (pile1count >= pile2count && pile1count >= pile3count) {
                totalLines = pile1count;
            }

            else if (pile2count >= pile1count && pile2count >= pile3count) {
                totalLines = pile2count;
            }

            else {
                totalLines = pile3count;
            }

            int linecount = totalLines;
            int gross = 1;

            System.out.println("");

            while (linecount > 0) {

                int pile1limit = totalLines - pile1count;
                
                if ( gross > pile1limit ) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

                int pile2limit = totalLines - pile2count; //
                
                if ( gross > pile2limit ) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

                int pile3limit = totalLines - pile3count;
                
                if ( gross > pile3limit ) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

                System.out.println("");

                linecount--;
                gross++;
            }

            System.out.println("A B C");

            System.out.println("");

            int currentPile = 1;
            
            //makes sure the pile is valid and not empty
            while (!pile.equals("A") && !pile.equals("B") && !pile.equals("C") || currentPile <= 0) {

                System.out.print("\n" + currentPlayer + ", choose a pile: ");
                pile = in.next().toUpperCase();

                if ( pile.equals("A") )
                    currentPile = pile1;
                else if ( pile.equals("B") )
                    currentPile = pile2;
                else
                    currentPile = pile3;
                
                if ( currentPile <= 0 ) {
                    System.out.println("Nice try. That pile is empty.");
                }
            }

            //finds amount to remove from pile

            int amount = 100;

            while (amount > currentPile || amount <= 0) {
                System.out.print("\nHow many to remove from Pile " + pile + "? ");
                amount = in.nextInt();

                if (amount > currentPile) {
                    System.out.println("There aren't that many in Pile " + pile + "! Try again.");
                } else if ( amount <= 0 ) {
                    System.out.println("You must choose at least 1");
                }
            }
           

            if (pile.equals("A")) {
                pile1 -= amount;
            } else if (pile.equals("B")) {
                pile2 -= amount;
            } else if (pile.equals("C")) {
                pile3 -= amount;
            }

            //housekeeping
            turn++;
            piles = pile1 + pile2 + pile3;
        }

        if (piles == 1) {
            if (currentPlayer.equals(player1))
                System.out.println("\n" + player2 + " you must take the last counter, so you lose. " + player1 + ", you win!");
            else
                System.out.println("\n" + player1 + " you must take the last counter, so you lose. " + player2 + ", you win!");
        }

        else {
            System.out.println("\n" + currentPlayer + ", you lose!");
        }

    }


}

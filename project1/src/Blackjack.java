import java.util.Scanner;
public class Blackjack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        P1Random rng = new P1Random();

        int menu, playerCardTotal, playerCard, dealer, actualGamesPlayed;
        int wins = 0, loss = 0, ties = 0, totalGames = 1;
        double winPercent;

        //Need to increment the number of games
        System.out.println("START GAME #" + totalGames);

        //Give player random card and display
        playerCardTotal = 0;
        playerCard = rng.nextInt(13) + 1;
        playerCardTotal = playerCard + playerCardTotal;
        System.out.println("\nYour card is a " + playerCard + "!");
        System.out.println("Your hand is: " + playerCardTotal);
        //do-while loop is used throughout the entire program
        //to ensure that the code can loop indefinitely for the rounds
        do {
            //Menu
            System.out.println("\n1. Get another card");
            System.out.println("2. Hold hand");
            System.out.println("3. Print statistics");
            System.out.println("4. Exit");

            //Prompt user for choice
            System.out.print("\nChoose an option: ");
            menu = scn.nextInt();

            //Check to see if user inputs a valid value for 'menu'
            while (menu < 1 || menu > 4) {
                System.out.println("\nInvalid input!");
                System.out.println("Please enter an integer value between 1 and 4.");
                System.out.println("\n1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.print("\nChoose an option: ");
                menu = scn.nextInt();
            }
            //Switch statements are used to implement a menu within the program
            switch (menu) {
                //1st case applies to the user drawing a random card
                case 1:
                    playerCard = rng.nextInt(13) + 1;
                    //Checking for Ace, Jacks, Queens, and Kings
                    if (playerCard == 1) {
                        System.out.println("Your card is a ACE!");
                        playerCardTotal = playerCard + playerCardTotal;
                        System.out.println("Your hand is: " + playerCardTotal);
                    } else if (playerCard == 11) {
                        playerCard = 10;
                        System.out.println("Your card is a JACK!");
                        playerCardTotal = playerCard + playerCardTotal;
                        System.out.println("Your hand is: " + playerCardTotal);
                    } else if (playerCard == 12) {
                        playerCard = 10;
                        System.out.println("Your card is a QUEEN!");
                        playerCardTotal = playerCard + playerCardTotal;
                        System.out.println("Your hand is: " + playerCardTotal);
                    } else if (playerCard == 13) {
                        playerCard = 10;
                        System.out.println("Your card is a KING!");
                        playerCardTotal = playerCard + playerCardTotal;
                        System.out.println("Your hand is: " + playerCardTotal);
                    } else {
                        playerCardTotal = playerCard + playerCardTotal;
                        System.out.println("Your card is a " + playerCard + "!");
                        System.out.println("Your hand is: " + playerCardTotal);
                    }
                    //Different scenarios when drawing a new card are checked here
                    if (playerCardTotal == 21) {
                        System.out.println("\nBLACKJACK! You win!");
                        wins++;
                        playerCardTotal = 0;
                    }
                    if (playerCardTotal > 21) {
                        System.out.println("\nYou exceeded 21! You lose.");
                        loss++;
                        playerCardTotal = 0;
                    }
                    break;
                case 2:
                    //The possible outcomes when the user decides to hold their card
                    dealer = rng.nextInt(11) + 16;
                    System.out.println("Dealer's hand: " + dealer);
                    System.out.println("Your hand is: " + playerCardTotal);
                    if (dealer > 21) {
                        System.out.println("\nYou win!");
                        wins++;
                        playerCardTotal = 0;
                    } else if (dealer == playerCardTotal) {
                        System.out.println("\nIt's a tie! No one wins!");
                        ties++;
                        playerCardTotal = 0;
                    } else if (dealer > playerCardTotal) {
                        System.out.println("\nDealer wins!");
                        loss++;
                        playerCardTotal = 0;
                    }
                    break;
                case 3:
                    //Calculating and displaying the statistics during a run of the program
                    actualGamesPlayed = wins + loss + ties;
                    winPercent = (double)wins/actualGamesPlayed * 100;
                    System.out.println("Number of Player wins: " + wins);
                    System.out.println("Number of Dealer wins: " + loss);
                    System.out.println("Number of tie games: " + ties);
                    System.out.println("Total # of games played is: " + actualGamesPlayed);
                    System.out.println("Percentage of Player wins: " + winPercent + "%");
                    System.out.println();
                    break;
            }
            //This block of if-else statements is used to start a new round within the program
            //'playerCardTotal' is reset to 0 at the end of the win/tie/lose scenarios in the switch block
           if (playerCardTotal == 0) {
               totalGames++;
               System.out.println("\nSTART GAME #" + totalGames);
               playerCard = rng.nextInt(13) + 1;
               System.out.println();
               //Need to check if the first card is either an Ace, Jack, Queen or King
               if (playerCard == 1) {
                   System.out.println("Your card is a ACE!");
                   playerCardTotal = playerCard + playerCardTotal;
                   System.out.println("Your hand is: " + playerCardTotal);
               } else if (playerCard == 11) {
                   playerCard = 10;
                   System.out.println("Your card is a JACK!");
                   playerCardTotal = playerCard + playerCardTotal;
                   System.out.println("Your hand is: " + playerCardTotal);
               } else if (playerCard == 12) {
                   playerCard = 10;
                   System.out.println("Your card is a QUEEN!");
                   playerCardTotal = playerCard + playerCardTotal;
                   System.out.println("Your hand is: " + playerCardTotal);
               } else if (playerCard == 13) {
                   playerCard = 10;
                   System.out.println("Your card is a KING!");
                   playerCardTotal = playerCard + playerCardTotal;
                   System.out.println("Your hand is: " + playerCardTotal);
               } else {
                   playerCardTotal = playerCard + playerCardTotal;
                   System.out.println("Your card is a " + playerCard + "!");
                   System.out.println("Your hand is: " + playerCardTotal);
               }
           }
           //Until the Exit option is chosen, the program will run indefinitely
        } while (menu != 4);
    }
}

import java.util.*;

public class Main extends Game{
    public static void main(String[] args) {

        Player1 player1 = new Player1();
        Monster monster = new Monster();

//Welcome message + introduces menu


        //do-while for menu


        int choice;
        do {
            System.out.println("Welcome to The Duel! a game where you use your wits and moves to defeat a terrible monster!" +
                    "\n Please select an option: \n 1. Rules \n 2.Author \n 3. Play game \n 4. Quit");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("You are a lone traveler, and you have come upon a monster in a cave!" +
                            "\n You and the monster both have the same attack moves, but the monster doesn't have a shield" +
                            "\n Kick beats punch, Shield beats kick and punch, and special beats Kick and shield." +
                            "\n If you punch the monster's special, you parry his move! But watch out, the monster can parry too!" +
                            "\n You lose when your health gets to 0, and win if the monster's health reaches 0. Good luck traveler! ");
                    break;
                case 2:
                    System.out.println("This game was imagined, written, and coded by Kennedy Hilario.");
                    break;
                case 3:
                    PlayGame();
                    break;
                case 4:
                    System.out.println("The mark of a coward, quitting before the battle has even begun.");

                    break;

            }
        } while (choice != 4);


    }//main
}//class main


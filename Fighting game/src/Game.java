
import java.util.*;

public class Game extends Player1 {


    public static void PlayGame() {


        //Declare variables of type integer
        int userChoice, computerChoice, punch, kick, shield, special;

        //User input
        Scanner input = new Scanner(System.in);

        //Generates a Random Move for the Monster
        Random rnd = new Random();

        //Assigning values to the following variables:
        punch = 0;
        kick = 1;
        shield = 2;
        special = 3;


        //display the game name
        System.out.println("-----THE DUEL BEGINS------");
        while (Health != 0) {
            System.out.println("What will you do? \n 0. Punch \n 1. Kick \n 2.Shield 3.Special");
            //User input
            userChoice = input.nextInt();
            //if user chooses above 3
            while (userChoice > 3) {
                System.out.println("Please enter a valid number");
                userChoice = input.nextInt();
            }
            //user selections
            if (userChoice == punch) {
                System.out.println("You deliver a ferocious punch...");
            } else {
                if (userChoice == kick) {
                    System.out.println("A textbook roundhouse kick...");
                } else if (userChoice == shield) {
                    System.out.println("You take a stance with your shield...");
                }
                if (userChoice == special) {
                    System.out.println("You prepare your fireball...");
                }
                //computer input (random)
                computerChoice = rnd.nextInt(4);

                //computer selection
                if (computerChoice == punch) {
                    System.out.println("The monster strikes back...");
                } else {
                    if (computerChoice == kick) {
                        System.out.println("The monster responds with a kick...");
                    } else if (computerChoice == shield) {
                        System.out.println("The monster retreats under titanium scales...");
                    }
                    if (computerChoice == special) {
                        System.out.println("The monster widens its mouth, revealing a ball of flame");
                    }

                    //Results section

                    //Moves are the same
                    while (userChoice == computerChoice) {
                        System.out.println("Your attacks clash! you ready yourself for combat as the monster shrieks...");
                        userChoice = input.nextInt();
                    }
                    computerChoice = rnd.nextInt(4);
                    while (userChoice > 3) {
                        System.out.println("Please enter a valid number");
                        userChoice = input.nextInt();
                    }
                    //user selections
                    if (userChoice == punch) {
                        System.out.println("You deliver a ferocious punch...");
                    } else {
                        if (userChoice == kick) {
                            System.out.println("A textbook roundhouse kick...");
                        } else if (userChoice == shield) {
                            System.out.println("You take a stance with your shield...");
                        }
                        if (userChoice == special) {
                            System.out.println("You prepare your fireball...");
                        }
                        //computer input (random)
                        computerChoice = rnd.nextInt(4);

                        //computer selection
                        if (computerChoice == punch) {
                            System.out.println("The monster strikes back...");
                        } else {
                            if (computerChoice == kick) {
                                System.out.println("The monster responds with a kick...");
                            } else if (computerChoice == shield) {
                                System.out.println("The monster retreats under titanium scales...");
                            }
                            if (computerChoice == special) {
                                System.out.println("The monster widens its mouth, revealing a ball of flame");
                            }

//RESU              //if the monster chooses punch
                            if (computerChoice == punch) {
                                if (userChoice == kick) {
                                    System.out.println("The monster wiffs it's punch and you deliver a swift kick! " +
                                            "\nThe monster takes 20 damage!");
                                } else if (userChoice == special) {
                                    System.out.println("The monster counters with a perfectly timed strike! \n You take 30 damage!");
                                } else if (userChoice == shield) {
                                    System.out.println("You block the monster's punch, negating all damage!");
                                }
                            }
                            //if the monster chooses kick
                            else if (computerChoice == kick) {
                                if (userChoice == punch) {
                                    System.out.println("Your punch is outranged by the monster's quick sweep! \n You take 20 damage!");
                                } else if (userChoice == special) {
                                    System.out.println("Your fireball engulfs the monster before he can kick! \n The Monster takes 30 damage!");
                                } else if (userChoice == shield) {
                                    System.out.println("You block the monster's kick, negating all damage!");
                                }
                            }
                            //If the monster chooses special
                            else if (computerChoice == special) {
                                if (userChoice == punch) {
                                    System.out.println("A Magnificently timed counter! \nThe monster takes 30 damage!");
                                } else if (userChoice == kick) {
                                    System.out.println("You're covered in flames before you can kick! \nYou take 30 damage");
                                } else if (userChoice == shield) {
                                    System.out.println("You cower behind your shield but it's not enough! \nYou take 30 damage");
                                }
                            }
                            //End results
                            //USE THE FACT THAT MONSTER HAS NO SHIELD TO REMOVE PUNCH IRREGULARITY?


                        }
                    }
                }
            }
        }//Health !=0
    }//PlayGame
}// Class game


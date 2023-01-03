public class Player1 implements Moves {

    static int Health;
    static int monsterHealth;

    Player1(){
        Health = 100;
        monsterHealth = 100;
    }//Player 1

    public int Punch(){
        System.out.println("What a punch! The monster screams and prepares itself for battle!");
        monsterHealth -= 10;
        System.out.print("The monster's health is now at ");
        return monsterHealth;

    }//punch

    public int Kick(){
        System.out.println("A textbook roundhouse kick! The monster staggers back!");
        monsterHealth -= 20;
        System.out.print("The monster's health is now at ");
        return monsterHealth;
    }//kick

    public int Special(){
    System.out.println("A massive fireball is summoned, engulfing the Monster in flames!");
        monsterHealth -= 20;
        System.out.print("The monster's health is now at ");
        return monsterHealth;
    }//kick

    public int Shield(){
        System.out.println("A Fantastic block! The monster trembles at your might!");
        System.out.print("You're health is still at ");
        return Health;
    }
    }//class

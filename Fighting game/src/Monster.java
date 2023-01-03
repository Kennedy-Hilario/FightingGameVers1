public class Monster implements Moves{
int monsterHealth;
int Health;

public int Monster(){
    monsterHealth = 100;
    return monsterHealth;
}//monster

    public int Punch(){
        System.out.print("The monster sends you flying with an uppercut!");
        Health -= 20;
        return Health;
    }//punch

    public int Kick(){
        Health -= 20;
        System.out.print("Textbook Roundhouse kick, the monster staggers backwards!");
        return Health;
    }//kick

    public int Special(){
        Health -= 20;
        System.out.print("A massive fireball is summoned, significantly damaging the monster!");
        return Health;
    }//kick

    public int Shield(){
        System.out.print("A Fantastic block! The monster trembles!");
        return Health;
    }
}//class


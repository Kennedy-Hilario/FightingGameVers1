
import java.util.Scanner;

public class KHPetStats {

    public static void main(String[] args) {
        UserTextInterface userTextInterface = new UserTextInterface();
        userTextInterface.run();
    }
}


public class UserTextInterface {
    private Scanner reader;
    private InputValidator inputValidator;
    private AnimalHandler animalHandler;

    public UserTextInterface(){
        reader = new Scanner(System.in);
        inputValidator = new InputValidator();
        animalHandler = new AnimalHandler("src/animal.txt");
    }

    public void run(){
        printOptions();
        while(processInput());
        animalHandler.saveArrayToFile();
    }

    public void printOptions(){
        System.out.println("Options:");
        System.out.println("0. Quit");
        System.out.println("1. Add a new dog");
        System.out.println("2. Add a new cat");
        System.out.println("3. Print all animals");
        System.out.println("4. Delete an animal");
        System.out.println("5. Update an animal");
    }

    public boolean processInput(){
        int input = inputValidator.readInt();
        while(input != 0){
            if(input == 1){
                animalHandler.addDog();
            }
            else if(input == 2){
                animalHandler.addCat();
            }
            else if(input == 3){
                animalHandler.printAllAnimals();
            }
            else if(input == 4){
                animalHandler.removeAnimal();
            }
            else if(input == 5){
                animalHandler.updateAnimal();
            }
            else{

            }
            input = inputValidator.readInt();
        }
        return false;
    }
}



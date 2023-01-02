import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileHandler {
    private String filePath;
    private File filePointer;
    private Scanner reader;
    private SimpleDateFormat dateFormatter;


    public FileHandler(String filePath) {
        this.filePath = filePath;
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

    }


    public List<Animal> load() {
        List<Animal> contents = new ArrayList<Animal>();
        try {
            filePointer = new File(filePath);
            reader = new Scanner(filePointer);
        } catch (Exception e) {
            return null;
        }
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] parts = line.split(":");
            Date dateOfBirth = new Date();
            try {
                dateOfBirth = dateFormatter.parse(parts[4]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            contents.add(new Animal(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3], dateOfBirth));
        }
        reader.close();
        return contents;
    }

    public boolean save(List<Animal> content) {
        FileWriter writer;
        try {
            writer = new FileWriter(filePath);
        } catch (Exception e) {
            return false;
        }
        for (Animal animal : content) {
            try {
                writer.write(animal.getName() + ":" + animal.getID() + ":" + animal.getNotes() + ":" + animal.getSpecies() + ":" + dateFormatter.format(animal.getDateOfBirth()) + "\n");
            } catch (Exception e) {
                return false;
            }
        }
        try {
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }


    public class AnimalHandler {
        private FileHandler fileHandler;
        private List<Animal> fileArray;
        private Scanner reader;
        private InputValidator inputValidator;
        private SimpleDateFormat dateFormatter;


        public AnimalHandler(String filePath) {
            fileHandler = new FileHandler(filePath);
            fileArray = new ArrayList<Animal>();
            ;
            reader = new Scanner(System.in);
            inputValidator = new InputValidator();
            dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
            loadFileToArray();
        }

        public void loadFileToArray() {
            fileArray = fileHandler.load();
        }

        public void saveArrayToFile() {
            fileHandler.save(fileArray);
        }

        public void addCat() {
            System.out.println("Enter the cat's name");
            String name = reader.nextLine();
            System.out.println("Enter the cat's ID");
            int ID = readID();
            System.out.println("Enter any notes:");
            String notes = reader.nextLine();
            Date date = readDate();
            fileArray.add(new Animal(name, ID, notes, "Cat", date));
            System.out.println("Cat added successfully");
        }


        public void addDog() {
            System.out.println("Enter the dog's name");
            String name = reader.nextLine();
            System.out.println("Enter the dog's ID");
            int ID = readID();
            System.out.println("Enter any notes:");
            String notes = reader.nextLine();
            Date date = readDate();
            fileArray.add(new Animal(name, ID, notes, "Dog", date));
            System.out.println("Dog added successfully");
        }

        public void removeAnimal() {
            System.out.println("Enter the ID of the animal you want to remove: ");
            int ID = inputValidator.readInt();
            for (Animal animal : fileArray) {
                if (animal.getID() == ID) {
                    fileArray.remove(animal);
                    System.out.println("Animal: " + animal.getSpecies() + ", Name: " + animal.getName() + ": Deleted successfully");
                    return;
                }
            }
            System.out.println("Could not find animal with ID: " + ID);
        }


        public void updateAnimal() {
            System.out.println("Enter the ID of the animal you want to update: ");
            int ID = inputValidator.readInt();
            if (!IDAlreadyExists(ID)) {
                System.out.println("Could not find animal with ID: " + ID);
                return;
            }

            int index = -1;
            for (Animal animal : fileArray) {
                if (animal.getID() == ID) {
                    index = fileArray.indexOf(animal);
                    break;
                }
            }

            if (index >= 0) {
                Animal animal = fileArray.get(index);
                System.out.println("Found: Animal: " + animal.getSpecies() + ", Name: " + animal.getName() + ". Please enter new details below");

                System.out.println("Would you like to enter a new name? Y/N: ");
                String answer = reader.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    System.out.println("Enter a new name: ");
                    String newName = reader.nextLine();
                    animal.setName(newName);

                }


                System.out.println("Would you like to enter a new ID? Y/N: ");
                answer = reader.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    System.out.println("Enter a new ID: ");
                    int newID = inputValidator.readInt();
                    if (IDAlreadyExists(newID)) {
                        System.out.println("This ID is already in use. Please enter a different one: ");
                        newID = readID();
                    }
                    animal.setID(newID);

                }


                System.out.println("Would you like to enter a new date of birth? Y/N: ");
                answer = reader.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    System.out.println("Enter a new date of birth: ");
                    Date newDate = readDate();
                    animal.setDateOfBirth(newDate);
                }
            } else {
                System.out.println("Error, ID not found. This should never happen.");
            }
        }

        public void printAllAnimals() {
            for (Animal animal : fileArray) {
                System.out.println(animal);
            }
        }

        public boolean IDAlreadyExists(int ID) {
            for (Animal animal : fileArray) {
                if (animal.getID() == ID) {
                    return true;
                }
            }
            return false;
        }

        public int readID() {
            int ID = inputValidator.readInt();
            while (IDAlreadyExists(ID) || ID < 0) {
                if (ID < 0) {
                    System.out.println("The ID cannot be negative. Please enter a positive ID: ");
                }
                if (IDAlreadyExists(ID)) {
                    System.out.println("This ID is already in use. Please enter a different one: ");
                }
                ID = inputValidator.readInt();
            }
            return ID;
        }

        public Date readDate() {

            String date = "";

            System.out.println("Enter day of birth:");
            int day = inputValidator.readInt();
            while (day < 1 || day > 31) {
                System.out.println("Invalid number. Please enter a number between 1-31");
                day = inputValidator.readInt();
            }
            if (day < 10) {
                date += "0" + day + "/";
            } else {
                date += day + "/";
            }

            System.out.println("Enter month of birth:");
            int month = inputValidator.readInt();
            while (month < 1 || month > 12) {
                System.out.println("Invalid number. Please enter a number between 1-12");
                month = inputValidator.readInt();
            }
            if (month < 10) {
                date += "0" + month + "/";
            } else {
                date += month + "/";
            }


            System.out.println("Enter year of birth:");
            int year = inputValidator.readInt();
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            while (year < 1900 || year > currentYear) {
                System.out.println("Invalid number. Please enter a number between 1900 and " + currentYear);
                year = inputValidator.readInt();
            }
            date += year + "";

            Date dateOfBirth = new Date();
            try {
                dateOfBirth = dateFormatter.parse(date);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return dateOfBirth;
        }
    }


    public class InputValidator {
        private Scanner reader;

        public InputValidator() {
            reader = new Scanner(System.in);
        }

        public int readInt() {
            int input = 0;
            boolean gotCorrect = false;
            while (!gotCorrect) {
                try {
                    input = Integer.parseInt(reader.nextLine());
                    gotCorrect = true;
                } catch (Exception e) {
                    System.out.println("Please enter a valid number");
                }
            }
            return input;
        }
    }
}

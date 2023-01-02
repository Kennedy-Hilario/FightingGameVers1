import java.util.Date;

public class Animal {
    private String name;
    private int ID;
    private String notes;
    private String species;
    private Date dateOfBirth;


    public Animal(String name, int ID, String notes, String species, Date dateOfBirth) {
        this.name = name;
        this.ID = ID;
        this.notes = notes;
        this.species = species;
        this.dateOfBirth = dateOfBirth;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Animal: " + species + ", Name: " + name + ", ID: " + ID + ", Notes: " + notes + ", Date of birth: " + dateOfBirth.toString();
    }
}

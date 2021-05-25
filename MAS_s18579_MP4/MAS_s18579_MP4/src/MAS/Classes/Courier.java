package MAS.Classes;

import MAS.Object.ObjectPlus4;

public class Courier extends ObjectPlus4 {
    // -- Atrybuty --
    private String firstName;           // -- Imie --
    private String surname;             // -- Nazwisko --
    private double salary;              // -- Pensja --
    private String drivingLicenceNumber;// -- Numer prawa jazdy --
    // -- Konstruktory --
    public Courier(String firstName, String surname, double salary, String drivingLicenceNumber) {
        super();
        this.firstName = firstName;
        this.surname = surname;
        this.salary = salary;
        this.drivingLicenceNumber = drivingLicenceNumber;
    }
    // -- Gettery i Settery --
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getDrivingLicenceNumber() {
        return drivingLicenceNumber;
    }
    public void setDrivingLicenceNumber(String drivingLicenceNumber) throws Exception {
        if(drivingLicenceNumber.chars().allMatch(Character::isDigit)) this.drivingLicenceNumber = drivingLicenceNumber;
        else throw new Exception("Numer licencji musi byc cyframi");
    }
    // -- Metody --
    /**
     * toString() --- Przeslonienie metody
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return  "Klasa Kurier:\t" + super.toString() + "\n"+
                "-> Imie:\t" + firstName  + ",\n"+
                "-> Nazwisko:\t" + surname +",\n"+
                "-> Pensja:\t" + salary +",\n"+
                "-> Numer prawa jazdy:\t" + drivingLicenceNumber;
    }
}

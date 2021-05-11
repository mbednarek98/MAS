package MAS.classes.dynamic;

import java.util.List;

public class Courier extends  Employee{
    // -- Atrybuty klasy --
    private String driversLicenseNumber;
    private DriverCat driverCategory;

    // -- Konstruktory
    public Courier(List<String> firstName, String surname, String pesel, float salaryNetto,String driversLicenseNumber, DriverCat driverCategory ) {
        super(firstName, surname, pesel, salaryNetto);
        this.driversLicenseNumber = driversLicenseNumber;
        this.driverCategory = driverCategory;
    }

    public Courier(Employee prevEmployee,String driversLicenseNumber, DriverCat driverCategory) {
        super(prevEmployee.getFirstName(), prevEmployee.getSurname(), prevEmployee.getPesel(), prevEmployee.getSalaryNetto());
        this.driversLicenseNumber = driversLicenseNumber;
        this.driverCategory = driverCategory;
    }

    // -- Gettery --

    public String getDriversLicenseNumber() {
        return driversLicenseNumber;
    }

    // -- Settery --

    public void setDriversLicenseNumber(String driversLicenseNumber) {
        this.driversLicenseNumber = driversLicenseNumber;
    }

    // -- Metody --

    @Override
    public double getSalaryWithBonus() {
        if(this.driverCategory == DriverCat.A) return getSalaryBrutto();
        else if(this.driverCategory == DriverCat.B) return getSalaryBrutto() + 50;
        else if(this.driverCategory == DriverCat.C) return getSalaryBrutto() + 100;
        else if(this.driverCategory == DriverCat.D) return getSalaryBrutto() + 200;
        else return 0;
    }

    /**
     * toString()               -- Przeslonienie metody --
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString(){
        return super.toString() + " Klasa Kurier:\n" +
                "Numer prawa jazdy:" + driversLicenseNumber + "\n";
    }
}

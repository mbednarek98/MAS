package MAS.classes.dynamic;

import java.util.List;

public class ServiceTechnician extends Employee{
    // -- Atrybuty klasowe --
    private Title title;                                                // tytul
    private List<String> qualification;
    private double bonus;

    // -- Konstruktory --
    public ServiceTechnician(List<String> firstName, String surname, String pesel, float salaryNetto, Title title, List<String> qualification, double bonus) {
        super(firstName, surname, pesel, salaryNetto);
        this.title = title;
        this.qualification = qualification;
        this.bonus = bonus;
    }

    public ServiceTechnician(Employee prevEmployee, Title title, List<String> qualification, double bonus) {
        super(prevEmployee.getFirstName(), prevEmployee.getSurname(), prevEmployee.getPesel(), prevEmployee.getSalaryNetto());
        this.title = title;
        this.qualification = qualification;
        this.bonus = bonus;
    }
    
    // -- Gettery --

    public Title getTitle() {
        return title;
    }

    public List<String> getQualification() {
        return qualification;
    }

    // -- Settery --


    public void setTitle(Title title) {
        this.title = title;
    }

    public void setQualification(List<String> qualification) {
        this.qualification = qualification;
    }

    // -- Metody --

    @Override
    public double getSalaryWithBonus() {
        return getSalaryBrutto() + bonus;
    }

    /**
     * toString()               -- Przeslonienie metody --
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString(){
        return super.toString() + " Klasa Serwisant:\n" +
        "Tytul:" + title + "\n"+
        "Kwalifikacje: " + qualification + "\n";
    }
}

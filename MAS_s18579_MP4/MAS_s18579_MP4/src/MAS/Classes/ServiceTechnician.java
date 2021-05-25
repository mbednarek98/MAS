package MAS.Classes;

import MAS.Classes.Enum.Title;
import MAS.Object.ObjectPlus4;

import java.util.ArrayList;
import java.util.List;

public class ServiceTechnician extends ObjectPlus4 {
    public static final String SERVICETECHNICIAN = "servicetechnician";
    public static final String SERVICE = "service";
    public static final String SERVICES = "services";
    public static final String MANAGE_SERVICES = "manageservices";
    // -- Atrybuty --
    private String firstName;           // -- Imie --
    private String surname;             // -- Nazwisko --
    private double salary;              // -- Pensja --
    private Title title;                // -- Tytul --
    private List<String> qualification; // -- Kwalifikacje [1..*]
    private static List<ServiceTechnician> extent = new ArrayList<>();
    // -- Konstruktory --
    public ServiceTechnician(String firstName, String surname, double salary, Title title, List<String> qualification) {
        super();
        this.firstName = firstName;
        this.surname = surname;
        this.salary = salary;
        this.title = title;
        this.qualification = qualification;
        addServiceTechnician(this);
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
    public Title getTitle() {
        return title;
    }
    public void setTitle(Title title) {
        this.title = title;
    }
    public List<String> getQualification() {
        return qualification;
    }
    public void setQualification(List<String> qualification) {
        this.qualification = qualification;
    }
    // -- Metody --
    public void addServiceTechnician(ServiceTechnician st) {
        if (!extent.contains(st)) extent.add(st);
    }
    public void removeServiceTechnician(ServiceTechnician st) {
        if (extent.contains(st)) extent.remove(st);
    }
    public List<ServiceTechnician> getExtent(){
        return extent;
    }
    public void printExtent(){
        System.out.println(extent);
    }
    public void linkSubset(Service service) throws Exception {
        this.addLink(SERVICETECHNICIAN,SERVICE,service);
        this.addLink_subset(SERVICES,MANAGE_SERVICES,SERVICETECHNICIAN, service);
    }
    public void showLinkSubset() throws Exception {
        this.showLinks(SERVICETECHNICIAN, System.out);
        this.showLinks(SERVICES, System.out);
    }
    /**
     * toString() --- Przeslonienie metody
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return "Klasa ServiceTechnician" + super.toString() +
                "-> Imie:" + firstName + ",\n" +
                "-> Nazwisko:" + surname + ",\n" +
                "-> Pensja:" + salary + ",\n" +
                "-> Tytul:" + title + ",\n" +
                "-> Kwalifikacje:" + qualification;
    }
}

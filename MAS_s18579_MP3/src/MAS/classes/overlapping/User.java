package MAS.classes.overlapping;

import MAS.object.ObjectPlusPlus;

import java.util.List;

public class User extends ObjectPlusPlus {
    // -- Atrybuty klasy --
    private List<String> firstName;     // imie[1..*]
    private String surname;             // nazwisko
    private List<String> phoneNumber;   // numerTelefonu[1..*]
    private String email;               // email
    private static int minimalAge = 18; // _minimalnyWiek_ = 18


    private static String roleNameGeneralization = "generalization";
    private static String roleNameClient = "Klient";
    private static String roleNameEmployee = "Pracownik";

    // -- Konstruktor --
    public User(List<String> firstName, String surname, List<String> phoneNumber, String email, Address residanceAddress){
        super();
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        addClient(residanceAddress);
    }

    public User(List<String> firstName, String surname, List<String> phoneNumber, String email,String pesel, float salaryNetto){
        super();
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        addEmployee(pesel,salaryNetto);
    }

    // -- Gettery --

    public List<String> getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public static int getMinimalAge() { return minimalAge; }

    // -- Settery --

    public void setFirstName(List<String> firstName) { this.firstName = firstName; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setPhoneNumber(List<String> phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setEmail(String email) { this.email = email; }

    public static void setMinimalAge(int minimalAge) {
        User.minimalAge = minimalAge;
    }
    // -- Metody klasy --
    /**
     * toString() -- Przeslonienie metody --
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return "Klasa Uzytkownk\n" +
                "-> Imie:\t" + firstName + ",\n" +
                "-> Nazwisko:\t" + surname + ",\n" +
                "-> Numer telefonu:\t" + phoneNumber + ",\n" +
                "-> Email:\t" + email + ",\n";
    }

    private void addClient(Address residanceAddress) {
        Client client = new Client(residanceAddress);
        this.addLink(roleNameClient, roleNameGeneralization, client);
    }

    private void addEmployee(String pesel, float salaryNetto) {
        Employee employee = new Employee(pesel,salaryNetto);
        this.addLink(roleNameEmployee, roleNameGeneralization, employee);
    }
}

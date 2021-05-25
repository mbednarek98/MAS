package MAS.Classes;

import MAS.Object.ObjectPlus4;

public class Client extends ObjectPlus4 {
    // -- Atrybuty --
    private String firstName;           // -- Imie --
    private String surname;             // -- Nazwisko --
    private Address residenceAddress;   // -- Adres zamieszkania --
    private int age;   // -- Adres zamieszkania --
    public final static int minAge = 18;
    // -- Konstruktory --
    public Client(String firstName, String surname, Address residenceAddress, int age) throws Exception {
        this.firstName = firstName;
        this.surname = surname;
        this.residenceAddress = residenceAddress;
        setAge(age);
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
    public Address getResidenceAddress() {
        return residenceAddress;
    }
    public void setResidenceAddress(Address residenceAddress) {
        this.residenceAddress = residenceAddress;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) throws Exception {
        if(age < minAge) throw new Exception(String.format("Wiek uzytkownika (%s) musi byc przynajmniej %s lat", age, minAge));
        this.age = age;
    }
    // -- Metody --
    /**
     * toString() --- Przeslonienie metody
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return  "Klasa Klient:\t" + super.toString() + "\n"+
                "-> Imie:\t" + firstName  + ",\n"+
                "-> Nazwisko:\t" + surname +",\n"+
                "-> Adres zamieszkania:\t" + residenceAddress;
    }
    public void addXORRoles(){
        addXorRole("service");
        addXorRole("order");
    }

    public void addLinkXORService(Service service) throws Exception {
        addLinkXor("service","repair",service);
        showLinks("service",System.out);
    }
    public void addLinkXOROrder(Order order) throws Exception {
        addLinkXor("order","send",order);
        showLinks("order",System.out);
    }
}

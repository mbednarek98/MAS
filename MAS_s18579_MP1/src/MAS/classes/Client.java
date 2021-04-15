package MAS.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable { // Klient
    // -- Atrybuty klasy --
        // TODO: Atrybuty z abstrakcyjnej klasy Uzytkownik
        private List<String> firstName;     // imie[1..*]
        private String surname;             // nazwisko
        private List<String> phoneNumber;   // numerTelefonu[1..*]
        private String email;               // email[0..1]
        private static int minimalAge = 18; // _minimalnyWiek_ = 18
        // -----------------
    private static List<Client> ext = new ArrayList<>(); // atrybut ekstensji
    private Address residanceAddress;                    // adresZamieszkania
    // -----------------

    // -- Konstruktory --
    public Client(List<String> firstName, String surname, List<String> phoneNumber, String email, Address residanceAddress){
        // TODO: przekazac atrybuty do nadklasy (super())
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.residanceAddress = residanceAddress;
        addClient(this);
    }

    public Client(List<String> firstName, String surname, List<String> phoneNumber, Address residanceAddress){
        // TODO: przekazac atrybuty do nadklasy (super())
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = null;
        this.residanceAddress = residanceAddress;
        addClient(this);
    }
    // -----------------

    // -- Extensja --
    public static List<Client> getExtent() {
        return ext;
    }
    private static void addClient(Client client) { ext.add(client); }
    private static void removeClient(Client client) {
        ext.remove(client);
    }
    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException { ext = (ArrayList<Client>) stream.readObject(); }
    public static void writeExtent(ObjectOutputStream stream) throws IOException { stream.writeObject(ext); }
    public static void showExtent(){
        System.out.println("Extent klasy: " + Client.class.getName());
        for(Client client : ext) System.out.println(client);
    }
    // -----------------

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

    public Address getResidanceAddress() { return residanceAddress; }
    // -----------------

    // -- Settery --

    public void setFirstName(List<String> firstName) { this.firstName = firstName; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setPhoneNumber(List<String> phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setEmail(String email) { this.email = email; }

    public static void setMinimalAge(int minimalAge) {
        Client.minimalAge = minimalAge;
    }

    public void setResidanceAddress(Address residanceAddress) { this.residanceAddress = residanceAddress; }
    // -----------------

    // -- Metody klasy --
    /**
     * anulujZamowienie(Zamowienie)
     *
     * TODO: dokonczyc klase (anulujZamowienie(Zamowienie) -- brak asocjacji miedzy klasami)
     */
    public void cancelOrder(Order order){ }

    /**
     * toString() -- Przeslonienie metody --
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return "Klasa Klient" + super.toString() + "\n"+
                "-> Imie:\t" + firstName +",\n"+
                "-> Nazwisko:\t" + surname +",\n"+
                "-> Numer telefonu:\t" + phoneNumber + ",\n"+
                "-> Email:\t" + email + ",\n"+
                "-> Adres zamieszkania:\t\n" + residanceAddress + ",\n";
    }
    // -----------------
}

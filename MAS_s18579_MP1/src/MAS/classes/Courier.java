package MAS.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Courier implements Serializable {      // Kurier
    // -- Atrybuty klasy --

            // TODO: Atrybuty z abstrakcyjnej klasy Uzytkownik
            private List<String> firstName;         // imie[1..*]
            private String surname;                 // nazwisko
            private List<String> phoneNumber;       // numerTelefonu[1..*]
            private String email ;                  // email[0..1]
            private static int minimalAge = 18;     // _minimalnyWiek_ = 18      -- atrybut klasowy --
            // -----------------

        // TODO: Atrybuty z abstrakcyjnej klasy Pracownika
        private String pesel;                       // PESEL {unique}           -- ograniczenie {unique} --
        private float salaryNetto;                  // wynagrodzenieNetto
        private float salaryBrutto;                 // wynagrodzenieBrutto
        private static float VAT = 0.23f;           // _VAT_                    -- atrybut klasowy --
        // -----------------

    private static List<Courier> ext = new ArrayList<>();   // atrybut ekstensji
    private String driversLicenseNumber;                    // numerPrawaJazdy
    // -----------------

    // -- Konstruktory --
    public Courier(List<String> firstName, String surname, List<String> phoneNumber, String email,String pesel, float salaryNetto,String driversLicenseNumber){
        //// TODO:przekazac atrybuty do nadklasy (super())
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        setPesel(pesel);
        this.salaryNetto = salaryNetto;
        this.salaryBrutto = getGrossSalary();
        this.driversLicenseNumber = driversLicenseNumber;
        addCourier(this);
    }
    public Courier(List<String> firstName, String surname, List<String> phoneNumber,String pesel,float salaryNetto,String driversLicenseNumber){
        // TODO: przekazac atrybuty do nadklasy (super())
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = null;
        setPesel(pesel);
        this.salaryNetto = salaryNetto;
        this.salaryBrutto = getGrossSalary();
        this.driversLicenseNumber = driversLicenseNumber;
        addCourier(this);
    }
    // -----------------

    // -- Extensja --
    public static List<Courier> getExtent() { return ext; }
    private static void addCourier(Courier courier) { ext.add(courier); }
    private static void removeCourier(Courier courier) { ext.remove(courier); }
    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException { ext = (ArrayList<Courier>) stream.readObject(); }
    public static void writeExtent(ObjectOutputStream stream) throws IOException { stream.writeObject(ext); }
    public static void showExtent(){
        System.out.println("Extent klasy: " + Courier.class.getName());
        for(Courier courier : ext) System.out.println(courier);
    }
    // -----------------

    // --Gettery --
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

    public String getPesel() { return pesel; }

    public float getSalaryNetto() { return salaryNetto; }

    public float getSalaryBrutto() { return salaryBrutto; }

    public static float getVAT() { return VAT; }

    public String getDriversLicenseNumber() { return driversLicenseNumber; }


    // -----------------

    // -- Settery --
    public void setFirstName(List<String> firstName) { this.firstName = firstName; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setPhoneNumber(List<String> phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setEmail(String email) { this.email = email; }

    public static void setMinimalAge(int minimalAge) { Courier.minimalAge = minimalAge; }

    public void setPesel(String pesel) {
        if(checkPESELUniqueness(pesel)) this.pesel = pesel;
        else System.err.println("Podany PESEL juz wystepuje");
    }

    public void setSalaryNetto(float salaryNetto) { this.salaryNetto = salaryNetto; }

    public static void setVAT(float VAT) { Courier.VAT = VAT; }

    public void setDriversLicenseNumber(String driversLicenseNumber) { this.driversLicenseNumber = driversLicenseNumber; }

    // -----------------

    // -- Metody klasy --
    /**
     * zdobadzWynagrodzenieBrutto()     -- Metoda atrybuty pochodnego --
     *
     * @return (float) wynagrodzenie po odjeciu podatku VAT
     * TODO: metoda klasy abstrakcyjnej Pracownik
     */
    public float getGrossSalary(){ return salaryNetto - (salaryNetto*VAT); }

    /**
     * sprawdzOgraniczenieUnique()      -- Ograniczenie {Unique} --
     *
     * @return (boolean) czy taki PESEL nie jest juz uzywany (ograniczenie unique)
     * TODO: metoda klasy abstrakcyjnej Pracownik
     */
    public boolean checkPESELUniqueness(String pesel){
        return ext.stream().noneMatch(serviceTechnician -> serviceTechnician.getPesel().equals(pesel));
    }
    /**
     * wyliczSrednieWynagrodzenieBrutto()   -- Metoda klasowa --
     *
     * @return (float) srednia wartosc Brutto dla wszystkich kurierow
     * TODO: metoda klasy abstrakcyjnej Pracownik
     */
    public float avgSalary(){
        float sum = 0;
        for(Courier courier : ext) sum += courier.getSalaryBrutto();
        return sum/ext.size();
    }
    /**
     * toString()               -- Przeslonienie metody --
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return "Klasa Kurier:\t" + super.toString() + "\n"+
                "-> Imie:\t" + firstName +",\n"+
                "-> Nazwisko:\t" + surname +",\n"+
                "-> Numer telefonu:\t" + phoneNumber + ",\n"+
                "-> Email:\t" + email + ",\n"+
                "-> PESEL:\t" + pesel + ",\n"+
                "-> Wynagrodzenie netto:\t" + salaryNetto + " zl,\n"+
                "-> Wynagrodzenie brutto:\t" + salaryBrutto + " zl,\n"+
                "-> Numer prawa jazdy:\t" + driversLicenseNumber + ",\n";
    }
    // -----------------
}

package MAS.classes;

import MAS.restrictions.Condition;
import MAS.restrictions.Title;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServiceTechnician implements Serializable {   // Serwisant
    // -- Atrybuty klasy --

            // TODO: Atrybuty z abstrakcyjnej klasy Uzytkownik
            private List<String> firstName;         // imie[1..*]
            private String surname;                 // nazwisko
            private List<String> phoneNumber;       // numerTelefonu[1..*]
            private String email;                   // email[0..1]
            private static int minimalAge = 18;     // _minimalnyWiek_ = 18      -- atrybut klasowy --
            // -----------------

        // TODO: Atrybuty z abstrakcyjnej klasy Pracowni
        private String pesel;                       // PESEL {unique}           -- ograniczenie {unique} --
        private float salaryNetto;                  // wynagrodzenieNetto
        private float salaryBrutto;                 // wynagrodzenieBrutto
        private static float VAT = 0.23f;           // _VAT_                    -- atrybut klasowy --
        // -----------------

    private static List<ServiceTechnician> ext = new ArrayList<>();     // atrybut ekstensji
    private Title title;                                                // tytul
    private List<String> qualification;                                 // kwalifikacjie[1..*]
    // -----------------

    // -- Asocjacja z atrybutem --

    private List<DeviceService> deviceServices = new ArrayList<>();

    // -----------------

    // -- Konstruktory --
    public ServiceTechnician(List<String> firstName, String surname, List<String> phoneNumber, String email,String pesel, float salaryNetto,Title title, List<String> qualification){
        // TODO: przekazac atrybuty do nadklasy (super())
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        setPesel(pesel);
        this.salaryNetto = salaryNetto;
        this.salaryBrutto = getGrossSalary();
        this.title = title;
        this.qualification = qualification;
        addServiceTechnician(this);
    }
    public ServiceTechnician(List<String> firstName, String surname, List<String> phoneNumber,String pesel,float salaryNetto,Title title, List<String> qualification){
        // TODO: przekazac atrybuty do nadklasy (super())
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = null;
        setPesel(pesel);
        this.salaryNetto = salaryNetto;
        this.salaryBrutto = getGrossSalary();
        this.title = title;
        this.qualification = qualification;
        addServiceTechnician(this);
    }
    // -----------------

    // -- Extensja --
    public static List<ServiceTechnician> getExtent() { return ext; }
    private static void addServiceTechnician(ServiceTechnician serviceTechnician) { ext.add(serviceTechnician); }
    private static void removeServiceTechnician(ServiceTechnician serviceTechnician) { ext.remove(serviceTechnician); }
    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException { ext = (ArrayList<ServiceTechnician>) stream.readObject(); }
    public static void writeExtent(ObjectOutputStream stream) throws IOException { stream.writeObject(ext); }
    public static void showExtent(){
        System.out.println("Extent klasy: " + ServiceTechnician.class.getName());
        for(ServiceTechnician serviceTechnician : ext) System.out.println(serviceTechnician);
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

    public String getPesel() { return pesel; }

    public float getSalaryNetto() { return salaryNetto; }

    public static float getVAT() { return VAT; }

    public float getSalaryBrutto() { return salaryBrutto; }

    public Title getTitle() { return title; }

    public List<String> getQualification() { return qualification; }
    // -----------------

    // -- Settery --
    public void setFirstName(List<String> firstName) { this.firstName = firstName; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setPhoneNumber(List<String> phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setEmail(String email) { this.email = email; }

    public static void setMinimalAge(int minimalAge) { ServiceTechnician.minimalAge = minimalAge; }

    public void setPesel(String pesel) {
        if(checkPESELUniqueness(pesel)) this.pesel = pesel;
        else System.err.println("Podany PESEL juz wystepuje");
    }

    public void setSalaryNetto(float salaryNetto) { this.salaryNetto = salaryNetto; }

    public static void setVAT(float VAT) { ServiceTechnician.VAT = VAT; }

    public void setTitle(Title title) { this.title = title; }

    public void setQualification(List<String> qualification) { this.qualification = qualification; }

    // -----------------
    // -- Metody klasy --
    /**
     * ustawSerwisSprzetu()       -- Metoda asocjacji z atrybutem --
     *
     */
    public void setDeviceService(DeviceService deviceService) {
        if (!deviceServices.contains(deviceService)) {
            deviceServices.add(deviceService);
            deviceService.setServiceTechnician(this);
        }
    }
    /**
     * usunSerwisSprzetu()       -- Metoda asocjacji z atrybutem --
     *
     */
    public void deleteDeviceService(DeviceService deviceService) {
        if (deviceServices.contains(deviceService)) {
            deviceServices.remove(deviceService);
            deviceService.setServiceTechnician(null);
        }
    }
    /**
     * zmienStatusSprzetu(SerwisSprzetu, stan)
     *
     * @param deviceService  klasa SerwisSprzetu do ktorego chcemy sie odwolac
     * @param condition stan sprzetu podczas serwisu
     * TODO: dokonczyc klase (zmienStatusSprzetu(SerwisSprzetu, stan)) -- brak asocjacji miedzy klasami)
     */
    public void changeConditionDeviceService(DeviceService deviceService, Condition condition){ }
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
        for(ServiceTechnician serviceTechnician : ext) sum += serviceTechnician.getSalaryBrutto();
        return sum/ext.size();
    }
    /**
     * toString() --- Przeslonienie metody
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return  "Klasa Serwisant:\t" + super.toString() + "\n"+
                "-> Imie:\t" + firstName +",\n"+
                "-> Nazwisko:\t" + surname +",\n"+
                "-> Numer telefonu:\t" + phoneNumber + ",\n"+
                "-> Email:\t" + email + ",\n"+
                "-> PESEL:\t" + pesel + ",\n"+
                "-> Wynagrodzenie netto:\t" + salaryNetto + ",\n"+
                "-> Wynagrodzenie brutto:\t" + salaryBrutto + ",\n"+
                "-> Tytul:\t" + title + ",\n"+
                "-> Kwalifikacje:\t" + qualification + ",\n";
    }
    // -----------------
}

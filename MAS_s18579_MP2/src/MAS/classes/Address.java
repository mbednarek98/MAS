package MAS.classes;


import java.io.Serializable;

public class Address implements Serializable { // Adres
    // -- Atrybuty klasy --
    private String street;          // ulica
    private int streetNumber;       // numerUlicy
    private int apartamentNumber;   // numerDomu
    private String city;            // miasto
    private String zipcode;         // kodPocztowy

    // -----------------

    // -- Konstruktor --
    public Address(String street, int streetNumber, int apartamentNumber, String city, String zipcode){
        this.street = street;
        this.streetNumber = streetNumber;
        this.apartamentNumber = apartamentNumber;
        this.city = city;
        this.zipcode = zipcode;
    }

    // --------------

    // -- Getter --
    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public int getstreetNumber() {
        return streetNumber;
    }

    public int getApartamentNumber() {
        return apartamentNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    // --------------

    // -- Setter --

    public void setStreet(String street) {
        this.street = street;
    }

    public void setstreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setApartamentNumber(int apartamentNumber) {
        this.apartamentNumber = apartamentNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    // --------------

    // -- Metody klasy --
    /**
     * toString() --- Przeslonienie metody
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return  "\tKlasa Adres:\t" + super.toString() + "\n"+
                "\t-> Ulica:\t" + street  + " "+ streetNumber+"\\"+apartamentNumber+",\n"+
                "\t-> Miasto:\t" + city +",\n"+
                "\t-> Kod pocztowy:\t" + zipcode;
    }
    // -----------------
}

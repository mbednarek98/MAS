package MAS.Classes;

import MAS.Object.ObjectPlus4;

import java.util.HashSet;
import java.util.Set;

public class Device extends ObjectPlus4 {
    // -- Atrybuty --
    private String idNumber;       // -- Numer identyfikacyjny {unique} --
    private String name;           // -- Nazwa --
    private double price;          // -- Cena --
    private String specifications; // -- Specyfikacje --
    private static final Set<String> allIdNumber = new HashSet<String>(){}; // -- Ogr. unique --
    // -- Konstruktory --
    public Device(String idNumber, String name, double price, String specifications) throws Exception {
        super();
        setIdNumber(idNumber);
        this.name = name;
        this.price = price;
        this.specifications = specifications;
    }
    // -- Gettery i Settery --
    public String getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(String idNumber) throws Exception {     // -- Ogr. unique --
        if (allIdNumber.contains(idNumber)) throw new Exception(String.format("Dany numer identyfikacji jest juz w bazie!",idNumber));
        allIdNumber.add(idNumber);
        this.idNumber = idNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getSpecifications() {
        return specifications;
    }
    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }
    // -- Metody --
    /**
     * toString() --- Przeslonienie metody
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return "Klasa Sprzet" + super.toString() +
                "-> Numer identyfikacyjny:" + idNumber + ",\n" +
                "-> Nazwa:" + name + ",\n" +
                "-> Cena:" + price + ",\n"+
                "-> Specyfikacje:" + specifications + ",\n";
    }
}

package MAS.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Projector implements Serializable {
    // -- Atrybuty klasy --
        // TODO: Atrybuty z abstrakcyjnej klasy Sprzet
        private int idNumber;                      // numerIdentyfikacjiny {unique}
        private float price;                       // cena
        // -----------------
    private static List<Projector> ext = new ArrayList<>();        // atrybut ekstensji
    private String displayType;                                    // rodzajWyswietlacza
    // -----------------

    // -- Konstruktory --

    public Projector(int idNumber,float price, String displayType ){
        // TODO: przekazac atrybuty do nadklasy (super())
        setIdNumber(idNumber);
        this.price = price;
        this.displayType = displayType;
        addProjector(this);
    }

    // -----------------

    // -- Extensja --
    public static List<Projector> getExtent() {
        return ext;
    }
    private static void addProjector(Projector projector) { ext.add(projector); }
    private static void removeProjector(Projector projector) {
        ext.remove(projector);
    }
    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException { ext = (ArrayList<Projector>) stream.readObject(); }
    public static void writeExtent(ObjectOutputStream stream) throws IOException { stream.writeObject(ext); }
    public static void showExtent(){
        System.out.println("Extent klasy: " + Projector.class.getName());
        for(Projector projector : ext) System.out.println(projector);
    }
    // -----------------

    // -- Gettery --

    public int getIdNumber() {
        return idNumber;
    }

    public float getPrice() {
        return price;
    }

    public String getDisplayType() {
        return displayType;
    }

    // -----------------

    // -- Settery

    public void setIdNumber(int idNumber) {
        if(checkIDUniqueness(idNumber)) this.idNumber = idNumber;
        else System.err.println("Podany ID juz wystepuje");
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    // -----------------

    // -- Metody klasy --
    /**
     * sprawdzOgraniczenieUnique()      -- Ograniczenie {Unique} --
     *
     * @return (boolean) czy taki id nie jest juz uzywany (ograniczenie unique)
     * TODO: metoda klasy abstrakcyjnej Sprzet
     */
    public boolean checkIDUniqueness(int idNumber){
        return ext.stream().noneMatch(projector -> projector.getIdNumber() == idNumber);
    }
    /**
     * toString() -- Przeslonienie metody --
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return "Klasa Projektor: " + super.toString() + "\n"+
                "-> Numer Identyfikacyjny:\t" + idNumber +",\n"+
                "-> Cena:\t" + price +",\n"+
                "-> Rodzaj wyswietlacza:\t" + displayType + ",\n";
    }
    // -----------------
}

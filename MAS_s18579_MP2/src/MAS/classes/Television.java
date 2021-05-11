package MAS.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Television implements Serializable {
    // -- Atrybuty klasy --
        // TODO: Atrybuty z abstrakcyjnej klasy Sprzet
        private int idNumber;               // numerIdentyfikacjiny {unique}
        private float price;                // cena
        // -----------------
    private static List<Television> ext = new ArrayList<>(); // atrybut ekstensji
    private int matrixSize;                                  // rozmiarMatrycy
    private String oS;                                       // systemOperacyjny[0..1]
    // -----------------

    // -- Konstruktory --
    public Television(int idNumber,float price,int matrixSize, String oS ){
        // TODO: przekazac atrybuty do nadklasy (super())
        setIdNumber(idNumber);
        this.price = price;
        this.matrixSize = matrixSize;
        this.oS = oS;
        addTelevision(this);
    }

    public Television(int idNumber,float price,int matrixSize){
        // TODO: przekazac atrybuty do nadklasy (super())
        setIdNumber(idNumber);
        this.price = price;
        this.matrixSize = matrixSize;
        this.oS = null;
        addTelevision(this);
    }
    // -----------------

    // -- Extensja --
    public static List<Television> getExtent() {
        return ext;
    }
    private static void addTelevision(Television television) { ext.add(television); }
    private static void removeTelevision(Television television) {
        ext.remove(television);
    }
    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException { ext = (ArrayList<Television>) stream.readObject(); }
    public static void writeExtent(ObjectOutputStream stream) throws IOException { stream.writeObject(ext); }
    public static void showExtent(){
        System.out.println("Extent klasy: " + Television.class.getName());
        for(Television television : ext) System.out.println(television);
    }
    // -----------------

    // -- Gettery --

    public int getIdNumber() {
        return idNumber;
    }

    public float getPrice() {
        return price;
    }

    public int getMatrixSize() {
        return matrixSize;
    }

    public String getoS() {
        return oS;
    }

    // -----------------

    // -- Settery --

    public void setIdNumber(int idNumber) {
        if(checkIDUniqueness(idNumber)) this.idNumber = idNumber;
        else System.err.println("Podany ID juz wystepuje");
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setMatrixSize(int matrixSize) {
        this.matrixSize = matrixSize;
    }

    public void setoS(String oS) {
        this.oS = oS;
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
        return ext.stream().noneMatch(Television -> Television.getIdNumber() == idNumber);
    }
    /**
     * toString() -- Przeslonienie metody --
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return "Klasa Telewizor" + super.toString() + "\n"+
                "-> Numer Identyfikacyjny:\t" + idNumber +",\n"+
                "-> Cena:\t" + price +",\n"+
                "-> Rozmiar matrycy:\t" + matrixSize + ",\n"+
                "-> System operacyjny:\t" + oS + ",\n";
    }
    // -----------------
}

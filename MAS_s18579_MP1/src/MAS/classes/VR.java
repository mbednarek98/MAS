package MAS.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VR implements Serializable {
    // -- Atrybuty klasy --
        // TODO: Atrybuty z abstrakcyjnej klasy Sprzet
        private int idNumber;                      // numerIdentyfikacjiny {unique}
        private float price;                      // cena
        // -----------------
    private static List<VR> ext = new ArrayList<>();        // atrybut ekstensji
    private String lensType;                                // typSoczewki
    private boolean wireless;                               // bezprzewodowy{'tak','nie'}
    // -----------------

    // -- Konstruktory --

    public VR(int idNumber,float price, String lensType, boolean wireless){
        // TODO: przekazac atrybuty do nadklasy (super())
        setIdNumber(idNumber);
        this.price = price;
        this.lensType = lensType;
        this.wireless = wireless;
        addVR(this);
    }

    // -----------------

    // -- Extensja --
    public static List<VR> getExtent() {
        return ext;
    }
    private static void addVR(VR vr) { ext.add(vr); }
    private static void removeVR(VR vr) {
        ext.remove(vr);
    }
    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException { ext = (ArrayList<VR>) stream.readObject(); }
    public static void writeExtent(ObjectOutputStream stream) throws IOException { stream.writeObject(ext); }
    public static void showExtent(){
        System.out.println("Extent klasy: " + VR.class.getName());
        for(VR vr : ext) System.out.println(vr);
    }
    // -----------------

    // -- Gettery --

    public int getIdNumber() {
        return idNumber;
    }

    public float getPrice() {
        return price;
    }

    public String getLensType() {
        return lensType;
    }

    public boolean getWireless() {
        return wireless;
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

    public void setLensType(String lensType) {
        this.lensType = lensType;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
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
        return ext.stream().noneMatch(vr -> vr.getIdNumber() == idNumber);
    }
    /**
     * toString() -- Przeslonienie metody --
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return "Klasa Okulary VR: " + super.toString() + "\n"+
                "-> Numer Identyfikacyjny:\t" + idNumber +",\n"+
                "-> Cena:\t" + price +",\n"+
                "-> Typ soczewki:\t" + lensType + ",\n"+
                "-> Bezprzewodowy:\t" + wireless + ",\n";
    }
    // -----------------
}

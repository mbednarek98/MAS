package MAS.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Console implements Serializable {
    // -- Atrybuty klasy --
        // TODO: Atrybuty z abstrakcyjnej klasy Sprzet
        private String idNumber;                      // numerIdentyfikacjiny {unique}
        private float price;                       // cena
        // -----------------
    private static List<Console> ext = new ArrayList<>();        // atrybut ekstensji
    private String version;                                      // wersja
    private double diskSize;                                     // pojemnoscDysku
    // -----------------

    // -- Asocjacja kwalifikowana --

    private List<Order> orders = new ArrayList<>();

    // -----------------

    // -- Asocjacja z atrybutem --

    private List<DeviceService> deviceServices = new ArrayList<>();

    // -----------------

    // -- Konstruktory --

    public Console(String idNumber,float price, String version, double diskSize){
        // TODO: przekazac atrybuty do nadklasy (super())
        setIdNumber(idNumber);
        this.price = price;
        this.version = version;
        this.diskSize = diskSize;
        addConsole(this);
    }

    // -----------------

    // -- Extensja --
    public static List<Console> getExtent() {
        return ext;
    }
    private static void addConsole(Console console) { ext.add(console); }
    private static void removeConsole(Console console) {
        ext.remove(console);
    }
    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException { ext = (ArrayList<Console>) stream.readObject(); }
    public static void writeExtent(ObjectOutputStream stream) throws IOException { stream.writeObject(ext); }
    public static void showExtent(){
        System.out.println("Extent klasy: " + Console.class.getName());
        for(Console console : ext) System.out.println(console);
    }
    // -----------------

    // -- Gettery --

    public String getIdNumber() {
        return idNumber;
    }

    public float getPrice() {
        return price;
    }

    public String getVersion() {
        return version;
    }

    public double getDiskSize() {
        return diskSize;
    }
    // -----------------

    // -- Settery

    public void setIdNumber(String idNumber) {
        if(checkIDUniqueness(idNumber)) this.idNumber = idNumber;
        else System.err.println("Podany ID juz wystepuje");
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setDiskSize(double diskSize) {
        this.diskSize = diskSize;
    }

    // -----------------

    // -- Metody klasy --
    /**
     * ustawSerwisSprzetu()       -- Metoda asocjacji z atrybutem --
     *
     */
    public void setDeviceService(DeviceService deviceService) {
        if (!deviceServices.contains(deviceService)) {
            deviceServices.add(deviceService);
            deviceService.setConsole(this);
        }
    }
    /**
     * usunSerwisSprzetu()       -- Metoda asocjacji z atrybutem --
     *
     */
    public void deleteDeviceService(DeviceService deviceService) {
        if (deviceServices.contains(deviceService)) {
            deviceServices.remove(deviceService);
            deviceService.setConsole(null);
        }
    }
    /**
     * dodajZamowienie()              -- Metoda asocjacji kwalifikowanej --
     *
     */
    public void addOrder(Order order) throws Exception {
        if (order == null) throw new Exception("Klasa order nie moze byc nullem");
        else if (!orders.contains(order)) {
            orders.add(order);
            order.addConsoleQualif(this);
        }
    }

    /**
     * usunZamowienie()              -- Metoda asocjacji kwalifikowanej --
     *
     */
    public void deleteOrder(Order order) throws Exception {
        if (orders.contains(order)) {
            orders.remove(order);
            order.deleteConsole(idNumber);
        }
    }

    /**
     * sprawdzOgraniczenieUnique()      -- Ograniczenie {Unique} --
     *
     * @return (boolean) czy taki id nie jest juz uzywany (ograniczenie unique)
     * TODO: metoda klasy abstrakcyjnej Sprzet
     */
    public boolean checkIDUniqueness(String idNumber){
        return ext.stream().noneMatch(console -> console.getIdNumber().equals(idNumber));
    }
    /**
     * toString() -- Przeslonienie metody --
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return "Klasa Konsola: " + super.toString() + "\n"+
                "-> Numer Identyfikacyjny:\t" + idNumber +",\n"+
                "-> Cena:\t" + price +",\n"+
                "-> Wersja:\t" + version + ",\n"+
                "-> Pojemnosc dysku:\t" + diskSize + ",\n";
    }
    // -----------------
}

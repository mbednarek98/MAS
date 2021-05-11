package MAS.classes;

import MAS.restrictions.Condition;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DeviceService implements Serializable {
    // -- Atrybuty klasy --
    private static List<DeviceService> ext = new ArrayList<>(); // atrybut ekstensji
    private LocalDate serviceDate;                              // godzinaPrzydzialu
    private Condition deviceCondition;
    // -----------------

    // -- Asocjacja z atrybutem --
    private ServiceTechnician serviceTechnician;
    private Console console;
    // -----------------

    // -- Konstruktory --
    public DeviceService(ServiceTechnician serviceTechnician, Console console,LocalDate serviceDate, Condition deviceCondition){
        this.serviceTechnician = serviceTechnician;
        this.console = console;
        serviceTechnician.setDeviceService(this);
        console.setDeviceService(this);
        this.serviceDate = serviceDate;
        this.deviceCondition = deviceCondition;
        addDeviceService(this);
    }
    public DeviceService(LocalDate serviceDate, Condition deviceCondition){
        this.serviceDate = serviceDate;
        this.deviceCondition = deviceCondition;
        addDeviceService(this);
    }
    // -----------------

    // -- Extensja --
    public static List<DeviceService> getExtent() {
        return ext;
    }
    private static void addDeviceService(DeviceService deviceService) { ext.add(deviceService); }
    private static void removeDeviceService(DeviceService deviceService) {
        ext.remove(deviceService);
    }
    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException { ext = (ArrayList<DeviceService>) stream.readObject(); }
    public static void writeExtent(ObjectOutputStream stream) throws IOException { stream.writeObject(ext); }
    public static void showExtent(){
        System.out.println("Extent klasy: " + DeviceService.class.getName());
        for(DeviceService deviceService : ext) System.out.println(deviceService);
    }
    // -----------------

    // -- Gettery --

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public Condition getDeviceCondition() {
        return deviceCondition;
    }
    // -----------------

    // -- Settery

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public void setDeviceCondition(Condition deviceCondition) {
        this.deviceCondition = deviceCondition;
    }
// -----------------

    // -- Metody klasy --
    /**
     * ustawSerwisanta()       -- Metoda asocjacji z atrybutem --
     *
     */
    public void setServiceTechnician(ServiceTechnician serviceTechnician) {
        if (serviceTechnician == null) {
            this.serviceTechnician.deleteDeviceService(this);
            this.serviceTechnician = null;
        } else {
            if (this.serviceTechnician == null) {
                this.serviceTechnician = serviceTechnician;
                serviceTechnician.setDeviceService(this);
            }
        }
    }
    /**
     * ustawSprzet()       -- Metoda asocjacji z atrybutem --
     *
     */
    public void setConsole(Console console) {
        if (console == null) {
            this.console.deleteDeviceService(this);
            this.console = null;
        } else {
            if (this.console == null) {
                this.console = console;
                console.setDeviceService(this);
            }
        }
    }
    /**
     * obliczIloscSprzetu()       -- Metoda klasowa --
     *
     * @return (long) ilosc zamowien w systemie
     */
    public static long numberOfDevices() { return ext.size(); }

    /**
     * obliczIloscSprzetu(stan)       -- Metoda klasowa --
     *
     * @return (long) ilosc zamowien w systemie
     */
    public static long numberOfDevices(Condition condition) { return ext.stream().filter(deviceService -> deviceService.getDeviceCondition().equals(condition)).count(); }

    /**
     * toString() -- Przeslonienie metody --
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return "Klasa SerwisSprzetu: " + super.toString() + "\n"+
                "-> Data serwisu:\t" + serviceDate +",\n"+
                "-> Stan sprzetu:\t" + deviceCondition +",\n"+
                "-> Konsola:\t\n" + console +
                "-> Serwisant:\t\n" + serviceTechnician +"\n";
    }
    // -----------------
}

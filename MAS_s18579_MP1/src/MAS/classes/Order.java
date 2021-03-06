package MAS.classes;

import MAS.restrictions.State;
import MAS.restrictions.TypeofPayment;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

    // -- Atrybuty klasy --
    private static List<Order> ext = new ArrayList<>();
    private LocalDate dateofOrder;          // dataZamowienia
    private LocalDate dateofDelivery;       // dataOddania
    private TypeofPayment typeofPayment;    // typPlatnosci
    private Address deliveryAddress;        // adresDostawy
    private State state;                    // status
    // -----------------


    // -- Konstruktor --
    public Order(LocalDate dateofOrder, LocalDate dateofDelivery, TypeofPayment typeofPayment, Address deliveryAddress, State state){
        this.dateofOrder = dateofOrder;
        this.dateofDelivery = dateofDelivery;
        this.typeofPayment = typeofPayment;
        this.deliveryAddress = deliveryAddress;
        this.state = state;
        addOrder(this);
    }
    // -----------------

    // -- Extensja --
    public static List<Order> getExtent() {
        return ext;
    }
    private static void addOrder(Order order) { ext.add(order); }
    private static void removeOrder(Order order) {
        ext.remove(order);
    }
    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException { ext = (ArrayList<Order>) stream.readObject(); }
    public static void writeExtent(ObjectOutputStream stream) throws IOException { stream.writeObject(ext); }
    public static void showExtent(){
        System.out.println("Extent klasy: " + Order.class.getName());
        for(Order order : ext) System.out.println(order);
    }
    // -----------------

    // --Gettery --
    public LocalDate getDateofOrder() {
        return dateofOrder;
    }

    public LocalDate getDateofDelivery() {
        return dateofDelivery;
    }

    public TypeofPayment getTypeofPayment() {
        return typeofPayment;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public State getState() {
        return state;
    }
    // -----------------

    // -- Settery --
    public void setDateofOrder(LocalDate dateofOrder) {
        this.dateofOrder = dateofOrder;
    }

    public void setDateofDelivery(LocalDate dateofDelivery) {
        this.dateofDelivery = dateofDelivery;
    }

    public void setTypeofPayment(TypeofPayment typeofPayment) {
        this.typeofPayment = typeofPayment;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setState(State state) {
        this.state = state;
    }
    // -----------------

    // -- Metody klasy --
    /**
     * obliczIloscZam??wie??()              -- Metoda klasowa --
     *
     * @return (long) ilosc zamowien w systemie
     */
    public static long numberOfOrders() { return ext.size(); }

    /**
     * obliczIloscZam??wie??(status)       -- Metoda klasowa --
     *
     * @return (long) ilosc zamowien w systemie
     */
    public static long numberOfOrders(State state) { return ext.stream().filter(order -> order.state.equals(state)).count(); }

    /**
    * obliczIloscZam??wie??(Kurier)       -- Metoda klasowa --
    *
    * @param courier klasa kurier
    * @return (int) ilosc zamowien w systemie dla danego kuriera
    * TODO: dokonczyc klase (obliczIloscZam??wie??(Kurier) -- brak asocjacji miedzy klasami)
    */
    public void numberOfOrders(Courier courier){ }

    /**
     * obliczCeneZamowienia()           -- Metoda obiektowa --
     *
     * @return (float) cena zamowienia
     * TODO: dokonczyc klase (obliczCeneZamowienia() -- brak asocjacji miedzy klasami)
     */
    public void orderPrice(){ }

    /**
     * toString()                       -- Przeslonienie metody --
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */

    @Override
    public String toString() {
        return  "Klasa Zamowienie:\t" + super.toString() + "\n"+
                "-> Data zamowienia:\t" + dateofOrder +",\n"+
                "-> Data oddania:\t" + dateofDelivery +",\n"+
                "-> Typ platnosci:\t" + typeofPayment + ",\n"+
                "-> Adres dostawy:\n" + deliveryAddress + ",\n"+
                "-> Status:\t" + state + ",\n";
    }
    // -----------------
}
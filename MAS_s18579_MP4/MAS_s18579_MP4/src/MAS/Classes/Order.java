package MAS.Classes;

import MAS.Classes.Enum.State;
import MAS.Classes.Enum.ToP;
import MAS.Object.ObjectPlus4;

import java.time.LocalDate;

public class Order extends ObjectPlus4 {
    // -- Atrybuty --
    private LocalDate orderDate;    // -- Data zamowienia --
    private LocalDate deliveryDate; // -- Data oddania --
    private ToP typeOfPayment;      // -- Typ platnosci --
    private Address addressDelivery;// -- Adres dostawy --
    private State state;            // -- Status --
    // -- Konstruktory --
    public Order(LocalDate orderDate, LocalDate deliveryDate, ToP typeOfPayment, Address addressDelivery, State state) throws Exception {
        super();
        this.orderDate = orderDate;
        setDeliveryDate(deliveryDate);
        this.typeOfPayment = typeOfPayment;
        this.addressDelivery = addressDelivery;
        this.state = state;
    }
    // -- Gettery i Settery --
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(LocalDate deliveryDate) throws Exception {
        if (orderDate.isAfter(deliveryDate)) throw new Exception(String.format("Data zamowienia (%s) musi byc wieksza niz %s", deliveryDate, orderDate));
        this.deliveryDate = deliveryDate;
    }
    public ToP getTypeOfPayment() {
        return typeOfPayment;
    }
    public void setTypeOfPayment(ToP typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }
    public Address getAddressDelivery() {
        return addressDelivery;
    }
    public void setAddressDelivery(Address addressDelivery) {
        this.addressDelivery = addressDelivery;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    // -- Metody --
    /**
     * toString() --- Przeslonienie metody
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return "Klasa Order" + super.toString() +
                "-> Data zamowienia:" + orderDate + ",\n"+
                "-> Data oddania:" + deliveryDate + ",\n"+
                "-> Typ platnosci:" + typeOfPayment + ",\n"+
                "-> Adres dostawy:" + addressDelivery + ",\n"+
                "-> Status:" + state;
    }
}

package MAS.Classes;

import MAS.Object.ObjectPlus4;

import java.time.LocalDate;

public class CourierOrder extends ObjectPlus4 {
    public static final String COURIER = "courier";
    public static final String COURIERORDER = "courierorder";
    public static final String ORDER = "order";
    // -- Atrybuty --
    private LocalDate dateAssignment;   // -- Data przydzialu --
    private final Courier courier;
    private final Order order;
    // -- Konstruktory --
    public CourierOrder(LocalDate dateAssignment, Courier courier, Order order) {
        super();
        this.dateAssignment = dateAssignment;
        this.courier = courier;
        this.order = order;

        this.addLink(COURIER, COURIERORDER, courier);
        this.addLink(ORDER, COURIERORDER, order);
    }
    // -- Gettery i Settery --
    public LocalDate getDateAssignment() {
        return dateAssignment;
    }
    public void setDateAssignment(LocalDate dateAssignment) {
        this.dateAssignment = dateAssignment;
    }
    // -- Metody --
    public void showLinks() throws Exception {
        showLinks(COURIER,System.out);
        showLinks(ORDER,System.out);
    }
    /**
     * toString() --- Przeslonienie metody
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return "Klasa CourierOrder" + super.toString() +
                "-> Data przydzialu:" + dateAssignment;
    }
}

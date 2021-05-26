package MAS.Classes;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Reservation")
public class Reservation {
    public enum TypeOfPayment {Przelew, KartaPlatnicza, OplataZaPobraniem,Paypal}
    public enum State {Anulowana, Zlozona, WTrakcie, Wykonana}

    private long idReservation;
    private LocalDate dateOfOrder;
    private LocalDate dateOfReturn;
    private TypeOfPayment typeOfPayment;
    private State state;

    private Client client;
    private Courier courier;
    private Device device;

    public Reservation(){}

    public Reservation(LocalDate dateOfOrder, LocalDate dateOfReturn, TypeOfPayment typeOfPayment, State state) {
        this.dateOfOrder = dateOfOrder;
        this.dateOfReturn = dateOfReturn;
        this.typeOfPayment = typeOfPayment;
        this.state = state;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(long idReservation) {
        this.idReservation = idReservation;
    }



    @ManyToOne
    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne
    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    @Basic
    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDate dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    @Basic
    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    @Enumerated
    public TypeOfPayment getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfPayment(TypeOfPayment typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }

    @Enumerated
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

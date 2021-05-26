package MAS.Classes;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Device")
public class Device {
    private long idDevice;
    private String name;
    private double price;

    List<Reservation> reservations = new ArrayList<>();

    public Device(){}
    public Device(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(long idDevice) {
        this.idDevice = idDevice;
    }


    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        getReservations().add(reservation);
        reservation.setDevice(this);
    }

    public void removeReservation(Reservation reservation) {
        getReservations().remove(reservation);
        reservation.setDevice(null);
    }
}

package MAS.Classes;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Client")
public class Client {
    private long idClient;
    private String residenceAddress;
    private String name;
    private String surname;
    private String phoneNumber;

    private List<Reservation> reservations = new ArrayList<>();

    public Client() { }

    public Client(String residenceAddress, String name, String surname, String phoneNumber) {
        this.residenceAddress = residenceAddress;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    @Basic
    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }
    @Basic
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        getReservations().add(reservation);
        reservation.setClient(this);
    }

    public void removeReservation(Reservation reservation) {
        getReservations().remove(reservation);
        reservation.setClient(null);
    }
}

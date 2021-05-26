package MAS.Classes;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Courier")
public class Courier {
    private final static double VAT = 0.14;

    private long idCourier;
    private String PESEL;
    private double salaryNetto;
    private String name;
    private String surname;
    private String phoneNumber;

    private List<Reservation> reservations = new ArrayList<>();

    public Courier(){}

    public Courier(String PESEL, double salaryNetto, String name, String surname, String phoneNumber) {
        this.PESEL = PESEL;
        this.salaryNetto = salaryNetto;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getIdCourier() {
        return idCourier;
    }

    public void setIdCourier(long idCourier) {
        this.idCourier = idCourier;
    }



    @Basic
    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }
    @Basic
    public double getSalaryNetto() {
        return salaryNetto;
    }

    public void setSalaryNetto(double salaryNetto) {
        this.salaryNetto = salaryNetto;
    }
    @Transient
    public double getSalaryBrutto() {
        return salaryNetto - (salaryNetto*VAT);
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

    @OneToMany(mappedBy = "courier", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        getReservations().add(reservation);
        reservation.setCourier(this);
    }

    public void removeReservation(Reservation reservation) {
        getReservations().remove(reservation);
        reservation.setCourier(null);
    }


}

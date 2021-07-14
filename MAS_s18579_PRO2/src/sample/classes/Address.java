package sample.classes;

import org.hibernate.annotations.GenericGenerator;
import sample.classes.shared.Shared;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/** Klasa Adres */
@Entity(name = Shared.ADDRESS)
public class Address {
    /** Atrybuty klasy Adres */
    private long id;                            /** Atrybut id */
    private String street;                      /** Atrybut ulica */
    private int houseNumber;                    /** Atrybut numerDomu */
    private int apartamentNumber;               /** Atrybut numerMieszkania */
    private String town;                        /** Atrybut miejscowosc */

    /** Atrybuty asocjacji klasy Adres */
    private List<Client> clients = new ArrayList<>();

    /** Konstruktory klasy Adres */
    public Address() {
    }
    public Address(String street, int houseNumber, int apartamentNumber, String town) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartamentNumber = apartamentNumber;
        this.town = town;
    }

    /** Gettery i Settery klasy Adres */
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Basic
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    public int getHouseNumber() {
        return houseNumber;
    }
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Basic
    public int getApartamentNumber() {
        return apartamentNumber;
    }
    public void setApartamentNumber(int apartamentNumber) {
        this.apartamentNumber = apartamentNumber;
    }

    @Basic
    public String getTown() {
        return town;
    }
    public void setTown(String town) {
        this.town = town;
    }

    @ManyToMany
    public List<Client> getClients() {
        return clients;
    }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    public void addClient(Client client){
        getClients().add(client);
    }

    /** Metody klasy Adres */
    // ---- BRAK METOD ----
}

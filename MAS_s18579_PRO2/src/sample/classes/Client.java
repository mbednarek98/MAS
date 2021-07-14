package sample.classes;

import org.hibernate.annotations.GenericGenerator;
import sample.classes.shared.Shared;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Klasa Klient */
@Entity(name = Shared.CLIENT)
public class Client {
    /** Atrybuty klasy Klient */
    private long id;                    /** Atrybut id */
    private String email;               /** Atrybut email */

    /** Atrybuty asocjacji klasy Klient */
    private Person person;
    private List<Address> addresses = new ArrayList<>();
    private List<Treatment> treatments = new ArrayList<>();

    /** Konstruktory klasy Klient */
    public Client(){}
    public Client(String email) {
        this.email = email;
    }

    /** Gettery i Settery klasy Klient */
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @OneToOne
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    @ManyToMany(mappedBy = Shared.CLIENTSMALLS, cascade = CascadeType.ALL)
    public List<Address> getAddresses() {
        return addresses;
    }
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    public void addAddress(Address address) {
        this.addresses.add(address);
        address.addClient(this);
    }

    @OneToMany(mappedBy = Shared.CLIENTSMALL, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Treatment> getTreatments() {
        return treatments;
    }
    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
    public void addTreatment(Treatment treatment) {
        getTreatments().add(treatment);
        treatment.setClient(this);
    }
    public void removeActor(Treatment treatment) {
        getTreatments().remove(treatment);
        treatment.setClient(null);
    }
    /** Metody klasy Klient */

    /** stworzNowyZabieg() ----> stworz nowy zabieg
     *
     * */
    private void createNewTreatmet(){}

    /** zapiszZwierzeNaZabieg(zwierze) ----> dodaj zwierze do zabiegu
     *
     * @param animal (zwierze)
     * */
    private void addAnimalToTreatment(Animal animal){}

    /** zaplac() ----> zaplac
     *
     * */
    private void pay(){}

    /** wybierzTermin(data) ----> wybierz termin
     *
     * @param date (data)
     * */
    private void chooseData(LocalDate date){}

}

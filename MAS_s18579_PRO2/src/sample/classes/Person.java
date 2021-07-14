package sample.classes;

import org.hibernate.annotations.GenericGenerator;
import sample.classes.shared.Shared;

import javax.persistence.*;

/** Klasa Osoba */
@Entity(name = Shared.PERSON)
public class Person {
    /** Atrybuty klasy Osoba */
    private long id;                            /** Atrybut id */
    private String firstName;                   /** Atrybut imie */
    private String lastName;                    /** Atrybut nazwisko */
    private String phoneNumber;                 /** Atrybut telefon */

    /** Atrybuty asocjacji klasy Osoba */
    private Client client;
    private Vet vet;
    private VetNurse vetNurse;

    /** Konstruktory klasy Osoba */
    public Person() {
    }
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    /** Gettery i Settery klasy Osoba */
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
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToOne(mappedBy = Shared.PERSONSMALL, cascade = CascadeType.ALL, orphanRemoval = true)
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public void addClient(Client client) {
        setClient(client);
        client.setPerson(this);
    }

    @OneToOne(mappedBy = Shared.PERSONSMALL, cascade = CascadeType.ALL, orphanRemoval = true)
    public Vet getVet() {
        return vet;
    }
    public void setVet(Vet vet) {
        this.vet = vet;
    }
    public void addVet(Vet vet) {
        setVet(vet);
        vet.setPerson(this);
    }

    @OneToOne(mappedBy = Shared.PERSONSMALL, cascade = CascadeType.ALL, orphanRemoval = true)
    public VetNurse getVetNurse() {
        return vetNurse;
    }
    public void setVetNurse(VetNurse vetNurse) {
        this.vetNurse = vetNurse;
    }
    public void addVetNurse(VetNurse vetNurse){
        setVetNurse(vetNurse);
        vetNurse.setPerson(this);
    }
    /** Metody klasy Osoba */
    // ---- BRAK METOD ----
}

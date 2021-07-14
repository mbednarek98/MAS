package sample.classes;

import org.hibernate.annotations.GenericGenerator;
import sample.classes.enums.State;
import sample.classes.shared.Shared;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** Klasa Zabieg */
@Entity(name = Shared.TREATMENT)
public class Treatment {
    /** Atrybuty klasy Zabieg */
    private long id;                        /** Atrybut id */
    private LocalDate date;                 /** Atrybut dataZabiegu */
    private String type;                    /** Atrybut rodzajZabiegu */
    private boolean underNarcosis;          /** Atrybut podNarkoza */
    private State state;                    /** Atrybut stanZabiegu */

    /** Atrybuty asocjacji klasy Zabieg */
    private List<Vet> vets = new ArrayList<>();
    private Client client;
    private Animal animal;
    private Payment payment;
    private List<Medicine> medicines = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private List<Allocation> allocations = new ArrayList<>();

    /** Konstruktory klasy Zabieg */
    public Treatment() {
    }
    public Treatment(LocalDate date, String type, boolean underNarcosis, State state) {
        this.date = date;
        this.type = type;
        this.underNarcosis = underNarcosis;
        this.state = state;
    }

    /** Gettery i Settery klasy Zabieg */
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
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Basic
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Basic
    public boolean isUnderNarcosis() {
        return underNarcosis;
    }
    public void setUnderNarcosis(boolean underNarcosis) {
        this.underNarcosis = underNarcosis;
    }

    @Enumerated
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }

    @ManyToMany(mappedBy = Shared.TREATMENTSMALLS, cascade = CascadeType.ALL)
    public List<Vet> getVets() {
        return vets;
    }
    public void setVets(List<Vet> vets) {
        this.vets = vets;
    }
    public void addVet(Vet vet) {
        this.vets.add(vet);
        vet.addTreatment(this);
    }

    @ManyToMany(mappedBy = Shared.TREATMENTSMALLS, cascade = CascadeType.ALL)
    public List<Room> getRooms() {
        return rooms;
    }
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
    public void addRoom(Room room) {
        this.rooms.add(room);
        room.addTreatment(this);
    }

    @OneToMany(mappedBy = Shared.TREATMENTSMALL, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Allocation> getAllocations() {
        return allocations;
    }
    public void setAllocations(List<Allocation> allocations) {
        this.allocations = allocations;
    }
    public void addAllocation(Allocation allocation) {
        getAllocations().add(allocation);
        allocation.setTreatment(this);
    }
    public void removeReservation(Allocation allocation) {
        getAllocations().remove(allocation);
        allocation.setTreatment(null);
    }

    @ManyToOne
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne
    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @OneToOne(mappedBy = Shared.TREATMENTSMALL, cascade = CascadeType.ALL)
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    public void addPayment(Payment payment){
        setPayment(payment);
        payment.setTreatment(this);
    }

    @ManyToMany(mappedBy = Shared.TREATMENTSMALLS, cascade = CascadeType.ALL)
    public List<Medicine> getMedicines() {
        return medicines;
    }
    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
    public void addMedicine(Medicine medicine) {
        this.medicines.add(medicine);
        medicine.getTreatments().add(this);
    }
    /** Metody klasy Zabieg */

    /** __pokazZabiegi(dataZabiegu)__ ----> wyciagnij z bazy danych wszystkie zabiegi oraz pokaz liste zabiegow danej daty
     *
     * @param date (dataZabiegu)
     * @return (Treatment) lista zabiegow danej daty
     * */
    private static List<Treatment> showTreatments(LocalDate date){
        return Collections.emptyList();
    }

    /** wprowadzDaneKlienta(klient) ----> wprowadz Klienta do bazy i polacz z zabiegiem
     *
     * @param client (klient)
     * */
    private void enterCustomerData(Client client){

    }

    /** wprowadzDaneZwierzecia(zwierze) ----> wprowadz Zwierze do bazy i polacz z zabiegiem
     *
     * @param animal (zwierze)
     * */
    private void enterAnimalData(Animal animal){

    }

    /** stworzNowaTransakcje() ----> wprowadz nowa platnosc i polacz z zabiegiem
     *
     * */
    private void createNewPayment(){

    }

    /** wyswietlMozliweDaty(data) ----> wyswietl mozliwe daty
     *
     * @param date (data)
     * */
    private void showAllData(LocalDate date){

    }

    /** wyswietlInformacjeOZabiegu() ----> wyswietl informacje o zabiegu
     *
     * */
    private void showInfoTreatment(){

    }

    /** wybierzPlatnosc() ----> wybierz platnosc
     *
     * */
    private void choosePayment(){

    }
}

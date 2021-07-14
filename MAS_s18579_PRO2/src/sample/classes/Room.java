package sample.classes;

import org.hibernate.annotations.GenericGenerator;
import sample.classes.shared.Shared;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/** Klasa Sala */
@Entity(name = Shared.ROOM)
public class Room {
    /** Atrybuty klasy Sala */
    private long id;                            /** Atrybut id */
    private int number;                         /** Atrybut numer */
    private String type;                        /** Atrybut typ */
    private List<String> equipment;             /** Atrybut sprzet */

    /** Atrybuty asocjacji klasy Sala */
    private List<Treatment> treatments = new ArrayList<>();

    /** Konstruktory klasy Sala */
    public Room() {
    }
    public Room(int number, String type, List<String> equipment) {
        this.number = number;
        this.type = type;
        this.equipment = equipment;
    }

    /** Gettery i Settery klasy Sala */
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
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @ElementCollection
    public List<String> getEquipment() {
        return equipment;
    }
    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }

    @ManyToMany
    public List<Treatment> getTreatments() {
        return treatments;
    }
    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
    public void addTreatment(Treatment treatment) {
        getTreatments().add(treatment);
    }
    /** Metody klasy Sala */

    /** dodajSprzet(sprzet) ----> dodaj do list sprzet sprzet
     *
     * @param equipment (sprzet)
     * */
    private void addEquipment(String equipment){
        this.equipment.add(equipment);
    }
}

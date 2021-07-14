package sample.classes;

import org.hibernate.annotations.GenericGenerator;
import sample.classes.shared.Shared;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/** Klasa Lek */
@Entity(name = Shared.MEDICINE)
public class Medicine {
    /** Atrybuty klasy Lek */
    private long id;                         /** Atrybut id */
    private String type;                     /** Atrybut rodzaj */
    private int dose;                        /** Atrybut dawka */
    private List<String> sideEffects;        /** Atrybut efektyUboczne */

    /** Atrybuty asocjacji klasy Lek */
    private List<Treatment> treatments = new ArrayList<>();

    /** Konstruktory klasy Lek */
    public Medicine(){}
    public Medicine(String type, int dose, List<String> sideEffects) {
        this.type = type;
        this.dose = dose;
        this.sideEffects = sideEffects;
    }

    /** Gettery i Settery klasy Lek */
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Basic
    public int getDose() {
        return dose;
    }
    public void setDose(int dose) {
        this.dose = dose;
    }

    @ElementCollection
    public List<String> getSideEffects() {
        return sideEffects;
    }
    public void setSideEffects(List<String> sideEffects) {
        this.sideEffects = sideEffects;
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

    /** Metody klasy Lek */

    /** dodajSkutkiUboczne(efekt) ----> dodaj do list skutkiUboczne skutek uboczny
     *
     * @param effect (skutek uboczny)
     * */
    private void addSideEffect(String effect){
        sideEffects.add(effect);
    }
}

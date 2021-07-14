package sample.classes;

import org.hibernate.annotations.GenericGenerator;
import sample.classes.shared.Shared;

import javax.persistence.*;
import java.util.List;

/** Klasa Choroba */
@Entity(name = Shared.SICKNESS)
public class Sickness {
    /** Atrybuty klasy Choroba */
    private long id;                            /** Atrybut id */
    private String type;                        /** Atrybut rodzaj */
    private List<String> symptoms;              /** Atrybut objawy */
    private String diagnosis;                   /** Atrybut diagnoza */

    /** Atrybuty asocjacji klasy Choroba */
    private Animal animal;

    /** Konstruktory klasy Choroba */
    public Sickness() {
    }
    public Sickness(String type, List<String> symptoms, String diagnosis) {
        this.type = type;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
    }

    /** Gettery i Settery klasy Choroba */
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

    @ElementCollection
    public List<String> getSymptoms() {
        return symptoms;
    }
    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    @Basic
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @ManyToOne
    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    /** Metody klasy Choroba */

    /** dodajObjaw(objaw) ----> dodaj do list objawy objaw
     *
     * @param sick (objaw)
     * */
    private void addSymptoms(String sick){
        this.symptoms.add(sick);
    }

}

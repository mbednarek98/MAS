package sample.classes;

import org.hibernate.annotations.GenericGenerator;
import sample.classes.enums.Type;
import sample.classes.shared.Shared;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/** Klasa Zwierze */

@Entity(name = Shared.ANIMAL)
public class Animal {
    /** Atrybuty klasy Zwierze */
    private long id;                        /** Atrybut id */
    private Type type;                      /** Atrybut typ */
    private String species;                 /** Atrybut gatunek */
    private String specialSigns;            /** Atrybut znakiSzczegolne */
    private String name;                    /** Atrybut imie */
    private List<String> allergies;         /** Atrybut alergie */

    /** Atrybuty asocjacji klasy Zwierze */
    private List<Treatment> treatments = new ArrayList<>();
    private List<Sickness> sicknesses = new ArrayList<>();

    /** Konstruktory klasy Zwierze */
    public Animal(){}
    public Animal(Type type, String species, String specialSigns, String name, List<String> allergies) {
        this.type = type;
        this.species = species;
        this.specialSigns = specialSigns;
        this.name = name;
        this.allergies = allergies;
    }

    /** Gettery i Settery klasy Zwierze */
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
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    @Basic
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }

    @Basic
    public String getSpecialSigns() {
        return specialSigns;
    }
    public void setSpecialSigns(String specialSigns) {
        this.specialSigns = specialSigns;
    }

    @Basic
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @ElementCollection
    public List<String> getAllergies() {
        return allergies;
    }
    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    @OneToMany(mappedBy = Shared.ANIMALSMALL, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Treatment> getTreatments() {
        return treatments;
    }
    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
    public void addTreatment(Treatment treatment) {
        getTreatments().add(treatment);
        treatment.setAnimal(this);
    }
    public void removeTreatment(Treatment treatment) {
        getTreatments().remove(treatment);
        treatment.setAnimal(null);
    }

    @OneToMany(mappedBy = Shared.ANIMALSMALL, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Sickness> getSicknesses() {
        return sicknesses;
    }
    public void setSicknesses(List<Sickness> sicknesses) {
        this.sicknesses = sicknesses;
    }
    public void addSickness(Sickness sickness) {
        getSicknesses().add(sickness);
        sickness.setAnimal(this);
    }
    public void removeSickness(Sickness sickness) {
        getSicknesses().remove(sickness);
        sickness.setAnimal(null);
    }


    /** Metody klasy Zwierze */
    // ---- BRAK METOD ----

}

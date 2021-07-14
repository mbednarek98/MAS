package sample.classes;

import org.hibernate.annotations.GenericGenerator;
import sample.classes.abstracts.Employee;
import sample.classes.enums.Specialization;
import sample.classes.shared.Shared;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** Klasa Weterynarz */
@Entity(name = Shared.VET)
public class Vet extends Employee {
    /** Atrybuty klasy Weterynarz */
    private long id;                                    /** Atrybut id */
    private Specialization specialization;              /** Atrybut specjalizacja */
    private String qualification;                       /** Atrybut kwalifikacja */

    /** Atrybuty asocjacji klasy Weterynarz */
    private List<Treatment> treatments = new ArrayList<>();

    /** Konstruktory klasy Weterynarz */
    public Vet() {
    }
    public Vet(String pesel, Double revenue, Specialization specialization, String qualification) {
        super(pesel, revenue);
        calculateIncome();
        this.specialization = specialization;
        this.qualification = qualification;
    }

    /** Gettery i Settery klasy Weterynarza */
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
    public String getPesel() {
        return pesel;
    }
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Basic
    public Double getRevenue() {
        return revenue;
    }
    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    @Transient
    public Double getIncome() {
        return income;
    }
    public void setIncome(Double income) {
        this.income = income;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    @Enumerated
    public Specialization getSpecialization() {
        return specialization;
    }
    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @Basic
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
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
/** Metody klasy Weterynarz */

    /** pokazWeterynarzy(specjalizacja) ----> wyciagnij z bazy danych wszystkiech weterynarzy i pokaz tych co maja dana specjalizacje
     *
     * @param specialization (specjalizacja)
     * @return (Vet) lista weterynarzy
     * */
    private static List<Vet> showVet(Specialization specialization){ return Collections.emptyList();}

    /** pokazWeterynarzy(specjalizacja) ----> wyciagnij z bazy danych wszystkiech weterynarzy i pokaz ich
     *
     * @return (Vet) lista weterynarzy
     * */
    private static List<Vet> showVet(){ return Collections.emptyList();}

    /** wyliczDochod() ----> wylicza przychod pracownika
     *
     * @return przychodu pracownika (Double)
     */
    @Override
    public Double calculateIncome() {
        this.income = revenue - (revenue*taxVAT);
        return this.income;
    }
}

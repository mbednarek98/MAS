package sample.classes;

import org.hibernate.annotations.GenericGenerator;
import sample.classes.abstracts.Employee;
import sample.classes.shared.Shared;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/** Klasa Pielegniarka */
@Entity(name = Shared.VETNURSE)
public class VetNurse extends Employee {
    /** Atrybuty klasy Pielegniarka */
    private long id;                    /** Atrybut id */
    private int internship;             /** Atrybut staz */
    private int hoursWorked;            /** Atrybut godzinyWypracowane */
    private double bonus;               /** Atrybut bonus */

    /** Atrybuty asocjacji klasy Pielegniarka */
    private List<Allocation> allocations = new ArrayList<>();

    /** Konstruktory klasy Pielegniarka */
    public VetNurse() {
    }
    public VetNurse(String pesel, Double revenue, int internship, int hoursWorked) {
        super(pesel, revenue);
        calculateIncome();
        this.internship = internship;
        this.hoursWorked = hoursWorked;
        this.bonus = calculateBonus();
    }


    /** Gettery i Settery klasy Pielegniarka */
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

    @Basic
    public int getInternship() {
        return internship;
    }
    public void setInternship(int internship) {
        this.internship = internship;
    }

    @Basic
    public int getHoursWorked() {
        return hoursWorked;
    }
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Transient
    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @OneToMany(mappedBy = Shared.VETNURSESMALL, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Allocation> getAllocations() {
        return allocations;
    }
    public void setAllocations(List<Allocation> allocations) {
        this.allocations = allocations;
    }
    public void addAllocation(Allocation allocation) {
        getAllocations().add(allocation);
        allocation.setVetNurse(this);
    }
    public void removeReservation(Allocation allocation) {
        getAllocations().remove(allocation);
        allocation.setVetNurse(null);
    }

    /** Metody klasy Pielegniarka */

    /** wyliczBonus() ----> wylicza przychod pracownika
     *
     * @return bonus (Double)
     */
    private double calculateBonus(){
        return hoursWorked * 3;
    }


    /** wyliczDochod() ----> wylicza przychod pracownika
     *
     * @return przychodu pracownika (Double)
     */
    @Override
    public Double calculateIncome() {
        this.income = revenue - (revenue*taxVAT) + bonus;
        return this.income;
    }


}

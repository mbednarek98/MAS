package sample.classes;

import org.hibernate.annotations.GenericGenerator;
import sample.classes.enums.Status;
import sample.classes.shared.Shared;

import javax.persistence.*;
import java.time.LocalDate;

/** Klasa Platnosc */
@Entity(name = Shared.PAYMENT)
public class Payment {
    /** Atrybuty klasy Platnosc */
    private long id;                    /** Atrybut id */
    private String type;                /** Atrybut rodzaj */
    private Status status;              /** Atrybut status */
    private LocalDate date;             /** Atrybut data */

    /** Atrybuty asocjacji klasy Platnosc */
    private Treatment treatment;

    /** Konstruktory klasy Platnosc */
    public Payment() { }
    public Payment(String type, Status status, LocalDate date) {
        this.type = type;
        this.status = status;
        this.date = date;
    }

    /** Gettery i Settery klasy Platnosc */
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

    @Enumerated
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    @Basic
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @ManyToOne
    public Treatment getTreatment() {
        return treatment;
    }
    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }
    /** Metody klasy Platnosc */

    /** zmienStatus(status) ----> zmien status
     *
     * @param status (status)
     * */
    private void changeStatus(Status status){
        this.status = status;
    }
}

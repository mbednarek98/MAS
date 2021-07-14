package sample.classes;

import org.hibernate.annotations.GenericGenerator;
import sample.classes.shared.Shared;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/** Klasa Przydzial */
@Entity(name = Shared.ALLOCATION)
public class Allocation {
    /** Atrybuty klasy Przydzial */
    private long id;                        /** Atrybut id */
    private LocalDateTime hourFrom;         /** Atrybut godzinaOd */
    private LocalDateTime hourTo;           /** Atrybut godzinaDo */
    private LocalDate date;                 /** Atrybut data */

    /** Atrybuty asocjacji klasy Przydzial */
    private VetNurse vetnurse;
    private Treatment treatment;

    /** Konstruktory klasy Przydzial */
    public Allocation(){}
    public Allocation(LocalDateTime hourFrom, LocalDateTime hourTo, LocalDate date) {
        this.hourFrom = hourFrom;
        this.hourTo = hourTo;
        this.date = date;
    }

    /** Gettery i Settery klasy Przydzial */
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
    public LocalDateTime getHourFrom() {
        return hourFrom;
    }
    public void setHourFrom(LocalDateTime hourFrom) {
        this.hourFrom = hourFrom;
    }

    @Basic
    public LocalDateTime getHourTo() {
        return hourTo;
    }
    public void setHourTo(LocalDateTime hourTo) {
        this.hourTo = hourTo;
    }

    @Basic
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @ManyToOne
    public VetNurse getVetNurse() {
        return vetnurse;
    }
    public void setVetNurse(VetNurse vetnurse) {
        this.vetnurse = vetnurse;
    }

    @ManyToOne
    public Treatment getTreatment() {
        return treatment;
    }
    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }
/** Metody klasy Przydzial */

    /** wyliczCzas() ----> wylicz ilosc godzin miedzy {@link #hourFrom} a {@link #hourTo}
     *
     * @return (Long) ilosc godzin
     * */
    private long calculateTime(){
        return Duration.between(hourFrom, hourTo).toHours();
    }

}

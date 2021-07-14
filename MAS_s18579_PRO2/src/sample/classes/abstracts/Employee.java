package sample.classes.abstracts;

import sample.classes.Person;

import java.util.List;

/** Klasa Pracownik */

public abstract class Employee {
    /** Atrybuty klasy Pracownik */
    public String pesel;                          /** Atrybut PESEL */
    public final static double taxVAT = 0.23;     /** Atrybut podatekVAT */
    public Double revenue;                        /** Atrybut przychod */
    public Double income;                         /** Atrybut dochod */

    /** Atrybuty asocjacji klasy Pracownik */
    public Person person;

    /** Konstruktory klasy Pracownik */
    public Employee() {
    }
    public Employee(String pesel, Double revenue) {
        this.pesel = pesel;
        this.revenue = revenue;
    }


    /** Metody klasy Pracownik */

    /** __wyliczSredniaDochodu()__ ----> pobiera wszystkich pracownikow i wylicza srednia przychodu
     *
     *
     * @return srednia przychodu pracownika (Double)
     */
    public static Double calculateAvgIncome(){
        //TODO: Wyciagnac z bazy danych wszystkie dane i wyliczyc z nich
        return 0.0;
    }

    /** wyliczDochod(){abstract} ----> wylicza przychod pracownika
     *
     * @return przychodu pracownika (Double)
     */
    public abstract Double calculateIncome();
}

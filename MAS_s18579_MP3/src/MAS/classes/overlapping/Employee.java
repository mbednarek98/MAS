package MAS.classes.overlapping;

import MAS.object.ObjectPlusPlus;

import java.util.List;

public class Employee extends ObjectPlusPlus {
    private String pesel;                       // PESEL {unique}           -- ograniczenie {unique} --
    private float salaryNetto;                  // wynagrodzenieNetto
    private float salaryBrutto;                 // wynagrodzenieBrutto
    private static float VAT = 0.23f;           // _VAT_                    -- atrybut klasowy --

    public Employee(String pesel, float salaryNetto) {
        super();
        this.pesel = pesel;
        this.salaryNetto = salaryNetto;
        this.salaryBrutto = getGrossSalary();
    }


    // --Gettery --


    public String getPesel() { return pesel; }

    public float getSalaryNetto() { return salaryNetto; }

    public float getSalaryBrutto() { return salaryBrutto; }

    public static float getVAT() { return VAT; }

    // -- Settery --


    public void setPesel(String pesel) {this.pesel = pesel; }

    public void setSalaryNetto(float salaryNetto) { this.salaryNetto = salaryNetto; }

    public static void setVAT(float VAT) { Employee.VAT = VAT; }

    // -- Metody klasy --
    /**
     * zdobadzWynagrodzenieBrutto()     -- Metoda atrybuty pochodnego --
     *
     * @return (float) wynagrodzenie po odjeciu podatku VAT
     * TODO: metoda klasy abstrakcyjnej Pracownik
     */
    public float getGrossSalary(){ return salaryNetto - (salaryNetto*VAT); }

    /**
     * toString()               -- Przeslonienie metody --
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return  super.toString()+"Klasa Pracownik:\t" + super.toString() + "\n"+
                "-> PESEL:\t" + pesel + ",\n"+
                "-> Wynagrodzenie netto:\t" + salaryNetto + " zl,\n"+
                "-> Wynagrodzenie brutto:\t" + salaryBrutto + " zl,\n";
    }
    // -----------------
}

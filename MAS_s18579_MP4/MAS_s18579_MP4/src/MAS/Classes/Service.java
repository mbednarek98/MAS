package MAS.Classes;

import MAS.Classes.Enum.Condition;
import MAS.Object.ObjectPlus4;

import java.time.LocalDate;
import java.util.Arrays;

public class Service extends ObjectPlus4 {
    // -- Atrybuty --
    private LocalDate dateOfService;    // -- Data serwisu --
    private Condition condition;        // -- Stan --
    // -- Konstruktory --
    public Service(LocalDate dateOfService, Condition condition) {
        this.dateOfService = dateOfService;
        this.condition = condition;
    }
    // -- Gettery i Settery --
    public LocalDate getDateOfService() {
        return dateOfService;
    }
    public void setDateOfService(LocalDate dateOfService) {
        this.dateOfService = dateOfService;
    }
    public Condition getCondition() {
        return condition;
    }
    public void setCondition(Condition condition) {
        this.condition = condition;
    }
    // -- Metody --
    public void linkSubset(ServiceTechnician serviceTechnician) throws Exception {
        this.addLink("service","servicetechnician",serviceTechnician);
        this.addLink_subset("manage_service","services","service", serviceTechnician);
    }
    public void showLinkSubset() throws Exception {
        this.showLinks("services", System.out);
        this.showLinks("servicetechnician", System.out);
    }
    public void showManager() throws Exception {
        System.out.println("Manadzer serwisu w dniu " +dateOfService+":\n"+ Arrays.toString(this.getLinks("manage_service")));
    }
    public void showWorkers() throws Exception {
        System.out.println("Pracownicy serwisu w dniu " +dateOfService+":\n"+ Arrays.toString(this.getLinks("service")));
    }
    /**
     * toString() --- Przeslonienie metody
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return "Klasa Service" + super.toString() +
                "-> Data serwisu:" + dateOfService + ",\n"+
                "-> Stan:" + condition;
    }
}

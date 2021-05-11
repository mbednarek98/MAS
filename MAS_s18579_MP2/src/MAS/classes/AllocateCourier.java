package MAS.classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AllocateCourier implements Serializable {
    // -- Atrybuty klasy --
    private static List<AllocateCourier> ext = new ArrayList<>(); // atrybut ekstensji
    private LocalDateTime allocateTime;     // godzinaPrzydzialu
    // -----------------

    // -- Konstruktory --
        public AllocateCourier(LocalDateTime allocateTime){
            this.allocateTime = allocateTime;
            addAllocateCourier(this);
        }
    // -----------------

    // -- Extensja --
    public static List<AllocateCourier> getExtent() {
        return ext;
    }
    private static void addAllocateCourier(AllocateCourier allocateCourier) { ext.add(allocateCourier); }
    private static void removeAllocateCourier(AllocateCourier allocateCourier) {
        ext.remove(allocateCourier);
    }
    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException { ext = (ArrayList<AllocateCourier>) stream.readObject(); }
    public static void writeExtent(ObjectOutputStream stream) throws IOException { stream.writeObject(ext); }
    public static void showExtent(){
        System.out.println("Extent klasy: " + AllocateCourier.class.getName());
        for(AllocateCourier allocateCourier : ext) System.out.println(allocateCourier);
    }
    // -----------------

    // -- Gettery --

    public LocalDateTime getAllocateTime() {
        return allocateTime;
    }

    // -----------------

    // -- Settery

    public void setAllocateTime(LocalDateTime allocateTime) {
        this.allocateTime = allocateTime;
    }

    // -----------------

    // -- Metody klasy --
    /**
     * toString() -- Przeslonienie metody --
     *
     * @return (string) wszystkie atrybuty obiektu w stringu
     */
    @Override
    public String toString() {
        return "Klasa Przydzial: " + super.toString() + "\n"+
                "-> Godzina przydzialu:\t" + allocateTime +",\n";
    }
    // -----------------
}

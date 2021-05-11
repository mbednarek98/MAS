package MAS.classes.multiple.aspect;

import MAS.classes.multiple.Device;

public class VR extends Device {
    // -- Atrybuty klasy --
    private String typeOfLens;
    // -- Konstuktor --

    public VR(double price, int batteryLifespan, String typeOfLens) {
        super(price, batteryLifespan);
        this.typeOfLens = typeOfLens;
    }

    public VR(double price, double wireSize, String wirePlug, String typeOfLens) {
        super(price, wireSize, wirePlug);
        this.typeOfLens = typeOfLens;
    }

    // -- Gettery --

    public String getTypeOfLens() {
        return typeOfLens;
    }

    // -- Settery --

    public void setTypeOfLens(String typeOfLens) {
        this.typeOfLens = typeOfLens;
    }

    // -- Metody --

    @Override
    public String toString() {
        return super.toString()+"Klasa VR\n" +
                "Typ soczewki: " + typeOfLens + "\n";
    }
}

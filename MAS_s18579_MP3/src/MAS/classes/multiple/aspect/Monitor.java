package MAS.classes.multiple.aspect;

import MAS.classes.multiple.Device;

public class Monitor extends Device {
    // -- Atrybuty klasy --
    private String displayType;
    private String resolution;
    // -- Konstuktor --

    public Monitor(double price, int batteryLifespan, String displayType, String resolution) {
        super(price, batteryLifespan);
        this.displayType = displayType;
        this.resolution = resolution;
    }

    public Monitor(double price, double wireSize, String wirePlug, String displayType, String resolution) {
        super(price, wireSize, wirePlug);
        this.displayType = displayType;
        this.resolution = resolution;
    }

    // -- Gettery --

    public String getDisplayType() {
        return displayType;
    }

    public String getResolution() {
        return resolution;
    }


    // -- Settery --

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    // -- Metody --

    @Override
    public String toString() {
        return super.toString()+"Klasa Monitor\n" +
                "Typ wyswietlacza: " + displayType + ",\n" +
                "Rozdzielczosc: " + resolution + ",\n";
    }
}

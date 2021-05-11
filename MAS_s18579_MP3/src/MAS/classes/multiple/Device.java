package MAS.classes.multiple;

public abstract class Device {
    // -- Atrybuty klasy --
    private double price;
    private String typeOfConnection;
    private int batteryLifespan;
    private double wireSize;
    private String wirePlug;
    // -- Konstuktor --

    public Device(double price, int batteryLifespan) {
        this.price = price;
        this.typeOfConnection = "battery";
        this.batteryLifespan = batteryLifespan;
    }

    public Device(double price, double wireSize, String wirePlug) {
        this.price = price;
        this.typeOfConnection = "cable";
        this.wireSize = wireSize;
        this.wirePlug = wirePlug;
    }
    // -- Gettery --

    public double getPrice() {
        return price;
    }

    public String getTypeOfConnection() {
        return typeOfConnection;
    }

    public int getBatteryLifespan() {
        if(typeOfConnection.equals("battery")) return batteryLifespan;
        return Integer.parseInt(null);
    }

    public Double getWireSize() {
        if(typeOfConnection.equals("cable")) return wireSize;
        return null;
    }

    public String getWirePlug() {
        if(typeOfConnection.equals("cable")) return wirePlug;
        return "BRAK <- typ polaczenia batteria";
    }

    // -- Settery --

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTypeOfConnection(String typeOfConnection, String wirePlug, double wireSize) {
        this.typeOfConnection = typeOfConnection;
        this.wirePlug = wirePlug;
        this.wireSize = wireSize;
    }

    public void setTypeOfConnection(String typeOfConnection, int batteryLifespan) {
        this.typeOfConnection = typeOfConnection;
        this.batteryLifespan = batteryLifespan;
    }

    public void setBatteryLifespan(int batteryLifespan) {
        this.batteryLifespan = batteryLifespan;
    }

    public void setWireSize(double wireSize) {
        this.wireSize = wireSize;
    }

    public void setWirePlug(String wirePlug) {
        this.wirePlug = wirePlug;
    }

    // -- Metody --


    @Override
    public String toString() {
        String info = "Klasa Urzadzenie:\n" +
                "Cena:" + price + ",\n" +
                "Typ polaczenia: " + typeOfConnection + ",\n";
        if(typeOfConnection.equals("battery")) info += "Czas zycia baterii: " + batteryLifespan + "\n";
        else info += "Rozmiar przewodu:" + wireSize + "\n"+
                "Wyczka: " + wirePlug + "\n";
       return info;
    }
}

package MAS.classes.multiple.aspect;

import MAS.classes.multiple.Device;

public class Computer extends Device {
    // -- Atrybuty klasy --
    private String gpu;
    private String cpu;
    private String motherboard;
    private String ram;
    // -- Konstuktor --

    public Computer(double price, int batteryLifespan, String gpu, String cpu, String motherboard, String ram) {
        super(price, batteryLifespan);
        this.gpu = gpu;
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.ram = ram;
    }

    public Computer(double price, double wireSize, String wirePlug, String gpu, String cpu, String motherboard, String ram) {
        super(price, wireSize, wirePlug);
        this.gpu = gpu;
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.ram = ram;
    }


    // -- Gettery --

    public String getGpu() {
        return gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public String getRam() {
        return ram;
    }


    // -- Settery --

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }


    // -- Metody --


    @Override
    public String toString() {
        return super.toString()+ "Klasa Komputer\n" +
                "GPU: " + gpu + ",\n" +
                "CPU: " + cpu + ",\n" +
                "Plyta glowna: " + motherboard + ",\n" +
                "RAM: " + ram + ",\n";
    }
}

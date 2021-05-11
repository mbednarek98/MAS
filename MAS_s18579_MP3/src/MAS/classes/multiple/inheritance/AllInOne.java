package MAS.classes.multiple.inheritance;

import MAS.classes.multiple.aspect.Monitor;

public class AllInOne extends Monitor implements IComputer{
    // -- Atrybuty klasy --
    private String gpu;
    private String cpu;
    private String motherboard;
    private String ram;
    private String typeOfSeal;
    private double weight;
    // -- Konstuktor --

    public AllInOne(double price, int batteryLifespan, String displayType, String resolution, String gpu, String cpu, String motherboard, String ram, String typeOfSeal, double weight) {
        super(price, batteryLifespan, displayType, resolution);
        this.gpu = gpu;
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.ram = ram;
        this.typeOfSeal = typeOfSeal;
        this.weight = weight;
    }

    public AllInOne(double price, double wireSize, String wirePlug, String displayType, String resolution, String gpu, String cpu, String motherboard, String ram, String typeOfSeal, double weight) {
        super(price, wireSize, wirePlug, displayType, resolution);
        this.gpu = gpu;
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.ram = ram;
        this.typeOfSeal = typeOfSeal;
        this.weight = weight;
    }


    // -- Gettery --

    @Override
    public String getGpu() {
        return gpu;
    }

    @Override
    public String getCpu() {
        return cpu;
    }

    @Override
    public String getMotherboard() {
        return motherboard;
    }

    @Override
    public String getRam() {
        return ram;
    }


    // -- Settery --

    @Override
    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    @Override
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    @Override
    public void setRam(String ram) {
        this.ram = ram;
    }

    // -- Metody --
}

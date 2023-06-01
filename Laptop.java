package homework6;

public class Laptop {
    private String model;
    private int amountRAM;
    private int hardDiskCapacity;
    private String operatingSystem;
    private String color;

    // Конструктор класса
    public Laptop(String model, int amountRAM, int hardDiskCapacity, String operatingSystem, String color) {
        this.model = model;
        this.amountRAM = amountRAM;
        this.hardDiskCapacity = hardDiskCapacity;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    // Геттеры для доступа к полям

    public String getModel() {
        return model;
    }

    public int getAmountRAM() {
        return amountRAM;
    }

    public int getHardDiskCapacity() {
        return hardDiskCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }
}

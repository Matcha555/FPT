package DTO;

public class Smartphone extends Products {

    String Ram;
    String CPU;
    float size;

    public Smartphone(String code, String name, String brand, double price,
            int quantity, String Ram, String CPU, float size) {
        super(code, name, brand, price, quantity);
        this.Ram = Ram;
        this.CPU = CPU;
        this.size = size;
    }

    public String getRam() {
        return Ram;
    }

    public void setRam(String Ram) {
        this.Ram = Ram;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public float getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return code + " - " + name + " - " + price;
    }
}

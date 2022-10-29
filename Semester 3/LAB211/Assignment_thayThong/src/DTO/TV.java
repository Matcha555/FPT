package DTO;

public class TV extends Products {

    float size;

    public TV(String code, String name, String brand, double price, int quantity, float size) {
        super(code, name, brand, price, quantity);
        this.size = size;
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

package DTO;

public class AirConditioner extends Products {

    float power;

    public AirConditioner(String code, String name, String brand,
            double price, int quantity, float power) {
        super(code, name, brand, price, quantity);
        this.power = power;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return code + " - " + name + " - " + price;
    }
}

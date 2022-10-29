package DTO;

public class Products {

    String code;
    String name;
    String brand;
    double price;
    int quantity;

    public Products() {
    }

    public Products(String code, String name, String brand, double price, int quantity) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.price = price >= 0 ? price : 0;
        this.quantity = quantity >= 0 ? quantity : 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return code + " - " + name + " - " + price;
    }

}

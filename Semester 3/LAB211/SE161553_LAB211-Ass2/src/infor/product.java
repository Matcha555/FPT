package infor;

public class product implements Comparable<product> {

    public static final String ID_FORMAT = "D\\d{3}";
    public static final char SEPARATOR = ',';

    String ID;
    String name;
    double UnitPrice;
    int quantity;
    String status;

    public product(String ID, String name, double UnitPrice, int quantity, String status) {
        this.ID = ID;
        this.name = name;
        this.UnitPrice = UnitPrice;
        this.quantity = quantity;
        this.status = status;
    }

    public product(String line) {
        String[] parts = line.split("" + this.SEPARATOR);
        ID = parts[0].trim();
        name = parts[1].trim();
        UnitPrice = Double.parseDouble(parts[2].trim());
        quantity = Integer.parseInt(parts[3].trim());
        status = parts[4].trim();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ID + " , " + name + " , " + UnitPrice + " , " + quantity + " , " + status + "\n";
    }

    @Override
    public int compareTo(product t) {
        return ID.indexOf(((product) t).ID);

    }

}

package DTO;

import MyUtils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductsList extends ArrayList<Products> {

    public Products search(String codeString) {
        for (Products products : this) {
            if (codeString.equalsIgnoreCase(products.getCode())) {
                return products;
            }
        }
        return null;
    }

    public void addSmartphone() {
        String code;
        String name;
        String brand;
        String Ram;
        String CPU;
        float size;
        double price;
        int quantity;

        System.out.println("");
        code = Utils.getStringPattern("Enter code <SMxxx>: ", "^SM\\d{3}$", this);
        name = Utils.getString("Enter name: ");
        brand = Utils.getString("Enter brand: ");
        Ram = Utils.getString("Enter Ram: ");
        CPU = Utils.getString("Enter CPU: ");
        size = Utils.getFloat("Enter size (inch): ");
        price = Utils.getFloat("Enter price: ");
        quantity = Utils.getInt("Enter quantity: ");

        this.add(new Smartphone(code, name, brand, price, quantity, Ram, CPU, size));
        System.out.println("\nADD SUCCESSFULLY!");
    }

    public void addTV() {
        String code;
        String name;
        String brand;
        float size;
        double price;
        int quantity;

        System.out.println("");
        code = Utils.getStringPattern("Enter code <TIxxx>: ", "^TI\\d{3}$", this);
        name = Utils.getString("Enter name: ");
        brand = Utils.getString("Enter brand: ");
        size = Utils.getFloat("Enter size (inch): ");
        price = Utils.getFloat("Enter price: ");
        quantity = Utils.getInt("Enter quantity: ");

        this.add(new TV(code, name, brand, price, quantity, size));
        System.out.println("\nADD SUCCESSFULLY!");
    }

    public void addAirConditioner() {
        String code;
        String name;
        String brand;
        float power;
        double price;
        int quantity;

        System.out.println("");
        code = Utils.getStringPattern("Enter code <AIRxxx>: ", "^AIR\\d{3}$", this);
        name = Utils.getString("Enter name: ");
        brand = Utils.getString("Enter brand: ");
        power = Utils.getFloat("Enter power: ");
        price = Utils.getFloat("Enter price: ");
        quantity = Utils.getInt("Enter quantity: ");

        this.add(new AirConditioner(code, name, brand, price, quantity, power));
        System.out.println("\nADD SUCCESSFULLY!");
    }

    public void printAll() {
        if (this == null || this.isEmpty()) {
            System.out.println("\nEMPTY LIST! Total: 0\n");
        } else {
            System.out.println("\n================== LIST OF PRODUCTS ===================");

            for (Products list : this) {
                System.out.println(list.toString());
            }

            System.out.println("Total: " + this.size() + "\n");
        }
    }

    public void printDescPriceListSM() {
        ArrayList<Smartphone> sortList = new ArrayList<>();

        for (Products list : this) {
            if (list instanceof Smartphone) {
                sortList.add((Smartphone) list);
            }
        }

        Collections.sort(sortList, new Comparator<Smartphone>() {
            @Override
            public int compare(Smartphone t, Smartphone t1) {
                if (t.getPrice() < t1.getPrice()) {
                    return 1;
                }
                if (t.getPrice() == t1.getPrice()) {
                    return t.getCode().compareTo(t.getCode());
                }
                return -1;
            }
        });

        System.out.println("\n===================== LIST OF SMS =====================");
        for (Smartphone list : sortList) {
            System.out.println(list.toString());
        }

    }

    public void printAscPriceListTV() {
        ArrayList<TV> sortList = new ArrayList<>();

        for (Products list : this) {
            if (list instanceof TV) {
                sortList.add((TV) list);
            }
        }

        Collections.sort(sortList, new Comparator<TV>() {
            @Override
            public int compare(TV t, TV t1) {
                if (t.getPrice() > t1.getPrice()) {
                    return 1;
                }
                if (t.getPrice() == t1.getPrice()) {
                    return t.getCode().compareTo(t.getCode());
                }
                return -1;
            }
        });

        System.out.println("\n===================== LIST OF TVS =====================");
        for (TV list : sortList) {
            System.out.println(list.toString());
        }
    }

    public void printDescPriceListAIR() {
        ArrayList<AirConditioner> sortList = new ArrayList<>();

        for (Products list : this) {
            if (list instanceof AirConditioner) {
                sortList.add((AirConditioner) list);
            }
        }

        Collections.sort(sortList, new Comparator<AirConditioner>() {
            @Override
            public int compare(AirConditioner t, AirConditioner t1) {
                if (t.getPrice() < t1.getPrice()) {
                    return 1;
                }
                if (t.getPrice() == t1.getPrice()) {
                    return t.getCode().compareTo(t.getCode());
                }
                return -1;
            }
        });

        System.out.println("\n===================== LIST OF AIRS =====================");

        for (AirConditioner list : sortList) {
            System.out.println(list.toString());
        }
    }

    public void highestPriceProduct() {
        double max = Integer.MIN_VALUE;

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getPrice() > max) {
                max = this.get(i).getPrice();
            }
        }

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getPrice() == max) {
                System.out.println(this.get(i).toString());
            }
        }
    }

    public void updateByCode() {
        if (this == null || this.isEmpty()) {
            System.out.println("\nEMPTY LIST, NO UPDATE CAN BE PERFORMED!\n");
        }
        String code = Utils.getString("Enter product's code you want to update: ");

        Products product = this.search(code);

        if (product == null) {
            System.out.println("PRODUCT " + code + " DOES NOT EXIST!");
        } else {
            String name;
            String brand;
            String Ram;
            String CPU;
            float power;
            int size;
            double price;
            int quantity;

            if (product instanceof Smartphone) {
                name = Utils.getString("Enter name: ");
                brand = Utils.getString("Enter brand: ");
                Ram = Utils.getString("Enter Ram: ");
                CPU = Utils.getString("Enter CPU: ");
                size = Utils.getInt("Enter size (inch): ");
                price = Utils.getFloat("Enter price: ");
                quantity = Utils.getInt("Enter quantity: ");

                product.setName(name);
                product.setBrand(brand);
                product.setPrice(price);
                ((Smartphone) product).setCPU(CPU);
                ((Smartphone) product).setRam(Ram);
                ((Smartphone) product).setSize(size);
                product.setQuantity(quantity);
            } else if (product instanceof TV) {
                name = Utils.getString("Enter name: ");
                brand = Utils.getString("Enter brand: ");
                size = Utils.getInt("Enter size (inch): ");
                price = Utils.getFloat("Enter price: ");
                quantity = Utils.getInt("Enter quantity: ");

                product.setName(name);
                product.setBrand(brand);
                product.setPrice(price);
                ((TV) product).setSize(size);
                product.setQuantity(quantity);
            } else if (product instanceof AirConditioner) {
                name = Utils.getString("Enter name: ");
                brand = Utils.getString("Enter brand: ");
                power = Utils.getInt("Enter size (inch): ");
                price = Utils.getFloat("Enter price: ");
                quantity = Utils.getInt("Enter quantity: ");

                product.setName(name);
                product.setBrand(brand);
                product.setPrice(price);
                ((AirConditioner) product).setPower(power);
                product.setQuantity(quantity);
            }

            System.out.println("\nUPDATE SUCCESSFULLY!\n");
        }
    }

    public void deleteByCode() {
        if (this == null || this.isEmpty()) {
            System.out.println("\nEMPTY LIST, NO DELETE CAN BE PERFORMED!\n");
        }
        String code = Utils.getString("Enter product's code you want to remove: ");
        Products product = this.search(code);

        if (product == null) {
            System.out.println("PRODUCT'S CODE DOES NOT EXIST");
        } else {
            this.remove(product);
            System.out.println("\nREMOVE SUCCESSFULLY!\n");
        }
    }

    public void totalAmount() {
        float total = 0;
        for (int i = 0; i < this.size(); i++) {
            total += this.get(i).getPrice() * this.get(i).getQuantity();
        }
        System.out.println("\nTotal amound of all product: " + total + "\n");
    }

    public void Menu() {
        System.out.println("======================== Menu =========================");
        System.out.println("1. Add new Product");
        System.out.println("2. List of products");
        System.out.println("3. List of Smartphones in descending order of price");
        System.out.println("4. List of TVs in ascending order of price");
        System.out.println("5. List of Air-conditioner in descending order of price");
        System.out.println("6. Information of products with the highest price");
        System.out.println("7. Update product's information by code");
        System.out.println("8. Delete product by code");
        System.out.println("9. Total amount of all products");
        System.out.println("10. Exit");
    }

}

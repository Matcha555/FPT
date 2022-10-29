package infor;

import myTool.myTool;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.jar.Attributes;

public class productList extends ArrayList<product> {

    boolean chaned = true;
    private String dataFile = "Product.dat";
    boolean changed = false;

    private ArrayList<product> list = new ArrayList();

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public void loadDataFromFile() {
        List<String> list = myTool.readLinesFromFile(dataFile);

        for (String d : list) {
            this.add(new product(d));
        }
    }

    public void addProduct() {
        String ID;
        String name;
        double UnitPrice;
        int quantity;
        String status;
        int choice;
        boolean check;

        ID = myTool.readPattern2("Enter the ID: ", product.ID_FORMAT, this);
        do {
            check = true;
            name = myTool.readString("Enter the name: ").toUpperCase();
            if (name.length() < 5) {
                System.out.println("Product'name should have more than 5 characters!!!");
                check = false;
            }
        } while (check == false);
        UnitPrice = myTool.readDouble("Enter the UnitPrice: ");
        quantity = myTool.readInt("Enter the quantity: ");
        choice = myTool.readOption("Enter the choice (1.Available - 2.Not Available): ", "1 or 2", 1, 2);
        if (choice == 1) {
            product pd = new product(ID, name, UnitPrice, quantity, "Available");
            this.add(pd);
            changed = true;
        } else {
            product pd = new product(ID, name, UnitPrice, quantity, "Not Available");
            this.add(pd);
            changed = true;
        }

        System.out.println("Done.");
    }

    public void checkExitProduct() {
        if (this.size() > 0) {
            System.out.println("Product existed.");
        } else {
            System.out.println("No product founded!");
        }
    }

    private product searchProduct(String ID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getID().equalsIgnoreCase(ID)) {
                return this.get(i);
            }
        }
        return null;
    }

    private int searchProductbyname(String Name) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getName().toUpperCase().equals(Name)) {
                return i;
            }
        }
        return -1;
    }

    public void searchProduct() {
        System.out.println("Enter the Name: ");
        String Name = myTool.pc.nextLine().toUpperCase();
        int pos = searchProductbyname(Name);
        if (pos < 0) {
            System.out.println("Product: " + Name + " not found!");
        } else {
            System.out.println(this.get(pos));
        }
    }

    public void updateProduct() {
        if (this.isEmpty()) {
            System.out.println("Empty the list of product");
        }
        int choice = myTool.readOption("Choice [1.Update product - 2.Delete product]: ", "1 or 2", 1, 2);
        if (choice == 1) {
            boolean check;
            String ID = myTool.readPattern("Enter the product'ID you want update ", product.ID_FORMAT, this);
            product pd = this.searchProduct(ID);
            do {
                check = true;
                String newName = myTool.readString("Enter the new name: ").toUpperCase();
                pd.setName(newName);
                changed = true;
                if (newName.isEmpty() && newName.length() < 5) {
                    System.out.println("Product'name should have more than 5 characters.");
                    check = true;
                }
            } while (check == false);
            double newPrice = myTool.readDouble("Enter the new UnitPrice: ");
            pd.setUnitPrice(newPrice);
            changed = true;
            int newQuantity = myTool.readInt("Enter the new quantity: ");
            pd.setQuantity(newQuantity);
            changed = true;
            int newchoice = myTool.readOption("Choice [1.Available - 2.Not Available]: ", "1 or 2", 1, 2);
            if (newchoice == 1) {
                pd.setStatus("Available");
                changed = true;
            } else {
                pd.setStatus("Not Avaiable");
                changed = true;
            }
        } else {
            String ID = myTool.readPattern("Enter the product'ID you want delete: ", product.ID_FORMAT, this);
            product pd = this.searchProduct(ID);
            if (pd != null) {
                this.remove(pd);
                changed = true;
            }
        }

    }

    public void printAllProduct() {
//        int n = this.size();
//        for (int i = 0; i < n; i++) {
//            System.out.println(this.get(i));
//        }

        if (this.isEmpty()) {
            System.out.println("Empty List!");
        } else {
            for (int i = 0; i < this.size(); i++) {
                System.out.print(this.get(i).toString());
            }
        }
    }

    public void writeProductToFile() {
        if (changed) {
            myTool.writeFile(dataFile, this);
            changed = false;
            System.out.println("Done!!!");
        }
    }

    public static void main(String[] args) {
        productList obj = new productList();
        obj.loadDataFromFile();
    }
}

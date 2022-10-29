/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import utils.MyTools;

public class ProductList {

    private ArrayList<Product> list = new ArrayList();

    public void readListProductFromFile() {
        try {
            FileInputStream fis = new FileInputStream("product.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Product>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println("Fail.");
        }
    }

    public void createNewProduct() {
        String id, name, status;
        Product product = null;
        do {
            id = MyTools.getString("Enter ID: ", "Not empty.Input again.");
            product = getProductByID(id);
            if (product != null) {
                System.out.println("Duplicated ID.Input again.");
            }
        } while (product != null);
        do {
            name = MyTools.getString("Enter Name: ", "Not empty.Input again.");
            if (name.length() < 5) {
                System.out.println("Product's name more than five characters.");
            }
        } while (name.length() < 5);
        double price = MyTools.getADouble("Enter Price[0..10000]: ", "Just from 0 to 10000", 0, 10000);
        int quantity = MyTools.getAnInteger("Enter Quantity[0..1000]: ", "Just from 0 to 1000", 0, 1000);
        int choice = MyTools.getAnInteger("Enter choice status(1.Avaiable or 2.Not Avaiable): ", "Just 1 or 2", 1, 2);
        if (choice == 1) {
            list.add(new Product(id, name, price, quantity, "Avaiable"));
        } else {
            list.add(new Product(id, name, price, quantity, "Not Avaiable"));
        }
        System.out.println("The product is added to the list.");
    }

    public Product getProductByID(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductID().equalsIgnoreCase(id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public void checkExitProduct() {
        if (list.size() > 0) {
            System.out.println("Exist Product.");
        } else {
            System.out.println("No Product Found!");
        }
    }

    public void searchProduct() {
        ArrayList<Product> listSearch = new ArrayList();
        boolean flag = false;
        String name = MyTools.getString("Enter Name: ", "Not empty.Input again.");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductName().toLowerCase().contains(name.toLowerCase())) {
                listSearch.add(list.get(i));
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Have no any Product.");
            return;
        }
        Collections.sort(listSearch, (o1, o2) -> {
            return o1.getProductName().compareToIgnoreCase(o2.getProductName());
        });
        System.out.println("ID        NAME                PRICE     QUANTITY  STATUS    ");
        for (int i = 0; i < listSearch.size(); i++) {
            System.out.printf("%-10s%-20s%-10.1f%-10d%-15s\n", listSearch.get(i).getProductID(), listSearch.get(i).getProductName(),
                    listSearch.get(i).getPrice(), listSearch.get(i).getQuantity(), listSearch.get(i).getStatus());
        }
    }

    public void updateProduct() {
        int choice = MyTools.getAnInteger("1.Update Product OR 2.Delete Product: ", "Just 1 or 2.", 1, 2);
        if (choice == 1) {
            String id = MyTools.getString("Enter ID: ", "Not empty.Input again.");
            Product product = getProductByID(id);
            if (product != null) {
                boolean check;
                String newName;
                System.out.println("HERE IS OLD INFORMATION OF PRODUCT:");
                System.out.println("ID        NAME                PRICE     QUANTITY  STATUS    ");
                System.out.printf("%-10s%-20s%-10.1f%-10d%-15s\n", product.getProductID(), product.getProductName(),
                        product.getPrice(), product.getQuantity(), product.getStatus());
                do {
                    check = true;
                    newName = MyTools.updateString("Enter New Name Product: ", product.getProductName());
                    if (!newName.isEmpty() && newName.length() < 5) {
                        System.out.println("Product's Name more than five characters.");
                        check = false;
                    }
                } while (check == false);
                product.setProductName(newName);
                double newPrice = MyTools.updateADouble("Enter New Price Product: ", 0, 10000, product.getPrice());
                product.setPrice(newPrice);
                int newQuantity = MyTools.updateAnInteger("Enter New Quantity Product: ", 0, 1000, product.getQuantity());
                product.setQuantity(newQuantity);
                int choiceStatus = MyTools.getAnInteger("Do you want change status(1.Yes OR 2.No): ", "Just 1 or 2", 1, 2);
                if (choiceStatus == 1) {
                    if (product.getStatus().equals("Avaiable")) {
                        product.setStatus("Not Avaiable");
                    } else {
                        product.setStatus("Avaiable");
                    }
                }
                System.out.println("Product information is updated.");
            } else {
                System.out.println("Product name does not exist.");
            }
        } else {
            String id = MyTools.getString("Enter ID Product: ", "Not blank or empty.");
            Product product = getProductByID(id);
            if (product != null) {
                list.remove(product);
                System.out.println("The product is removed from the list.");
            } else {
                System.out.println("Product name does not exist.");
            }
        }
    }

    public void saveListProductToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("product.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("Fail.");
        }
        System.out.println("Save to file Successfully.");
    }

    public void printAllListProduct() {
        if (list.isEmpty()) {
            System.out.println("List empty.Nothing to print.");
        } else {
            Collections.sort(list, Comparator.comparingInt(list -> ((Product) list).getQuantity()).reversed().thenComparingDouble(list -> ((Product) list).getPrice()));
            System.out.println("HERE IS INFORMATION OF LIST PRODUCT:");
            System.out.println("ID        NAME                PRICE     QUANTITY  STATUS    ");
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%-10s%-20s%-10.1f%-10d%-15s\n", list.get(i).getProductID(), list.get(i).getProductName(),
                        list.get(i).getPrice(), list.get(i).getQuantity(), list.get(i).getStatus());
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.ProductList;
import ui.Menu;

public class Main {

    public static void main(String[] args) {
        ProductList control = new ProductList();
        control.readListProductFromFile();
        Menu menu = new Menu();
        menu.addMenu("**                 MENU                    **");
        menu.addMenu("**  1. Create a Product.                   **");
        menu.addMenu("**  2. Check to exist Product.             **");
        menu.addMenu("**  3. Search Product information by name. **");
        menu.addMenu("**  4. Update Product.                     **");
        menu.addMenu("**  5. Save to file.                       **");
        menu.addMenu("**  6. Print all lists from file.          **");
        menu.addMenu("**  7. Exit.                               **");
        menu.addMenu("**                                         **");
        int choice;
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    control.createNewProduct();
                    break;
                case 2:
                    control.checkExitProduct();
                    break;
                case 3:
                    control.searchProduct();
                    break;
                case 4:
                    control.updateProduct();
                    break;
                case 5:
                    control.saveListProductToFile();
                    break;
                case 6:
                    control.printAllListProduct();
                    break;
                case 7:
                    System.out.println("Exit program....");
                    break;
            }
        } while (choice != 7);
    }
}

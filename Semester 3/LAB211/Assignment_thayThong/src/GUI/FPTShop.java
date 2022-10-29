package GUI;

import DTO.ProductsList;
import java.util.Scanner;

public class FPTShop {

    public static void main(String[] args) {
        ProductsList list = new ProductsList();
        String choice, choice1;
        Scanner sc = new Scanner(System.in);
        boolean check;

        do {
            check = true;
            list.Menu();
            System.out.print("Enter your choice: ");
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    boolean check2 = true;
                    do {
                        System.out.println("\n1. Add new Smartphone");
                        System.out.println("2. Add new TV");
                        System.out.println("3. Add new Air-conditioner");
                        System.out.println("4. Back to menu.");
                        System.out.print("Enter your choice: ");
                        choice1 = sc.nextLine();

                        switch (choice1) {
                            case "1":
                                list.addSmartphone();
                                break;
                            case "2":
                                list.addTV();
                                break;
                            case "3":
                                list.addAirConditioner();
                                break;
                            case "4":
                                check2 = false;
                        }
                    } while (check2);
                    break;
                case "2":
                    list.printAll();
                    break;
                case "3":
                    list.printDescPriceListSM();
                    break;
                case "4":
                    list.printAscPriceListTV();
                    break;
                case "5":
                    list.printDescPriceListAIR();
                    break;
                case "6":
                    list.highestPriceProduct();
                    break;
                case "7":
                    list.updateByCode();
                    break;
                case "8":
                    list.deleteByCode();
                    break;
                case "9":
                    list.totalAmount();
                    break;
                case "10":
                    System.out.println("\nTHANKS FOR USING MY SOFTWARE!");
                    System.exit(0);
                default:
                    System.out.println("\nPLEASE ENTER NUMBER FROM 1 - 12!\n");

            }
        } while (check);
    }
}

package Menu;

import infor.productList;
import myTool.myTool;

public class Main {

    public static void main(String[] args) {
        productList pro = new productList();
        pro.loadDataFromFile();
        int option = 0;
        do {
            System.out.println("1 - Create a product                        ");
            System.out.println("2 - Check exits product                     ");
            System.out.println("3 - Search product by name                  ");
            System.out.println("4 - Update product                          ");
            System.out.println("5 - Save product to file                    ");
            System.out.println("6 - Print product from the file             ");
            System.out.println("7 - Quit                                   ");
            option = myTool.readInt("You wanna choose: \n");
            switch (option) {
                case 1:
                    System.out.println("- Create a product");
                    pro.addProduct();
                    break;
                case 2:
                    System.out.println("- Check exits product");
                    pro.checkExitProduct();
                    break;
                case 3:
                    System.out.println("- Search by name");
                    pro.searchProduct();
                    break;
                case 4:
                    System.out.println("- Update product");
                    pro.updateProduct();
                    break;
                case 5:
                    pro.writeProductToFile();
                    break;
                case 6:
                    System.out.println("- List product from file");
                    pro.printAllProduct();
                    break;
                case 7:
                    System.exit(0);
                    System.out.println("You exit the program!");

                default:
                    if (pro.isChanged()) {
                        boolean res = myTool.readBool("Date changed. Write to file?");
                        if (res == true) {
                            pro.writeProductToFile();
                        }
                    } else {
                        System.out.print("Enter the option: \n");
                    }
            }
        } while (option <= 7);
    }
}

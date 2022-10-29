package mng;

import data.Account;
import data.AccountChecker;
import data.DealerList;
import tools.MyTool;

public class LogIn {

    private Account acc = null; //account will log in

    public LogIn(Account acc) {
        this.acc = acc;
    }

    public static Account inputAccount() {
        System.out.print("Enter the name: ");
        String accName = MyTool.pc.nextLine();
        System.out.print("Enter the password: ");
        String pwd = MyTool.pc.nextLine();
        System.out.print("Enter the role: ");
        String role = MyTool.pc.nextLine();
        Account acc = new Account(accName, pwd, role);
        return acc;
    }

    public Account getAcc() {
        return acc;
    }

    public static void main(String[] args) {
        Account acc = null;
        boolean cont = false;
        boolean valid = false;
        do {
            AccountChecker accChk = new AccountChecker();
            acc = inputAccount();
            valid = accChk.check(acc);
            if (!valid) {
                cont = MyTool.readBool("Invalid account- Try again?");
            }
            if (!valid && !cont) {
                System.exit(0); //quit the program
            }
        } while (cont && !valid);
        LogIn loginObj = new LogIn(acc);
        if (acc.getRole().equalsIgnoreCase("ACC-1")) {
            String[] options = {"1 - Add new dealer", "2 - Search a dealer", "3 - Remove a dealer", "4 - Update a dealer", "5 - Print all dealers", "6 - Prine continuing dealers", "7 - Print UN-continuing dealers", "8 - Write to file"};
            Menu mnu = new Menu(options);
            DealerList dList = new DealerList(loginObj);
            dList.initWithFile();
            int choice = 0;
            do {
                choice = mnu.getChoice("Managing dealers");
                switch (choice) {
                    case 1:
                        dList.addDealer();
                        break;
                    case 2:
                        dList.searchDealer();
                        break;
                    case 3:
                        dList.removeDealer();
                        break;
                    case 4:
                        dList.updateDealer();
                        break;
                    case 5:
                        dList.printAllDealers();
                        break;
                    case 6:
                        dList.printContinuingDealers();
                        break;
                    case 7:
                        dList.printUnContinuingDealers();
                        break;
                    case 8:
                        dList.writeDealerToFile();
                        break;
                    default:
                        if (dList.isChanged()) {
                            boolean res = MyTool.readBool("Data changed. Write to file?");
                            if (res == true) {
                                dList.writeDealerToFile();
                            }
                        }
                }
            } while (choice > 0 && choice < mnu.size());
            System.out.println("Bye.");

        }
    }
}

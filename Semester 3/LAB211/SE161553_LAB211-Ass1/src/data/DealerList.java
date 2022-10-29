/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Array;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashSet;
import tools.MyTool;
import mng.LogIn;

public class DealerList extends ArrayList<Dealer> //<Dealer>: trong trường hợp này, Dealer là con của ArrayList.
{

    LogIn loginObj = null;  //loginObj: trong trường hợp này là dữ liệu
    private static final String PHONEPATTERN = "\\d{9}|\\d{11}";
    private String dataFile = "";
    boolean changed = false; //= false: mặc định chưa bị đổi

    public DealerList(LogIn loginObj) //loginObj: trong trường hợp này là tham số
    {
        super();
        this.changed = changed;
        this.dataFile = dataFile;
        this.loginObj = loginObj;
    }

    public DealerList() {

    }

    private void loadDealerFromFile() {
        List<String> list = MyTool.readLinesFromFile(dataFile);
        for (String d : list) {
            this.add(new Dealer(d));
        }
    }

    public void initWithFile() {
        Config cR = new Config();
        dataFile = cR.getDealerFile();
        loadDealerFromFile();
    }

    public DealerList getContinuingList() {
        DealerList resultlist = new DealerList();
        for (Dealer d : this) {
            if (d.isContinuing() == true) {
                resultlist.add(d);
            }
        }
        return resultlist;
    }

    public DealerList getUnContinuingList() {
        DealerList resultlist = new DealerList();
        for (Dealer d : this) {
            if (d.isContinuing() == false) {
                resultlist.add(d);
            }
        }
        return resultlist;
    }

    private int searchDealer(String ID) {
        ID = ID.toUpperCase();
        int N = this.size();
        for (int i = 0; i < N; i++) {
            if (this.get(i).getID().equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    public void searchDealer() {
        String ID;
        System.out.println("Enter ID: ");
        ID = MyTool.pc.nextLine();
        int pos = searchDealer(ID);
        if (pos < 0) {
            System.out.print("NOT FOUND!");
        } else {
            System.out.println(this.get(pos));
        }
    }

    public void addDealer() {
        String ID;
        String name;
        String addr;
        String phone;
        boolean continuing;
        int pos;

        do {
            ID = MyTool.readPattern("ID of new dealer", Dealer.ID_FORMAT);
            ID = ID.toUpperCase();
            pos = searchDealer(ID);
            if (pos >= 0) {
                System.out.println("ID is deplicated!");
            }
        } while (pos >= 0);
        name = MyTool.readNonBlank("Name of new dealer ").toUpperCase();
        addr = MyTool.readNonBlank("Address of new dealer ");
        phone = MyTool.readPattern("Phone number ", Dealer.PHONE_FORMAT);
        continuing = true;
        Dealer d = new Dealer(ID, name, addr, phone, continuing);
        this.add(d);
        System.out.println("New dealer has been added.");
        changed = true;
    }

    public void removeDealer() {
        String ID;
        System.out.println("Enter ID ");
        ID = MyTool.pc.nextLine();
        int pos = searchDealer(ID);
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            this.remove(pos);
            System.out.println("Removed");
            changed = true;  //data changed successfully
        }
    }

    public void updateDealer() {
        System.out.println("Dealer's ID needs updating ");
        String ID = MyTool.pc.nextLine();
        int pos = searchDealer(ID);
        if (pos < 0) {
            System.out.println("Dealer " + ID + " not found!");
        } else {
            Dealer d = this.get(pos);
            String newName = ""; //Update name
            System.out.println("new name, ENTER for omitting ");
            newName = MyTool.pc.nextLine().trim().toUpperCase();
            if (!newName.isEmpty()) {
                d.setName(newName);
                changed = true;
            }

            String newAddr = "";
            System.out.println("new address, ENTER for omitting ");
            newAddr = MyTool.pc.nextLine().trim().toUpperCase();
            if (!newAddr.isEmpty()) {
                d.setAddr(newAddr);
                changed = true;
            }

            String newPho = "";
            System.out.println("new phone, ENTER for omitting ");
            newPho = MyTool.pc.nextLine().trim().toUpperCase();
            if (!newPho.isEmpty()) {
                d.setPhone(newPho);
                changed = true;
            }
        }
    }

    public void printAllDealers() {
        if (this.isEmpty()) {
            System.out.println("Empty List!");
        } else {
            for (int i = 0; i < this.size(); i++) {
                System.out.print(this.get(i).toString());
            }
        }
    }

    public void printContinuingDealers() {
        this.getContinuingList().printAllDealers();
    }

    public void printUnContinuingDealers() {
        this.getUnContinuingList().printAllDealers();
    }

    public void writeDealerToFile() {
        if (changed) {
            MyTool.writeFile(dataFile, this);
            changed = false;
        }
    }

    public boolean isChanged() {
        return this.isChanged();
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

}

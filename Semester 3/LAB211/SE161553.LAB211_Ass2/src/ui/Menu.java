/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import utils.MyTools;

public class Menu {

    private ArrayList<String> listMenu = new ArrayList();

    public void addMenu(String newOption) {
        listMenu.add(newOption);
    }

    public void showMenu() {
        System.out.println("");
        for (String x : listMenu) {
            System.out.println(x);
        }
    }

    public int getChoice() {
        int size = listMenu.size() - 2;
        String input = "        Enter your Choice[1.." + size + "]: ";
        String error = "You are required to choose the option 1.." + size;
        return MyTools.getAnInteger(input, error, 1, size);
    }
}

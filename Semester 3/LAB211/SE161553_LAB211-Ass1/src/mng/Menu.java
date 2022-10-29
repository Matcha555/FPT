/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import tools.MyTool;

public class Menu extends ArrayList<String> {

    public Menu() {
        super();
    }

    public Menu(String[] items) {
        super();
        for (String item : items) {
            this.add(item);
        }
    }

//Get user choice -- IMPLEMENT IT
    public int getChoice(String title) {
        Iterator iter = this.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        return choice;
    }
}

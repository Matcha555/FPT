/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author DELLL
 */
public class MyTools {

    public static Scanner sc = new Scanner(System.in);

    public static double getADouble(String welcome, String error, double min, double max) {
        double n;
        while (true) {
            try {
                System.out.print(welcome);
                n = Double.parseDouble(sc.nextLine());
                if (n < min || n > max) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public static int getAnInteger(String welcome, String error, int min, int max) {
        int n;
        while (true) {
            try {
                System.out.print(welcome);
                n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public static String getString(String welcome, String error) {
        String id;
        while (true) {
            System.out.print(welcome);
            id = sc.nextLine().trim();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(error);
            } else {
                return id;
            }
        }
    }

    public static int updateAnInteger(String welcome, int min, int max, int oldData) {
        boolean check = true;
        int number = oldData;
        do {
            try {
                System.out.print(welcome);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check == true || number > max || number < min);
        return number;
    }

    public static double updateADouble(String welcome, double min, double max, double oldData) {
        boolean check = true;
        double number = oldData;
        do {
            try {
                System.out.print(welcome);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Double.parseDouble(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check == true || number > max || number < min);
        return number;
    }

    public static String updateString(String welcome, String oldData) {
        String result = oldData;
        System.out.printf(welcome);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        }
        return result;
    }
}

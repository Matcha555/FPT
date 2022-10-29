package MyUtils;

import DTO.Products;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public static String getString(String msg) {
        String result = "";
        boolean check = false;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print(msg);
            result = capitalizeFirstLeter(sc.nextLine().trim());

            if (result.isEmpty()) {
                System.out.println("CAN NOT BE EMPTY!");
            } else {
                check = true;
            }

        } while (!check);

        return result;
    }

    public static String getStringPattern(String msg, String pattern, ArrayList<Products> list) {
        String result = "";
        boolean check = false;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print(msg);
            result = sc.nextLine().trim().toUpperCase();

            if (result.isEmpty()) {
                System.out.println("CAN NOT BE EMPTY!");
                check = true;
            } else if (!result.matches(pattern)) {
                System.out.println("WRONG FORMAT!");
                check = true;
            } else {
                check = isCodeDuplicated(list, result);
            }
        } while (check);

        return result;
    }

    public static int getInt(String msg) {
        int nums = 0;
        boolean check = false;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.print(msg);
                nums = Integer.parseInt(sc.nextLine());
            } catch (Exception err) {
                System.out.println("PLEASE ENTER A NUMBER!");
            }

            if (nums <= 0) {
                System.out.println("MUST BE GREATER THAN 0!");
            } else {
                check = true;
            }

        } while (!check);
        return nums;
    }

    public static float getFloat(String msg) {
        float nums = 0;
        boolean check = false;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.print(msg);
                nums = Float.parseFloat(sc.nextLine());
            } catch (Exception err) {
                System.out.println("PLEASE ENTER A NUMBER!");
            }

            if (nums <= 0) {
                System.out.println("MUST BE GREATER THAN 0!");
            } else {
                check = true;
            }

        } while (!check);

        return nums;
    }

    public static boolean isCodeDuplicated(ArrayList<Products> list, String code) {
        boolean check = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equals(code)) {
                System.out.println("Code has been used!");
                check = true;
                break;
            } else {
                check = false;
            }
        }

        return check;
    }

    public static String capitalizeFirstLeter(String str) {
        char[] charArray = str.toCharArray();
        boolean foundSpace = true;

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {
                if (foundSpace) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }
            } else {
                foundSpace = true;
            }
        }

        str = String.valueOf(charArray);
        return str;
    }

}

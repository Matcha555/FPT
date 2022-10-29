package myTool;

import infor.product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class myTool {

    public static final Scanner pc = new Scanner(System.in);

    public static boolean validStr(String str, String regEx) {
        return str.matches(regEx);
    }

    public static List<String> readLinesFromFile(String filename) {
        ArrayList<String> list = new ArrayList();
        File f = new File(filename);
        if (f.exists()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty()) {
                        list.add(line);
                    }
                }
                br.close();
                fr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return list;

    }

    public static boolean readBool(String mess) {
        String input;
        System.out.println(mess + "[1/0-Y/N-T/F]");
        input = pc.nextLine();
        if (input.isEmpty()) {
            return false;
        }
        char c = Character.toUpperCase(input.charAt(0));
        return (c == '1' || c == 'Y' || c == 'T');
    }

    public static void writeFile(String filename, List list) {
        try {
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);
            for (Object x : list) {
                pw.println(x);
            }
            pw.close();;
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String readNonBlank(String message) {
        String input = "";
        do {
            System.out.println(message + ": ");
            input = pc.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    public static String readPattern(String message, String pattern, ArrayList<product> list) {
        String input = "";
        boolean valid;
        do {
            System.out.print(message + ": ");
            input = pc.nextLine().trim();
            valid = validStr(input, pattern);
        } while (!valid);
        return input;
    }

    public static String readPattern2(String message, String pattern, ArrayList<product> list) {
        String result = "";
        boolean check = false;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print(message);
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

    public static boolean isCodeDuplicated(ArrayList<product> list, String code) {
        boolean check = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equals(code)) {
                System.out.println("Code has been used!");
                check = true;
                break;
            } else {
                check = false;
            }
        }

        return check;
    }

    public static int readInt(String message) {
        boolean check = true;
        int number = 0;
        Scanner pc = new Scanner(System.in);
        do {
            try {
                System.out.print(message);
                number = Integer.parseInt(pc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Please input number: ");
            }
        } while (check || number < 0 || number > 1000);
        return number;
    }

    public static int readOption(String message, String error, int min, int max) {
        int n;
        while (true) {
            try {
                System.out.print(message);
                n = Integer.parseInt(pc.nextLine());
                if (n < min || n > max) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public static double readDouble(String message) {
        boolean check = true;
        double number = 0;
        Scanner pc = new Scanner(System.in);
        do {
            try {
                System.out.print(message);
                number = Double.parseDouble(pc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Please input number: ");
            }
        } while (check || number < 0 || number > 10000);
        return number;
    }

    public static String readString(String message) {
        boolean check = true;
        String result = "";
        Scanner pc = new Scanner(System.in);
        do {
            check = true;
            System.out.print(message);
            result = pc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Not empty!");
            } else if (result.contains(" ")) {
                System.out.println("No space.");
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

}

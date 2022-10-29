package tools;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.io.IOException;

public class MyTool {

    public static final Scanner pc = new Scanner(System.in);

    public static boolean validStr(String str, String regEx) {
        return str.matches(regEx);  //matches: trả về giá trị boolean
    }

    public static boolean validPassword(String str, int minLen) //str: mật khẩu, minLen: độ dài nhỏ nhất
    {
        if (str.length() < minLen) {
            return false;
        }
        return str.matches(".*[a-xA-Z]+.*") && str.matches(".*[\\d]+.*") && str.matches(".*[\\W]+.*");
        /*
        .*[a - zA - z]+.*
        [a - zA - Z]: khớp với bất kỳ ký tự nào từ chữ thường a đến chữ hoa Z.
        +: ít nhất một ký tự
        .*: ký tự bất kỳ xuất hiện bao nhiêu lần cũng được.
         */

        //[\\W]: một ký tự đặc biệt
    }

    public static Date parseDate(String dateStr, String dateFormat) {
        //The java.text.SimpleDateFormat class is used to both parse and format dates according to a formatting pattern you specify yourself.
        SimpleDateFormat dF = (SimpleDateFormat) SimpleDateFormat.getInstance(); //getInstance: lấy đối tượng định dạng ngày tháng
        dF.applyPattern(dateFormat);
        try {
            long t = dF.parse(dateStr).getTime(); //getTime: lấy số mili giây.
            return new Date(t);
        } catch (ParseException e) {
            System.out.println(e);
        }
        return null;
    }

    public static String dataToStr(Date date, String dateFormat) {
        SimpleDateFormat dF = (SimpleDateFormat) SimpleDateFormat.getInstance(); //getInstance: lấy đối tượng định dạng ngày tháng
        dF.applyPattern(dateFormat);
        String dateToString = dF.format(date);
        return dateToString;
    }

    public static boolean parseBool(String boolStr) {
        char c = boolStr.trim().toUpperCase().charAt(0);
        return (c == '1' || c == 'Y' || c == 'T');
    }

    public static String readNonBlank(String message) {
        String input = "";
        do {
            System.out.print(message + ": ");
            input = pc.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    public static String readPattern(String message, String pattern) {
        String input = "";
        boolean valid;
        do {
            System.out.print(message + ": ");
            input = pc.nextLine().trim();
            valid = validStr(input, pattern);
        } while (!valid);
        return input;
    }

    public static boolean readBool(String message) {
        String input;
        System.out.print(message + "[1/0-Y/N-T/F]: ");
        input = pc.nextLine().trim();
        if (input.isEmpty()) {
            return false;
        }
        char c = Character.toUpperCase(input.charAt(0));
        {
            return (c == '1' || c == 'Y' || c == 'T');
        }
    }

    //Thuật toán để đọc các dòng từ file
    public static List<String> readLinesFromFile(String filename) //tạo một mảng tên là list với phần tử là một chuỗi
    {
        ArrayList<String> list = new ArrayList();
        File f = new File(filename);
        if (f.exists()) //kiểm tra file có tồn tại không
        {
            try {
                FileReader fr = new FileReader(f); //Đọc file
                BufferedReader br = new BufferedReader(fr); //Đọc dữ liệu của chuỗi
                String line;  //Create line
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

    public static void writeFile(String filename, List list) //Ghi filename dữ liệu từ list
    {
        try {
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);
            for (Object obj : list) {
                pw.print(obj);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Tests with phone numbers: ");
        System.out.println(validStr("012345678", "\\d{9}|\\d{11}"));
        System.out.println(validStr("01234567891", "\\d{9}|\\d{11}"));
        System.out.println(validStr("12345678", "\\d{9}|\\d{11}"));

        //Test password - OK
        System.out.println(validPassword("qwerty", 8)); //false
        System.out.println(validPassword("qwertyABC", 8));//false
        System.out.println(validPassword("12345678", 8)); //false
        System.out.println(validPassword("qbc123456", 8)); //false
        System.out.println(validPassword("qbc@123456", 8)); //true

        //ID format D000 -> OK
        System.out.println("Tests with IDs: ");
        System.out.println(validStr("A0001", "D\\d{3}"));
        System.out.println(validStr("10001", "D\\d{3}"));
        System.out.println(validStr("D0001", "D\\d{3}"));
        System.out.println(validStr("D101", "D\\d{3}"));

        //Test date format -> OK
        Date d = parseDate("2022:12:07", "yyyy:MM:dd");
        System.out.println(d);
        System.out.println(dataToStr(d, "dd/MM/yyyy")); //test OK
        d = parseDate("12/07/2022", "MM/dd/yyyy");
        System.out.println(d);
        d = parseDate("2022/07/12", "yyyy/dd/MM");
        System.out.println(d);
        d = parseDate("2000/29/02", "yyyy/dd/MM");
        System.out.println(d);
        d = parseDate("2000/30/02", "yyyy/dd/MM");
        System.out.println(d);
        d = parseDate("2000/40/16", "yyyy/dd/MM");
        System.out.println(d);

//Test input data -> ok
        String input = readNonBlank("Input a non-blank staring");
        System.out.println(input);  //OK
        input = readPattern("Phone 9/11 digits", "\\d{9}|\\d{11}");
        System.out.println(input);  //OK
        input = readPattern("ID- format X00000", "x\\d{5}");
        System.out.println(input);  //OK
        boolean b = readBool("Input boolean");
        System.out.println(b);  //OK
    }

}

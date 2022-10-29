package Stack;

import java.util.Scanner;

public class test {

    public static void decToBin(int k) {
        stack s = new stack();
        System.out.print(k + " in binary system is: ");
        while (k > 0) {
            s.push(new Integer(k % 2));
            k = k / 2;
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner pc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = Integer.parseInt(pc.nextLine());
        decToBin(num);

    }
}

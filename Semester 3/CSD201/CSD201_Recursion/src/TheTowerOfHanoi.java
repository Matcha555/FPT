
import java.util.Scanner;

public class TheTowerOfHanoi {

    public void moveDisks(int a, char col1, char col2, char col3) {
        if (a == 1) {
            System.out.println(col1 + "->" + col2);;
        } else {
            moveDisks(a - 1, col1, col3, col2);
            System.out.println(col1 + "->" + col2);
            moveDisks(a - 1, col3, col2, col1);
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        Scanner pc = new Scanner(System.in);
        int n = pc.nextInt();
        //n = Integer.parseInt(pc.nextLine());

        char x = 'A', y = 'B', z = 'C';
        TheTowerOfHanoi th = new TheTowerOfHanoi();
        th.moveDisks(n, x, z, y);
    }

}

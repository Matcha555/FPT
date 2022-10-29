
import java.util.Scanner;

public class Main {

    void permutation(StringBuffer s, int k, int n) {
        if (n != k - 1) {
            for (int i = 0; i < k; i++) {
                StringBuffer s1 = new StringBuffer();
                s1.append(s);
                s1 = s1.insert(i, k);
                permutation(s1, k + 1, n);
            }
        } else {
            System.out.println(s);
        }
    }

    static void permute(int[] a, int k) {
        if (k == a.length) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(" [" + a[i] + "] ");
            }
            System.out.println();
        } else {
            for (int i = k; i < a.length; i++) {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;

                permute(a, k + 1);

                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void main(String args[]) {
        int N = 3;
        int[] sequence = new int[N];

        for (int i = 0; i < N; i++) {
            sequence[i] = i + 1;
        }

        permute(sequence, 0);

    }
}

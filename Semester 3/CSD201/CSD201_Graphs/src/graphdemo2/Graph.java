package graphdemo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Graph {

    int[][] a;  //mảng 2 chiều
    int n;

    public Graph() {
        int[][] b = {
            {0, 2, 6, 0, 1, 0},
            {2, 0, 3, 0, 7, 0},
            {6, 3, 0, 4, 1, 0},
            {0, 0, 4, 0, 2, 5},
            {0, 7, 1, 2, 0, 8},
            {0, 0, 0, 5, 8, 0},};
        this.a = b;
        this.n = a.length;
    }

    public Graph(int[][] b, int n) {
        this.a = b;
        this.n = n;
    }

    public Graph(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            line = br.readLine();
            this.n = Integer.parseInt(line);
            int[][] b = new int[n][n];
            int i = 0;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(",");
                for (int j = 0; j < txt.length; j++) {
                    b[i][j] = Integer.parseInt(txt[j]);
                }
                i++;
            }
            this.a = b;
            br.close();
            fr.close();
        } catch (Exception e) {
        }
    }

    public void writeToFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Integer.toString(n));
            bw.newLine();
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.n; j++) {
                    bw.write(Integer.toString(this.a[i][j]));
                    if (j != this.n - 1) {
                        bw.write(",");
                    }
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
        }
    }

    public void display() {
        System.out.println(n);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                System.out.print(a[i][j]);
                if (j != n - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("");
        }
    }

}

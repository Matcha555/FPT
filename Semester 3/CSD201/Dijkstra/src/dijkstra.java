/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.Scanner;

/**
 *
 * @author Welcome
 */
public class Graph {

    int a[][] = {
        {0, 2, 6, 0, 0, 0},
        {2, 0, 3, 0, 7, 0},
        {6, 3, 0, 4, 1, 0},
        {0, 0, 4, 0, 2, 5},
        {0, 7, 1, 2, 0, 8},
        {0, 0, 0, 5, 8, 0},};
    int check[];
    int d[];
    int pre[];
    int n = 6;

    //===========================
    public void findPathDijkstra(int s) {
        //khoi tao
        check = new int[n];
        d = new int[n];
        pre = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != s) {
                check[i] = 0;    //dinh i chua xet
                pre[i] = s;      //truoc i la s
                if (a[s][i] != 0) {
                    d[i] = a[s][i];
                } else {
                    d[i] = Integer.MAX_VALUE;
                }
            }
        }
        d[s] = 0;
        pre[s] = -1;
        check[s] = 1;
        //vong lap gan nhan
        int count = 1;
        do {
            //tim dinh u co d[u] min de gan nhan
            int min = Integer.MAX_VALUE;
            int u = 0;
            for (int i = 0; i < n; i++) {
                if (min > d[i] && check[i] == 0) {
                    u = i;
                    min = d[i];
                }
            }
            check[u] = 1;
            //cap nhat duong di cua cac dinh ke voi u ma chua xet
            for (int i = 0; i < n; i++) {
                if (a[u][i] != 0 && check[i] == 0) {
                    if (d[i] > d[u] + a[u][i]) {
                        d[i] = d[u] + a[u][i];
                        pre[i] = u;
                    }
                }
            }
            count++;
        } while (count <= n);
        //xuat duong di ngan nhat tu s den cac dinh
        for (int i = 0; i < n; i++) {
            if (i != s) {
                int j = i;
                System.out.print(j + 1);
                do {
                    System.out.print("<-" + (pre[j] + 1));
                    if (pre[j] != -1) {
                        j = pre[j];
                    }
                } while (pre[j] != -1);
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        System.out.print("Input the start vertex:");
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        g.findPathDijkstra(start - 1);
    }
}

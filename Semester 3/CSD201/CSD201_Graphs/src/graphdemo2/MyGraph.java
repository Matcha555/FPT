package graphdemo2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MyGraph {

    Graph g;
    int visit[];
    int previous[];

    public MyGraph() {
        g = new Graph();
        visit = new int[g.n];
        previous = new int[g.n];
        for (int i = 0; i < g.n; i++) {
            visit[i] = 0;
            previous[i] = -1;
        }
    }

    public MyGraph(String filename) {
        this.g = new Graph(filename);
        visit = new int[g.n];
        previous = new int[g.n];
        for (int i = 0; i < g.n; i++) {
            visit[i] = 0;
            previous[i] = -1;
        }
    }

    public void DFS(int v) {
        System.out.print((v) + "-");
        visit[v] = 1;
        for (int j = 0; j < g.n; j++) {
            if (g.a[v][j] == 1 && visit[j] == 0) {
                DFS(j);
            }
        }
    }

    public void BFS(int v) {
        ArrayDeque<Integer> MyQueue = new ArrayDeque<>();
        MyQueue.add(v);
        visit[v] = 1;
        while (!MyQueue.isEmpty()) {
            int u = MyQueue.remove();
            System.out.print(u + "-");
            for (int i = 0; i < g.n; i++) {
                if (g.a[u][i] == 1 && visit[i] == 0) {
                    MyQueue.add(i);
                    visit[i] = 1;
                }
            }
        }
    }

    public void freeVertex() {
        for (int i = 0; i < g.n; i++) {
            visit[i] = 0;
        }
    }

    public void freePath() {
        for (int i = 0; i < g.n; i++) {
            previous[i] = -1;
        }
    }

    public void printPath(int u) {
        int i = u;
        System.out.print(i + "<-");
        do {
            i = previous[i];
            System.out.print(i + "<-");
        } while (previous[i] != -1);
        System.out.println("");
    }

    public void findPathByDFS(int v, int des) {
        if (v == des) {
            this.printPath(des);
        } else {
            visit[v] = 1;
            for (int i = 0; i < g.n; i++) {
                if (g.a[v][i] == 1 && visit[i] == 0) {
                    previous[i] = v;
                    findPathByDFS(i, des);
                    visit[i] = 0;
                }
            }
        }

    }

    public void findPathByBFS(int v, int des) {
        ArrayDeque<Integer> MyQueue = new ArrayDeque<>();
        MyQueue.add(v);
        visit[v] = 1;
        while (!MyQueue.isEmpty()) {
            int u = MyQueue.remove();
            if (u == des) {
                this.printPath(u);
            } else {
                for (int i = 0; i < g.n; i++) {
                    if (g.a[u][i] == 1 && visit[i] == 0) {
                        MyQueue.add(i);
                        visit[i] = 1;
                        previous[i] = u;
                    }
                }
            }
        }
    }

    public void findPathByDijkstra(int s) {
        previous[s] = -1;
        int d[] = new int[g.n];
        for (int i = 0; i < g.n; i++) {
            if (i != s && g.a[s][i] == 0) {
                d[i] = Integer.MAX_VALUE;
            } else {
                d[i] = g.a[s][i];
            }
            if (i != s && g.a[s][i] != 0) {
                previous[i] = s;
            }
            visit[i] = 0;
        }

        d[s] = 0;
        visit[s] = 1;
        int count = 1;  //đếm số đỉnh
        while (count < g.n) {
            int min = Integer.MAX_VALUE;  //giá trị nhỏ nhất để đánh dấu
            int u = 0;
            for (int j = 0; j < g.n; j++) {
                if (visit[j] == 0 && min > d[j]) {
                    min = d[j];
                    u = j;
                }
            }
            visit[u] = 1;
            for (int v = 0; v < g.n; v++) {
                if (g.a[u][v] != 0 && visit[v] == 0 && d[v] > d[u] + g.a[u][v]) {
                    d[v] = d[u] + g.a[u][v];
                    previous[v] = u;
                }
            }
            count++;
        }

        for (int i = 0; i < g.n; i++) {
            if (i != s) {
                System.out.println("Sortest path from " + s + " to " + i + " weighted " + d[i] + ":");
                this.printPath(i);
            }
        }
    }

    public static void main(String[] args) {
        MyGraph mg = new MyGraph();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println(" 1. Read a graph from file - Graph.txt");
            System.out.println(" 2. Display the graph by adjacency matrix");
            System.out.println(" 3. Traverse the graph by DFS");
            System.out.println(" 4. Traverse the graph by DFS");
            System.out.println(" 5. Find the path by DFS");
            System.out.println(" 6. Find the path by BFS");
            System.out.println(" 7. Read a weighted graph from file - Graph1.txt");
            System.out.println(" 8. Find the path by Dijkstra");
            System.out.println(" 0. Exit ");
            System.out.print("    Your selection (0 -> 7): ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    mg = new MyGraph("Graph.txt");
                    break;
                case 2:
                    mg.g.display();
                    break;
                case 3:
                    System.out.print("DFS from the vertex:");
                    int v3 = sc.nextInt();
                    mg.freeVertex();
                    mg.DFS(v3);
                    break;
                case 4:
                    System.out.println("");
                    System.out.print("BFS from the vertex:");
                    int v4 = sc.nextInt();
                    mg.freeVertex();
                    mg.BFS(v4);
                    break;
                case 5:
                    System.out.print("Find path by DFS from:");
                    int start = sc.nextInt();
                    System.out.print("to:");
                    int des = sc.nextInt();
                    mg.freePath();
                    mg.findPathByDFS(start, des);
                    break;
                case 6:
                    System.out.print("Find path by DFS from:");
                    int start1 = sc.nextInt();
                    System.out.print("to:");
                    int des1 = sc.nextInt();
                    mg.freePath();
                    mg.findPathByBFS(start1, des1);
                    break;
                case 7:
                    mg = new MyGraph("Graph1.txt");
                    break;
                case 8:
                    System.out.print("Find shortest path by Dijkstra from:");
                    int s = sc.nextInt();
                    mg.findPathByDijkstra(s);
                    break;
                default:
                    System.out.print("Wrong selection!");
            }
        }
    }

}

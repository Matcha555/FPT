/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        int a[] = {35, 18, 25, 9, 20, 46, 40, 60, 50, 42};
        BSTree tree = new BSTree();
        for (int o : a) {
            tree.insert(o);
        }
        System.out.println("The Tree with inOrder:");
        tree.inOrder(tree.getRoot());
        System.out.println("");
//        System.out.println("The Tree with preOrder:");
//        tree.preOrder(tree.getRoot());
//        System.out.println("");
//        System.out.println("The Tree with postOrder:");
//        tree.postOrder(tree.getRoot());
//        System.out.println("");
        System.out.print("Input a number to detele from Tree:");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        tree.delete(x);
        System.out.println("The Tree with inOrder:");
        tree.inOrder(tree.getRoot());
        System.out.println("");

    }

}

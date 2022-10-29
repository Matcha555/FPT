/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

/**
 *
 * @author meoca
 */
public class Node {

    Node headNode, lastNode;
    int data;
    Node next;

    Node(int x, Node p) {
        data = x;
        next = p;
    }

    Node(int x) {
        this(x, null);
    }
}

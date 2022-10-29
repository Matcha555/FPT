package Main;

public class Node {

    student data;
    Node next;

    Node() {
    }

    Node(student s, Node p) {
        data = s;
        next = p;
    }

    Node(student s) {
        data = s;
        next = null;
    }
}

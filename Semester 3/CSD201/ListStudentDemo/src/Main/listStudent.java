package Main;

public class listStudent {

    Node head;
    Node tail;

    listStudent() {
        //khi mới khởi tạo cho head và tail = null
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void addFirst(student s) {
        Node p = new Node(s);  //tạo một node mới
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    void addLast(student s) {
        Node p = new Node(s);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    void addAtPosition(student s, int pos) {
        Node p = new Node(s);
        if (isEmpty()) {
            head = tail = p;
        } else {
            if (pos == 1) {
                addFirst(s);
            } else {
                int i = 1;
                Node q = head;
                while (q != null && i < pos - 1) {
                    q = q.next;
                    i = i + 1;
                }
                if (q == null) {
                    addLast(s);
                } else {
                    p.next = q.next;
                    q.next = p;
                }
            }
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
        System.out.println();
    }

    void deleteFist() {
        if (isEmpty()) {
            head = head.next;
            if (isEmpty()) {
                tail = null;
            }
        }
    }

    void deleteLast() {
        if (!isEmpty()) {
            Node p = head;
            if (p.next == null) {
                head = tail = null;
            } else {
                while (p.next != null) {
                    p = p.next;
                    p.next = null;
                    tail = p;
                }
            }
        }
    }

    void deleteAtPosition(int pos) //pos: vi tri muon xoa
    {
        if (!isEmpty()) {
            if (pos == 1) {
                deleteFist();
            } else {
                Node p = head;
                int i = 1;
                while (p.next != null && i < pos - 1) {
                    p = p.next;
                    i = i + 1;
                }

                if (p != null && p.next == null) {
                    deleteLast();
                } else {
                    p.next = p.next.next;
                }
            }
        }
    }

    int findName(String name1) {
        Node p = head;
        int pos = 1;
        while (p != null && !p.data.name.equals(name1)) {
            p = p.next;
            pos = pos + 1;
        }
        if (p != null) {
            return pos;
        } else {
            return 0;
        }
    }

    void deleteName(String name1) {
        int pos = findName(name1);
        deleteAtPosition(pos);
    }

    void sort() {
        Node p = head;
        while (p != null) {
            Node q = p.next;
            while (q != null) {
                if (p.data.age > q.data.age) {
                    student temp = p.data;
                    p.data = q.data;
                    q.data = temp;
                }
                q = q.next;
            }
            p = p.next;
        }
    }
}

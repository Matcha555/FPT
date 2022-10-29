package Main;

public class main {

    public static void main(String[] args) {
        listStudent ls = new listStudent();

        student s1 = new student("Quang", 20);
        student s2 = new student("Khoa", 30);
        student s3 = new student("Nguyen", 25);
        student s4 = new student("Le", 14);

        ls.addLast(s1);
        ls.addLast(s2);
        ls.addLast(s3);
        ls.addLast(s4);
        ls.traverse();
        ls.addAtPosition(new student("Son", 18), 0);
        ls.traverse();
        ls.deleteFist();
        ls.traverse();
        ls.deleteLast();
        ls.traverse();
        ls.deleteAtPosition(2);
        ls.traverse();
    }
}

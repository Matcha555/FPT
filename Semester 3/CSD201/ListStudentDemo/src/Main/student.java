package Main;

public class student {

    String name;
    int age;

    student() {
    }

    student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" + "name=" + name + ", age=" + age + '}';
    }
}

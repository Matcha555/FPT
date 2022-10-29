package Stack;

import java.util.Scanner;
import java.util.Stack;

public class SequenceOfIntegers {

    public static void main(String[] args) {
        Scanner pc = new Scanner(System.in);
        System.out.println("Enter how many numbers you want to place on the Stack: ");
        int stackSize = pc.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < stackSize; i++) {
            System.out.println("Enter numbers: ");
            int number = pc.nextInt();
            stack.push(number);
        }
        System.out.println("--------------------");
        while (!(stack.isEmpty())) {
            System.out.println(stack.pop());
        }
    }
}

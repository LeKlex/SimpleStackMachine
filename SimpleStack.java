/*
 * Simple Stack emulator
 */
package simplestack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ing Alexander Poschenreithner <alexander.poschenreithner@gmail.com>
 */
public class SimpleStack {

    protected static Integer register = new Integer(1);

    protected static List<Integer> stack = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String cmd;

        cliPrefix();
        cmd = sc.next();

        while (!cmd.equals("bye")) {

            switch (cmd) {

                case "pop": pop();
                    break;

                case "push": push();
                    break;

                case "swap": swap();
                    break;

                case "add": add();
                    break;

                case "mult": mult();
                    break;

                case "dump": dump();
                    break;

                case "reset": reset();
                    break;

                default:
                    System.out.println("Unknown command (pop, push, swap, add, mult, dump, reset, bye)\n");
            }
            cliPrefix();
            cmd = sc.next();
        }

        dump();
        System.out.println("-- End");
    }

    protected static void cliPrefix() {
        System.out.print("Stack > ");
    }

    public static void reset() {
        while(!stack.isEmpty()) {
            stack.remove(0);
        }
        register = 1;
    }

    /**
     * Add last to stack elements and push outcome back to stack
     */
    public static void add () {
        if (stack.size() > 1) {
            stack.set(stack.size() - 2, stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
            stack.remove(stack.size() - 1);
        } else {
            System.out.println("Add needs two stack elements!\n");
        }
    }

    /**
     * Multiply last two stack elements and push back to stack
     */
    public static void mult () {
        if (stack.size() > 1) {
            stack.set(stack.size() - 2, stack.get(stack.size() - 1) * stack.get(stack.size() - 2));
            stack.remove(stack.size() - 1);
        } else {
            System.out.println("Mult needs two stack elements!\n");
        }
    }

    /**
     * Dump Stack and Register
     */
    public static void dump () {
        System.out.println("Stack: " + stack + " - Register: " + register);
    }

    /**
     * Interchange last two stack elements
     */
    public static void swap () {
        if (stack.size() > 1) {
            Integer tmp = new Integer(0);
            tmp = stack.get(stack.size() - 1);
            stack.set(stack.size() - 1, stack.get(stack.size() - 2));
            stack.set(stack.size() - 2, tmp);
        } else {
            System.out.println("Swap need two stack elements!\n");
        }
    }

    /**
     * Push Register value to stack
     */
    public static void push () {
        stack.add(register);
    }

    /**
     * Move last stack element to register
     */
    public static void pop() {
        if (stack.size() > 0) {
            register = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
        } else {
            System.out.println("Pop needs one stack element!\n");
        }
    }
}

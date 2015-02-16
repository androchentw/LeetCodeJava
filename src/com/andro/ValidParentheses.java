package com.andro;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("input: ");
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(isValid(in.nextLine()) + "\ninput: ");
        }
    }

    /**
     * @param s, console input
     * @return isValidParentheses
     */
    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<String>();
        stack.push("0");

        for (int i = 0; i < s.length(); i++) {
            String input = String.valueOf(s.charAt(i));
            if (isPair(stack.peek(), input)) stack.pop();
            else stack.push(input);
        }

        return stack.size() == 1;
    }

    public static boolean isPair(String left, String right) {
        return  (left.equals("(") && right.equals(")")) ||
                (left.equals("[") && right.equals("]")) ||
                (left.equals("{") && right.equals("}"));
    }
}

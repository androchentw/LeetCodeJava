package com.andro;

import java.util.Scanner;
import java.util.Stack;

/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println("input: ");
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(reverse(in.nextInt()) + "\ninput: ");
        }
    }

    /**
     * @param x, console input int
     * @return result
     */
    public static int reverse(int x) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;

        for (int i = 0; !isTopDigit(x, i); i++) {
            stack.push((int) (x / Math.pow(10, i) % 10));
        }

        int topDigit = stack.size();
        for (int i = 0; i < topDigit; i++) {
            int num = stack.pop();
            if (isOverOrUnderflow(num, i, result)) {
                result = 0;
                break;
            }

            result += num * Math.pow(10, i);
        }

        return result;
    }

    public static boolean isTopDigit(int x, int i) {
        return (int) (x / Math.pow(10, i)) == 0;
    }

    public static boolean isOverOrUnderflow(int num, int i, int result) {
        return (num > 0 && num * Math.pow(10, i) > Integer.MAX_VALUE - result) ||
                (num < 0 && num * Math.pow(10, i) < Integer.MIN_VALUE - result);
    }
}

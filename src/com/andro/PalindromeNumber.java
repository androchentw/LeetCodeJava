package com.andro;

import java.util.Scanner;
import java.util.Stack;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println("input: ");
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(isPalindrome(in.nextInt()) + "\ninput: ");
        }
    }

    /**
     * @param x, console input int
     * @return result
     */
    public static boolean isPalindrome(int x) {
        if (x == Integer.MIN_VALUE) return false;
        if (x < 0) return false;        // if (x < 0) x = -x;

        int n = getOrder(x);
        for (int i = 0; i < n/2; i++) {
            if (getDigit(x, i) != getDigit(x, n - 1 - i)) return false;
        }

        return true;
    }

    public static int getOrder(int x) {
        int order = 0;
        while (x > 0) {
            order++;
            x /= 10;
        }
        return order;
    }

    public static int getDigit(int x, int i) {
        return (int) (x / Math.pow(10, i) % 10) ;
    }

    /**
     * Hints
     * 1. Negative integers
     * 2. Overflow -> false
     */
}

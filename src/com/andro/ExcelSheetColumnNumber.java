package com.andro;

import java.util.Scanner;

/**
 * Given a column title as appear in an Excel sheet,
 * return its corresponding column number.
 *
 * A -> 1, B -> 2, ..., Z -> 26, AA -> 27, AB -> 28
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println("input: ");
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(titleToNumber(in.nextLine()) + "\ninput: ");
        }
    }

    public static int titleToNumber(String s) {
        // s = s.toUpperCase();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += getAsciiNum(s.charAt(s.length() - 1 - i)) * Math.pow(26, i);
        }
        return result;
    }

    public static int getAsciiNum(char c) {
        return ((int) c) - 64;
    }
}

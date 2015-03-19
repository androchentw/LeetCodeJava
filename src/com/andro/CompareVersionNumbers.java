package com.andro;

import java.util.Scanner;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three",
 * it is the fifth second-level revision of the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 *
 * 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println("input: ");
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(getInput(in.nextLine()) + "\ninput: ");
        }
    }

    /**
     * Get input from console, should be in the form: $ version1, version2
     * e.g. 1.1, 2.3
     * @param s, input
     */
    public static int getInput(String s) {
        String[] arr = s.split(", ");
        return compareVersion(arr[0], arr[1]);
    }

    public static int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int ans;

        int size = (ver1.length < ver2.length) ? ver1.length : ver2.length;
        for (int i = 0; i < size; i++) {
            int tmp1 = Integer.parseInt(ver1[i]);
            int tmp2 = Integer.parseInt(ver2[i]);
            ans = (int) Math.signum(tmp1 - tmp2);
            if (ans != 0) return ans;
        }

        if (ver1.length < ver2.length) {
            if (isEndingZero(ver1, ver2)) return 0;
        } else {
            if (isEndingZero(ver2, ver1)) return 0;
        }

        return (int) Math.signum(ver1.length - ver2.length);
    }

    public static boolean isEndingZero(String[] shorter, String[] longer) {
        for (int i = shorter.length; i < longer.length; i++) {
            if (Integer.parseInt(longer[i]) != 0) return false;
        }
        return true;
    }

    /**
     * Hint
     * 1. split("\\.")
     * 2. 1.0, 1
     */
}

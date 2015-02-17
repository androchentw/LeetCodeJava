package com.andro;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println("input: ");
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(majorityElement(in.nextLine()) + "\ninput: ");
        }
    }

    public static int[] IntegerToArray(String s) {
        int length = s.length();
        int[] num = new int[length];
        for (int i = 0; i < length; i++) {
            num[i] = (int) s.charAt(i) - 48;
        }
        return num;
    }

    public static int majorityElement(String s) {
        int[] num = IntegerToArray(s);

        int result = 0;
        int resultValue = 0;
        int tmpValue;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < num.length; i++) {
            tmpValue = (map.containsKey(num[i])) ? map.get(num[i]) : 0;
            map.put(num[i], ++tmpValue);

            if (tmpValue > resultValue) {
                result = num[i];
                resultValue = tmpValue;
            }
        }

        return result;
    }
}
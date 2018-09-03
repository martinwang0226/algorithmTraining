package com.example.lib.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by martinwang on 2018/9/1.
 */

public class AnagramComparator {
    public static void main(String[] args) {
        String[] a = {"martin", "wang", "tinmar", "wagn"};
//        Arrays.sort(a, new AnaggramComparator());
        sortBull(a);
        for (int i = 0; i < a.length; i++)
            System.out.println("排序后的结果是" + "===========" + a[i]);
    }

    //比较器方法
    public static class AnaggramComparator implements Comparator<String> {
        public String sortChars(String s) {
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        @Override
        public int compare(String s1, String s2) {
            return sortChars(s1).compareTo(sortChars(s2));
        }
    }

    public static String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    // 散列表方法
    public static void sortBull(String[] array) {
        Hashtable<String, LinkedList<String>> hash =
                new Hashtable<String, LinkedList<String>>();

        for (String s : array) {
            String key = sortChars(s);
            if (!hash.containsKey(key)) {
                hash.put(key, new LinkedList<String>());
            }
            LinkedList<String> anagrams = hash.get(key);
            anagrams.push(s);
        }

        int index = 0;
        for (String key : hash.keySet()) {
            LinkedList<String> list = hash.get(key);
            for (String t : list) {
                array[index] = t;
                index++;
            }
        }
    }


}

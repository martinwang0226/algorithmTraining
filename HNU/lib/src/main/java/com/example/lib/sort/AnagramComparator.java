package com.example.lib.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by martinwang on 2018/9/1.
 * 11.2　编写一个方法，对字符串数组进行排序，将所有变位词1排在相邻的位置。（第77页）
 * <p>
 * Gayle Laakmann McDowell. 程序员面试金典（第5版） (p. 256). 人民邮电出版社. Kindle 版本.
 */

public class AnagramComparator {
    public static void main(String[] args) {
        String[] a = {"martin", "wang", "tinmar", "wagn"};
//        Arrays.sort(a, new AnaggramComparator());
        sortBull(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println("排序后的结果是" + "===========" + a[i]);
        }
    }

    //比较器方法,通过排序后的字符串比较两个字符串是否相同
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

        //将同为变位词的单词放在同一组
        for (String s : array) {

            String key = sortChars(s);
            if (!hash.containsKey(key)) {
                hash.put(key, new LinkedList<String>());
            }
            LinkedList<String> anagrams = hash.get(key);
            anagrams.push(s);
        }

        int index = 0;
        //按照key，取出同为词，入队
        for (String key : hash.keySet()) {
            LinkedList<String> list = hash.get(key);
            for (String t : list) {
                array[index] = t;
                index++;
            }
        }
    }


}

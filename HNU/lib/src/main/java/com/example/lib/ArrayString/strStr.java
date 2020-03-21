package com.example.lib.ArrayString;

/**
 * <description>
 *
 * @author habo
 * @date 2020/3/21
 */
public class strStr {
    public static void main(String[] args) {


    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    private int[] callLps(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int length = 0;
        for (int i = 1;i < pattern.length();i++) {
            while (length > 0 && pattern.charAt(length) != pattern.charAt(i)) {
                length = lps[length - 1];
            }
            if (pattern.charAt(length) == pattern.charAt(i)) {
                length++;
            }
            lps[i] = length;
        }
        return lps;
    }
    public int strStr2(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int[] lps = callLps(needle); // longest proper prefix which is also suffix
        int i = 0, j = 0; // idx for text and pattern
        while (i < haystack.length()) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            }
            if (j == needle.length()) {
                return i - j;
            } else if (i < haystack.length() && needle.charAt(j) != haystack.charAt(i)) { // mismatch after j matches
                if (j > 0) { // Don't match lps[0..lps[j-1]] characters, they will match anyway
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

}

package com.example.lib.ArrayString;

/**
 * Create by chenlong.wang
 * 实现朴素的字符串匹配算法
 * on 2020/9/12
 */
public class stringMatch {

    /**
     * 暴力匹配算法
     *
     * @param sStr 父串
     * @param dStr 子串
     * @return 子串在父串中下标index[int]
     */
    public static int violentMatch(String sStr, String dStr) {
        int sLength = sStr.length();
        int dLength = dStr.length();
        int sIndex = 0, dIndex = 0;

        while (sIndex < sLength && dIndex < dLength) {
            //当前字符匹配
            if (sStr.charAt(sIndex) == dStr.charAt(dIndex)) {
                //父串和子串同时后移一个字符
                sIndex++;
                dIndex++;
            } else {//不匹配则sIndex回溯，dIndex被置为0
                sIndex = sIndex - (dIndex - 1);
                dIndex = 0;
            }
        }
        if (dIndex == dLength) {
            return sIndex - dLength;
        }
        return -1;
    }
}

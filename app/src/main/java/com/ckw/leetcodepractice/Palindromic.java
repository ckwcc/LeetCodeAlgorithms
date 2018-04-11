package com.ckw.leetcodepractice;

/**
 * Created by ckw
 * on 2018/4/10.
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.

 Example:

 Input: "cbbd"

 Output: "bb"
 */
public class Palindromic {
    private static int originIndex;//回文的初始位置
    private static int maxLength;//回文的长度
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        for (int i = 0; i < len - 1; i++) {
            //如果回文的类型是aba型,它（i）不需要检测到最后一位，因为getMaxLength方法中会检测到最后是类似aba的情况
            getMaxLength(s,i,i);
            //如果回文的类型是abba型，由于有i+1的情况在，循环也只需要到len-1,否则会下标越界
            getMaxLength(s,i,i+1);
        }
        return s.substring(originIndex,originIndex+maxLength);
    }

    /*
    * 两边辐射法
    * */
    private static void getMaxLength(String s,int i,int j){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        if(maxLength < j - i - 1){
            originIndex = i + 1;
            maxLength = j - i - 1;
        }
    }


}

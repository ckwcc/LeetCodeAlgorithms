package com.ckw.leetcodepractice;


/**
 * Created by ckw
 * on 2018/4/10.
 * 第三题：
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 */
public class LongestSubString {

    public static int lengthOfLongestSubstring(String s) {

        if("".equals(s)){
            return 0;
        }
        char[] chars = s.toCharArray();
        int maxLength = 1;
        int tempLength = 1;
        StringBuffer sb = new StringBuffer();
        //两层for，外层对所有的字符遍历，内存是除了外层之外的后续字符的循环
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            for (int j = i+1; j < chars.length ; j++) {
                if(sb.toString().contains(String.valueOf(chars[j]))){
                    tempLength = sb.length();
                    break;
                }else {
                    sb.append(chars[j]);
                    tempLength = sb.length();
                }
            }

            if(tempLength > maxLength){
                maxLength = tempLength;
                tempLength = 1;
            }

            //需要重置sb
            sb = new StringBuffer();
        }
        return maxLength;
    }
}

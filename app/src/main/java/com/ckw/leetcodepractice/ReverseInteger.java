package com.ckw.leetcodepractice;

import android.util.Log;

/**
 * Created by ckw
 * on 2018/4/13.
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 给定一个32位带符号整数，返回这个整数的反向数字。
 * Example 1:

 Input: 123
 Output: 321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21

 Note:
 Assume we are dealing with an environment which could only store integers within the 32-bit signed
 integer range: [−231,  231 − 1]. For the purpose of this problem,
 assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public static int reverse(int x) {
        //x是否是正数
        boolean isPositive = x > 0;

        x = Math.abs(x);

        if(!isPositive){
            if(x < 0){
                return 0;
            }
        }

        String s = String.valueOf(x);
        int len = s.length();
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            int temp = x % 10;
            arr[i] = temp;
            x = x / 10;
        }
        long sum = 0;

        for (int i = 0; i < len; i++) {
            sum = sum * 10 + arr[i];
        }

        long max = 1L << 31;
        if(isPositive){
            if(sum >= max ){
                return 0;
            }else {
                return (int) sum;
            }

        }else {
            if(sum > max){
                return 0;
            }else {
                return (int) -sum;
            }
        }

    }
}

package com.ckw.leetcodepractice;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ckw
 * on 2018/4/16.
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

 Example 1:

 Input: 121
 Output: true
 Example 2:

 Input: -121
 Output: false
 Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 Example 3:

 Input: 10
 Output: false
 Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 Follow up:

 Coud you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        int temp = x;
        while (temp != 0){
            list.add(temp % 10);
            temp = temp / 10;
        }

        int size = list.size();
        for (int i = 0; i < size; i++) {
            if(list.get(i) != list.get(size - i -1)){
                return false;
            }
        }
        return true;
    }
}

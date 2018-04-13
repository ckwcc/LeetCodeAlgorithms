package com.ckw.leetcodepractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView mShowInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowInfo = findViewById(R.id.tv_show);

        //第一题：Two Sum
//        firstProblem();

        //第二题：Add Two Numbers
//        secondProblem();

        //第三题：Longest Substring Without Repeating Characters
//        thirdProblem();

        //第四题： Longest Palindromic Substring
//        fourthProblem();

        //第五题： Median of Two Sorted Arrays (比较难)
        fifthProblem();
    }

    /*
    * 第一题测试用例
    * */
    private void firstProblem(){
        int[] nums = new int[]{2,7,11,15};
        int target = 26;
//        int[] ints = twoSum(nums, target);
        int[] ints = twoSumA(nums, target);

        if(ints != null){
            mShowInfo.setText("第一个数字下标是："+ints[0]+";第二个数字下标是："+ints[1]);
        }
    }

    /*
    * 第二题测试用例
    * */
    private void secondProblem(){
        AddTwoNumbers.ListNode first = new AddTwoNumbers.ListNode(2);
        first.next = new AddTwoNumbers.ListNode(4);
        first.next.next = new AddTwoNumbers.ListNode(3);

        AddTwoNumbers.ListNode second = new AddTwoNumbers.ListNode(5);
        second.next = new AddTwoNumbers.ListNode(6);
        second.next.next = new AddTwoNumbers.ListNode(4);

        StringBuffer stringBuffer = new StringBuffer();
        AddTwoNumbers.ListNode listNode = AddTwoNumbers.addTwoNumbers(first, second);
        AddTwoNumbers.ListNode temp = listNode;
        while (temp != null){
            stringBuffer.append(temp.val);
            temp = temp.next;
        }

        mShowInfo.setText(stringBuffer);
    }


    /*
    * 第三题测试用例
    * */
    private void thirdProblem(){
        int length = LongestSubString.lengthOfLongestSubstring("aaaaaaabbcdbbbb");
        mShowInfo.setText("长度是："+length);
    }

    /*
    * 第四题测试用例
    * */
    private void fourthProblem(){
        String s = Palindromic.longestPalindrome("abcdccba");
        mShowInfo.setText(s);
    }

    /*
    * 第五题测试用例
    * */
    private void fifthProblem(){
        int[] b = new int[]{1,2,3,4,100};
        int[] a = new int[]{6,7,8};
        double median = MedianofTwoSortedArrays.findMedianSortedArrays(a, b);
        mShowInfo.setText("中间数是："+median);
    }
    /*
     * 算法第一题：Two Sum
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * 问题描述：
     * 给一个int类型的数组，返回一个由其中 两个数字相加等于一个具体的值 的这两个数字的数组下标
     * 这里假设每个输入只有一种解决方案，同时这两个数字不能是由相同的元素组成

     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     * */
    /*
    * 方法一
    * 时间复杂度是O(n^2)
    * 空间复杂度是O(1)
    * */
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size ; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*
     * 方法二：
     * 时间复杂度是O(n)
     * 空间复杂度是O(n)
     * */
    public int[] twoSumA(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if(map.containsKey(remainder) && map.get(remainder) != i){
                return new int[] { i, map.get(remainder) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}

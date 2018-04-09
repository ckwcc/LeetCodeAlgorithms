package com.ckw.leetcodepractice;

/**
 * Created by ckw
 * on 2018/4/9.
 * 第二题：Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 给定两个非空链表，表示两个非负整数。这些数字以相反的顺序存储，每个节点都包含一个数字。
 * 添加两个数字并将其作为一个链表返回。
 * 你可以假设这两个数字不包含任何前导零，除了数字0本身。
 *
 * 例子：input是输入，output是输出
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //首先分别指向l1和l2，这样做的目的是不改变原有数据
        ListNode first = l1;
        ListNode second = l2;
        //新建一个对象，用于返回数据,并创建一个临时变量指向这个需要返回的对象
        ListNode ret = new ListNode(0);
        ListNode temp = ret;
        //用于记录对应位数字相加之和
        int sum = 0;
        //必须两者都为空才可以停止
        while (first != null || second != null){
            //不停地将sum往高位上走（例如7+8=15，sum有记录加法余量的功能）
            sum /= 10;
            //这里是从个位开始加
            if(first != null){
                sum += first.val;
                first = first.next;
            }

            if(second != null){
                sum += second.val;
                second = second.next;
            }

            temp.next = new ListNode(sum % 10);
            //这样做会报空指针
//            temp.next.val = sum %10;
            temp = temp.next;
        }

        //如果最后的余量还是超过十
        if(sum / 10 == 1){
            temp.next = new ListNode(1);
        }

        return ret.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

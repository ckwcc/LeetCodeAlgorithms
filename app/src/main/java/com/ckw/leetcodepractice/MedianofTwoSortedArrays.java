package com.ckw.leetcodepractice;

/**
 * Created by ckw
 * on 2018/4/11.
 * 第五题：找出两个数组的所有元素的中间值
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 */
public class MedianofTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //得到中间的下标
        int mid = (nums2.length+nums1.length+1)/2;
        //得到中间值
        double res = getkth(nums1, nums2, mid);
        //如果组合的长度是偶数，那么也需要找到mid+1元素。
        if((nums2.length+nums1.length) % 2 == 0) {
            res += getkth(nums1, nums2, mid+1);
            //两者平均值
            res = res/2;
        }
        return res;
    }

    public static int getkth(int[] A, int[] B, int k) {
        //确保A是更短的
        if(B.length < A.length ) return getkth(B, A, k);
        //如果短的数组长度为0，返回
        if(A.length == 0) return B[k-1];
        //如果k=1，选取AB中最小的一个
        if(k == 1) return Math.min(A[0], B[0]);

        //A中用来比较的下标i
        int i = Math.min((A.length), k/2);
        //B的下标和A的下标加起来必须是K
        int j = k - i;

        //如果A的第i个元素的值小于B的第j个元素的值，不断地把A中更小的部分去除
        if(A[i- 1] <  B[j-1]) {
            int[] newA = new int[A.length - i];
            //复制一个新数组，将A剩余部分的复制进去
            System.arraycopy(A, i, newA, 0, (A.length - i));
            return getkth(newA, B, k - i);
        }
        else {
            int[] newB = new int[B.length - j];
            System.arraycopy(B, j, newB, 0, (B.length - j));
            return getkth(A, newB, k - j);
        }
    }
}

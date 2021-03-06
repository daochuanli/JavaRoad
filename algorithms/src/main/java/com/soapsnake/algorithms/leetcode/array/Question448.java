package com.soapsnake.algorithms.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
class Question448 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};

        Question448 question448 = new Question448();
        ArrayUtils.printList(question448.findDisappearedNumbers(nums));
    }

    //题目要求不能使用其他内存(除了数组和list)来解题,但是我这里使用了set,算是违规了
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length + 1; i++) {
            set.add(i);
        }

        for (int j = 0; j < nums.length; j++) {
            set.remove(nums[j]);
        }
        List<Integer> res = new ArrayList<>(set);
        return res;
    }


}

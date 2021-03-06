package com.soapsnake.algorithms.leetcode.str;

class Question3 {

    public static void main(String[] args) {
        Question3 question3 = new Question3();
        String str = "abcabcbb";
        String str2 = "pwwkew";
        System.out.println(question3.lengthOfLongestSubstring(str));
    }

    //最傻逼解法,时间复杂度平方级别
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.equals("")) {
            return 0;
        }
        if (s.equals(" ")) {
            return 1;
        }
        char[] chars = s.toCharArray();
        int max = -Integer.MAX_VALUE;
        String temp = "";
        for (int i = 0; i < chars.length; i++) {
            temp += chars[i];
            if (chars.length - i <= max) {
                return max;
            }
            for (int j = i + 1; j < chars.length; j++) {
                if (temp.contains(chars[j] + "")) {
                    break;
                } else {
                    temp += chars[j];
                }
            }
            max = Math.max(temp.length(), max);
            temp = "";
        }
        return max;
    }
}

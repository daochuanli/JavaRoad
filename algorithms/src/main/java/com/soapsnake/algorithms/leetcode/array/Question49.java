package com.soapsnake.algorithms.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther soapsnake@gmail.com
 * @Date 2019-03-20 12:27
 */
public class Question49 {

    public static void main(String[] args) {
        Question49 question49 = new Question49();
        String[] a = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(question49.groupAnagrams2(a));

        System.out.println(question49.permut("abc"));
    }

    /**
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //方案1:看字符串按字典序排序后是否一致,一致放一起
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String string : strs) {
            String dest = this.sortDest(string);
            System.out.println("dest = " + dest);
            if (map.containsKey(dest)) {
                ArrayList<String> temp = map.get(dest);
                temp.add(string);
                map.put(dest, temp);
            } else {
                ArrayList<String> temp2 = new ArrayList<>();
                temp2.add(string);
                map.put(dest, temp2);
            }
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(map.values());
        return res;
    }

    private String sortDest(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    //方案2:
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = Arrays.stream(strs).collect(Collectors.groupingBy(this::groupc));
        return new ArrayList<>(map.values());
    }

    private String groupc(String o) {
        char[] chars = o.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private List<String> permut(String o) {
        char[] chars = o.toCharArray();
        List<String> res = new ArrayList<>();
        this.backTrace(res, new ArrayList<>(), chars);
        return res;
    }

    private void backTrace(List<String> res, List<Character> tmp, char[] chars) {
        if (tmp.size() == chars.length) {
            StringBuilder s = new StringBuilder();
            for (Character c : tmp) {
                s.append(c);
            }
            res.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (tmp.contains(chars[i])) {
                continue;
            }
            tmp.add(chars[i]);
            backTrace(res, tmp, chars);
            tmp.remove(tmp.size() - 1);
        }
    }
}

package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 串联所有单词的子串（注意：所有单词长度相等！！）
 * 标签：哈希 字符串 双指针
 * 【技巧：滑动窗口】
 * 第一遍：没有思路，直接看答案。。
 * 第二遍：2020-6-7复习：解题思路：将所有单次置入HashMap1；遍历子串，如果当前扫描的字符串的单词在HashMap1中，那么置入HashMap2
 */
public class Leetcode_30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();
        // HashMap1 存所有单词
        Map<String, Integer> allWords = new HashMap<>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        // 遍历所有子串
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            // HashMap2 存当前扫描的字符串含有的单词
            Map<String, Integer> hasWords = new HashMap<>();
            int num = 0;
            // 判断该子串是否符合
            while (num < wordNum) {
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                //判断该单词在 HashMap1 中
                if (allWords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, value + 1);
                    //判断当前单词的 value 和 HashMap1 中该单词的 value
                    if (hasWords.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            // 判断是不是所有的单词都符合条件
            if (num == wordNum) {
                res.add(i);
            }
        }
        return res;
    }

//    示例 1：
//
//    输入：
//    s = "barfoothefoobarman",
//    words = ["foo","bar"]
//    输出：[0,9]
//    解释：
//    从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//    输出的顺序不重要, [9,0] 也是有效答案。
//    示例 2：
//
//    输入：
//    s = "wordgoodgoodgoodbestword",
//    words = ["word","good","best","word"]
//    输出：[]
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> res = findSubstring(s, words);
    }
}

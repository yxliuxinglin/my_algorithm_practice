import sun.jvm.hotspot.memory.PlaceholderEntry;

import java.util.Collections;

/**
 * 反转字符串中的单词 III
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 */

public class Leetcode_557 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String res = reverseWords(s);
        System.out.print(res);
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // 步骤一：先将整个字符串逆序
        StringBuilder sb = new StringBuilder(s);
        String str = sb.reverse().toString();

        // 步骤二：再将逆序后的字符串的单词顺序逆序进行排列
        String[] words = str.split(" ");
        reverse(words);
        return String.join(" ", words);
    }

    private static void reverse(String[] words) {
        for (int i = 0; i < words.length / 2; i++) {
            String tempStr = words[i];
            words[i] = words[words.length-1-i];
            words[words.length-1-i] = tempStr;
        }
    }
//
//    public String reverseWords2(String s) {
//        String words[] = s.split(" ");
//        StringBuilder res = new StringBuilder();
//        for (String word : words) {
//            res.append(new StringBuffer(word).reverse().toString() + " ");
//        }
//        return res.toString().trim();
//    }
}

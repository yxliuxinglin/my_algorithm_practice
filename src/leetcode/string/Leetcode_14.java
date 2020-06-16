package leetcode.string;

import java.util.Arrays;
import java.util.Collections;

/**
 * 最长公共前缀
 *
 * @author l00365373
 * @since 2020-06-11
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Leetcode_14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String res = longestCommonPrefix3(strs);
        System.out.println(res);
        // String str1 = "flower";
        // String str2 = "flow";
        // int index = str2.indexOf(str1);

    }

    /**
     * 横向扫描
     * 依次遍历每个字符串，更新最长公共前缀
     * 先假设最长前缀是str[0]，然后不断缩小长度，直到满足它是所有字符串的前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {  // prefix不是前缀，那么继续缩小prefix范围，继续查找，直到prefix是前缀
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    /**
     * 纵向扫描
     * 从第一个字符，不断向后扩展，找出最长公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != ch)
                    return strs[0].substring(0, i);
            }
        }

        return strs[0];
    }

    /**
     * 奇技淫巧
     * 将所有字符串排序，然后比较首尾字符串即可
     * @param strs
     * @return
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Collections.sort(Arrays.asList(strs));
        String start = strs[0], end = strs[strs.length-1];
        int length = Math.min(start.length(), end.length());
        for (int i = 0; i < length; i++) {
            if (start.charAt(i) != end.charAt(i)) {
                return start.substring(0, i);
            }
        }
        return start;
    }
}

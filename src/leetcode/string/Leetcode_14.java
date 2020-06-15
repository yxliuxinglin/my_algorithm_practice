package leetcode.string;

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
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
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

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String res = longestCommonPrefix(strs);

        // String str1 = "flower";
        // String str2 = "flow";
        // int index = str2.indexOf(str1);

    }

    // string longestCommonPrefix(vector<string>& strs) {
    //     if (strs.empty())
    //         return "";
    //
    //     for (int i = 0; i < strs[0].size(); i++) {
    //         char ch = strs[0][i];
    //         for (int j = 1; j < strs.size(); j++) {
    //             if (strs[j].size() == i || strs[j][i] != ch)
    //                 return strs[0].substr(0, i);
    //         }
    //     }
    //
    //     return strs[0];
    // }
}

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 题目类型：滑动窗口
 * @author l00365373
 * @since 2020-05-14
 */
class Leetcode_3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));  // 只要set检查已有重复的字符，就缩小窗口；如果缩小后依然有重复，就继续缩小，直到没有重复
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
    }
}

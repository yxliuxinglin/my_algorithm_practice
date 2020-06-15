package leetcode.sliding_window;

/**
 * 长度最小的子数组
 *
 * 标签：双指针（滑动窗口）
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Leetcode_209 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int s = 7;
        int res = minSubArrayLen2(s, nums);
        System.out.println(res);
    }

    /**
     * 暴力法 时间复杂度O(n^2)
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen1(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    len = Math.min(len, j+1-i);
                }
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    /**
     * 双指针（滑动窗口），时间复杂度O(n)
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {  // 技巧，如果写成if (sum >= s)结果不对
                len = Math.min(len, i+1-left);
                sum -= nums[left];
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}

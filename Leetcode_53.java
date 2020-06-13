/**
 * 最大子序和
 * 标签：数组 动态规划 分治
 * 第一遍：没有思路
 *
 *    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *    示例:
 *
 *    输入: [-2,1,-3,4,-1,2,1,-5,4],
 *    输出: 6
 *    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *    进阶:
 *
 *    如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class Leetcode_53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {1};
        int result = maxSubArray(nums);
        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum + nums[i] > nums[i]) {  // 即sum>0
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}

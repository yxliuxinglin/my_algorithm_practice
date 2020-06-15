package leetcode.greedy;

/*
 * 乘积最大子数组
 * 第一遍：贪心、动态规划，但是数字有正负数，不知道怎么判断当前数字算不算？
 */
public class Leetcode_152 {
    public static void main(String[] args) {
//        int[] nums = {2,3,-2,4};
//        int[] nums = {2, -3, -4};
        int [] nums = {-2, 0, -1};
        int result = maxProduct(nums);
        System.out.println(result);
    }

//    示例 1:
//
//    输入: [2,3,-2,4]
//    输出: 6
//    解释: 子数组 [2,3] 有最大乘积 6。
//    示例 2:
//
//    输入: [-2,0,-1]
//    输出: 0
//    解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int iMin = nums[0]; // 记录到当前节点i时，当前乘积最小的值
        int iMax = nums[0]; // 记录到当前节点i时，当前乘积最大的值

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }
            iMax = Math.max(iMax * nums[i], nums[i]);
            iMin = Math.min(iMin * nums[i], nums[i]);

            max = Math.max(max, iMax);
        }
        return max;
    }
}

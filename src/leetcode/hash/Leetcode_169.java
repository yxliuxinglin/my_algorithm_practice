package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  HashMap实现
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @author l00365373
 * @since 2020-06-08
 */
class Leetcode_169 {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.getOrDefault(nums[i], 0);  // 如果map中可以找到nums[i]，返回map的value；否则找不到返回0
            count++;
            if (count > nums.length/2) {
                return nums[i];
            }
            map.put(nums[i], count);
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int count = majorityElement(nums);
        System.out.println(count);
    }
}

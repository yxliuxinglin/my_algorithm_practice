package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 标签：数组、哈希
 *
 * @author l00365373
 * @since 2020-06-11
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Leetcode_1 {
//     vector<int> twoSum(vector<int> &numbers, int target) {
//         vector<int> result;
//         map<int, int> hmap;
//
//         for (int i = 0; i < numbers.size(); i++) {
//             if (hmap.find(numbers[i]) == hmap.end())  //没有找到
//                 hmap.insert(pair<int, int>(numbers[i],i));
//
//             int x = target- numbers[i];  //另一个元素
//             if (hmap.find(x) != hmap.end() && hmap[x] != i) {  //找到了另一个元素(避免相同元素的情况)
//                 result.push_back(hmap[x]+1);
//                 result.push_back(i+1);
//                 break;
//             }
//         }
//
//         return result;
//     }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

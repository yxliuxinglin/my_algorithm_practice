package leetcode.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 考点：Hash 堆
 *
 * 692. 前K个高频单词
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *  
 *
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *  
 *
 * 注意：
 *
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 *  
 *
 * 扩展练习：
 *
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 */
class Leetcode_692 {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        // String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 6;

        List<String> result = topKFrequent(words, k);
        System.out.println(result);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        // 定义一个hashmap来存储各个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            Integer count = map.getOrDefault(word, 0);  // 如果map中可以找到word，返回map的value；否则找不到返回0
            count++;
            map.put(word, count);
        }

        // 使用Java的优先级队列定义一个最小堆
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k + 1,
            new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if (o1.getValue() == o2.getValue()) {
                        return o2.getKey().compareTo(o1.getKey());  // 注意
                    }
                    return o1.getValue().compareTo(o2.getValue());
                }
        });

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());  // Java的优先队列每次取最小元素，C++的优先队列每次取最大元素
        }

        Collections.reverse(result);  // 注意 使用最小堆的麻烦之处在于，最后输出元素时，得逆序一下子才行。不然就是频率从小到大排序了
        return result;
    }
}

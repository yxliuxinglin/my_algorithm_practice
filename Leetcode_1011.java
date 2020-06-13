/**
 * 标签：数组、二分查找
 */

//       示例 1：
//
//        输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
//        输出：15
//        解释：
//        船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
//        第 1 天：1, 2, 3, 4, 5
//        第 2 天：6, 7
//        第 3 天：8
//        第 4 天：9
//        第 5 天：10
//
//        请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
//        示例 2：
//
//        输入：weights = [3,2,2,4,1,4], D = 3
//        输出：6
//        解释：
//        船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
//        第 1 天：3, 2
//        第 2 天：2, 4
//        第 3 天：1, 4
//        示例 3：
//
//        输入：weights = [1,2,3,1,1], D = 4
//        输出：3
//        解释：
//        第 1 天：1
//        第 2 天：2
//        第 3 天：3
//        第 4 天：1, 1
//         
//
//        提示：
//
//        1 <= D <= weights.length <= 50000
//        1 <= weights[i] <= 500

import java.util.Arrays;

public class Leetcode_1011 {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        System.out.println(shipWithinDays(weights, D));
    }

    public static int shipWithinDays(int[] weights, int D) {
        int lo = Arrays.stream(weights).max().getAsInt(); // 船的最低运载能力是所有包裹中的最大重量
        int hi = Arrays.stream(weights).sum();  // 船的最大运载能力是所有包裹重量总和即可（D为1天便可运送完成）
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(weights, D, mid)) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    }

    private static boolean canShip(int[] weights, int D, int K) {
        int cur = K; // cur 表示当前船的可用承载量
        for (int weight: weights) {
            if (weight > K) {
                return false;
            }
            if (weight > cur) {
                cur = K;
                D--;
            }
            cur -= weight;
        }
        return D > 0; // 能否在D天内运完
    }
}

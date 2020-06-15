package oj.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * 题目描述
 * 在七夕那天晚上，海绵宝宝去广场玩，他看到所有人衣服上面都有数字m，在广场上如果有两个人衣服上面的数字是一样的，那么他们就是一对情侣。海绵宝宝比较奇葩，他不想知道有多少对情侣，他想知道在广场上有多少人是单身(单身的意思就是，某个数字不能被匹配）。
 *
 * 解答要求
 * 时间限制：1000ms, 内存限制：64MB
 * 输入
 * 第一行给你一个数字n（0<n<=200000)。表示广场上有n个人。接下来给出n个整数，表示这n个人衣服上面的数字（由于衣服不是很大，所以写不了很大的数字，这数字的范围是0<=m<=100000。
 *
 * 输出
 * 输出单身的人数。
 *
 * 样例
 * 输入样例 1 复制
 *
 * 5
 * 1 1 2 2 3
 * 输出样例 1
 *
 * 1
 *
 * 提示
 * 开bool数组，用下标表示衣服上面的数字，如果某个数字出现，则取反（初始全为0）。
 * 查询整个区间为1的，进行统计，最后输出结果。
 *
 */
class OJ_282 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            Map<Integer, Integer> map = new HashMap<>();
            int num = in.nextInt();  // 数字个数
            int result = num;  // 先假定所有人都是单身狗
            if (num < 0 || num > 200000) {
                System.out.println("0");
                return;
            }

            for (int i = 0; i < num; i++) {
                int m = in.nextInt();
                if (m < 0 || num > 100000) {
                    System.out.println("0");
                    return;
                }
                if ( map.getOrDefault(m, -1) == -1) {  // 如果map中没有数字，存入map
                    map.put(m, 1);
                } else {  // 否则，说明map中已有相同的数字。说明至此，此数字已经出现第二次，说明有2人非单身狗，从总数中减去2
                    result -= 2;
                }
            }

            System.out.println(result);
        }
    }
}

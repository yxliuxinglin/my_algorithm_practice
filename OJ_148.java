import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 小华给小为出了一道难题，小华给出了N（N<=100000）个数，这N个数是由一个整数经过“最优拆分”得到的，他问小为最优拆分的代价X是多少。
 * “最优拆分”定义为：
 * 1.可以将一个整数T拆分为A+B+C三部分，将消耗代价T；
 * 2.在多次拆分之后，代价总和最小的拆分方法叫做最优拆分，代价总和为最优拆分的代价。
 * 小为被这道题难住了，聪明的你能帮助小为解决这个问题吗？
 *
 * 解答要求
 * 时间限制：1000ms, 内存限制：64MB
 * 输入
 * 第一行一个数N，含义如题。
 * 第二行N个数，表示拆分后的N个数， 用空格隔开。
 *
 * 输出
 * 仅一行，最小代价X % 10000007的值。
 *
 * 样例
 * 输入样例 1 复制
 *
 * 3
 * 1 2 3
 * 输出样例 1
 *
 * 6
 *
 * 提示
 * 每次合并最小的三个数。
 * 使用小根堆即可在合适的复杂度内解决问题。
 */
class OJ_148 {
    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        while (in.hasNext()) {
            Queue<Long> minHeap = new PriorityQueue<>();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                minHeap.add(in.nextLong());
            }

            long sum = 0;
            long temp;
            while (minHeap.size() >= 3) {
                temp = 0;
                temp += minHeap.remove();
                temp += minHeap.remove();
                temp += minHeap.remove();
                sum += temp;
                minHeap.add(temp);
            }

            // 如果还有两个，就还需要再做一次加法。sum需要加上这次计算。如果只剩一个数，就不需要再加。
            if (minHeap.size() > 1) {
                sum += minHeap.poll();
                sum += minHeap.poll();
            }
            System.out.println(sum % 10000007);
        }
    }
}

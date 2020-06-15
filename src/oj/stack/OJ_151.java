package oj.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 队列、栈应用
 * 当任意一人手中的牌全部出完时，游戏结束，而另一个人获胜。
 *
 * 题目描述
 * 苗苗今天很无聊，就喊来希希和他一起玩熊猫钓鱼的扑克游戏。苗苗找来一堆扑克，将其平均分成两份，每人拿一份，苗苗先拿出手中的第一张牌放在桌子上，然后希希也拿出手中第一张牌放在苗苗刚打出来的牌上面，就像这样两人交替出牌。出牌时，如果谁打出的牌与桌上某张牌牌面相同，就可以把两张相同牌以及夹在其中的所有牌全部取走，并且把自己赢得的牌按照桌面上从上到下(1号牌压在2号牌上，那么1号牌就是在上，2号牌就在下)摆放的顺序依次放回手牌末尾。当任意一人手中的牌全部出完时，游戏结束，而另一个人获胜。
 *
 * 解答要求
 * 时间限制：1000ms, 内存限制：64MB
 * 输入
 * 第一行输入一个正整数N（N<=100),表示一开始每人手中有多少张牌（两个人一开始手中牌数相等），接下来两行，每行N个数字，分别表示一开始苗苗手中的牌和希希手中的牌，每张牌的牌面为数字1～13中某一个（保证在有限的回合后产生获胜者）。
 *
 * 输出
 * 第一行输出产生获胜者的回合数。接下来一行，若最后苗苗获胜，输出“mm”，若希希获胜，则输出“xx”，接下来一行输出获胜者最后手中的牌。
 *
 * 样例
 * 输入样例 1 复制
 *
 * 6
 * 2 4 1 2 5 6
 * 3 1 3 5 6 4
 * 输出样例 1
 *
 * 25
 * xx
 * 6 5 2 3 4 1
 *
 * 提示
 * 熊猫钓鱼：
 * 模拟过程，两个人手中是队列，桌子就是栈，模拟队列和栈的进出过程即可
 */
class OJ_151 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            Queue<Integer> placardOfMiaomiao = new LinkedList<>();
            Queue<Integer> placardOfXixi = new LinkedList<>();
            generateData(input, placardOfMiaomiao, placardOfXixi);

            int round = playRound(placardOfMiaomiao, placardOfXixi);
            System.out.println(round);

            if (!placardOfMiaomiao.isEmpty()) {
                System.out.println("mm");
                printQueue(placardOfMiaomiao);
            } else {
                System.out.println("xx");
                printQueue(placardOfXixi);
            }
        }
    }

    private static void generateData(Scanner input, Queue<Integer> placardOfMiaomiao, Queue<Integer> placardOfXixi) {
        int placardNum = input.nextInt();  // 表示一开始每人手中有多少张牌
        for (int i = 0; i < placardNum; i++) {
            placardOfMiaomiao.offer(input.nextInt());
        }
        for (int i = 0; i < placardNum; i++) {
            placardOfXixi.offer(input.nextInt());
        }
    }

    private static int playRound(Queue<Integer> placardOfMiaomiao, Queue<Integer> placardOfXixi) {
        Stack<Integer> desk = new Stack<>();
        int round = 0;
        while (!placardOfMiaomiao.isEmpty() && !placardOfXixi.isEmpty()) {
            oneRound(desk, placardOfMiaomiao);
            oneRound(desk, placardOfXixi);
            round++;  // 两个人都出完一次牌，回合数加1
        }
        return round;
    }

    private static void oneRound(Stack<Integer> desk, Queue<Integer> player) {
        Integer card = player.poll();
        check(desk, player, card);
    }

    private static void check(Stack<Integer> desk, Queue<Integer> player, Integer placard) {
        if (desk.contains(placard)) {  // 如果桌上的牌面中包含选手将出的这张
            player.offer(placard);  // 直接收回此张牌
            while (desk.contains(placard)) {  // 持续判断
                player.offer(desk.pop());  // 从最上方的牌面依次收回，直到满足条件
            }
        } else {  // 否则，出牌放入桌子
            desk.add(placard);
        }
    }

    private static void printQueue(Queue<Integer> queue) {
        while (queue.size() > 1) {
            System.out.print(queue.poll());
            System.out.print(" ");
        }
        System.out.print(queue.poll());
    }
}

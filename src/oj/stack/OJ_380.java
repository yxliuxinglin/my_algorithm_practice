package oj.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 栈使用
 *
 * 题目描述
 * (1+(2+3)*(3+(8+0))+1-2)这是一个简单的数学表达式，今天不是计算它的值，而是比较它的括号匹配是否正确。前面这个式子可以简化为(()(()))这样的括号我们认为它是匹配正确的，而((())这样的我们就说他是错误的。注意括号里面的表达式可能是错的，也可能有多个空格，对于这些我们是不用去管的，我们只关心括号是否使用正确。
 *
 * 解答要求
 * 时间限制：1000ms, 内存限制：64MB
 * 输入
 * 给出一行表达式（长度不超过100）。
 *
 * 输出
 * 如果匹配正确输出括号的对数，否则输出-1。
 *
 * 样例
 * 输入样例 1 复制
 *
 * (1+(2+3)*(3+(8+0))+1-2)
 * 输出样例 1
 *
 * 4
 *
 * 提示
 * 对于栈的优先使用，利用push和pop操作来判断括号的匹配。
 */
class OJ_380 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        input.close();

        Stack<Character> bracketStack = new Stack<>();
        int num = 0;  // 统计括号对的个数
        int index = 0;

        for (; index < str.length(); index++) {
            char item = str.charAt(index);
            if (item == '(') {
                bracketStack.push(item);
            } else if (item == ')') {
                if (bracketStack.empty()) {  // 表示)比(多
                    break;
                } else {
                    bracketStack.pop();
                    num++;
                }
            }
        }

        // 如果已经遍历完了字符串，并且栈为空，表示匹配成功
        if (index == str.length() && bracketStack.empty()) {
            System.out.println(num);
        } else {
            System.out.println(-1);
        }
    }
}

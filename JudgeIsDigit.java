/**
 * 判断double类型数是否是整数
 *
 * 方法1：对1取模，结果为0表示是整数
 */

public class JudgeIsDigit {
    public static void main(String[] args) {
        int num = 9;
        double sqrt = Math.sqrt(num);
        boolean res = judge1(sqrt);
        System.out.println(res);
    }

    public static boolean judge1(double num) {
        if (num % 1 == 0) {
            return true;
        }
        return false;
    }
}

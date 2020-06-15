package leetcode.math;

/**
 * 整数反转
 * 标签：数学
 * @author l00365373
 * @since 2020-06-11
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Leetcode_7 {
    int reverse(int x) {
        int result = 0, temp = x, digit;
        int currrlt;

        while (temp != 0) {
            digit = temp % 10;
            temp /= 10;
            currrlt = result * 10;
            if (currrlt / 10 != result)
                return 0;
            result = result * 10 + digit;
        }

        return result;
    }

    // int reverse(int x) {
    //     int result = 0, temp = x, digit;
    //
    //     while (temp != 0) {
    //         digit = temp % 10;
    //         temp /= 10;
    //         if (result > 214748364 || result < -214748364)
    //             return 0;
    //         else
    //             result = result * 10 + digit;
    //     }
    //
    //     return result;
    // }

    // int reverse(int x) {
    //     int result = 0, temp = x, digit;
    //     int currrlt;
    //
    //     while (temp != 0) {
    //         digit = temp % 10;
    //         temp /= 10;
    //         currrlt = result * 10;
    //         if (currrlt / 10 != result)
    //             return 0;
    //         result = result * 10 + digit;
    //     }
    //
    //     if ((x >= 0 && result >= 0) || (x < 0 && result < 0))
    //         return result;
    //     return 0;
    // }
}

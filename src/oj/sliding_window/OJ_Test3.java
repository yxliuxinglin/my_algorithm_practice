package oj.sliding_window;/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * OJ考题代码：最佳升级时间窗
 *
 * @author 命题组
 * @since 2020-4-21
 *
 * 6
 * 1 2 3 4 5 6 7 8 9 10 11 12 12 11 10 9 8 7 6 5 4 3 2 1 1 2 3 4 5 6 7 8 9 10 11 12 12 11 10 9 8 7 6 5 4 3 2 1 1 2 3 4 5 6 7 8 9 10 11 12 12 11 10 9 8 7 6 5 4 3 2 1 1 2 3 4 5 6 7 8 9 10 11 12 12 11 10 9 8 7 6 5 4 3 2 1 1 2 3 4 5 6 7 8 9 10 11 12 12 11 10 9 8 7 6 5 4 3 2 1 1 2 3 4 5 6 7 8 9 10 11 12 12 11 10 9 8 7 6 5 4 3 2 1 1 2 3 4 5 6 7 8 9 10 11 12 12 11 10 9 8 7 6 5 4 3 2 1
 *
 * 7
 * 4 1 31 42 30 23 17 50 21 10 110 60 121 110 15 30 3 1 23 32 42 31 21 13 15 21 31 42 32 23 17 8 9 10 110 121 121 110 10 9 8 17 23 32 42 31 21 10 10 21 31 42 32 23 17 8 9 10 110 121 121 110 10 9 8 17 23 32 42 31 21 10 10 21 31 42 32 23 17 8 9 10 110 121 121 110 10 9 8 17 23 32 42 31 21 10 10 21 31 42 32 23 17 8 9 10 110 121 121 110 10 9 8 17 23 32 42 31 21 10 10 21 31 42 32 23 17 8 9 10 110 121 121 110 10 9 8 17 23 32 42 31 21 10 10 21 31 42 32 23 17 8 9 10 110 121 121 110 10 9 8 17 23 32 42 31 21 1
 */
public class OJ_Test3 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int pvErrorTolerance = Integer.parseInt(cin.nextLine());
        int[] pvByHourWeekly = new int[7 * 24];
        for (int i = 0; i < pvByHourWeekly.length; i++) {
            pvByHourWeekly[i] = cin.nextInt();
        }
        cin.close();
        int[] results = getBestTimeWindow(pvByHourWeekly, pvErrorTolerance);
        String[] strResult = Arrays.stream(results).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(String.join(" ", strResult));
    }

    private static int[] getBestTimeWindow(int[] pvByHourWeekly, int pvErrorTolerance) {
        int[] results = {-1, -1};

        if (pvByHourWeekly == null || pvByHourWeekly.length == 0 || pvErrorTolerance == 0) {
            return results;
        }

        scan(pvByHourWeekly, pvErrorTolerance, results);
        return results;
    }

    private static void scan(int[] pvByHourWeekly, int pvErrorTolerance, int[] results) {
        int sum = 0;
        int j = 0;
        int length = 0;  // 遍历每次符合条件的长度
        int maxLength = 0;  // 找到最大长度
        for (int i = 0; i < pvByHourWeekly.length; i++) {
            if (sum + pvByHourWeekly[i] <= pvErrorTolerance) {
                sum = sum + pvByHourWeekly[i];
                length = i-j;
            } else {
                maxLength = getMaxLength(results, j, length, maxLength, i);
                sum = 0;
                i=j;
                j++;
            }
        }

        if (sum <= pvErrorTolerance) {
            for (int i = 0; i < pvErrorTolerance; i++) {
                if (sum + pvByHourWeekly[i] <= pvErrorTolerance) {
                    sum = sum + pvByHourWeekly[i];
                    length++;
                } else {
                    getMaxLength(results, j, length, maxLength, i);
                    maxLength = getMaxLength(results, j, length, maxLength, i);
                    sum = 0;
                    i=j;
                    j++;
                }
            }
        }
    }

    private static int getMaxLength(int[] results, int j, int length, int maxLength, int i) {
        if (maxLength < length) {  // 本次扫描的长度更长
            maxLength = length;
            results[0] = j;
            results[1] = i-1;
        }
        return maxLength;
    }
}

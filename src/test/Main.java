package test;/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2014-2020. All rights reserved.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author MANO PDU
 * @since LCM R19
 */
public class Main {
    private static final String HKD = "HKD";

    private static final String CNY = "CNY";

    private static final String USD = "USD";

    private static final String GBP = "GBP";

    private static final String MIN = "MIN";

    private static final String MAX = "MAX";

    private static final String ERROR = "ERROR";

    private static final String SEPARATER = " ";

    private static final List<String> moneyTypes = new ArrayList<>(Arrays.asList(CNY, HKD, USD, GBP));

    private static final List<String> convertTypes = new ArrayList<>(Arrays.asList(MIN, MAX));

    /**
     * 实现最大/最小兑换
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String input = in.nextLine();

            // 参数校验
            if (!checkParam(input)) {
                System.out.println(ERROR);
                continue;
            }

            // 生成兑换表
            String[] items = input.split(SEPARATER);
            ExchangeTable exchangeTable = new ExchangeTable(Integer.parseInt(items[0]), Integer.parseInt(items[1]),
                Integer.parseInt(items[2]));

            // 转换为最小货币HKD
            int totalHkd = exchangeTable.convert2Hkd(Integer.parseInt(items[3]), items[4]);
            if (totalHkd < 1) {
                System.out.println(ERROR);
                continue;
            }

            // 输出兑换结果
            if (MIN.equals(items[5])) {
                System.out.println(totalHkd + SEPARATER + HKD);
                continue;
            }
            System.out.println(exchangeTable.convert2Max(totalHkd));
        }
    }

    /**
     * 进行参数校验
     *
     * @param input 输入字符串
     * @return 校验结果。true表示参数合法
     */
    private static boolean checkParam(String input) {
        if (input == null || "".equals(input) || !input.contains(SEPARATER)) {
            return false;
        }
        String[] items = input.split(SEPARATER);
        if (items.length != 6) {
            // 不是6个数据，校验失败
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (!isNumeric(items[i]) || items[i].contains(".")) {
                // 不是数字类型字符串，或者包含小数点，校验失败
                return false;
            }
            int value = Integer.parseInt(items[i]);
            if (value < 1) {
                // 包含负数，校验失败
                return false;
            }
        }
        // 不是指定的货币类型的兑换方式，校验失败
        return (validMoneyType(items[4])) && (validConvertType(items[5]));
    }

    /**
     * 校验字符串是否是数值类型的
     *
     * @param cs 字符串
     * @return 字符串是否是数值类型的
     */
    private static boolean isNumeric(CharSequence cs) {
        if (cs == null || cs.length() == 0) {
            return false;
        } else {
            int sz = cs.length();
            for (int i = 0; i < sz; ++i) {
                if (!Character.isDigit(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean validMoneyType(String type) {
        return moneyTypes.contains(type);
    }

    private static boolean validConvertType(String type) {
        return convertTypes.contains(type);
    }

    /**
     * 货币价值表
     */
    public static class ExchangeTable {
        /**
         * 每个gbp价值多少hkd
         */
        private int gbp;

        /**
         * 每个usd价值多少hkd
         */
        private int usd;

        /**
         * 每个cny价值多少hkd
         */
        private int cny;

        /**
         * 每个hkd价值多少hkd
         */
        private int hkd;

        ExchangeTable(int hkdsPerCny, int cnysPerUsd, int usdsPerGbp) {
            this.hkd = 1;
            this.cny = hkdsPerCny;
            this.usd = cnysPerUsd * hkdsPerCny;
            this.gbp = usdsPerGbp * cnysPerUsd * hkdsPerCny;
        }

        /**
         * 指定类型的指定数量货币，能兑换的HKD的数量
         *
         * @param total 货币数量
         * @param moneyType 货币类型
         * @return 能兑换的HKD的数量
         */
        int convert2Hkd(int total, String moneyType) {
            switch (moneyType) {
                case HKD:
                    return total;
                case CNY:
                    return total * getCny();
                case USD:
                    return total * getUsd();
                case GBP:
                    return total * getGbp();
                default:
                    return -1;
            }
        }

        /**
         * 指定数量的HKD，能够进行的最大兑换
         *
         * @param total 货币数量
         * @return 最大兑换信息
         */
        String convert2Max(int total) {
            int tempTotal = total;
            StringBuilder sb = new StringBuilder();

            int gbpNum = tempTotal / getGbp();
            if (gbpNum > 0) {
                sb.append(SEPARATER).append(gbpNum).append(SEPARATER).append(GBP);
            }
            tempTotal = tempTotal % getGbp();

            int usdNum = tempTotal / getUsd();
            if (usdNum > 0) {
                sb.append(SEPARATER).append(usdNum).append(SEPARATER).append(USD);
            }
            tempTotal = tempTotal % getUsd();

            int cnyNum = tempTotal / getCny();
            if (cnyNum > 0) {
                sb.append(SEPARATER).append(cnyNum).append(SEPARATER).append(CNY);
            }

            int hkdNum = tempTotal % getCny();
            if (hkdNum > 0) {
                sb.append(SEPARATER).append(hkdNum).append(SEPARATER).append(HKD);
            }
            return sb.toString().substring(1);
        }

        int getGbp() {
            return gbp;
        }

        int getUsd() {
            return usd;
        }

        int getCny() {
            return cny;
        }

        int getHkd() {
            return hkd;
        }
    }
}
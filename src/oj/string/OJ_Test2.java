package oj.string;/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * OJ考题代码：整理工号
 *
 * @author 命题组
 * @since 2020-3-9
 *
 * 8
 * ss789
 * 12n00
 * s00123
 * k2 3490
 * S123
 * s234
 * x235
 * m990
 */
public class OJ_Test2 {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int num = Integer.parseInt(cin.nextLine());
        String[] cardIds = new String[num];
        for (int i = 0; i < num; i++) {
            cardIds[i] = cin.nextLine();
        }
        cin.close();
        String[] results = regularID(cardIds);
        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String[] regularID(String[] cardIds) {
        String[] results = {};

        int i = 0;
        for (String cardId : cardIds) {
            String result = generateResult(cardId);
            if (result != "") {
                results[i++] = result;
            }
        }
        return results;
    }

    private static String generateResult(String cardId) {
        if ((cardId.charAt(0) < 'a' || cardId.charAt(0) > 'z') && (cardId.charAt(0) < 'A' || cardId.charAt(0) > 'Z')){
            return "";
        }

        String str = cardId.trim();
        StringBuilder cardIdNoWhitespace = new StringBuilder();
        cardIdNoWhitespace.append(cardId.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && cardId.charAt(0) > '0' && cardId.charAt(0) > '9') {
                cardIdNoWhitespace.append(str.charAt(i));
            }
        }
        if (cardIdNoWhitespace.length() < 9) {
            int zeroNum = 9-cardIdNoWhitespace.length();
            StringBuilder prifix = new StringBuilder();
            prifix.append(cardIdNoWhitespace.charAt(0));
            for (int i = 1; i < zeroNum+1; i++) {
                prifix.append('0');
            }
            cardIdNoWhitespace = prifix.append(cardIdNoWhitespace.subSequence(1, cardIdNoWhitespace.length()));
        }

        return cardIdNoWhitespace.toString();
    }
}

package oj.math;

/**
 * 功能描述
 *
 * @author l00365373
 * @since 2020-06-15
 */
class OJ_Test1 {
    private static String[] transpose(String[] input) {
        if (input == null || input.length == 0) {
            return new String[0];
        }

        String[] results = getStrings(input);
        return results;
    }

    private static String[] getStrings(String[] input) {
        String[] results = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            if (!isStrValid(input[i])) {
                results[i] = "ERROR";
            } else {
                int rowSize = (int) Math.sqrt(input[i].length());
                results[i] = generateResult(input[i], rowSize);
            }
        }
        return results;
    }

    private static boolean isStrValid(String input) {
        int length = input.length();
        double sqrtValue = Math.sqrt(length);
        int ceilValue = (int) Math.ceil(sqrtValue);
        if (Math.pow(ceilValue, 2)-length > 1E-6) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) > '9' || input.charAt(i) < '0') {
                return false;
            }
        }

        return true;
    }

    private static String generateResult(String input, int size) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.append(input.charAt(i+j*size));
            }
        }
        return result.toString();
    }
}

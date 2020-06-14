//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//        每行中的整数从左到右按升序排列。
//        每行的第一个整数大于前一行的最后一个整数。
//        示例 1:
//
//        输入:
//        matrix = [
//        [1,   3,  5,  7],
//        [10, 11, 16, 20],
//        [23, 30, 34, 50]
//        ]
//        target = 3
//        输出: true
//        示例 2:
//
//        输入:
//        matrix = [
//        [1,   3,  5,  7],
//        [10, 11, 16, 20],
//        [23, 30, 34, 50]
//        ]
//        target = 13
//        输出: false

/*
 * 最大子序和
 * 第一遍：朴素算法。。把二维数组转换成一个升序一维数组，进行二分查找，时间复杂度不好。。
 * 标签：数组、二分查找
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_74 {
//    public static boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix == null || matrix.length == 0) {
//            return false;
//        }
//
//        List<Integer> nums = new ArrayList<>();
//        int ans = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                nums.add(matrix[i][j]);
//            }
//        }
//
//        return findTarget(nums, target);
//    }
//
//    private static boolean findTarget(List<Integer> nums, int target) {
//        if (nums == null || nums.size() == 0) {
//            return false;
//        }
//
//        int lo = 0, hi = nums.size()-1;
//        while (lo < hi) {
//            int mid = lo + (hi - lo) / 2;
//            if (nums.get(mid) == target) {
//                return true;
//            }
//            if (nums.get(mid) > target) {
//                hi = mid-1;
//            } else {
//                lo = mid+1;
//            }
//        }
//        return nums.get(lo) == target;
//    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }

        int m = matrix.length;
        if(m == 0) {
            return false;
        }

        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while(i >= 0 && j < n) {
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int target = 1;
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
//        int [][] matrix = {{1, 3, 5}};
//        int [][] matrix = {{1, 3}};
        boolean res = searchMatrix(matrix, target);
        System.out.println(res);
    }
}

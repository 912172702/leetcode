package lc956;

import java.util.Arrays;

/**
 * @Author: Knox
 * @Date: 2018-12-17 21:21
 * @Description: 设二维数组a[i][j]为从0到i个数字中组成长度为j的组数，则有。
 * a[i][rod[i]] += 1;
 * a[i][j] = a[i][j - rods[i]] + a[i - 1][j - rods[i]](j >= rods[i])
 * a[i][j] = a[i - 1][j]( j < rods[i])
 * @Version 1.0
 */
public class LeetCode956 {
    public static void main(String[] args) {

        System.out.println(new Solution().tallestBillboard(new int[]{2, 3, 3, 5, 76}));

    }
}

//class Solution {
//    public int tallestBillboard(int[] rods) {
//        if (rods.length == 0) return 0;
//        Arrays.sort(rods);
//        int[][] a = new int[21][5001];
//
////        for (int i = 0; i < rods.length; i++) {
////            a[i][rods[i]] += 1;
////        }
//        a[0][rods[0]] += 1;
//        int sum = rods[0];
//        for (int i = 1; i < rods.length; i++) {
//            a[i][rods[i]] += 1;
//            sum += rods[i];
//            for (int j = 0; j <= sum; j++) {
//                if (j >= rods[i])
//                    a[i][j] += (a[i - 1][j - rods[i]] > 0 ? 1 : 0) + a[i - 1][j];
//                else
//                    a[i][j] += a[i - 1][j];
//            }
//        }
//
//        for (int i = sum / 2; i >= 0; i--) {
//            if (a[rods.length - 1][i] >= 2)
//                return i;
//        }
//        return 0;
//    }
//}

package lc956;

import java.util.Arrays;

/**
 * @Author: Knox
 * @Date: 2018-12-18 16:49
 * @Description: a[i][j] 表示前i个数字组成的两个集合中差别为j的最大集合的大小。
 * a[i][j] = a[i - 1][j - rods[i]] + rods[i] 将rods[i]加在大的集合里
 * a[i - 1][j + rods[i]] 将rods[i]加在小的集合里
 * a[i - 1][j]
 * 上面选max 且j >= rods[i]
 * 当j < rods[i]时候
 * <p>
 * a[i][j] = max a[i - 1][j + rods[i]]
 * <p>
 * a[i - 1][j]
 * @Version 1.0
 */
public class other {
    public static void main(String[] args) {
        System.out.println(new Solution().tallestBillboard(new int[]{2, 3, 3, 5, 76}));
    }
}

class Solution {
    public int tallestBillboard(int[] rods) {
        int[][] a = new int[22][5001];

        //a[0][rods[0]] = rods[0];
        int inf = 0x3f3f3f3f;
        for (int i = 0; i < 22; i++)
            for (int j = 0; j < 5001; j++)
                a[i][j] = -inf;

        a[0][0] = 0;
        for (int i = 0; i < rods.length; i++)
            for (int j = 0; j <= 5000; j++) {

                a[i + 1][j] = Math.max(a[i][j], a[i + 1][j]);
                if (j + rods[i] <= 5000)
                    a[i + 1][j] = Math.max(a[i + 1][j], a[i][j + rods[i]]);

                if (j >= rods[i] && a[i][j - rods[i]] != -inf)
                    a[i + 1][j] = Math.max(a[i + 1][j], a[i][j - rods[i]] + rods[i]);

                if (rods[i] >= j && a[i][rods[i] - j] != -inf)
                    a[i + 1][j] = Math.max(a[i + 1][j], j + a[i][rods[i] - j]);
            }
        return Math.max(a[rods.length][0], 0);
    }
}
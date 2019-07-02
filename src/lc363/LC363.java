package lc363;

/**
 * @Author: Knox
 * @Date: 2019-04-16 09:50
 * @Description: You Know
 * @Version 1.0
 */
//class Solution {
//    private int maxSum = Integer.MIN_VALUE;
//
//    private void deep(int[][] matrix, int sum, int rb, int re, int cb, int ce, int k) {
//
//        // System.out.println(sum + " " + rb + " " + re + " " + cb + " " + ce);
//        if (rb >= re || cb >= ce) return;
//        if (sum <= k && sum > maxSum)
//            maxSum = sum;
//
//        int sump = 0;
//        for (int i = rb; i < re; i++) sump += matrix[i][cb];
//        deep(matrix, sum - sump, rb, re, cb + 1, ce, k);
//
//        sump = 0;
//        for (int i = rb; i < re; i++) sump += matrix[i][ce - 1];
//        deep(matrix, sum - sump, rb, re, cb, ce - 1, k);
//
//        sump = 0;
//        for (int i = cb; i < ce; i++) sump += matrix[rb][i];
//        deep(matrix, sum - sump, rb + 1, re, cb, ce, k);
//
//        sump = 0;
//        for (int i = cb; i < ce; i++) sump += matrix[re - 1][i];
//        deep(matrix, sum - sump, rb, re - 1, cb, ce, k);
//    }
//
//    public int maxSumSubmatrix(int[][] matrix, int k) {
//        int row = matrix.length;
//        int col = matrix[0].length;
//        int sum = 0;
//        int[][][] rowNums = new int[row][col][col], colNums = new int[col][row][row];
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                sum += matrix[i][j];
//            }
//        }
//        deep(matrix, sum, 0, row, 0, col, k);
//        return maxSum;
//    }
//}

//class Solution {
//    private int maxSum = Integer.MIN_VALUE;
//
//    private void deep(int sum, int rb, int re, int cb, int ce, int k, int[][][] rowNums, int[][][] colNums) {
//        //System.out.println(sum);
//        if (rb >= re || cb >= ce) return;
//        if (sum <= k && sum > maxSum) {
//            maxSum = sum;
//            if (maxSum == k) return;
//            //System.out.println(maxSum);
//        }
//        deep(sum - colNums[cb][rb][re - 1], rb, re, cb + 1, ce, k, rowNums, colNums);
//        deep(sum - colNums[ce - 1][rb][re - 1], rb, re, cb, ce - 1, k, rowNums, colNums);
//        deep(sum - rowNums[rb][cb][ce - 1], rb + 1, re, cb, ce, k, rowNums, colNums);
//        deep(sum - rowNums[re - 1][cb][ce - 1], rb, re - 1, cb, ce, k, rowNums, colNums);
//    }
//
//    public int maxSumSubmatrix(int[][] matrix, int k) {
//        int row = matrix.length;
//        int col = matrix[0].length;
//        int sum = 0;
//        int[][][] rowNums = new int[row][col][col], colNums = new int[col][row][row];
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                sum += matrix[i][j];
//            }
//        }
//
//        for (int i = 0; i < row; i++) {
//
//            for (int m = 0; m < col; m++) {
//                rowNums[i][m][m] = matrix[i][m];
//            }
//            for (int j = 1; j < col; j++) {
//                for (int m = 0; m < col - j; m++) {
//                    rowNums[i][m][m + j] = rowNums[i][m][m + j - 1] + matrix[i][m + j];
//                }
//            }
//        }
//
//        for (int i = 0; i < col; i++) {
//            for (int m = 0; m < row; m++) {
//                colNums[i][m][m] = matrix[m][i];
//            }
//            for (int j = 1; j < row; j++) {
//                for (int m = 0; m < row - j; m++) {
//                    colNums[i][m][m + j] = colNums[i][m][m + j - 1] + matrix[m + j][i];
//                }
//            }
//        }
//        deep(sum, 0, row, 0, col, k, rowNums, colNums);
//        return maxSum;
//    }
//}


class Solution {


    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int res = Integer.MIN_VALUE;
        int[][] dp = new int[row + 1][col + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                for (int m = 0; m < i; m++) {
                    for (int n = 0; n < j; n++) {
                        int square = dp[i][j] - dp[m][j] - dp[i][n] + dp[m][n];
                        if (square == k) return k;
                        if (square < k) res = Math.max(res, square);
                    }
                }
            }
        }
        return res;
    }
}


//class Solution {
//    public int maxSumSubmatrix(int[][] matrix, int k) {
//        if(matrix.length==0||matrix[0].length==0){
//            return 0;
//        }
//        int n=matrix.length;
//        int m=matrix[0].length;
//
//        int[][] dp=new int[n+1][m+1];
//        for(int i=1;i<=n;++i){
//            for(int j=1;j<=m;++j){
//                dp[i][j]=matrix[i-1][j-1]+dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];//求(0,0)到(i,j)的面积
//            }
//        }
//        int ans=-0x7FFFFFF;
//        for(int i=1;i<=n;++i){
//            for(int j=1;j<=m;++j){
//                for(int t=0;t<i;++t){
//                    for(int z=0;z<j;++z){
//                        int rt=dp[i][j]-dp[t][j]-dp[i][z]+dp[t][z];
//                        if(rt==k){ //遇到k即可跳出
//                            return k;
//                        }
//                        if(rt<k){
//                            ans=Math.max(ans,rt);
//                        }
//                    }
//                }
//            }
//        }
//        return ans;
//    }
//}
public class LC363 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
        System.out.println(new Solution().maxSumSubmatrix(new int[][]{{2, 2, -1}}, 0));

        System.out.println(new Solution().maxSumSubmatrix(new int[][]{{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}}, 10));
        System.out.println(new Solution().maxSumSubmatrix(new int[][]{{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}}, 3));
        System.out.println(new Solution().maxSumSubmatrix(new int[][]{{27, 5, -20, -9, 1, 26, 1, 12, 7, -4, 8, 7, -1, 5, 8}, {16, 28, 8, 3, 16, 28, -10, -7, -5, -13, 7, 9, 20, -9, 26}, {24, -14, 20, 23, 25, -16, -15, 8, 8, -6, -14, -6, 12, -19, -13}, {28, 13, -17, 20, -3, -18, 12, 5, 1, 25, 25, -14, 22, 17, 12}, {7, 29, -12, 5, -5, 26, -5, 10, -5, 24, -9, -19, 20, 0, 18}, {-7, -11, -8, 12, 19, 18, -15, 17, 7, -1, -11, -10, -1, 25, 17}, {-3, -20, -20, -7, 14, -12, 22, 1, -9, 11, 14, -16, -5, -12, 14}, {-20, -4, -17, 3, 3, -18, 22, -13, -1, 16, -11, 29, 17, -2, 22}, {23, -15, 24, 26, 28, -13, 10, 18, -6, 29, 27, -19, -19, -8, 0}, {5, 9, 23, 11, -4, -20, 18, 29, -6, -4, -11, 21, -6, 24, 12}, {13, 16, 0, -20, 22, 21, 26, -3, 15, 14, 26, 17, 19, 20, -5}, {15, 1, 22, -6, 1, -9, 0, 21, 12, 27, 5, 8, 8, 18, -1}, {15, 29, 13, 6, -11, 7, -6, 27, 22, 18, 22, -3, -9, 20, 14}, {26, -6, 12, -10, 0, 26, 10, 1, 11, -10, -16, -18, 29, 8, -8}, {-19, 14, 15, 18, -10, 24, -9, -7, -19, -14, 23, 23, 17, -5, 6}}, -100));
    }
}

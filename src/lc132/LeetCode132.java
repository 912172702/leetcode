package lc132;

/**
 * @Author: Knox
 * @Date: 2018/12/7 2:36 PM
 * @Description: You Know
 * @Version 1.0
 */
public class LeetCode132 {
    public static void main(String[] args) {
        System.out.println(new Solution().minCut("aabbaa"));
        System.out.println(new Solution().minCut("dsdsddsffdsfds"));
        System.out.println(new Solution().minCut("wedswes"));
        System.out.println(new Solution().minCut("vfddsdede"));
    }
}

class Solution {
    public int minCut(String s) {
        int length = s.length();
        int[] dp = new int[length];
        boolean[][] is = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            //if (dp[i] == 0) continue;
            int min = length;
            for (int j = 0; j <= i; j++) {
                if (i == j || (s.charAt(j) == s.charAt(i) && (i - j == 1 || is[j + 1][i - 1]))) {
                    is[j][i] = true;
                    min = (j == 0) ? 0 : Math.min(min, dp[j - 1] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[length - 1];
    }
}
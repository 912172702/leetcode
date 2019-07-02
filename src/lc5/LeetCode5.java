package lc5;

/**
 * @Author: Knox
 * @Date: 2018-12-25 11:12
 * @Description: You Know
 * @Version 1.0
 */
public class LeetCode5 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("88776677887766"));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";

        int max = 1;
        int st = 0;
        int en = 1;
        int len = s.length();
        boolean[][] is = new boolean[len][len];


        for (int i = 0; i < len - 1; i++)
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 <= max)
                    continue;

                if (i > 0 && j < len - 1) {
                    if (is[i - 1][j + 1]) {
                        is[i][j] = true;
                        continue;
                    }
                }
                is[i][j] = isPalindrome(s.substring(i, j + 1));
                if (is[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    st = i;
                    en = j + 1;
                }
            }
        return s.substring(st, en);
    }

    boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }

}
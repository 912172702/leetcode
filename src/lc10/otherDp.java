package lc10;

/**
 * @Author: Knox
 * @Date: 2018-12-25 17:59
 * @Description: You Know
 * @Version 1.0
 */
public class otherDp {
    public static void main(String[] args) {
        System.out.println("should true, fact " + new Solution().isMatch("ab", ".*"));
        System.out.println("should true, fact " + new Solution().isMatch("aab", "c*a*b"));
        System.out.println("should false, fact " + new Solution().isMatch("mississippi", "mis*is*p*."));
        System.out.println("should true, fact " + new Solution().isMatch("mississippi", "mis*is*ip*."));
        System.out.println("should true, fact " + new Solution().isMatch("aaa", "a*a"));
        System.out.println("should true, fact " + new Solution().isMatch("aaa", "ab*a*c*a"));
        System.out.println("should false, fact " + new Solution().isMatch("aaba", "ab*a*c*a"));
    }
}


class Solution {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        if (m == 0 && n == 0) return true;

        boolean[][] match = new boolean[m + 1][n + 1];

        match[0][0] = true;
        for (int i = 1; i <= n; i++) {
            match[0][i] = i > 1 && p.charAt(i - 1) == '*' && match[0][i - 2];
        }
        for (int i = 1; i <= m; i++) {
            match[i][0] = false;
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(p.charAt(j - 1) != '*'){
                    //p的当前字符不是*
                    match[i][j] = match[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }else{
                    match[i][j] = match[i][j  - 2] || (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && match[i - 1][j];
                }
            }
        }
        return match[m][n];
    }


}
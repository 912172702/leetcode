//package lc32;
//
///**
// * @Author: Knox
// * @Date: 2018-12-26 11:23
// * @Description: You Know
// * @Version 1.0
// */
//public class LeetCode32 {
//    public static void main(String[] args) {
//        //System.out.println(new Solution().longestValidParentheses(")(((((()())()()))()(()))("));
//        System.out.println(new Solution().longestValidParentheses("((((()())()()))()(()))"));
//        //System.out.println(new Solution().longestValidParentheses("((()(())()))"));
//
//    }
//}
//
//class Solution {
//    int max = 0;
//    int st = 0;
//    int en = 0;
//
//    public int longestValidParentheses(String s) {
//        //System.out.println(s.length());
//        boolean[][] match = new boolean[s.length()][s.length()];
//
//        //初始化
//        for (int i = 0; i < s.length(); i++) {
//            match[i][i] = false;
//            if (i < s.length() - 1) {
//                match[i][i + 1] = s.charAt(i) == '(' && s.charAt(i + 1) == ')';
//            }
//        }
//        for (int i = 0; i < s.length(); i++)
//            for (int j = i + 1; j < s.length(); j++) {
//                if (isMatch(s, match, i, j)) {
//                    if (j - i + 1 > max) {
//                        max = j - i + 1;
//                        st = i;
//                        en = j + 1;
//                    }
//                }
//            }
//        System.out.println(s.substring(st, en));
//        return max;
//    }
//
//    boolean isMatch(String s, boolean[][] match, int i, int j) {
//        if (match[i][j]) return true;
//        if (s.charAt(i) == ')' || s.charAt(j) == '(') {
//        } else if ((i > 0 && j < s.length() - 1) && match[i - 1][j + 1]) match[i][j] = true;
//        else if (j > 1 && match[i][j - 2] && s.charAt(j - 1) == '(' && s.charAt(j - 2) == ')') match[i][j] = true;
//        else if (i + 1 < j - 1) {
//            if (match[i + 1][j - 1])
//                match[i][j] = true;
//            else {
//                match[i][j] = isMatch(s, match, i + 1, j - 1);
//            }
//            if (!match[i][j]) {
//                for (int k = i + 1; k < j; k++) {
//                    if (match[i][k] && isMatch(s, match, k + 1, j)) {
//                        match[i][j] = true;
//                        break;
//                    }
//                }
//            }
//        }
//        return match[i][j];
//    }
//}

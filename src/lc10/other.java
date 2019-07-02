package lc10;

/**
 * @Author: Knox
 * @Date: 2018-12-25 17:28
 * @Description: You Know
 * @Version 1.0
// */
//public class other {
//    public static void main(String[] args) {
//        System.out.println("should true, fact " + new Solution().isMatch("ab", ".*"));
//        System.out.println("should true, fact " + new Solution().isMatch("aab", "c*a*b"));
//        System.out.println("should false, fact " + new Solution().isMatch("mississippi", "mis*is*p*."));
//        System.out.println("should true, fact " + new Solution().isMatch("mississippi", "mis*is*ip*."));
//        System.out.println("should true, fact " + new Solution().isMatch("aaa", "a*a"));
//        System.out.println("should true, fact " + new Solution().isMatch("aaa", "ab*a*c*a"));
//        System.out.println("should false, fact " + new Solution().isMatch("aaba", "ab*a*c*a"));
//    }
//}

//class Solution {
//    public boolean isMatch(String s, String p) {
//        if (s.length() == 0 && p.length() == 0)
//            return true;
//        if (s.length() != 0 && p.length() == 0)
//            return false;
//
//        if (p.length() > 1 && p.charAt(1) == '*') {
//            if (s.length() > 0 && p.charAt(0) == '.')
//                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
//            if (s.length() > 0 && s.charAt(0) == p.charAt(0))
//                return isMatch(s.substring(1), p) || isMatch(s,p.substring(2));
//            return isMatch(s, p.substring(2));
//        }
//        if (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'))
//            return isMatch(s.substring(1), p.substring(1));
//        return false;
//    }
//}
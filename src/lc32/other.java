package lc32;

/**
 * @Author: Knox
 * @Date: 2018-12-26 14:02
 * @Description: You Know
 * @Version 1.0
 */
public class other {
    public static void main(String[] args) {
//        System.out.println(new Solution().longestValidParentheses(")(((((()())()()))()(()))("));
//        System.out.println(new Solution().longestValidParentheses("((((()())()()))()(()))"));
//        System.out.println(new Solution().longestValidParentheses("((()(())()))"));
//        System.out.println(new Solution().longestValidParentheses("())"));
        System.out.println(new Solution().longestValidParentheses("())"));
    }
}

//class Solution {
//
//
//    public int longestValidParentheses(String s) {
//        int max = 0;
//        int[] dp = new int[s.length()];
//        int pre;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(')
//                dp[i] = 0;
//            else if (i > 0) {
//                pre = i - dp[i - 1] - 1;
//                if (pre >= 0 && s.charAt(pre) == '(')
//                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
//                max = max < dp[i] ? dp[i] : max;
//            }
//        }
//        return max;
//    }
//
//}
class Solution {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        return Math.max(calc(chars, 0, 1, chars.length, '('), calc(chars, chars.length - 1, -1, -1, ')'));
        //return calc(chars, 0, 1, chars.length, '(');
    }

    private static int calc(char[] chars, int i, int flag, int end, char cTem) {
        int max = 0, sum = 0, currLen = 0, validLen = 0;
        for (; i != end; i += flag) {
            sum += (chars[i] == cTem ? 1 : -1);
            currLen++;
            if (sum < 0) {
                max = max > validLen ? max : validLen;
                sum = 0;
                currLen = 0;
                validLen = 0;
            } else if (sum == 0) {
                validLen = currLen;
            }
        }
        return max > validLen ? max : validLen;
    }
}
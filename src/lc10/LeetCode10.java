//package lc10;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Author: Knox
// * @Date: 2018-12-25 14:24
// * @Description: You Know
// * @Version 1.0
// */
//public class LeetCode10 {
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
//
//class State {
//    boolean finish = false;
//    Map<Character, State> next = new HashMap<>();
//
//}
//
//class Solution {
//    public boolean isMatch(String s, String p) {
//
//        char[] pattern = p.toCharArray();
//        State state = new State();
//        State start = state;
//        for (int i = 0; i < pattern.length; i++) {
//            if (pattern[i] == '.') {
//                if (i != pattern.length - 1 && pattern[i + 1] == '*') {
//                    //接受任意长度任意字符, 用'-'表示
//                    state.next.put('-', state);
//                    i++;
//                } else {
//                    //只接受一个字符
//                    State nextState = new State();
//                    state.next.put(pattern[i], nextState);
//                    state = nextState;
//                }
//            } else {
//                if (i != pattern.length - 1 && pattern[i + 1] == '*') {
//                    //当前字符可以0个或者n个当前字符
//                    State nextState = new State();
//                    nextState.next.put(pattern[i],nextState);
//                    state.next.put(pattern[i], state);
//                    i++;
//                } else {
//                    //普通匹配一个字符
//                    State nextState = new State();
//                    // 如果当前状态已经包含了一个路径,则把他的大写字母加入路径
//                    if (state.next.containsKey(pattern[i])) {
//                        state.next.put(Character.toUpperCase(pattern[i]), nextState);
//                    } else {
//                        state.next.put(pattern[i], nextState);
//                    }
//                    state = nextState;
//                }
//            }
//        }
//        state.finish = true;
//        return fit(s, start);
//    }
//
//    boolean fit(String s, State start) {
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (start.next.containsKey(chars[i])) {
//                boolean containUpper = start.next.containsKey(Character.toUpperCase(chars[i]));
//                if (i == chars.length - 1 && !containUpper) {
//                    start = start.next.get(chars[i]);
//                    break;
//                }
//                if (fit(s.substring(i + 1), start.next.get(chars[i])))
//                    return true;
//                if (containUpper)
//                    if (fit(s.substring(i + 1), start.next.get(Character.toUpperCase(chars[i]))))
//                        return true;
//            }
//
//            if (start.next.containsKey('.')) {
//                start = start.next.get('.');
//            } else if (!start.next.containsKey('-')) {
//                return false;
//            }
//        }
//        return start.finish;
//    }
//}
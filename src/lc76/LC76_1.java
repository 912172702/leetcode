package lc76;

import java.util.*;

/**
 * @Author: Knox
 * @Date: 2019-07-03 20:44
 * @Description: You Know
 * @Version 1.0
 */
public class LC76_1 {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution().minWindow("bccbacaaababaabcbabbbbabbcca", "caccabbabcacbabcb"));
    }
}

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] needs = new int[150];
        int required = 0;
        for (int i = 0; i < t.length(); i++) {
            if (needs[t.charAt(i)] == 0) required++;
            needs[t.charAt(i)]++;
        }

        for (int l = t.length(); l <= s.length(); l++) {
            //Set<Character> notFull = new HashSet<>();
            int full = 0;
            //
            int[] have = new int[150];
            for (int i = 0; i < l; i++) {
                if (needs[s.charAt(i)] > 0) {
                    have[s.charAt(i)]++;
                    if (have[s.charAt(i)] == needs[s.charAt(i)]) {
                        full++;
                        if (full == required) return s.substring(0, i + 1);
                    }
                }
            }
            //
            for (int i = 1; i < s.length() - l + 1; i++) {
                char cb = s.charAt(i - 1);
                char ce = s.charAt(i + l - 1);
                if (needs[cb] > 0) {
                    have[cb]--;
                    if (have[cb] == needs[cb] - 1) {
                        full--;
                    }
                }
                if (needs[ce] > 0) {
                    have[ce]++;
                    if (have[ce] == needs[ce]) {
                        full++;
                        if (full == required) return s.substring(i, i + l);
                    }
                }
            }

        }
        return "";
    }
}

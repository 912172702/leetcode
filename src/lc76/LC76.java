/*
package lc76;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * @Author: Knox
 * @Date: 2019-07-02 23:02
 * @Description: You Know
 * @Version 1.0
 *//*

public class LC76 {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution().minWindow("bccbacaaababaabcbabbbbabbcca", "caccabbabcacbabcb"));
    }
}

class Solution {

    int minx = 1 << 30;
    int maxx = -1;


    public String minWindow(String s, String t) {

        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        }
         System.out.println(map);
        for (int i = 0; i < t.length(); i++)
            if (map.get(t.charAt(i)) == null)
                return "";
        boolean[] visit = new boolean[s.length()];
        findRes(map, 0, t, 1 << 30, -1, visit);
        // System.out.println(minx + "," + (maxx + 1));
        if (maxx == -1) return "";
        return s.substring(minx, maxx + 1);

    }

    void findRes(Map<Character, List<Integer>> map, int index, String t, int minm, int maxm, boolean[] visit) {
        if (index == t.length()) {
            if ((maxm - minm < maxx - minx) || maxx == -1) {
                minx = minm;
                maxx = maxm;
            }
        } else {
            int premin = minm;
            int premax = maxm;
            List<Integer> list = map.get(t.charAt(index));
            for (int next : list) {
                if (visit[next]) continue;
                minm = premin;
                maxm = premax;
                if (next > premax) maxm = next;
                if (next < premin) minm = next;
                if((maxm - minm >= maxx - minx) && maxx != -1)continue;
                visit[next] = true;
                findRes(map, index + 1, t, minm, maxm, visit);
                visit[next] = false;
            }
        }
    }
}*/

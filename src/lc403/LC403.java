package lc403;

import java.util.*;

/**
 * @Author: Knox
 * @Date: 2019-04-08 16:34
 * @Description: You Know
 * @Version 1.0
 */
//class Solution {
//    public boolean canCross(int[] stones) {
//        int[][] dp = new int[stones.length + 1][1000];
//        int[] index = new int[stones.length + 1];
//        if (stones[1] != 0 && stones[1] != 1) return false;
//        dp[1][index[1]++] = 1;
//        for (int i = 2; i <= stones.length; i++) {
//            for (int j = i - 1; j > 0; j--) {
//                int temp = stones[i - 1] - stones[j - 1];
//                for (int k = 0; k < index[j]; k++) {
////                for (int num : dp[j]) {
//                    if (temp == dp[j][k] - 1 || temp == dp[j][k] || temp == dp[j][k] + 1) {
//                        dp[i][index[i]++] = stones[i - 1] - stones[j - 1];
//                        break;
//                    }
//                }
//            }
//        }
//        if (index[stones.length] == 0) return false;
//        return true;
//    }
//}


//class Solution {
//    private Map<Integer, Set<Integer>> block2jump = new HashMap<>();
//
//    public boolean canCross(int[] stones) {
//        if (stones.length <= 1 || stones[1] != 1) return false;
//
//        return deepJump(stones, 1, 1);
//    }
//
//    private boolean deepJump(int[] stones, int now, int step) {
//        if (now == stones[stones.length - 1]) return true;
//        Set<Integer> a = block2jump.computeIfAbsent(now, k -> new HashSet<>());
//        for (int temp = step - 1; temp <= step + 1; temp++) {
//            int nextStep = now + temp;
//            int nextIndex = Arrays.binarySearch(stones, 0, stones.length, nextStep);
//            if (nextIndex > 0) {
//                if (a.contains(temp)) continue;
//                else
//                    a.add(temp);
//                if (deepJump(stones, nextStep, temp)) return true;
//            }
//        }
//        return false;
//    }
//
//}


class Solution {
    private Map<Integer, Set<Integer>> block2jump = new HashMap<>();

    public boolean canCross(int[] stones) {
        if (stones.length <= 1 || stones[1] != 1) return false;

        return deepJump(stones, 1, 1);
    }

    private boolean deepJump(int[] stones, int index, int step) {
        if (index == stones.length - 1) return true;
        Set<Integer> a = block2jump.computeIfAbsent(index, k -> new HashSet<>());
        for (int temp = step - 1; temp <= step + 1; temp++) {
            if (a.contains(temp)) continue;
            int nextStep = stones[index] + temp;

            int nextIndex = Arrays.binarySearch(stones, index + 1, stones.length, nextStep);
            if (nextIndex > 0) {
                a.add(temp);
                if (deepJump(stones, nextIndex, temp)) return true;
            }
        }
        return false;
    }

}

public class LC403 {
    public static void main(String[] args) {
        System.out.println(new Solution().canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }
}

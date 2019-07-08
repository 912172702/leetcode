package lc1;

import java.util.*;

/**
 * @Author: Knox
 * @Date: 2019-07-04 13:40
 * @Description: You Know
 * @Version 1.0
 */
public class LC1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 5}, 9)));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
//        int[] res = new int[2];
//        Map<Integer, Set<Integer>> freq = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            freq.computeIfAbsent(nums[i], k -> new HashSet<>()).add(i);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            freq.get(nums[i]).remove(i);
//            int diff = target - nums[i];
//            Set<Integer> t;
//            if ((t = freq.get(diff)) != null && t.size() > 0)
//                return new int[]{i, t.iterator().next()};
//        }
//
//        return res;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}
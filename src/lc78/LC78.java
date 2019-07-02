package lc78;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Knox
 * @Date: 2019-07-02 13:18
 * @Description: You Know
 * @Version 1.0
 */
public class LC78 {
    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++)
            re(list, new ArrayList<>(), nums, i);
        return list;
    }

    private void re(List<List<Integer>> list, List<Integer> temp, int nums[], int index) {
        temp.add(nums[index]);
        list.add(new ArrayList<>(temp));
        for (int i = index + 1; i < nums.length; i++) {
            re(list, temp, nums, i);
        }
        temp.remove(temp.size() - 1);
    }
}
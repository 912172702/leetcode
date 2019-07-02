package lc123;

/**
 * @Author: Knox
 * @Date: 2018/12/7 12:28 PM
 * @Description: You Know
 * @Version 1.0
 */
public class LeetCode123 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(new Solution().maxProfit(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 4, 5}));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int minLeft = prices[0];
        int maxRight = prices[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - minLeft;
            left[i] = diff > left[i - 1] ? diff : left[i - 1];
            minLeft = prices[i] < minLeft ? prices[i] : minLeft;
        }
        for (int j = prices.length - 2; j >= 0; j--) {
            int diff = maxRight - prices[j];
            right[j] = diff > right[j + 1] ? diff : right[j + 1];
            maxRight = prices[j] > maxRight ? prices[j] : maxRight;
        }

        int max = right[0];
        for (int k = 0; k < prices.length - 1; k++) {
            //System.out.println(left[k] + "\t" + right[k + 1]);

            int add = left[k] + right[k + 1];
            max = add > max ? add : max;
        }
        return max;
    }
}
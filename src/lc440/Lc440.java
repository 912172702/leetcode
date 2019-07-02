package lc440;

/**
 * @Author: Knox
 * @Date: 2019-03-29 19:44
 * @Description: You Know
 * @Version 1.0
 */
class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            long step = 0, first = cur, last = cur + 1;
            while (first <= n) {
                step += Math.min(last, (long) (n + 1)) - first;
                first *= 10;
                last *= 10;
            }

            if (step > k) {
                //在树里
                k--;
                cur *= 10;
            }
            if (step <= k) {
                //不在树里
                k -= step;
                ++cur;
            }
        }
        return cur;
    }
}

public class Lc440 {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthNumber(10
                , 3));
    }
}

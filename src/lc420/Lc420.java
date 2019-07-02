package lc420;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Knox
 * @Date: 2019-03-31 10:27
 * @Description: You Know
 * @Version 1.0
 */
class Solution {
    public int strongPasswordChecker(String s) {
        int res = 0;
        List<Integer> cnts = new ArrayList<>();
        int low = 0, high = 0, number = 0;
        int cnt = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i > 0) {
                if (c == s.charAt(i - 1)) {
                    cnt++;
                } else {
                    if (cnt >= 3) cnts.add(cnt);
                    cnt = 1;
                }
            }
            if (c >= 'a' && c <= 'z') low++;
            if (c >= 'A' && c <= 'Z') high++;
            if (c >= '0' && c <= '9') number++;
        }
        if (cnt >= 3) cnts.add(cnt);
        int t = 0;
        int length = s.length();
        int needs = 0;//需要改变或增加的字符数量
        if (low == 0) needs++;
        if (high == 0) needs++;
        if (number == 0) needs++;

        for (Integer i : cnts) {
            t += (i / 3);
        }
        res += t;
        //先补齐字符 ,两种补齐方式，如果不足6个，则采用插入补齐，否则采用修改补齐
        if (length < 6) {
            length = Math.min(6, length + t);
            t -= length - s.length();
        }

        int tempNeed = needs;
        t = Math.max(0, t - needs);
        needs -= res - t;

        if (length > 20) {
            if (t == 0)
                res += Math.max(0, needs + s.length() - 20);
            else {
                //res -= Math.max(0, needs + s.length() - t - 20);
                res -= t;
                int remain = length - 20;
                cnts.sort(Comparator.naturalOrder());
                int kkk = 0;
                int i = 0;
                for (; i < cnts.size(); i++) {
                    int size = cnts.get(i);
                    int m = size / 3;
                    if (m <= tempNeed) tempNeed -= Math.min(m, tempNeed);
                    else {
                        int diff = Math.max(0, size - tempNeed * 3 - 2);
                        tempNeed = 0;
                        if (remain > diff) {
                            res += diff;
                            remain -= diff;
                        } else {
                            kkk = diff - remain;
                            res += remain;
                            remain = 0;
                            i++;
                            break;
                        }
                    }
                }
                if (remain > 0) res += remain;
                else {
                    int ll = (kkk == 0 ? 0 : (1 + (kkk - 1) / 3));
                    while (i < cnts.size()) {
                        ll += cnts.get(i) / 3;
                        i++;
                    }
                    res += ll;
                }
            }
        } else if (length < 6) {
            res += Math.max(6 - length, needs);
        } else {
            //要么t = 0 ，要么needs = 0
            if (t == 0) {
                res += needs;
            }
        }

        return res;
    }
}

public class Lc420 {
    public static void main(String[] args) {
        //System.out.println(new Solution().strongPasswordChecker("1234567890123456Baaaaa"));
        //System.out.println(new Solution().strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(new Solution().strongPasswordChecker("aaaabbaaabbaaa123456A"));
    }
}

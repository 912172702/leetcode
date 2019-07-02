package lc722;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Knox
 * @Date: 2019-04-01 20:48
 * @Description: You Know
 * @Version 1.0
 */


class Solution {
    public List<String> removeComments(String[] source) {
        StringBuilder total = new StringBuilder();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            total.append(source[i]).append("\n");
        }
        int indexline = -1, indexbb = -1, i = 0, length = total.length();

        while (i < length - 1) {
            char fi = total.charAt(i);
            char se = total.charAt(i + 1);
            if (fi == '/' && se == '/') {
                indexline = i;
                //删除直到\n
                while (i < length && total.charAt(i) != '\n') i++;
                total.delete(indexline, i);
                length -= (i - indexline);
                i = indexline - 1;
            } else if (fi == '/' && se == '*') {
                //找到下一个*/
                indexbb = i;
                i += 2;
                while (i < length - 1 && !(total.charAt(i) == '*' && total.charAt(i + 1) == '/')) i++;
                total.delete(indexbb, i + 2);
                length -= (i + 2 - indexbb);
                i = indexbb - 1;
            }
            i++;
        }
        String[] resArray = total.toString().split("\n");
        for (String str : resArray) {
            if (!"".equals(str)) {
                res.add(str);
            }
        }
        return res;
    }
}

public class LC722 {
    public static void main(String[] args) {
        //System.out.println(new Solution().removeComments(new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}));
        System.out.println(new Solution().removeComments(new String[]{"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"}));
    }
}

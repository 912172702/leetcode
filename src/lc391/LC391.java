package lc391;

import org.omg.CORBA.INTERNAL;

import java.util.*;
import java.util.function.Predicate;

/**
 * @Author: Knox
 * @Date: 2019-04-12 14:19
 * @Description: You Know
 * @Version 1.0
 */


//class Solution {
//
//    public boolean isRectangleCover(int[][] rectangles) {
//        Map<Integer, Set<Integer>> points = new HashMap<>();
//        //boolean[][] points = new boolean[100][100];
//        int pointCnt = 0;
//        int minX = 1 << 30, minY = 1 << 30, maxX = 0, maxY = 0;
//        int rows = rectangles.length;
//
//        for (int i = 0; i < rows; i++) {
//            //每个点加入,边界点放入边界
//            for (int p = rectangles[i][0]; p < rectangles[i][2]; p++) {
//                Set<Integer> point = points.computeIfAbsent(p, key -> new HashSet<>());
//                for (int q = rectangles[i][1] + 1; q <= rectangles[i][3]; q++) {
//                    if (point.contains(q)) return false;
//                    point.add(q);
//                    pointCnt++;
//                }
//            }
//
//            minX = rectangles[i][0] < minX ? rectangles[i][0] : minX;
//            minY = rectangles[i][1] < minY ? rectangles[i][1] : minY;
//            maxX = rectangles[i][2] > maxX ? rectangles[i][2] : maxX;
//            maxY = rectangles[i][3] > maxY ? rectangles[i][3] : maxY;
//        }
//
//        int width = maxX - minX;
//        int length = maxY - minY;
//        return width > 0 && length > 0 && width * length == pointCnt;
//    }
//}


//class Square {
//    int lx, ly, rx, ry;
//
//    public Square(int lx, int ly, int rx, int ry) {
//        this.lx = lx;
//        this.ly = ly;
//        this.rx = rx;
//        this.ry = ry;
//    }
//}
//
//class Solution {
//    private TreeSet<Square> left = new TreeSet<>((a, b) -> {
//        if (a.lx != b.lx)
//            return Integer.compare(a.lx, b.lx);
//        return 1;
//    });
//    private TreeSet<Square> right = new TreeSet<>((a, b) -> {
//        if (a.rx != b.rx)
//            return Integer.compare(a.rx, b.rx);
//        return 1;
//    });
//    private TreeSet<Square> down = new TreeSet<>((a, b) -> {
//        if (a.ly != b.ly)
//            return Integer.compare(a.ly, b.ly);
//        return 1;
//    });
//    private TreeSet<Square> up = new TreeSet<>((a, b) -> {
//        if (a.ry != b.ry)
//            return Integer.compare(a.ry, b.ry);
//        return 1;
//    });
//    int[][] xy = new int[][]{{0, 1}, {2, 3}, {0, 3}, {2, 1}};
//    Set<Square> lp;
//    Set<Square> rp;
//    Set<Square> dp;
//    Set<Square> upp;
//
//    public boolean isRectangleCover(int[][] rectangles) {
////        Map<Integer, Set<Integer>> points = new HashMap<>();
//
//        int pointCnt = 0;
//        // int minX = 1 << 30, minY = 1 << 30, maxX = 0, maxY = 0;
//        int rows = rectangles.length;
//
//
//        for (int i = 0; i < rows; i++) {
//
//            //查找判断
//            for (int j = 0; j < 4; j++) {
//                getByCompare(rectangles[i][xy[j][0]], rectangles[i][xy[j][1]]);
//
//                lp.removeIf(a -> !rp.contains(a));
//
//                lp.removeIf(a -> !upp.contains(a));
//
//                lp.removeIf(a -> !dp.contains(a));
//
//                if (!lp.isEmpty()) return false;
//
//            }
//
//
////            all.addAll(lp);
////            all.addAll(rp);
////            all.addAll(dp);
////            all.addAll(upp);
////            if (all.size() != lp.size() + rp.size() + dp.size() + upp.size()) return false;
//            //插入一个方形
//            Square square = new Square(rectangles[i][0], rectangles[i][1], rectangles[i][2], rectangles[i][3]);
//            left.add(square);
//            right.add(square);
//            down.add(square);
//            up.add(square);
//            pointCnt += (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);
//
////            minX = rectangles[i][0] < minX ? rectangles[i][0] : minX;
////            minY = rectangles[i][1] < minY ? rectangles[i][1] : minY;
////            maxX = rectangles[i][2] > maxX ? rectangles[i][2] : maxX;
////            maxY = rectangles[i][3] > maxY ? rectangles[i][3] : maxY;
//        }
////        Square l = right.last();
////        Square l2 = left.first();
//        int width = right.last().rx - left.first().lx;
//        int length = up.last().ry - down.first().ly;
//        return width > 0 && length > 0 && width * length == pointCnt;
//    }
//
//    private void getByCompare(int x, int y) {
//        lp = left.headSet(new Square(x - 1, 0, 0, 0));
//        rp = right.tailSet(new Square(0, 0, x + 1, 0));
//        dp = down.headSet(new Square(0, y - 1, 0, 0));
//        upp = up.tailSet(new Square(0, 0, 0, y + 1));
//    }
//}


class Solution {

    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> points = new HashSet<>();
        int square = 0;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int up = Integer.MIN_VALUE;
        int down = Integer.MAX_VALUE;

        for (int i = 0; i < rectangles.length; i++) {
            String ld = rectangles[i][0] + " " + rectangles[i][1];
            String lu = rectangles[i][0] + " " + rectangles[i][3];
            String ru = rectangles[i][2] + " " + rectangles[i][3];
            String rd = rectangles[i][2] + " " + rectangles[i][1];


            if (points.contains(ld)) points.remove(ld);
            else points.add(ld);
            if (points.contains(lu)) points.remove(lu);
            else points.add(lu);
            if (points.contains(ru)) points.remove(ru);
            else points.add(ru);
            if (points.contains(rd)) points.remove(rd);
            else points.add(rd);


            left = Math.min(left, rectangles[i][0]);
            right = Math.max(right, rectangles[i][2]);
            up = Math.max(up, rectangles[i][3]);
            down = Math.min(down, rectangles[i][1]);

            square += (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);
        }

        return points.size() == 4 && points.containsAll(Arrays.asList(left + " " + up, left + " " + down, right + " " + up, right + " " + down)) && square == (right - left) * (up - down);
    }
}

public class LC391 {
    public static void main(String[] args) {
        System.out.println(new Solution().isRectangleCover(new int[][]{
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {3, 2, 4, 4},
                {1, 3, 2, 4},
                {2, 3, 3, 4}
        }));

        System.out.println(new Solution().isRectangleCover(new int[][]{
                {1, 1, 2, 3},
                {1, 3, 2, 4},
                {3, 1, 4, 2},
                {3, 2, 4, 4}
        }));

        long k = System.currentTimeMillis();
        System.out.println(new Solution().isRectangleCover(new int[][]{
                        {1, 1, 2, 3},
                        {1, 3, 2, 4},
                        {3, 1, 4, 2},
                        {3, 2, 4, 4}
                }
        ));
        System.out.println(System.currentTimeMillis() - k);
    }
}

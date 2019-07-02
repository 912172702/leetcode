package lc407;

import java.util.*;

/**
 * @Author: Knox
 * @Date: 2019-04-02 10:43
 * @Description: You Know
 * @Version 1.0
 */
class Node {
    int i = -1;
    int j = -1;
    int deep = 0;

    Node(int i, int j, int deep) {
        this.i = i;
        this.j = j;
        this.deep = deep;
    }
}

class Solution {
    private static final int MAX = 20001;

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
        int row = heightMap.length, col = heightMap[0].length;

        Node[][] pos = new Node[row][col];
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.deep));
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Node node = new Node(i, j, heightMap[i][j]);
                queue.add(node);
                pos[i][j] = node;
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.deep == MAX) break;
            //广度搜索
            ArrayDeque<Node> bfs = new ArrayDeque<>();
            List<Node> list = new ArrayList<>();
            bfs.offer(node);
            int min = MAX;
            boolean flag = false; //是否存不了水
            boolean[][] has = new boolean[row][col];
            //fillfalse(has);
            has[node.i][node.j] = true;
            while (!bfs.isEmpty()) {
                Node p = bfs.poll();
                list.add(p);
                //has[p.i][p.j] = true;
                if (p.i == 0 || p.i == row - 1 || p.j == 0 || p.j == col - 1) flag = true;
                //往上看
                if (p.i != 0 && !has[p.i - 1][p.j]) {
                    if (heightMap[p.i - 1][p.j] == p.deep) {
                        if (p.i == 1) flag = true;
                        bfs.offer(pos[p.i - 1][p.j]);
                    } else {
                        if (heightMap[p.i - 1][p.j] != MAX)
                            min = Math.min(min, heightMap[p.i - 1][p.j]);
                        else flag = true;
                    }
                    has[p.i - 1][p.j] = true;
                }
                //往下看
                if (p.i != row - 1 && !has[p.i + 1][p.j]) {
                    if (heightMap[p.i + 1][p.j] == p.deep) {
                        if (p.i == row - 2) flag = true;
                        bfs.offer(pos[p.i + 1][p.j]);
                    } else {
                        if (heightMap[p.i + 1][p.j] != MAX)
                            min = Math.min(min, heightMap[p.i + 1][p.j]);
                        else flag = true;
                    }
                    has[p.i + 1][p.j] = true;
                }
                //往左看
                if (p.j != 0 && !has[p.i][p.j - 1]) {
                    if (heightMap[p.i][p.j - 1] == p.deep) {
                        if (p.j == 1) flag = true;
                        bfs.offer(pos[p.i][p.j - 1]);
                    } else {
                        if (heightMap[p.i][p.j - 1] != MAX)
                            min = Math.min(min, heightMap[p.i][p.j - 1]);
                        else flag = true;
                    }
                    has[p.i][p.j - 1] = true;
                }
                //往右看
                if (p.j != col - 1 && !has[p.i][p.j + 1]) {
                    if (heightMap[p.i][p.j + 1] == p.deep) {
                        if (p.j == col - 2) flag = true;
                        bfs.offer(pos[p.i][p.j + 1]);
                    } else {
                        if (heightMap[p.i][p.j + 1] != MAX)
                            min = Math.min(min, heightMap[p.i][p.j + 1]);
                        else flag = true;
                    }
                    has[p.i][p.j + 1] = true;
                }
            }
            //如果flag = true,则这一轮装不了水，把list中的节点高度设置为MAX；否则将节点设置为min，res += list.size() * (min - p.deep);
            int temp = 0;
            if (flag) {
                temp = MAX;
            } else {
                temp = min;
                res += list.size() * (min - node.deep);
            }
            for (Node q : list) {
                q.deep = temp;
                heightMap[q.i][q.j] = temp;
                queue.remove(q);
                queue.offer(q);
            }
        }
        return res;
    }
}

public class LC407 {
    public static void main(String[] args) {
        //4
        System.out.println(new Solution().trapRainWater(new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}}));
        // 14
        System.out.println(new Solution().trapRainWater(new int[][]{{12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}}));

    }
}

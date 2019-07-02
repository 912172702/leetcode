package lc79;

/**
 * @Author: Knox
 * @Date: 2019-07-02 09:29
 * @Description: You Know
 * @Version 1.0
 */
public class LC79 {
    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(new Solution().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(new Solution().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}

class Solution {
    private int[][] index = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        boolean[][] visit = new boolean[board.length][board[0].length];

        char first = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == first) {
                    if (findStr(board, i, j, word, visit)) return true;
                }
            }
        }
        return false;
    }

    private boolean findStr(char[][] board, int i, int j, String word, boolean[][] visit) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || visit[i][j]) return false;
        if (board[i][j] == word.charAt(0)) {
            if (word.length() == 1) return true;
            visit[i][j] = true;
            for (int k = 0; k < 4; k++) {
                if (findStr(board, i + index[k][0], j + index[k][1], word.substring(1), visit))
                    return true;
            }
            visit[i][j] = false;
        }
        return false;
    }
}
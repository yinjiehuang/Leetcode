// Leetcode: Dungeon Game
// Author: Yinjie Huang
// Date: 01/11/2015
//
import java.util.*;

public class DungeonGame {
        public static void main(String[] args) {
                System.out.println("Leetcode: Dungeon Game!!!");
                DungeonGame dg = new DungeonGame();
                int[][] dungeon = new int[][]{
                        {-2, -3, 3},
                        {-5, -10, 1},
                        {10, 30, -5}
                };
                System.out.println(dg.calculateMinimumHP(dungeon));
        }

        public int calculateMinimumHP(int[][] dungeon) {
                if (dungeon == null) {
                        return 0;
                }
                int m = dungeon.length;
                int n = dungeon[0].length;
                int[][] cache = new int[m][n];
                cache[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
                for (int j = n - 2; j >= 0; j--) {
                        cache[m - 1][j] = Math.max(cache[m - 1][j + 1] - dungeon[m - 1][j], 1);
                }
                for (int i = m - 2; i >= 0; i--) {
                        cache[i][n - 1] = Math.max(cache[i + 1][n - 1] - dungeon[i][n - 1], 1);
                }
                for (int i = m - 2; i >= 0; i--) {
                        for (int j = n - 2; j >= 0; j--) {
                                cache[i][j] = Math.max(Math.min(cache[i + 1][j], cache[i][j + 1]) - dungeon[i][j],1);
                        }
                }
                return cache[0][0];
        }
}

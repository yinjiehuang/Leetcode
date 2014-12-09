// Leetcode: Best Time to Buy and Sell Stock III
// Author: Yinjie Huang
// Date: 12/04/2014
//
import java.util.*;

public class BestTimeToBuyAndSellStockIII {
        public static void main(String[] args) {
                System.out.println("Leetcode: Best Time to Buy and Sell Stock III!!!");
                BestTimeToBuyAndSellStockIII btbss = new BestTimeToBuyAndSellStockIII();
                int[] prices = new int[]{7, 1, 4, 2, 8, 5};
                System.out.println(btbss.maxProfit(prices));
        }

        public int maxProfit(int[] prices) {
                if (prices == null || prices.length == 0) {
                        return 0;
                }
                int len = prices.length;
                int[][] local = new int[len][3];
                int[][] global = new int[len][3];
                for (int i = 1; i < len; i++) {
                        int diff = prices[i] - prices[i - 1];
                        for (int j = 1; j < 3; j++) {
                                local[i][j] = Math.max(global[i - 1][j - 1] + (diff > 0 ? diff : 0), local[i - 1][j] + diff);
                                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
                        }
                }
                return global[len - 1][2];
        }
}

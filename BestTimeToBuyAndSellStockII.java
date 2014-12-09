// Leetcode: Best Time to Buy and Sell Stock II
// Author: Yinjie Huang
// Date: 12/03/2014
//
import java.util.*;

public class BestTimeToBuyAndSellStockII {
        public static void main(String[] args) {
                System.out.println("Leetcode: Best Time to Buy and Sell Stock II!!!");
                BestTimeToBuyAndSellStockII btbss = new BestTimeToBuyAndSellStockII();
                int[] prices = new int[]{6, 4, 7, 3, 5, 8, 1};
                System.out.println(btbss.maxProfit(prices));
        }

        public int maxProfit(int[] prices) {
               if (prices == null || prices.length < 2) {
                       return 0;
               }
               int profit = 0;
               for (int i = 0; i < prices.length - 1; i++) {
                       if (prices[i] < prices[i + 1]) {
                               profit += prices[i + 1] - prices[i];
                       }
               }
               return profit;
        }
}

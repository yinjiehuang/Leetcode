// Leetcode: Best Time to Buy and Sell Stock
// Author: Yinjie Huang
// Date: 12/02/2014
//
import java.util.*;

public class BestTimeToBuyAndSellStock {
        public static void main(String[] args) {
                System.out.println("Leetcode: Best Time to Buy and Sell Stock!!!");
                BestTimeToBuyAndSellStock btbss = new BestTimeToBuyAndSellStock();
                int[] prices = new int[]{3, 4, 2, 8};
                System.out.println(btbss.maxProfit(prices));
        }

        public int maxProfit(int[] prices) {
                int max = 0;
                int minprice = Integer.MAX_VALUE;
                for (int i = 0; i < prices.length; i++) {
                        minprice = Math.min(minprice, prices[i]);
                        max = Math.max(max, prices[i] - minprice);
                }
                return max;
        }
}

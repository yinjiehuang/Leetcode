// Leetcode 011: Container With Most Water
// Author: Yinjie Huang
// Date: 11/21/2014
//
import java.util.*;

public class ContainerWithMostWater {
        public static void main(String[] args) {
                System.out.println("Leetcode 011: Container With Most Water!!!");
                ContainerWithMostWater cwmw = new ContainerWithMostWater();
                int[] height = new int[]{2, 3, 1, 4, 5, 1};
                System.out.println(cwmw.maxArea(height));
        }

        public int maxArea(int[] height) {
                int len = height.length;
                if (len < 2) {
                        return 0;
                }
                int low = 0;
                int high = len - 1;
                int max = -1;
                while (low < high) {
                        int area = (high - low) * Math.min(height[low], height[high]);
                        max = Math.max(area, max);
                        if (height[low] <= height[high]) {
                                low++;
                        } else {
                                high--;
                        }
                }
                return max;
        }
}

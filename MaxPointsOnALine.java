// Leetcode: Max Points on a Line
// Author: Yinjie Huang
// Date: 12/06/2014
//
import java.util.*;

public class MaxPointsOnALine {
        public static void main(String[] args) {
                System.out.println("Leetcode: Max Points On a Line!!!");
                MaxPointsOnALine mpl = new MaxPointsOnALine();
                Point[] Points = new Point[]{new Point(2, 3), new Point(3, 3), new Point(-5, 3)};
                System.out.println(mpl.maxPoints(Points));
        }

        public int maxPoints(Point[] Points) {
                if (Points == null || Points.length == 0) {
                        return 0;
                }

                if (Points.length == 1) {
                        return 1;
                }
                int max = 1;
                for (int i = 0; i < Points.length; i++) {
                        HashMap<Float, Integer> hm = new HashMap<Float, Integer>();
                        int samecount = 0;
                        int localmax = 1;
                        for (int j = 0; j < Points.length; j++) {
                                if (i == j) {
                                        continue;
                                }
                                if (Points[i].x == Points[j].x && Points[i].y == Points[j].y) {
                                        samecount++;
                                        continue;
                                }
                                float slope = (float) (Points[j].y - Points[i].y)/(Points[j].x - Points[i].x);
                                if (hm.containsKey(slope)) {
                                        hm.put(slope, hm.get(slope) + 1);
                                } else {
                                        hm.put(slope, 2);
                                }
                        }
                        for (Integer v : hm.values()) {
                                localmax = Math.max(localmax, v);
                        }
                        max = Math.max(max, localmax + samecount);
                } 
                return max;
        }
}

class Point {
        int x;
        int y;
        Point() {
                x = 0;
                y = 0;
        }
        Point(int a, int b) {
                x = a;
                y = b;
        }
} 

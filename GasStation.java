// Leetcode: Gas Station
// Author: Yinjie Huang
// Date: 12/04/2014

import java.util.*;

public class GasStation {
        public static void main(String[] args) {
                System.out.println("Leetcode: Gas Station!!!");
                GasStation gs = new GasStation();
        }

        public int canCompleteCircuit(int[] gas, int[] cost) {
                if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
                        return -1;
                }
                int sum = 0;
                int global = 0;
                int start = -1;
                for (int i = 0; i < gas.length; i++) {
                        sum += gas[i] - cost[i];
                        global += gas[i] - cost[i];
                        if (sum < 0) {
                                sum = 0;
                                start = i;
                        }
                }
                if (global >= 0) {
                        return start + 1;
                } else {
                        return -1;
                }
        }
}

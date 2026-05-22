// Last updated: 22/05/2026, 11:22:34
import java.util.*;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int count = 0;

        for (int t : time) {
            int r = t % 60;
            int complement = (60 - r) % 60;
            count += remainders[complement];
            remainders[r]++;
        }

        return count;
    }
}
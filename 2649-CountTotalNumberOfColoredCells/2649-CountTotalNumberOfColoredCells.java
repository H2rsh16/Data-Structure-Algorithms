// Last updated: 22/05/2026, 11:19:48
class Solution {
    public long coloredCells(int n) {
        return (long) Math.pow(n - 1, 2) + (long) Math.pow(n, 2); 
    }
}
// Last updated: 22/05/2026, 11:18:46
class Solution {
    public int findClosest(int x, int y, int z) {
        int distance1 = Math.abs(x - z);
        int distance2 = Math.abs(y - z);

        if (distance1 < distance2) {
            return 1;
        } else if (distance2 < distance1) {
            return 2;
        }
            
        return 0;
    }
}
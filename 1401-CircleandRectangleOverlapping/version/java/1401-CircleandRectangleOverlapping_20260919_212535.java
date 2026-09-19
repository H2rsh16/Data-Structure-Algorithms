// Last updated: 19/09/2026, 21:25:35
1class Solution {
2    public boolean checkOverlap(int radius, int xCenter, int yCenter,
3                                int x1, int y1, int x2, int y2) {
4
5        int closestX = Math.max(x1, Math.min(xCenter, x2));
6        int closestY = Math.max(y1, Math.min(yCenter, y2));
7
8        int dx = xCenter - closestX;
9        int dy = yCenter - closestY;
10
11        return dx * dx + dy * dy <= radius * radius;
12    }
13}
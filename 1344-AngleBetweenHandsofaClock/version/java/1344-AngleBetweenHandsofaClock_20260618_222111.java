// Last updated: 18/06/2026, 22:21:11
1class Solution {
2    public double angleClock(int hour, int minutes) {
3        double minuteAngle = minutes * 6.0;
4        double hourAngle = (hour % 12) * 30.0 + minutes * 0.5;
5
6        double diff = Math.abs(hourAngle - minuteAngle);
7
8        return Math.min(diff, 360.0 - diff);
9    }
10}
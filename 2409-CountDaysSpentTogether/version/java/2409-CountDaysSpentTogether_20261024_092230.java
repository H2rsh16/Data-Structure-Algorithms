// Last updated: 24/10/2026, 09:22:30
1class Solution {
2
3    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
4        int start = Math.max(toDays(arriveAlice), toDays(arriveBob));
5        int end = Math.min(toDays(leaveAlice), toDays(leaveBob));
6
7        return Math.max(0, end - start + 1);
8    }
9
10
11    private int toDays(String date){
12        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
13        int month = Integer.parseInt(date.substring(0, 2));
14        int day = Integer.parseInt(date.substring(3, 5));
15
16        for(int i = 0; i < month - 1; i++){
17            day += days[i];
18        }
19
20        return day;
21    }
22}
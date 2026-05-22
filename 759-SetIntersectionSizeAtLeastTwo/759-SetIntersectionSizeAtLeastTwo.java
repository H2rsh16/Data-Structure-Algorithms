// Last updated: 22/05/2026, 11:23:08
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[1] == b[1]) return b[0] - a[0];

            return a[1] - b[1];
        });


        int a = -1, b = -1;
        int count = 0;

        for(int[] interval: intervals){
            int start = interval[0];
            int end = interval[1];

            boolean aIn = (a >= start);
            boolean bIn = (b >= start);

            if(aIn && bIn){
                continue;
            }

            else if(aIn){
                count++;
                b = a;
                a = end;
            }
            else{
                count += 2;
                b = end - 1;
                a = end;
            }
        }


        return count;
    }
}
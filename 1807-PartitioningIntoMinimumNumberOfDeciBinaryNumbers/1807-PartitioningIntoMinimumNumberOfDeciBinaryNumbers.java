// Last updated: 22/05/2026, 11:21:10
class Solution {
    public int minPartitions(String n) {
        int max = 0;

        for(char c: n.toCharArray()){
            max = Math.max(max, c - '0');

            if(max == 9){
                return 9;
            }
        }

        return max;
    }
}
// Last updated: 22/05/2026, 11:24:27
class Solution {
    public int hIndex(int[] citations) {
        int max = 0;
        int l = citations.length;
        Arrays.sort(citations);
        for(int i = 0; i < l; i++){
            if(citations[i] >= l - i){
                max = Math.max(max, l - i);
            }
        }

        return max;
    }
}
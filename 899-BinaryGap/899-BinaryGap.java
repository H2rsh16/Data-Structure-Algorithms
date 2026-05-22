// Last updated: 22/05/2026, 11:22:52
class Solution {
    public int binaryGap(int n) {
        int lastIndex = -1;
        int maxDistance = 0;
        int index = 0;

        while(n > 0){
            if((n & 1) == 1){
                if(lastIndex != -1){
                    maxDistance = Math.max(maxDistance, index - lastIndex);
                }

                lastIndex = index;
            }

            n = n >> 1;
            index++;
        }

        return maxDistance;
    }
}
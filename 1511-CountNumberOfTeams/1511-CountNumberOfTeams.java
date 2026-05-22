// Last updated: 22/05/2026, 11:21:46
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;

        int sum = 0;

        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if((rating[i] < rating[j] && rating[j] < rating[k]) ||
                    (rating[i] > rating[j] && rating[j] > rating[k])){
                        sum++;
                    }
                }
            }
        }

        return sum;
    }
}
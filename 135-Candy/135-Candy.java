// Last updated: 22/05/2026, 11:25:18
class Solution {
    public int candy(int[] ratings) {
        int l = ratings.length;
        int[] candies = new int[l];
        
        for(int i = 0; i < candies.length; i++){
            candies[i] = 1;
        }

        for (int i = 1; i < l; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = l - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}
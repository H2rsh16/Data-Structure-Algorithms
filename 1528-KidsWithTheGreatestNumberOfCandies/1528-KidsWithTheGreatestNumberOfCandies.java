// Last updated: 22/05/2026, 11:21:43
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> lst = new ArrayList<>();
        int maxCandy = 0;
        for(int c: candies){
            if(c > maxCandy){
                maxCandy = c;
            }
        }
        for(int c: candies){
            int sum = c + extraCandies;
            if(sum >= maxCandy){
                lst.add(true);
            }
            else{
                lst.add(false);
            }
        }
        return lst;
    }
}
// Last updated: 22/05/2026, 11:23:33
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;

        for(int i = 0; i < l; i++){
            boolean le = i == 0 || flowerbed[i - 1] == 0;
            boolean r = i == l - 1 || flowerbed[i + 1] == 0;

            if(le && r && flowerbed[i] == 0){
                flowerbed[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }
}
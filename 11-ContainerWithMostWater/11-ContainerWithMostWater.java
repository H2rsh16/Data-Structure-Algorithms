// Last updated: 22/05/2026, 11:26:50
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int maxArea = 0;

        while(i < j){
            int width = j - i;
            int currentH = Math.min(height[i], height[j]);
            int area = width * currentH;

            maxArea = Math.max(maxArea, area);
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }

        }
        return maxArea;
    }
}
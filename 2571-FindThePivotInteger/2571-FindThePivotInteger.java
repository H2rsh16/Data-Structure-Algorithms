// Last updated: 22/05/2026, 11:19:57
class Solution {
    public int pivotInteger(int n) {
       int i = 1;
       int j = n;
       int leftSum = i;
       int rightSum = j;

       if(n == 1) return n;

       while(i < j){
        if(leftSum < rightSum){
            leftSum += ++i;
        }
        else{
            rightSum += --j;
        }

        if(leftSum == rightSum && i + 1 == j - 1){
            return i + 1;
        }

       }
        return -1;
    }
}
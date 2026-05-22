// Last updated: 22/05/2026, 11:24:21
class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        int num = 0;
        for(int i = 0; i < arr.length; i++){
            String temp = Integer.toBinaryString(i);
            for(char a: temp.toCharArray()){
                if(a == '1'){
                    num++;
                    arr[i] = num;
                }
            }
            num = 0;
        }
        return arr;
    }
}
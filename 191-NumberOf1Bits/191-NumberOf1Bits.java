// Last updated: 22/05/2026, 11:24:48
class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        String binary = Integer.toBinaryString(n);
        for(char a: binary.toCharArray()){
            if(a == '1'){
                count++;
            }
        }
        return count;
    }
}
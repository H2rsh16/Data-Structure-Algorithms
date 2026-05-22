// Last updated: 22/05/2026, 11:21:33
class Solution {
    final long MOD = 1000000007;
    public int numSub(String s) {
        long count = 0;
        long result = 0;

        for(char ch: s.toCharArray()){
            if(ch == '1'){
                result = (result + ++count) % MOD;
            }
            else{
                count = 0;
            }
        }

        return (int) result;
    }
}
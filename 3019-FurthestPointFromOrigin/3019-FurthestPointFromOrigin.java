// Last updated: 22/05/2026, 11:19:26
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0, b = 0;


        for(int i = 0; i < moves.length(); i++){
            char ch = moves.charAt(i);

            if(ch == 'L') l++;
            else if(ch == 'R') r++;
            else b++;
        }


        return Math.abs(r - l) + b;
    }
}
// Last updated: 22/05/2026, 11:23:54
class Solution {
    public int findComplement(int num) {
        String b = Integer.toBinaryString(num);
        StringBuilder s = new StringBuilder();

        for(int i = 0; i < b.length(); i++){
            if(b.charAt(i) == '0'){
                s.append('1');
            }
            if(b.charAt(i) == '1'){
                s.append('0');
            }
        }

        return Integer.parseInt(s.toString(), 2);
    }
}
// Last updated: 22/05/2026, 11:21:54
class Solution {
    public int findTheLongestSubstring(String s) {
        int xor = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            switch(ch){
                case 'a': xor ^= 1 << 0; break;
                case 'e': xor ^= 1 << 1; break;
                case 'i': xor ^= 1 << 2; break;
                case 'o': xor ^= 1 << 3; break;
                case 'u': xor ^= 1 << 4; break;
            }

            if(map.containsKey(xor)){
                res = Math.max(res, i - map.get(xor));
            }
            else{
                map.put(xor, i);
            }

        }
        return res;
    }
}
// Last updated: 22/05/2026, 11:20:37
class Solution {
    public int getLucky(String s, int k) {
        StringBuilder num = new StringBuilder();
        for(char a: s.toCharArray()){
            num.append(a - 'a' + 1);
        }

        while(k > 0){
            int temp = 0;
            for(char b: num.toString().toCharArray()){
                temp += b - '0';
            }

            num = new StringBuilder(String.valueOf(temp));
            k--;
        }
        return Integer.parseInt(num.toString());
    }
}
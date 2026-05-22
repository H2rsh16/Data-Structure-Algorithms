// Last updated: 22/05/2026, 11:25:24
class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("\\s+|[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = str.length() - 1;


        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            
            left++;
            right--;
        }
        return true;
    }
}
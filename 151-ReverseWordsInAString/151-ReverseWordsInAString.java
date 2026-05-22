// Last updated: 22/05/2026, 11:25:12
class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        StringBuilder str = new StringBuilder();
        int n = arr.length;
        for(int i = n - 1; i >= 0; i--){
            str.append(arr[i]);
            if(i != 0){
                str.append(" ");
            }
        }

        return str.toString();
    }
}
// Last updated: 22/05/2026, 11:19:44
class Solution {
    public int countSeniors(String[] details) {
        int n = details.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            String sub = details[i].substring(11, details[i].length() - 2);
            int age = Integer.parseInt(sub);
            if(age > 60){
                count++;
            }
        }
        return count;
    }
}
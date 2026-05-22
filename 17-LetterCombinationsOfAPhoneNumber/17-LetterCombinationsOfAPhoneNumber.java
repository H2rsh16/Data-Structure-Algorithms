// Last updated: 22/05/2026, 11:26:41
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0) return ans;

        String output = "";
        int idx = 0;
        String map[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        helper(digits, output, idx, ans, map);

        return ans;
    }
    public void helper(String digits, String output, int idx, List<String> lst, String map[]){

        if(idx >= digits.length()){
            lst.add(output);
            return;
        }

        int num = digits.charAt(idx) - '0';
        String val = map[num];

        for(int i = 0; i < val.length(); i++){
            output += val.charAt(i);
            helper(digits, output, idx + 1, lst, map);
            output = output.substring(0, output.length() - 1);
        }
    }
}
// Last updated: 22/05/2026, 11:24:09
import java.util.*;
class Solution {
    public List<Integer> lexicalOrder(int n) {
        Vector<String> s = new Vector<>();

        for(int i = 1; i <= n; i++){
            s.add(String.valueOf(i));
        }
        Collections.sort(s);
        Vector<Integer> ans = new Vector<>();

        for(int i = 0; i < n; i++){
            ans.add(Integer.valueOf(s.get(i)));
        }

        return ans;
    }
}
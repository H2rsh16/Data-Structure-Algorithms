// Last updated: 01/07/2026, 13:03:22
1class Solution {
2    public String removeKdigits(String num, int k) {
3        int len = num.length();
4        if (k >= len) return "0";
5        
6        // Use StringBuilder directly as a monotonic stack
7        StringBuilder stack = new StringBuilder();
8        
9        for (int i = 0; i < len; i++) {
10            char ch = num.charAt(i);
11            
12            // While the "stack" is not empty, the top element is larger than the current digit, and k > 0
13            while (stack.length() > 0 && k > 0 && stack.charAt(stack.length() - 1) > ch) {
14                stack.deleteCharAt(stack.length() - 1); // pop
15                k--;
16            }
17            stack.append(ch); // push
18        }
19        
20        // If k is still > 0, truncate the last k digits from the end
21        while (k > 0 && stack.length() > 0) {
22            stack.deleteCharAt(stack.length() - 1);
23            k--;
24        }
25        
26        // Remove leading zeros efficiently
27        int nonZeroIndex = 0;
28        while (nonZeroIndex < stack.length() && stack.charAt(nonZeroIndex) == '0') {
29            nonZeroIndex++;
30        }
31        
32        // Build the final substring or return "0" if nothing is left
33        String result = stack.substring(nonZeroIndex);
34        return result.isEmpty() ? "0" : result;
35    }
36}
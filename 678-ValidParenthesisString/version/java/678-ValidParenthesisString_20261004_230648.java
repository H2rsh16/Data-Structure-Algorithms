// Last updated: 04/10/2026, 23:06:48
1class Solution {
2    public boolean checkValidString(String s) {
3        int minOpen = 0; 
4        int maxOpen = 0; 
5        for (char ch : s.toCharArray()) { 
6            if (ch == '(') { 
7                minOpen++; 
8                maxOpen++; 
9            } 
10            else if (ch == ')') { 
11                minOpen--; 
12                maxOpen--; 
13            } 
14            else { 
15                minOpen--; 
16                maxOpen++; 
17            } 
18            minOpen = Math.max(0, minOpen); 
19            if (maxOpen < 0) { 
20                return false; 
21            } 
22        } 
23        
24        return minOpen == 0;
25    }
26}
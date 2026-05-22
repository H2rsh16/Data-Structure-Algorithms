// Last updated: 22/05/2026, 11:24:38
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int r = 0;
        int n = 0;
        int sign = 1;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                n = 10 * n + (int)(c - '0');
            }
            else if(c == '+'){
                r += sign * n;
                n = 0; 
                sign = 1;
            }
            else if(c == '-'){
                r += sign * n;
                n = 0; 
                sign = -1;
            }
            else if(c == '('){
                stack.push(r);
                stack.push(sign);
                sign = 1;
                r = 0;
            }
            else if(c == ')'){
                r += sign * n;
                n = 0;
                r *= stack.pop();
                r += stack.pop();
            }
        }

        if(n != 0){
            r += sign * n;
        }

        return r;
    }
}
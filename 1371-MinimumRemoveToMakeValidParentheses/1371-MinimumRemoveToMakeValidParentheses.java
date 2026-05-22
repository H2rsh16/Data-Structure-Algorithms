// Last updated: 22/05/2026, 11:22:12
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for(int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i);

            if(c == '('){
                st.push(i);
            }
            else if(c == ')'){
                if(!st.isEmpty()){
                    st.pop();
                }
                else{
                    sb.setCharAt(i, '*');
                }
            }
        }

        while(!st.isEmpty()){
            sb.setCharAt(st.pop(), '*');
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) != '*'){
                result.append(sb.charAt(i));
            }
        }

        return result.toString();
    }
}
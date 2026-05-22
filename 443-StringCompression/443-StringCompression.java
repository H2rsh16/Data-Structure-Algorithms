// Last updated: 22/05/2026, 11:24:00
class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;

        while(read < chars.length){
            char currentChar = chars[read];
            int count = 0;

            while(read < chars.length && currentChar == chars[read]){
                read++;
                count++;
            }

            chars[write++] = currentChar;

            if(count > 1){
                for(char c: Integer.toString(count).toCharArray()){
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}
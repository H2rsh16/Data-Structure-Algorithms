// Last updated: 22/05/2026, 11:20:43
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int i = 0; i < chalk.length; i++){
            sum += chalk[i];
        }

        int remaining = (int) (k % sum);

        for(int i = 0; i < chalk.length; i++){
            if(remaining < chalk[i]){
                return i;
            }

            remaining -= chalk[i];
        }
        return 0;
    }
}
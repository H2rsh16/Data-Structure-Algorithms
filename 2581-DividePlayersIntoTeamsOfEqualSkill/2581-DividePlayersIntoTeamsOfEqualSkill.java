// Last updated: 22/05/2026, 11:19:56
class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill);
        int sum = skill[0] + skill[n - 1];
        long chemistry = skill[0] * skill[n - 1];

        for(int i = 1; i < n / 2; i++){
            int idx = n - 1 - i;

            if(skill[i] + skill[idx] != sum){
                return -1;
            }

            chemistry += (skill[i] * skill[idx]);
        }

        return chemistry;
    }
}
// Last updated: 22/05/2026, 11:26:18
class Solution {
    public void backtrack(List<List<Integer>> results, List<Integer> path, int[] candidates, int target, int start){
         if (target == 0) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            backtrack(results, path, candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lst = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(lst, new ArrayList<>(), candidates, target, 0);
        return lst;
    }
}
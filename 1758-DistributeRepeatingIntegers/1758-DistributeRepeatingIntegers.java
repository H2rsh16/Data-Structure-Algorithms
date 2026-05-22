// Last updated: 22/05/2026, 11:21:16
class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> freq = new ArrayList<>(map.values());

        Arrays.sort(quantity);
        reverse(quantity);

        return backtrack(freq, quantity, 0);
    }
    private boolean backtrack(List<Integer> freq, int[] quantity, int idx){
        if(idx == quantity.length) return true;

        for(int i = 0; i < freq.size(); i++){
            if(freq.get(i) >= quantity[idx]){
                freq.set(i, freq.get(i) - quantity[idx]);

                if(backtrack(freq, quantity, idx + 1)) return true;

                freq.set(i, freq.get(i) + quantity[idx]);
            }
        }

        return false;
    }
    private void reverse(int[] arr){
        int l = 0;
        int r = arr.length - 1;

        while(l < r){
            int temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
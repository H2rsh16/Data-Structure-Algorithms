// Last updated: 22/05/2026, 11:22:18
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int maxdif = Integer.MAX_VALUE;
        List<List<Integer>> lst = new ArrayList<>();

        Arrays.sort(arr);

        for(int i = 1; i < arr.length; i++){
            int dif = Math.abs(arr[i] - arr[i - 1]);

            if(dif < maxdif){
                maxdif = dif;
            }
        }

        for(int i = 1; i < arr.length; i++){
            int dif = Math.abs(arr[i] - arr[i - 1]);

            if(dif == maxdif){
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);

                lst.add(pair);
            }
        }

        return lst;
    }
}
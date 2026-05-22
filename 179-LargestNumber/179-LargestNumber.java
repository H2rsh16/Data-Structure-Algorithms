// Last updated: 22/05/2026, 11:25:02
class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder str = new StringBuilder();
        String[] arr = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (x, y) -> (y + x).compareTo(x + y));

        if(arr[0].equals("0")) return "0";

        for(String s: arr){
            str.append(s);
        }
        return str.toString();
    }
}
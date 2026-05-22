// Last updated: 22/05/2026, 11:18:44
class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop(); 
            }
            if (stack.peek() < num) {
                if (num > 0) ans++;
                stack.push(num);
            }
        }
        return ans;
    }
}
// Last updated: 22/05/2026, 11:23:02
class KthLargest {
    private int k;
    private PriorityQueue<Integer> p;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        p = new PriorityQueue<>(k);

        for(int num: nums){
            p.offer(num);
            if(p.size() > k){
                p.poll();
            }
        }
    }
    
    public int add(int val) {
        p.offer(val);
        if(p.size() > k){
            p.poll();
        }

        return p.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
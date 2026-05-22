// Last updated: 22/05/2026, 11:24:30
class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 0) return 0;

        int[] factors = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        set.add(1L);
        pq.offer(1L);

        long uglyNumber = 0;

        for(int i = 0; i < n; i++){
            uglyNumber = pq.poll();
            for(int f : factors){
                long newUgly = uglyNumber * f;
                if(set.add(newUgly)){
                    pq.offer(newUgly);
                }
            }
        }

        return (int) uglyNumber;
    }
}
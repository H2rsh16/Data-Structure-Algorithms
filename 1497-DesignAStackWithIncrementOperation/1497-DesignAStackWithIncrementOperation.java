// Last updated: 22/05/2026, 11:21:50
class CustomStack {
    int[] arr;
    int t = -1;
    public CustomStack(int maxSize) {
        this.arr = new int[maxSize];
    }
    
    public void push(int x) {
        if(t < this.arr.length - 1){
            t++;
            this.arr[t] = x;
        }
    }
    
    public int pop() {
        if(t != -1){
            return this.arr[t--];
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        for(int i = 0; i < Math.min(k, t + 1); i++){
            this.arr[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
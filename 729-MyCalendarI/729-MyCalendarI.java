// Last updated: 22/05/2026, 11:23:13
class MyCalendar {
    private List<int[]> c;
    public MyCalendar() {
        c = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] a: c){
            if((start < a[0] && end > a[0]) || (start == a[0]) || (start > a[0] && start < a[1])){
                return false;
            }
        }

        c.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
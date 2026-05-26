// Last updated: 26/05/2026, 12:55:30
1public class Solution {
2    public ListNode detectCycle(ListNode head) {
3        ListNode slow = head;
4        ListNode fast = head;
5
6        while(fast != null && fast.next != null){
7            slow = slow.next;
8            fast = fast.next.next;
9
10            if(slow == fast){
11                ListNode ptr = head;
12                while(slow != ptr){
13                    slow = slow.next;
14                    ptr = ptr.next;
15                }
16
17                return ptr;
18            }
19        }
20
21        return null;
22    }
23}
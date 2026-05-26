// Last updated: 26/05/2026, 14:00:52
1
2class Solution {
3    public ListNode middleNode(ListNode head) {
4        ListNode slow = head;
5        ListNode fast = head;
6
7
8        while(fast != null && fast.next != null){
9            slow = slow.next;
10            fast = fast.next.next;
11        }
12
13        return slow;
14    }
15}